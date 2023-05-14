package www.butle.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import www.butle.models.Order;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order,Long> {
    public Order findOrderById(Long id);
    public List<Order> getOrdersByAccount_Id(Long accountId);
}
