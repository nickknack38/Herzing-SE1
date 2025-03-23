package RestaurantManagementSystem.SpringBootExample.Model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;

class FoodTest {

    // Tests for getFoodTitle
    @Test
    void testGetFoodTitle_Basic() {
        Food food = new Food(1, "Pizza", "Cheesy delight", null, null, 12.99, LocalDateTime.now());
        assertEquals("Pizza", food.getFoodTitle());
    }

    @Test
    void testGetFoodTitle_Null() {
        Food food = new Food(1, null, "Description", null, null, 12.99, LocalDateTime.now());
        assertNull(food.getFoodTitle());
    }

    @Test
    void testGetFoodTitle_Edge() {
        Food food = new Food(1, "", "Description", null, null, 12.99, LocalDateTime.now());
        assertEquals("", food.getFoodTitle());
    }

    // Tests for setFoodTitle
    @Test
    void testSetFoodTitle_Basic() {
        Food food = new Food();
        food.setFoodTitle("Burger");
        assertEquals("Burger", food.getFoodTitle());
    }

    @Test
    void testSetFoodTitle_Null() {
        Food food = new Food();
        food.setFoodTitle(null);
        assertNull(food.getFoodTitle());
    }

    @Test
    void testSetFoodTitle_Edge() {
        Food food = new Food();
        food.setFoodTitle("");
        assertEquals("", food.getFoodTitle());
    }

    // Tests for getFoodDesc
    @Test
    void testGetFoodDesc_Basic() {
        Food food = new Food(1, "Pizza", "Cheesy delight", null, null, 12.99, LocalDateTime.now());
        assertEquals("Cheesy delight", food.getFoodDesc());
    }

    @Test
    void testGetFoodDesc_Null() {
        Food food = new Food(1, "Pizza", null, null, null, 12.99, LocalDateTime.now());
        assertNull(food.getFoodDesc());
    }

    @Test
    void testGetFoodDesc_Edge() {
        Food food = new Food(1, "Pizza", "", null, null, 12.99, LocalDateTime.now());
        assertEquals("", food.getFoodDesc());
    }

    // Tests for setFoodDesc
    @Test
    void testSetFoodDesc_Basic() {
        Food food = new Food();
        food.setFoodDesc("Spicy goodness");
        assertEquals("Spicy goodness", food.getFoodDesc());
    }

    @Test
    void testSetFoodDesc_Null() {
        Food food = new Food();
        food.setFoodDesc(null);
        assertNull(food.getFoodDesc());
    }

    @Test
    void testSetFoodDesc_Edge() {
        Food food = new Food();
        food.setFoodDesc("");
        assertEquals("", food.getFoodDesc());
    }

    // Tests for getFoodPrice
    @Test
    void testGetFoodPrice_Basic() {
        Food food = new Food(1, "Pizza", "Cheesy delight", null, null, 12.99, LocalDateTime.now());
        assertEquals(12.99, food.getFoodPrice());
    }

    @Test
    void testGetFoodPrice_Null() {
        Food food = new Food(1, "Pizza", "Cheesy delight", null, null, null, LocalDateTime.now());
        assertNull(food.getFoodPrice());
    }

    @Test
    void testGetFoodPrice_Edge() {
        Food food = new Food(1, "Pizza", "Cheesy delight", null, null, Double.MAX_VALUE, LocalDateTime.now());
        assertEquals(Double.MAX_VALUE, food.getFoodPrice());
    }

    // Tests for setFoodPrice
    @Test
    void testSetFoodPrice_Basic() {
        Food food = new Food();
        food.setFoodPrice(8.99);
        assertEquals(8.99, food.getFoodPrice());
    }

    @Test
    void testSetFoodPrice_Null() {
        Food food = new Food();
        food.setFoodPrice(null);
        assertNull(food.getFoodPrice());
    }

    @Test
    void testSetFoodPrice_Edge() {
        Food food = new Food();
        food.setFoodPrice(Double.MIN_VALUE);
        assertEquals(Double.MIN_VALUE, food.getFoodPrice());
    }

    // Additional tests for createdAt, foodImg, and other fields can follow the same pattern.
}
