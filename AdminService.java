package RestaurantManagementSystem.SpringBootExample.Service;

import RestaurantManagementSystem.SpringBootExample.Model.Admin;
import RestaurantManagementSystem.SpringBootExample.Repository.IAdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AdminService {
    @Autowired
    private IAdminRepo adminRepo;

    public Admin createAdmin(Admin admin) {
        admin.setCreatedAt(LocalDateTime.now());
        return adminRepo.save(admin);
    }

    public Admin updateAdmin(Integer adminId, Admin updatedAdmin) {
        Admin existingAdmin = adminRepo.findById(adminId)
                .orElseThrow(() -> new EntityNotFoundException("Admin not found"));


        existingAdmin.setAdminName(updatedAdmin.getAdminName());
        existingAdmin.setAdminEmail(updatedAdmin.getAdminEmail());


        return adminRepo.save(existingAdmin);
    }

    public void deleteAdmin(Integer adminId) {
        Admin existingAdmin = adminRepo.findById(adminId)
                .orElseThrow(() -> new EntityNotFoundException("Admin not found"));

        adminRepo.delete(existingAdmin);
    }

    public Admin getAdminById(Integer adminId) {
        return adminRepo.findById(adminId)
                .orElseThrow(() -> new EntityNotFoundException("Admin not found"));
    }

    public List<Admin> getAllAdmins() {
        return adminRepo.findAll();
    }
}