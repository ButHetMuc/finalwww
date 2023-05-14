package www.butle.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import www.butle.models.Product;

public interface ProductRepo extends JpaRepository<Product,Long> {
    public Product findProductById(Long id);

}
