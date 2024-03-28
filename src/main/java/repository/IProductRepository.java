package repository;

import dto.ProductDto;

import java.sql.SQLException;
import java.util.List;

public interface IProductRepository {
    List<ProductDto> findAll() throws SQLException;

}
