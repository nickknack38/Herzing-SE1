package RestaurantManagementSystem.SpringBootExample.Repository;

import RestaurantManagementSystem.SpringBootExample.Model.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVisitorRepo extends JpaRepository<Visitor, Integer> {
}