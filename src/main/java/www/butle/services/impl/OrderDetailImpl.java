package www.butle.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import www.butle.models.OrderDetail;
import www.butle.repos.OrderDetailRepo;
import www.butle.services.OrderDetailServices;

import java.util.List;

@Service
public class OrderDetailImpl implements OrderDetailServices {
    private final OrderDetailRepo repo;

    @Autowired
    public OrderDetailImpl(OrderDetailRepo repo) {
        this.repo = repo;
    }

    @Override
    public OrderDetail add(OrderDetail detail) {
        return repo.save(detail);
    }

    @Override
    public OrderDetail update(OrderDetail detail) {
        long detailId = detail.getId();
        OrderDetail detail1 = repo.findOrderDetailById(detailId);
        if(detail1 == null){
            return null;
        }
        repo.save(detail);
        return detail;
    }

    @Override
    public boolean delete(Long id) {
        OrderDetail detail = repo.findOrderDetailById(id);
        if (detail == null){
            return false;
        }
        repo.delete(detail);
        return true;
    }

    @Override
    public List<OrderDetail> getAll() {
        return repo.findAll();
    }
}
