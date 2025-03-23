package RestaurantManagementSystem.SpringBootExample.Service;

import RestaurantManagementSystem.SpringBootExample.Model.Admin;
import RestaurantManagementSystem.SpringBootExample.Repository.IAdminRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AdminServiceTest {

    @Mock
    private IAdminRepo adminRepo;

    @InjectMocks
    private AdminService adminService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // Tests for createAdmin
    @Test
    void testCreateAdmin_Basic() {
        Admin admin = new Admin(null, "John Doe", "john@admin.com", null);
        Admin savedAdmin = new Admin(1, "John Doe", "john@admin.com", LocalDateTime.now());

        when(adminRepo.save(any(Admin.class))).thenReturn(savedAdmin);

        Admin result = adminService.createAdmin(admin);
        assertNotNull(result);
        assertEquals(1, result.getAdminId());
        verify(adminRepo, times(1)).save(admin);
    }

    @Test
    void testCreateAdmin_Null() {
        assertThrows(NullPointerException.class, () -> adminService.createAdmin(null));
    }

    @Test
    void testCreateAdmin_Edge() {
        Admin admin = new Admin(null, "", "", null);
        Admin savedAdmin = new Admin(1, "", "", LocalDateTime.now());

        when(adminRepo.save(any(Admin.class))).thenReturn(savedAdmin);

        Admin result = adminService.createAdmin(admin);
        assertNotNull(result);
        assertEquals(1, result.getAdminId());
        assertEquals("", result.getAdminName());
        verify(adminRepo, times(1)).save(admin);
    }

    // Tests for updateAdmin
    @Test
    void testUpdateAdmin_Basic() {
        Admin existingAdmin = new Admin(1, "John Doe", "john@admin.com", LocalDateTime.now());
        Admin updatedAdmin = new Admin(null, "Jane Doe", "jane@admin.com", null);

        when(adminRepo.findById(1)).thenReturn(Optional.of(existingAdmin));
        when(adminRepo.save(any(Admin.class))).thenReturn(existingAdmin);

        Admin result = adminService.updateAdmin(1, updatedAdmin);
        assertNotNull(result);
        assertEquals("Jane Doe", result.getAdminName());
        assertEquals("jane@admin.com", result.getAdminEmail());
        verify(adminRepo, times(1)).findById(1);
        verify(adminRepo, times(1)).save(existingAdmin);
    }

    @Test
    void testUpdateAdmin_Null() {
        assertThrows(EntityNotFoundException.class, () -> adminService.updateAdmin(1, null));
    }

    @Test
    void testUpdateAdmin_Edge() {
        Admin existingAdmin = new Admin(1, "John Doe", "john@admin.com", LocalDateTime.now());
        Admin updatedAdmin = new Admin(null, "", "", null);

        when(adminRepo.findById(1)).thenReturn(Optional.of(existingAdmin));
        when(adminRepo.save(any(Admin.class))).thenReturn(existingAdmin);

        Admin result = adminService.updateAdmin(1, updatedAdmin);
        assertNotNull(result);
        assertEquals("", result.getAdminName());
        assertEquals("", result.getAdminEmail());
        verify(adminRepo, times(1)).findById(1);
        verify(adminRepo, times(1)).save(existingAdmin);
    }

    // Tests for deleteAdmin
    @Test
    void testDeleteAdmin_Basic() {
        Admin admin = new Admin(1, "John Doe", "john@admin.com", LocalDateTime.now());
        when(adminRepo.findById(1)).thenReturn(Optional.of(admin));

        assertDoesNotThrow(() -> adminService.deleteAdmin(1));
        verify(adminRepo, times(1)).findById(1);
        verify(adminRepo, times(1)).delete(admin);
    }

    @Test
    void testDeleteAdmin_Null() {
        when(adminRepo.findById(1)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> adminService.deleteAdmin(1));
        verify(adminRepo, times(1)).findById(1);
    }

    @Test
    void testDeleteAdmin_Edge() {
        assertThrows(EntityNotFoundException.class, () -> adminService.deleteAdmin(Integer.MAX_VALUE));
    }

    // Tests for getAdminById
    @Test
    void testGetAdminById_Basic() {
        Admin admin = new Admin(1, "John Doe", "john@admin.com", LocalDateTime.now());
        when(adminRepo.findById(1)).thenReturn(Optional.of(admin));

        Admin result = adminService.getAdminById(1);
        assertNotNull(result);
        assertEquals("John Doe", result.getAdminName());
        verify(adminRepo, times(1)).findById(1);
    }

    @Test
    void testGetAdminById_Null() {
        when(adminRepo.findById(1)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> adminService.getAdminById(1));
    }

    @Test
    void testGetAdminById_Edge() {
        assertThrows(EntityNotFoundException.class, () -> adminService.getAdminById(Integer.MIN_VALUE));
    }

    // Tests for getAllAdmins
    @Test
    void testGetAllAdmins_Basic() {
        List<Admin> admins = Arrays.asList(
                new Admin(1, "John Doe", "john@admin.com", LocalDateTime.now()),
                new Admin(2, "Jane Doe", "jane@admin.com", LocalDateTime.now())
        );
        when(adminRepo.findAll()).thenReturn(admins);

        List<Admin> result = adminService.getAllAdmins();
        assertNotNull(result);
        assertEquals(2, result.size());
        verify(adminRepo, times(1)).findAll();
    }

    @Test
    void testGetAllAdmins_Null() {
        when(adminRepo.findAll()).thenReturn(null);

        List<Admin> result = adminService.getAllAdmins();
        assertNull(result);
        verify(adminRepo, times(1)).findAll();
    }

    @Test
    void testGetAllAdmins_Edge() {
        when(adminRepo.findAll()).thenReturn(Arrays.asList());

        List<Admin> result = adminService.getAllAdmins();
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(adminRepo, times(1)).findAll();
    }
}
