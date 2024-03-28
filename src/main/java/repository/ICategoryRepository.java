package repository;

import model.Category;

import java.sql.SQLException;
import java.util.List;

public interface ICategoryRepository {
    List<Category> findAllCate() throws SQLException;

}
