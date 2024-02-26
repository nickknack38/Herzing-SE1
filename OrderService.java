package RestaurantManagementSystem.SpringBootExample.Service;

import RestaurantManagementSystem.SpringBootExample.Model.Order;
import RestaurantManagementSystem.SpringBootExample.Repository.IOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private IOrderRepo orderRepo;

    public Order createOrder(Order order) {

        return orderRepo.save(order);
    }

    public Order updateOrder(Integer orderId, Order updatedOrder) {
        Order existingOrder = orderRepo.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Order not found"));


        existingOrder.setOrderQuantity(updatedOrder.getOrderQuantity());
        existingOrder.setOrderStatus(updatedOrder.getOrderStatus());


        return orderRepo.save(existingOrder);
    }

    public void deleteOrder(Integer orderId) {
        Order existingOrder = orderRepo.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Order not found"));

        orderRepo.delete(existingOrder);
    }

    public Order getOrderById(Integer orderId) {
        return orderRepo.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Order not found"));
    }

    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }
}