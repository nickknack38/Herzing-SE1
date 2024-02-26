package RestaurantManagementSystem.SpringBootExample.Repository;

import RestaurantManagementSystem.SpringBootExample.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User, Integer> {
    User findFirstByUserEmail(String newEmail);
}