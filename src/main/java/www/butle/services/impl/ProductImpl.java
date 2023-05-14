package www.butle.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import www.butle.models.Product;
import www.butle.repos.ProductRepo;
import www.butle.services.ProductServices;

import java.util.List;

@Service
public class ProductImpl implements ProductServices {
    private ProductRepo repo;

    @Autowired
    public ProductImpl(ProductRepo repo) {
        this.repo = repo;
    }

    @Override
    public Product add(Product product) {
        return repo.save(product);
    }

    @Override
    public Product update(Product product) {
        long productId = product.getId();
        Product product1 = repo.findProductById(Long.valueOf(productId));
        if(product1 == null){
            return null;
        }
        return repo.save(product);
    }

    @Override
    public boolean delete(long id) {
        Product product = repo.findProductById(Long.valueOf(id));
        if (product == null){
            return false;
        }
        repo.delete(product);
        return true;
    }

    @Override
    public List<Product> getAll() {
        return repo.findAll();
    }
}
