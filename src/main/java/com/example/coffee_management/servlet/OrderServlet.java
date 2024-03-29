package com.example.coffee_management.servlet;



import DB.DBConnection;
import dao.OrderDAO;
import dto.OrderDto;
import dto.ProductDto;
import model.Order;
import model.Product;
import service.IProductService;
import service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

@WebServlet(name = "OrderServlet", urlPatterns = "/orders")
public class OrderServlet extends HttpServlet {
    private OrderDAO orderDAO;

    private IProductService productService = new ProductService();



    public void init(){
        this.orderDAO = new OrderDAO();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }switch (action){
            case "new":
                try {
                    showNewForm(req,resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "edit":
                try {
                    showEditForm(req,resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "delete":
                try {
                    deleteOrder(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "list":
            default:
                try {
                    listOrders(req,resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
        }
    }

    private void deleteOrder(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        int orderId = Integer.parseInt(req.getParameter("id"));
        orderDAO.deleteOrder(orderId);
        resp.sendRedirect("orders?action=list");
    }

    private void listOrders(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        String searchQuery = req.getParameter("search");
        String sortBy = req.getParameter("sortBy");
        String sortDirection = req.getParameter("sortDirection");

        if (sortBy == null || sortBy.isEmpty()) {
            sortBy = "order_date";
        }
        if (sortDirection == null || sortDirection.isEmpty()) {
            sortDirection = "ASC";
        }
        List<OrderDto> orderList = orderDAO.orderList();
        req.setAttribute("orderList", orderList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("orderForm/order-list.jsp");
        requestDispatcher.forward(req, resp);
    }


    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Order existingOrder = orderDAO.getOrderById(id);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("orderForm/order-edit.jsp");
        req.setAttribute("order",existingOrder);
        requestDispatcher.forward(req,resp);
    }

    private void showNewForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("orderForm/order-insert.jsp");
        List<ProductDto> products = this.productService.findAll();
        req.setAttribute("products", products);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "insert":
                    insertOrder(req, resp);
                    break;
                case "update":
                    updateOrder(req, resp);
                    break;
                default:
                    resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Action not found.");
                    break;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateOrder(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            int customerId = Integer.parseInt(req.getParameter("customerId"));
            LocalDate orderDate = LocalDate.parse(req.getParameter("orderDate"));
            int orderStatusId = Integer.parseInt(req.getParameter("orderStatus"));
            double totalAmount = Double.parseDouble(req.getParameter("totalAmount"));
            int productId = Integer.parseInt(req.getParameter("productId"));
            Order order = new Order(id,customerId,orderDate,orderStatusId,totalAmount,productId);
            boolean updateSuccess = orderDAO.updateOrder(order);
            if (updateSuccess) {
                req.getSession().setAttribute("message", "Order updated successfully.");
            } else {
                req.getSession().setAttribute("message", "Failed to update the order.");
            }
        } catch (NumberFormatException | DateTimeParseException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid input format.");
            return;
        }
        resp.sendRedirect(req.getContextPath() + "/orders?action=list");
    }

    private void insertOrder(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        try {
            int productId = Integer.parseInt(req.getParameter("productId"));
            int customerId = Integer.parseInt(req.getParameter("customerId"));
            LocalDate orderDate = LocalDate.parse(req.getParameter("orderDate"));
            int orderStatusId = Integer.parseInt(req.getParameter("orderStatusId"));
            double totalAmount = Double.parseDouble(req.getParameter("totalAmount"));
            Order newOrder = new Order();
            newOrder.setCustomerId(customerId);
            newOrder.setOrderDate(orderDate);
            newOrder.setOrderStatusId(orderStatusId);
            newOrder.setTotalAmount(totalAmount);
            newOrder.setProductId(productId);
            boolean insertResult = orderDAO.insertOrder(newOrder);
            if (insertResult) {
                req.getSession().setAttribute("message", "Order was successfully inserted.");
                resp.sendRedirect(req.getContextPath() + "/orders?action=list");
            } else {
                req.setAttribute("message",     "Failed to insert the order.");
                RequestDispatcher dispatcher = req.getRequestDispatcher("orderForm/order-insert.jsp");
                dispatcher.forward(req, resp);
            }
        } catch (NumberFormatException | DateTimeParseException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid input format.");
        } catch (SQLException e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while inserting the order.");
        }
    }

    private boolean checkCustomerExists(int customerId) throws SQLException {
        String query = "SELECT COUNT(id) FROM Customer WHERE id = ?";

        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(query)) {
            statement.setInt(1, customerId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1) > 0;
                }
            }
        }
        return false;
    }


    private boolean checkProductExists(int productId) throws SQLException {
        String query = "SELECT COUNT(product_id) FROM Product WHERE product_id = ?";
        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(query)) {
            statement.setInt(1, productId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1) > 0;
                }
            }
        }
        return false;
    }


}

