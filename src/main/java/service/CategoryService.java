package service;

import model.Category;
import repository.CategoryRepository;
import repository.ICategoryRepository;

import java.sql.SQLException;
import java.util.List;

public class CategoryService implements ICategoryService{
    private ICategoryRepository iCategoryRepository=new CategoryRepository();
    @Override
    public List<Category> findAllCate() throws SQLException {
        return iCategoryRepository.findAllCate();
    }
}
