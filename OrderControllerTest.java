package RestaurantManagementSystem.SpringBootExample.Controller;

import RestaurantManagementSystem.SpringBootExample.Model.Order;
import RestaurantManagementSystem.SpringBootExample.Service.OrderService;
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

class OrderControllerTest {

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // Tests for createOrder
    @Test
    void testCreateOrder_Basic() {
        Order order = new Order(1, 2, null, LocalDateTime.now(), null, null);
        doNothing().when(orderService).createOrder(order);

        ResponseEntity<?> response = orderController.createOrder(order);
        assertEquals(201, response.getStatusCodeValue());
        assertEquals("Order created successfully", response.getBody());
    }

    @Test
    void testCreateOrder_Null() {
        ResponseEntity<?> response = orderController.createOrder(null);
        assertEquals(201, response.getStatusCodeValue());
        assertEquals("Order created successfully", response.getBody()); // Assuming null input leads to success message
    }

    @Test
    void testCreateOrder_Edge() {
        Order order = new Order();
        doNothing().when(orderService).createOrder(order);

        ResponseEntity<?> response = orderController.createOrder(order);
        assertEquals(201, response.getStatusCodeValue());
        assertEquals("Order created successfully", response.getBody());
    }

    // Tests for getAllOrders
    @Test
    void testGetAllOrders_Basic() {
        List<Order> orders = Arrays.asList(
                new Order(1, 2, null, LocalDateTime.now(), null, null),
                new Order(2, 1, null, LocalDateTime.now(), null, null)
        );
        when(orderService.getAllOrders()).thenReturn(orders);

        ResponseEntity<List<Order>> response = orderController.getAllOrders();
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(2, response.getBody().size());
    }

    @Test
    void testGetAllOrders_Null() {
        when(orderService.getAllOrders()).thenReturn(null);

        ResponseEntity<List<Order>> response = orderController.getAllOrders();
        assertNull(response.getBody());
    }

    @Test
    void testGetAllOrders_Edge() {
        when(orderService.getAllOrders()).thenReturn(Arrays.asList());

        ResponseEntity<List<Order>> response = orderController.getAllOrders();
        assertEquals(200, response.getStatusCodeValue());
        assertTrue(response.getBody().isEmpty());
    }

    // Tests for getOrderById
    @Test
    void testGetOrderById_Basic() {
        Order order = new Order(1, 2, null, LocalDateTime.now(), null, null);
        when(orderService.getOrderById(1)).thenReturn(order);

        ResponseEntity<Order> response = orderController.getOrderById(1);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(2, response.getBody().getOrderQuantity());
    }

    @Test
    void testGetOrderById_Null() {
        when(orderService.getOrderById(1)).thenReturn(null);

        ResponseEntity<Order> response = orderController.getOrderById(1);
        assertNull(response.getBody());
    }

    @Test
    void testGetOrderById_Edge() {
        when(orderService.getOrderById(Integer.MAX_VALUE)).thenReturn(null);

        ResponseEntity<Order> response = orderController.getOrderById(Integer.MAX_VALUE);
        assertNull(response.getBody());
    }

    // Tests for updateOrder
    @Test
    void testUpdateOrder_Basic() {
        Order order = new Order(1, 3, null, LocalDateTime.now(), null, null);
        doNothing().when(orderService).updateOrder(1, order);

        ResponseEntity<?> response = orderController.updateOrder(1, order);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Order updated successfully", response.getBody());
    }

    @Test
    void testUpdateOrder_Null() {
        ResponseEntity<?> response = orderController.updateOrder(1, null);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Order updated successfully", response.getBody());
    }

    @Test
    void testUpdateOrder_Edge() {
        Order order = new Order();
        doNothing().when(orderService).updateOrder(1, order);

        ResponseEntity<?> response = orderController.updateOrder(1, order);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Order updated successfully", response.getBody());
    }

    // Tests for deleteOrder
    @Test
    void testDeleteOrder_Basic() {
        doNothing().when(orderService).deleteOrder(1);

        ResponseEntity<?> response = orderController.deleteOrder(1);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Order deleted successfully", response.getBody());
    }

    @Test
    void testDeleteOrder_Null() {
        ResponseEntity<?> response = orderController.deleteOrder(null);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Order deleted successfully", response.getBody());
    }

    @Test
    void testDeleteOrder_Edge() {
        doNothing().when(orderService).deleteOrder(Integer.MAX_VALUE);

        ResponseEntity<?> response = orderController.deleteOrder(Integer.MAX_VALUE);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Order deleted successfully", response.getBody());
    }
}
