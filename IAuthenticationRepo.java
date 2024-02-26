package RestaurantManagementSystem.SpringBootExample.Repository;

import RestaurantManagementSystem.SpringBootExample.Model.AuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthenticationRepo extends JpaRepository<AuthenticationToken, Long> {
    AuthenticationToken findFirstByTokenValue(String authTokenValue);
}