package service;

import dto.ProductDto;
import model.Product;
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

    @Override
    public void createPro(Product product) throws SQLException {
        iProductRepository.createPro(product);
    }

    @Override
    public void findById(Integer id) throws SQLException {
        iProductRepository.findById(id);
    }

    @Override
    public void updatePro(Product product) throws SQLException {
        iProductRepository.updatePro(product);
    }

    @Override
    public Product checkId(Integer id) throws SQLException {
        return iProductRepository.checkId(id);
    }
}
