package RestaurantManagementSystem.SpringBootExample.Model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;

class AuthenticationTokenTest {

    // Test for getTokenValue
    @Test
    void testGetTokenValue_Basic() {
        AuthenticationToken token = new AuthenticationToken(null, "ABC123", null, null);
        assertEquals("ABC123", token.getTokenValue());
    }

    @Test
    void testGetTokenValue_Null() {
        AuthenticationToken token = new AuthenticationToken(null, null, null, null);
        assertNull(token.getTokenValue());
    }

    @Test
    void testGetTokenValue_Edge() {
        AuthenticationToken token = new AuthenticationToken(null, "", null, null);
        assertEquals("", token.getTokenValue());
    }

    // Test for setTokenValue
    @Test
    void testSetTokenValue_Basic() {
        AuthenticationToken token = new AuthenticationToken();
        token.setTokenValue("XYZ789");
        assertEquals("XYZ789", token.getTokenValue());
    }

    @Test
    void testSetTokenValue_Null() {
        AuthenticationToken token = new AuthenticationToken();
        token.setTokenValue(null);
        assertNull(token.getTokenValue());
    }

    @Test
    void testSetTokenValue_Edge() {
        AuthenticationToken token = new AuthenticationToken();
        token.setTokenValue("");
        assertEquals("", token.getTokenValue());
    }

    // Test for getTokenCreationDateTime
    @Test
    void testGetTokenCreationDateTime_Basic() {
        LocalDateTime now = LocalDateTime.now();
        AuthenticationToken token = new AuthenticationToken(null, null, now, null);
        assertEquals(now, token.getTokenCreationDateTime());
    }

    @Test
    void testGetTokenCreationDateTime_Null() {
        AuthenticationToken token = new AuthenticationToken(null, null, null, null);
        assertNull(token.getTokenCreationDateTime());
    }

    @Test
    void testGetTokenCreationDateTime_Edge() {
        LocalDateTime epoch = LocalDateTime.of(1970, 1, 1, 0, 0, 0);
        AuthenticationToken token = new AuthenticationToken(null, null, epoch, null);
        assertEquals(epoch, token.getTokenCreationDateTime());
    }

    // Test for setTokenCreationDateTime
    @Test
    void testSetTokenCreationDateTime_Basic() {
        LocalDateTime now = LocalDateTime.now();
        AuthenticationToken token = new AuthenticationToken();
        token.setTokenCreationDateTime(now);
        assertEquals(now, token.getTokenCreationDateTime());
    }

    @Test
    void testSetTokenCreationDateTime_Null() {
        AuthenticationToken token = new AuthenticationToken();
        token.setTokenCreationDateTime(null);
        assertNull(token.getTokenCreationDateTime());
    }

    @Test
    void testSetTokenCreationDateTime_Edge() {
        LocalDateTime epoch = LocalDateTime.of(1970, 1, 1, 0, 0, 0);
        AuthenticationToken token = new AuthenticationToken();
        token.setTokenCreationDateTime(epoch);
        assertEquals(epoch, token.getTokenCreationDateTime());
    }
}
