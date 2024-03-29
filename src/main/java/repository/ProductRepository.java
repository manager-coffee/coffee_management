package repository;

import DB.DBConnection;
import dto.ProductDto;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private String FINDALL = " select Product.*,Category.name as nameCategory from Product join Category on Product" +
            ".category_id=Category.id;";
    private String CREATE = "  INSERT INTO Product ( product_name, price, category_id, image_url) VALUES\n" +
            "(?, ?, ?, ?);";
    private String DELETE = "delete from Product where product_id=?;";
    private String UPDATE = " update Product set product_name=?,price=?,category_id=?,image_url=? where product_id=?;";
    private String WHERE = "  select*from Product where product_id=?;";
    private String SEARCH = "   select Product.*,Category.name as nameCategory from Product join Category on Product" +
            ".category_id=Category.id where Product.product_name like ?;";

    @Override
    public List<ProductDto> findAll() throws SQLException {
        List<ProductDto> productDtos = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(FINDALL);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            Integer id = rs.getInt("product_id");
            String name = rs.getString("product_name");
            Integer price = rs.getInt("price");
            String category_id = rs.getString("nameCategory");
            String image_url = rs.getString("image_url");
            productDtos.add(new ProductDto(id, name, price, category_id, image_url));
        }
        connection.close();
        statement.close();
        rs.close();
        return productDtos;
    }

    @Override
    public void createPro(Product product) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(CREATE);
        statement.setString(1, product.getProduct_name());
        statement.setInt(2, product.getPrice());
        statement.setInt(3, product.getCategory_id());
        statement.setString(4, product.getImage_url());
        statement.executeUpdate();
        connection.close();
        statement.close();
    }

    @Override
    public void findById(Integer id) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(DELETE);
        statement.setInt(1, id);
        statement.executeUpdate();
        statement.close();
    }

    @Override
    public void updatePro(Product product) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(UPDATE);
        statement.setString(1, product.getProduct_name());
        statement.setInt(2, product.getPrice());
        statement.setInt(3, product.getCategory_id());
        statement.setString(4, product.getImage_url());
        statement.setInt(5, product.getProduct_id());
        statement.executeUpdate();
        connection.close();
        statement.close();
    }

    @Override
    public Product checkId(Integer id) throws SQLException {
        Product product = null;
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(WHERE);
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            Integer id1 = rs.getInt("product_id");
            String name = rs.getString("product_name");
            Integer price = rs.getInt("price");
            int category_id = rs.getInt("category_id");
            String image_url = rs.getString("image_url");
            product = new Product(id1, name, price, category_id, image_url);
        }
        connection.close();
        statement.close();
        rs.close();
        return product;
    }

    @Override
    public List<ProductDto> SearchName(String name) throws SQLException {
        List<ProductDto> productDtos = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(SEARCH);
        statement.setString(1, "%" + name + "%");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int id=resultSet.getInt("product_id");
            String namePro=resultSet.getString("product_name");
            int price=resultSet.getInt("price");
            String category_id=resultSet.getString("nameCategory");
            String image_url=resultSet.getString("image_url");
            productDtos.add(new ProductDto(id,namePro,price,category_id,image_url));
        }
        return productDtos;
    }
}
