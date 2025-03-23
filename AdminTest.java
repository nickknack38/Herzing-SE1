package RestaurantManagementSystem.SpringBootExample.Model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;

class AdminTest {

    // Test for getAdminEmail
    @Test
    void testGetAdminEmail_Basic() {
        Admin admin = new Admin(1, "John Doe", "john@admin.com", LocalDateTime.now());
        assertEquals("john@admin.com", admin.getAdminEmail());
    }

    @Test
    void testGetAdminEmail_Null() {
        Admin admin = new Admin(1, "John Doe", null, LocalDateTime.now());
        assertNull(admin.getAdminEmail());
    }

    @Test
    void testGetAdminEmail_Edge() {
        Admin admin = new Admin(1, "John Doe", "@admin.com", LocalDateTime.now());
        assertEquals("@admin.com", admin.getAdminEmail());
    }

    // Test for setAdminEmail
    @Test
    void testSetAdminEmail_Basic() {
        Admin admin = new Admin();
        admin.setAdminEmail("jane@admin.com");
        assertEquals("jane@admin.com", admin.getAdminEmail());
    }

    @Test
    void testSetAdminEmail_Null() {
        Admin admin = new Admin();
        admin.setAdminEmail(null);
        assertNull(admin.getAdminEmail());
    }

    @Test
    void testSetAdminEmail_Edge() {
        Admin admin = new Admin();
        admin.setAdminEmail("invalidemail");
        assertEquals("invalidemail", admin.getAdminEmail());
    }
}
