package service;

import dto.ProductDto;

import java.sql.SQLException;
import java.util.List;

public interface IProductService {
    List<ProductDto> findAll() throws SQLException;

}
