package RestaurantManagementSystem.SpringBootExample.Model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;

class OrderTest {

    // Tests for getOrderQuantity
    @Test
    void testGetOrderQuantity_Basic() {
        Order order = new Order(1, 10, null, null, null, null);
        assertEquals(10, order.getOrderQuantity());
    }

    @Test
    void testGetOrderQuantity_Null() {
        Order order = new Order();
        order.setOrderQuantity(null);
        assertNull(order.getOrderQuantity());
    }

    @Test
    void testGetOrderQuantity_Edge() {
        Order order = new Order(1, Integer.MAX_VALUE, null, null, null, null);
        assertEquals(Integer.MAX_VALUE, order.getOrderQuantity());
    }

    // Tests for setOrderQuantity
    @Test
    void testSetOrderQuantity_Basic() {
        Order order = new Order();
        order.setOrderQuantity(20);
        assertEquals(20, order.getOrderQuantity());
    }

    @Test
    void testSetOrderQuantity_Null() {
        Order order = new Order();
        order.setOrderQuantity(null);
        assertNull(order.getOrderQuantity());
    }

    @Test
    void testSetOrderQuantity_Edge() {
        Order order = new Order();
        order.setOrderQuantity(Integer.MIN_VALUE);
        assertEquals(Integer.MIN_VALUE, order.getOrderQuantity());
    }

    // Tests for getOrderStatus
    @Test
    void testGetOrderStatus_Basic() {
        OrderStatus status = OrderStatus.PENDING;
        Order order = new Order(1, 10, status, null, null, null);
        assertEquals(OrderStatus.PENDING, order.getOrderStatus());
    }

    @Test
    void testGetOrderStatus_Null() {
        Order order = new Order();
        order.setOrderStatus(null);
        assertNull(order.getOrderStatus());
    }

    @Test
    void testGetOrderStatus_Edge() {
        Order order = new Order(1, 10, null, null, null, null);
        assertNull(order.getOrderStatus()); // Edge case: no status set
    }

    // Tests for setOrderStatus
    @Test
    void testSetOrderStatus_Basic() {
        Order order = new Order();
        order.setOrderStatus(OrderStatus.CONFIRMED);
        assertEquals(OrderStatus.CONFIRMED, order.getOrderStatus());
    }

    @Test
    void testSetOrderStatus_Null() {
        Order order = new Order();
        order.setOrderStatus(null);
        assertNull(order.getOrderStatus());
    }

    @Test
    void testSetOrderStatus_Edge() {
        Order order = new Order();
        order.setOrderStatus(OrderStatus.CANCELLED);
        assertEquals(OrderStatus.CANCELLED, order.getOrderStatus());
    }

    // Tests for getCreatedAt
    @Test
    void testGetCreatedAt_Basic() {
        LocalDateTime now = LocalDateTime.now();
        Order order = new Order(1, 10, null, now, null, null);
        assertEquals(now, order.getCreatedAt());
    }

    @Test
    void testGetCreatedAt_Null() {
        Order order = new Order(1, 10, null, null, null, null);
        assertNull(order.getCreatedAt());
    }

    @Test
    void testGetCreatedAt_Edge() {
        LocalDateTime epoch = LocalDateTime.of(1970, 1, 1, 0, 0);
        Order order = new Order(1, 10, null, epoch, null, null);
        assertEquals(epoch, order.getCreatedAt());
    }

    // Tests for setCreatedAt
    @Test
    void testSetCreatedAt_Basic() {
        LocalDateTime now = LocalDateTime.now();
        Order order = new Order();
        order.setCreatedAt(now);
        assertEquals(now, order.getCreatedAt());
    }

    @Test
    void testSetCreatedAt_Null() {
        Order order = new Order();
        order.setCreatedAt(null);
        assertNull(order.getCreatedAt());
    }

    @Test
    void testSetCreatedAt_Edge() {
        LocalDateTime futureDate = LocalDateTime.of(2099, 12, 31, 23, 59);
        Order order = new Order();
        order.setCreatedAt(futureDate);
        assertEquals(futureDate, order.getCreatedAt());
    }
}
