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
        repo.save(order);
        for(OrderDetail detail: order.getOrderDetails()){
            detail.setOrder(order);
            detailRepo.save(detail);
        }
        List<OrderDetail> details = detailRepo.findOrderDetailByOrderId(order.getId());
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
//        List<OrderDetail> details = order1.getOrderDetails();
//        details.removeAll(details);
//        order1.setOrderDetails(details);
//        repo.save(order1);

//        repo.save(order);
//        for(OrderDetail detail: order.getOrderDetails()){
//            detail.setOrder(order);
//            detailRepo.save(detail);
//        }
//        List<OrderDetail> details1 = detailRepo.findOrderDetailByOrderId(order.getId());
//        order.setOrderDetails(details1);
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

    @Override
    public List<Order> getAll() {
        return repo.findAll();
    }
}
