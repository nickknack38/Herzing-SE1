package RestaurantManagementSystem.SpringBootExample.Repository;


import RestaurantManagementSystem.SpringBootExample.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdminRepo extends JpaRepository<Admin, Integer> {
    Admin findFirstByAdminEmail(String email);
}
