package RestaurantManagementSystem.SpringBootExample.Service;

import RestaurantManagementSystem.SpringBootExample.Model.Food;
import RestaurantManagementSystem.SpringBootExample.Repository.IFoodRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FoodServiceTest {

    @Mock
    private IFoodRepo foodRepo;

    @InjectMocks
    private FoodService foodService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // Tests for createFood
    @Test
    void testCreateFood_Basic() {
        Food food = new Food(1, "Pizza", "Cheesy delight", null, null, 12.99, null);
        when(foodRepo.save(food)).thenReturn(food);

        Food result = foodService.createFood(food);
        assertNotNull(result);
        assertEquals("Pizza", result.getFoodTitle());
        verify(foodRepo, times(1)).save(food);
    }

    @Test
    void testCreateFood_Null() {
        when(foodRepo.save(null)).thenThrow(NullPointerException.class);

        assertThrows(NullPointerException.class, () -> foodService.createFood(null));
        verify(foodRepo, times(1)).save(null);
    }

    @Test
    void testCreateFood_Edge() {
        Food food = new Food(1, "", "", null, null, 0.0, null);
        when(foodRepo.save(food)).thenReturn(food);

        Food result = foodService.createFood(food);
        assertNotNull(result);
        assertEquals("", result.getFoodTitle());
        assertEquals(0.0, result.getFoodPrice());
        verify(foodRepo, times(1)).save(food);
    }

    // Tests for updateFood
    @Test
    void testUpdateFood_Basic() {
        Food existingFood = new Food(1, "Pizza", "Cheesy delight", null, null, 12.99, null);
        Food updatedFood = new Food(1, "Burger", "Juicy goodness", null, null, 9.99, null);

        when(foodRepo.findById(1)).thenReturn(Optional.of(existingFood));
        when(foodRepo.save(existingFood)).thenReturn(updatedFood);

        Food result = foodService.updateFood(1, updatedFood);
        assertNotNull(result);
        assertEquals("Burger", result.getFoodTitle());
        verify(foodRepo, times(1)).findById(1);
        verify(foodRepo, times(1)).save(existingFood);
    }

    @Test
    void testUpdateFood_Null() {
        when(foodRepo.findById(1)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> foodService.updateFood(1, null));
        verify(foodRepo, times(1)).findById(1);
    }

    @Test
    void testUpdateFood_Edge() {
        Food existingFood = new Food(1, "Pizza", "Cheesy delight", null, null, 12.99, null);
        Food updatedFood = new Food(1, "", "", null, null, 0.0, null);

        when(foodRepo.findById(1)).thenReturn(Optional.of(existingFood));
        when(foodRepo.save(existingFood)).thenReturn(updatedFood);

        Food result = foodService.updateFood(1, updatedFood);
        assertNotNull(result);
        assertEquals("", result.getFoodTitle());
        assertEquals(0.0, result.getFoodPrice());
        verify(foodRepo, times(1)).findById(1);
        verify(foodRepo, times(1)).save(existingFood);
    }

    // Tests for deleteFood
    @Test
    void testDeleteFood_Basic() {
        Food food = new Food(1, "Pizza", "Cheesy delight", null, null, 12.99, null);

        when(foodRepo.findById(1)).thenReturn(Optional.of(food));
        doNothing().when(foodRepo).delete(food);

        assertDoesNotThrow(() -> foodService.deleteFood(1));
        verify(foodRepo, times(1)).findById(1);
        verify(foodRepo, times(1)).delete(food);
    }

    @Test
    void testDeleteFood_Null() {
        when(foodRepo.findById(1)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> foodService.deleteFood(1));
        verify(foodRepo, times(1)).findById(1);
    }

    @Test
    void testDeleteFood_Edge() {
        when(foodRepo.findById(Integer.MAX_VALUE)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> foodService.deleteFood(Integer.MAX_VALUE));
        verify(foodRepo, times(1)).findById(Integer.MAX_VALUE);
    }

    // Tests for getFoodById
    @Test
    void testGetFoodById_Basic() {
        Food food = new Food(1, "Pizza", "Cheesy delight", null, null, 12.99, null);

        when(foodRepo.findById(1)).thenReturn(Optional.of(food));

        Food result = foodService.getFoodById(1);
        assertNotNull(result);
        assertEquals("Pizza", result.getFoodTitle());
        verify(foodRepo, times(1)).findById(1);
    }

    @Test
    void testGetFoodById_Null() {
        when(foodRepo.findById(1)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> foodService.getFoodById(1));
        verify(foodRepo, times(1)).findById(1);
    }

    @Test
    void testGetFoodById_Edge() {
        when(foodRepo.findById(Integer.MAX_VALUE)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> foodService.getFoodById(Integer.MAX_VALUE));
        verify(foodRepo, times(1)).findById(Integer.MAX_VALUE);
    }

    // Tests for getAllFoodItems
    @Test
    void testGetAllFoodItems_Basic() {
        List<Food> foodList = Arrays.asList(
                new Food(1, "Pizza", "Cheesy delight", null, null, 12.99, null),
                new Food(2, "Burger", "Juicy goodness", null, null, 8.99, null)
        );
        when(foodRepo.findAll()).thenReturn(foodList);

        List
