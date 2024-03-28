package repository;

import DB.DBConnection;
import dto.ProductDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProductRepository implements IProductRepository{
    private String FINDALL=" select Product.*,Category.name as nameCategory from Product join Category on Product" +
            ".category_id=Category.id;";
    @Override
    public List<ProductDto> findAll() throws SQLException {
        List<ProductDto> productDtos=new ArrayList<>();
        Connection connection= DBConnection.getConnection();
        PreparedStatement statement=connection.prepareStatement(FINDALL);
        ResultSet rs=statement.executeQuery();
        while (rs.next()){
            Integer id=rs.getInt("product_id");
            String name=rs.getString("product_name");
            Integer price=rs.getInt("price");
            String category_id=rs.getString("nameCategory");
            String image_url=rs.getString("image_url");
            productDtos.add(new ProductDto(id,name,price,category_id,image_url));
        }
        connection.close();
        statement.close();
        rs.close();
        return productDtos;
    }
}
