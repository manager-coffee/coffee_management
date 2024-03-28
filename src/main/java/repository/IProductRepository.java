package repository;

import dto.ProductDto;
import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductRepository {
    List<ProductDto> findAll() throws SQLException;

    void createPro(Product product) throws SQLException;

    void findById(Integer id) throws SQLException;

    void updatePro(Product product) throws SQLException;

    Product checkId(Integer id) throws SQLException;

}
