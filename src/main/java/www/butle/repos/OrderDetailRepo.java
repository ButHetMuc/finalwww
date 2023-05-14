package www.butle.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import www.butle.models.OrderDetail;

public interface OrderDetailRepo extends JpaRepository<OrderDetail,Long> {
    public OrderDetail findOrderDetailById(Long id);
    public OrderDetail findOrderDetailByOrderId(Long id);
}
