package www.butle.services;

import www.butle.models.Product;

import java.util.List;

public interface ProductServices {
    public Product add (Product product);
    public Product update (Product product);
    public boolean delete(long id);
    public List<Product> getAll();
}
