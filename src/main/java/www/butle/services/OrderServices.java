package www.butle.services;


import www.butle.models.Order;

import java.util.List;

public interface OrderServices {
    public Order add (Order order);
    public Order update (Order order);
    public boolean delete(Long id);
    public List<Order> getAllByAccountId(Long accountId);
    public List<Order> getAll();
}
