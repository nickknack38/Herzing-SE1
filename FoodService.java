package RestaurantManagementSystem.SpringBootExample.Service;

import RestaurantManagementSystem.SpringBootExample.Model.Food;
import RestaurantManagementSystem.SpringBootExample.Repository.IFoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class FoodService {
    @Autowired
    private IFoodRepo foodRepo;

    public Food createFood(Food food) {

        return foodRepo.save(food);
    }

    public Food updateFood(Integer foodId, Food updatedFood) {
        Food existingFood = foodRepo.findById(foodId)
                .orElseThrow(() -> new EntityNotFoundException("Food not found"));


        existingFood.setFoodTitle(updatedFood.getFoodTitle());
        existingFood.setFoodDesc(updatedFood.getFoodDesc());
        existingFood.setFoodType(updatedFood.getFoodType());


        return foodRepo.save(existingFood);
    }

    public void deleteFood(Integer foodId) {
        Food existingFood = foodRepo.findById(foodId)
                .orElseThrow(() -> new EntityNotFoundException("Food not found"));

        foodRepo.delete(existingFood);
    }

    public Food getFoodById(Integer foodId) {
        return foodRepo.findById(foodId)
                .orElseThrow(() -> new EntityNotFoundException("Food not found"));
    }

    public List<Food> getAllFoodItems() {
        return foodRepo.findAll();
    }
}