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
    private String DELETE="delete from Product where product_id=?;";
    private String UPDATE=" update Product set product_name=?,price=?,category_id=?,image_url=? where product_id=?;";

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
        statement.setString(1,product.getProduct_name());
        statement.setInt(2,product.getPrice());
        statement.setInt(3,product.getCategory_id());
        statement.setString(4,product.getImage_url());
        statement.executeUpdate();
        connection.close();
        statement.close();
    }

    @Override
    public void findById(Integer id) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(DELETE);
        statement.setInt(1,id);
        statement.executeUpdate();
        statement.close();
    }

    @Override
    public void updatePro(Product product) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(UPDATE);
        statement.setString(1,product.getProduct_name());
        statement.setInt(2,product.getPrice());
        statement.setInt(3,product.getCategory_id());
        statement.setString(4,product.getImage_url());
        statement.executeUpdate();
        connection.close();
        statement.close();
    }

    @Override
    public Product checkId(Integer id) throws SQLException {
      Product product = null;
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(FINDALL);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            Integer id1 = rs.getInt("product_id");
            String name = rs.getString("product_name");
            Integer price = rs.getInt("price");
            int category_id = rs.getInt("nameCategory");
            String image_url = rs.getString("image_url");
            product = new Product(id1, name, price, category_id, image_url);
        }
        connection.close();
        statement.close();
        rs.close();
        return product;
    }
}
