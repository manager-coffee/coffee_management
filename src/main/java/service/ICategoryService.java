package service;

import model.Category;

import java.sql.SQLException;
import java.util.List;

public interface ICategoryService {
    List<Category> findAllCate() throws SQLException;

}
