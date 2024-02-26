package RestaurantManagementSystem.SpringBootExample.Service;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import RestaurantManagementSystem.SpringBootExample.DTO.SignUpOutput;
import RestaurantManagementSystem.SpringBootExample.Model.User;
import RestaurantManagementSystem.SpringBootExample.Repository.IUserRepo;

@Service
public class UserService {
    @Autowired
    private IUserRepo userRepo;

    public SignUpOutput signUpUser(User user) {

        userRepo.save(user);
        return new SignUpOutput(true, "User registered successfully");
    }

    public User createUser(User user) {
        user.setCreatedAt(LocalDateTime.now());
        return userRepo.save(user);
    }

    public User updateUser(Integer userId, User updatedUser) {
        User existingUser = userRepo.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));


        existingUser.setUserName(updatedUser.getUserName());
        existingUser.setUserEmail(updatedUser.getUserEmail());
        existingUser.setUserPassword(updatedUser.getUserPassword());


        return userRepo.save(existingUser);
    }

    public void deleteUser(Integer userId) {
        User existingUser = userRepo.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        userRepo.delete(existingUser);
    }

    public User getUserById(Integer userId) {
        return userRepo.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }



    }