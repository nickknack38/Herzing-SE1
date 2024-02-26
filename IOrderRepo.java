package RestaurantManagementSystem.SpringBootExample.Repository;

import RestaurantManagementSystem.SpringBootExample.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepo extends JpaRepository<Order, Integer> {
}