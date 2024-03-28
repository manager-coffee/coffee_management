package service;

import dto.ProductDto;
import repository.IProductRepository;
import repository.ProductRepository;

import java.sql.SQLException;
import java.util.List;

public class ProductService implements IProductService{
    private IProductRepository iProductRepository=new ProductRepository();
    @Override
    public List<ProductDto> findAll() throws SQLException {
        return iProductRepository.findAll();

    }
}
