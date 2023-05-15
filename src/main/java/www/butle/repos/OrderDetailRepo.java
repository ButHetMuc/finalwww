package www.butle.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import www.butle.models.OrderDetail;

import java.util.List;

public interface OrderDetailRepo extends JpaRepository<OrderDetail,Long> {
    public OrderDetail findOrderDetailById(Long id);
    public List<OrderDetail> findOrderDetailByOrderId(Long id);
    public void deleteById(Long id);

}
