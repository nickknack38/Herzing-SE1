package RestaurantManagementSystem.SpringBootExample.Controller;

import RestaurantManagementSystem.SpringBootExample.Model.Food;
import RestaurantManagementSystem.SpringBootExample.Service.FoodService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FoodControllerTest {

    @Mock
    private FoodService foodService;

    @InjectMocks
    private FoodController foodController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // Tests for createFoodItem
    @Test
    void testCreateFoodItem_Basic() {
        Food food = new Food(1, "Pizza", "Cheesy delight", null, null, 12.99, LocalDateTime.now());
        doNothing().when(foodService).createFood(food);

        ResponseEntity<?> response = foodController.createFoodItem(food);
        assertEquals(201, response.getStatusCodeValue());
        assertEquals("Food item created successfully", response.getBody());
    }

    @Test
    void testCreateFoodItem_Null() {
        ResponseEntity<?> response = foodController.createFoodItem(null);
        assertEquals(201, response.getStatusCodeValue());
        assertEquals("Food item created successfully", response.getBody()); // Assert behavior when null is passed
    }

    @Test
    void testCreateFoodItem_Edge() {
        Food food = new Food();
        doNothing().when(foodService).createFood(food);

        ResponseEntity<?> response = foodController.createFoodItem(food);
        assertEquals(201, response.getStatusCodeValue());
        assertEquals("Food item created successfully", response.getBody());
    }

    // Tests for getAllFoodItems
    @Test
    void testGetAllFoodItems_Basic() {
        List<Food> foodList = Arrays.asList(
                new Food(1, "Pizza", "Cheesy delight", null, null, 12.99, LocalDateTime.now()),
                new Food(2, "Burger", "Juicy goodness", null, null, 8.99, LocalDateTime.now())
        );
        when(foodService.getAllFoodItems()).thenReturn(foodList);

        ResponseEntity<List<Food>> response = foodController.getAllFoodItems();
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(2, response.getBody().size());
    }

    @Test
    void testGetAllFoodItems_Null() {
        when(foodService.getAllFoodItems()).thenReturn(null);

        ResponseEntity<List<Food>> response = foodController.getAllFoodItems();
        assertNull(response.getBody());
    }

    @Test
    void testGetAllFoodItems_Edge() {
        when(foodService.getAllFoodItems()).thenReturn(Arrays.asList());

        ResponseEntity<List<Food>> response = foodController.getAllFoodItems();
        assertEquals(200, response.getStatusCodeValue());
        assertTrue(response.getBody().isEmpty());
    }

    // Tests for getFoodItemById
    @Test
    void testGetFoodItemById_Basic() {
        Food food = new Food(1, "Pizza", "Cheesy delight", null, null, 12.99, LocalDateTime.now());
        when(foodService.getFoodById(1)).thenReturn(food);

        ResponseEntity<Food> response = foodController.getFoodItemById(1);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Pizza", response.getBody().getFoodTitle());
    }

    @Test
    void testGetFoodItemById_Null() {
        when(foodService.getFoodById(1)).thenReturn(null);

        ResponseEntity<Food> response = foodController.getFoodItemById(1);
        assertNull(response.getBody());
    }

    @Test
    void testGetFoodItemById_Edge() {
        when(foodService.getFoodById(Integer.MAX_VALUE)).thenReturn(null);

        ResponseEntity<Food> response = foodController.getFoodItemById(Integer.MAX_VALUE);
        assertNull(response.getBody());
    }

    // Tests for updateFoodItem
    @Test
    void testUpdateFoodItem_Basic() {
        Food food = new Food(1, "Burger", "Spicy delight", null, null, 9.99, LocalDateTime.now());
        doNothing().when(foodService).updateFood(1, food);

        ResponseEntity<?> response = foodController.updateFoodItem(1, food);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Food item updated successfully", response.getBody());
    }

    @Test
    void testUpdateFoodItem_Null() {
        ResponseEntity<?> response = foodController.updateFoodItem(1, null);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Food item updated successfully", response.getBody());
    }

    @Test
    void testUpdateFoodItem_Edge() {
        Food food = new Food();
        doNothing().when(foodService).updateFood(1, food);

        ResponseEntity<?> response = foodController.updateFoodItem(1, food);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Food item updated successfully", response.getBody());
    }

    // Tests for deleteFoodItem
    @Test
    void testDeleteFoodItem_Basic() {
        doNothing().when(foodService).deleteFood(1);

        ResponseEntity<?> response = foodController.deleteFoodItem(1);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Food item deleted successfully", response.getBody());
    }

    @Test
    void testDeleteFoodItem_Null() {
        ResponseEntity<?> response = foodController.deleteFoodItem(null);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Food item deleted successfully", response.getBody());
    }

    @Test
    void testDeleteFoodItem_Edge() {
        doNothing().when(foodService).deleteFood(Integer.MAX_VALUE);

        ResponseEntity<?> response = foodController.deleteFoodItem(Integer.MAX_VALUE);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Food item deleted successfully", response.getBody());
    }
}
