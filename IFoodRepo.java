package RestaurantManagementSystem.SpringBootExample.Repository;

import RestaurantManagementSystem.SpringBootExample.Model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFoodRepo extends JpaRepository<Food, Integer> {
}