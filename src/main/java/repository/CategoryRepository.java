package repository;

import DB.DBConnection;
import model.Category;
import service.ICategoryService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository implements ICategoryRepository {
    private String FINDALLCATE=" select*from Category;";
    @Override
    public List<Category> findAllCate() throws SQLException {
        List<Category> categories=new ArrayList<>();
        Connection connection= DBConnection.getConnection();
        PreparedStatement statement=connection.prepareStatement(FINDALLCATE);
        ResultSet rs=statement.executeQuery();
        while (rs.next()){
            Integer id=rs.getInt("id");
            String name=rs.getString("name");
            categories.add(new Category(id,name));
        }
        connection.close();
        statement.close();
        rs.close();
        return categories;
    }
}
