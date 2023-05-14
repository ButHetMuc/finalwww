package www.butle.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import www.butle.models.Order;
import www.butle.models.OrderDetail;
import www.butle.repos.OrderDetailRepo;
import www.butle.repos.OrderRepo;
import www.butle.services.OrderServices;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderImpl implements OrderServices {
    private OrderRepo repo;
    private OrderDetailRepo detailRepo;
    @Autowired
    public OrderImpl(OrderRepo repo,OrderDetailRepo detailRepo) {
        this.repo = repo;
        this.detailRepo = detailRepo;
    }

    @Override
    public Order add(Order order) {

        List<OrderDetail> details = new ArrayList<>();
        repo.save(order);
        for(OrderDetail detail: order.getOrderDetails()){
            detail.setOrder(order);
            detailRepo.save(detail);
            OrderDetail opt = detailRepo.findOrderDetailByOrderId(order.getId());
            details.add(opt);
        }
        order.setOrderDetails(details);
        return order;
    }

    @Override
    public Order update(Order order) {
        long orderId = order.getId();
        Order order1 = repo.findOrderById(orderId);
        if(order1 == null){
            return null;
        }
        repo.save(order);
        return order;
    }

    @Override
    public boolean delete(Long id) {
        Order order = repo.findOrderById(id);
        if (order == null){
            return false;
        }
        repo.delete(order);
        return true;
    }

    @Override
    public List<Order> getAllByAccountId(Long accountId) {
        return repo.getOrdersByAccount_Id(accountId);
    }
}
