package controller;

import dto.ProductDto;
import model.Category;
import model.Product;
import service.CategoryService;
import service.ICategoryService;
import service.IProductService;
import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductController", urlPatterns = "/coffee")
public class ProductController extends HttpServlet {
    private ICategoryService iCategoryService = new CategoryService();
    private IProductService iProductService = new ProductService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    showCreate(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "remove":
                try {
                    showRemove(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "update":
                try {
                    showUpdate(req,resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                try {
                    showList(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
        }
    }

    private void showUpdate(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("product_id"));
        Product product=iProductService.checkId(id);
        List<Category> category = iCategoryService.findAllCate();
        req.setAttribute("product",product);
        req.setAttribute("category", category);
        req.getRequestDispatcher("update.jsp").forward(req,resp);

    }

    private void showRemove(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        iProductService.findById(id);
        resp.sendRedirect("/coffee");
    }

    private void showCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        List<Category> category = iCategoryService.findAllCate();
        req.setAttribute("category", category);
        req.getRequestDispatcher("create.jsp").forward(req, resp);
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        List<ProductDto> product = iProductService.findAll();
        req.setAttribute("product", product);
        req.getRequestDispatcher("/list.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";

        }
        switch (action) {
            case "create":
                try {
                    createProduct(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "update":
                try {
                    updateProduct(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "search":
                try {
                    searchProduct(req,resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    private void searchProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String name=req.getParameter("name");
        if(name==null){
            name="";
        }
        List<ProductDto> product=iProductService.SearchName(name);
        req.setAttribute("product",product);
        req.setAttribute("name",name);
        req.getRequestDispatcher("list.jsp").forward(req,resp);

    }

    private void updateProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        int id = Integer.parseInt(req.getParameter("product_id"));
        String name = req.getParameter("product_name");
        int price = Integer.parseInt(req.getParameter("price"));
        int category_id = Integer.parseInt(req.getParameter("category_id"));
        String image_url = req.getParameter("image_url");
        Product product = new Product(name, price, category_id, image_url);
        product.setProduct_id(id);
        iProductService.updatePro(product);
        resp.sendRedirect("/coffee");
    }

    private void createProduct(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        String name = req.getParameter("product_name");
        int price = Integer.parseInt(req.getParameter("price"));
        int category_id = Integer.parseInt(req.getParameter("category_id"));
        String image_url = req.getParameter("image_url");
        Product product = new Product(name, price, category_id, image_url);
        iProductService.createPro(product);
        resp.sendRedirect("/coffee");

    }

}
