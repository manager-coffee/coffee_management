package dao;

import DB.DBConnection;
import dto.OrderDto;
import model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderDAO {
    private Connection connection;
    public OrderDAO(){
        connection = DBConnection.getConnection();
    }
    public List<OrderDto> orderList() throws SQLException {
        List<OrderDto> listOrder = new ArrayList<>();
        String query = "SELECT o.order_id, o.customer_id, o.order_date, o.order_status_id, o.total_amount, o.product_id, u.name as customer_name, p.product_name " +
                "FROM orders o " +
                "JOIN users u ON o.customer_id = u.id " +
                "JOIN Product p ON o.product_id = p.product_id";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    OrderDto orderDto = new OrderDto();
                    orderDto.setOrder_id(resultSet.getInt("order_id"));
                    orderDto.setCustomer_id(String.valueOf(resultSet.getInt("customer_id")));
                    orderDto.setOrder_date(String.valueOf(resultSet.getTimestamp("order_date").toLocalDateTime()));
                    orderDto.setOrder_status_id(String.valueOf(resultSet.getInt("order_status_id")));
                    orderDto.setTotal_amount(String.valueOf(resultSet.getDouble("total_amount")));
                    orderDto.setProduct_id(String.valueOf(resultSet.getInt("product_id")));
                    orderDto.setCustomer_name(resultSet.getString("customer_name"));
                    orderDto.setProduct_name(resultSet.getString("product_name"));
                    listOrder.add(orderDto);
                }
            }
        }
        return listOrder;
    }
    public boolean insertOrder(Order order) throws SQLException {
        String insertOrderSQL = "INSERT INTO orders (customer_id, order_date, order_status_id, total_amount, product_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertOrderSQL)) {
            preparedStatement.setInt(1, order.getCustomerId());
            preparedStatement.setDate(2, Date.valueOf(order.getOrderDate()));
            preparedStatement.setInt(3, order.getOrderStatusId());
            preparedStatement.setDouble(4, order.getTotalAmount());
            preparedStatement.setInt(5, order.getProductId());

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Order inserted successfully.");
            } else {
                System.out.println("Failed to insert order.");
            }
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println("Error inserting order: " + e.getMessage());
            throw e;
        }
    }
    public Order getOrderById(int orderId) throws SQLException {
        String getOrderByIdSQL = "SELECT order_id, customer_id, order_date, order_status_id, total_amount FROM orders WHERE order_id = ?";
        Order order = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(getOrderByIdSQL)) {
            preparedStatement.setInt(1, orderId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("order_id");
                    int customerId = resultSet.getInt("customer_id");
                    LocalDate orderDate = resultSet.getDate("order_date").toLocalDate();
                    String orderStatus = resultSet.getString("order_status_id");
                    double totalAmount = resultSet.getDouble("total_amount");

                    order = new Order(id, customerId, orderDate, orderStatus, totalAmount);
                }
            }
        }
        return order;
    }
    public boolean updateOrder(Order order) throws SQLException {
        String updateOrderSQL = "UPDATE orders SET customer_id = ?, order_date = ?, order_status_id= ?, total_amount= ? WHERE order_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateOrderSQL)) {
            preparedStatement.setInt(1, order.getCustomerId());
            if (order.getOrderDate() != null) {
                preparedStatement.setDate(2, Date.valueOf(order.getOrderDate()));
            } else {
                preparedStatement.setNull(2, java.sql.Types.DATE);
            }
            preparedStatement.setInt(3, order.getOrderStatusId());
            preparedStatement.setDouble(4, order.getTotalAmount());
            preparedStatement.setInt(5, order.getOrderId());

            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println("Error updating order: " + e.getMessage());
            throw e;
        }
    }
    public boolean deleteOrder(int orderID) throws SQLException {
        String deleteOrderSQL = "DELETE FROM orders WHERE order_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteOrderSQL)) {
            preparedStatement.setInt(1, orderID);
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        }
    }
}
