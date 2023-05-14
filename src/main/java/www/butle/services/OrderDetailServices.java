package www.butle.services;


import www.butle.models.OrderDetail;

import java.util.List;

public interface OrderDetailServices {
    public OrderDetail add (OrderDetail detail);
    public OrderDetail update (OrderDetail detail);
    public boolean delete(Long id);
    public List<OrderDetail> getAll();
}
