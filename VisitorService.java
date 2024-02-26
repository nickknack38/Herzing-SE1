package RestaurantManagementSystem.SpringBootExample.Service;

import RestaurantManagementSystem.SpringBootExample.DTO.SignUpOutput;
import RestaurantManagementSystem.SpringBootExample.Model.Visitor;
import RestaurantManagementSystem.SpringBootExample.Repository.IVisitorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class VisitorService {
    @Autowired
    private IVisitorRepo visitorRepo;

    public SignUpOutput signUpVisitor(Visitor visitor) {

        visitorRepo.save(visitor);
        return new SignUpOutput(true, "Visitor registered successfully");
    }

    public List<Visitor> getAllVisitors() {
        return visitorRepo.findAll();
    }

    public Visitor getVisitorById(Integer visitorId) {
        return visitorRepo.findById(visitorId)
                .orElseThrow(() -> new EntityNotFoundException("Visitor not found with ID: " + visitorId));
    }

    public void updateVisitor(Integer visitorId, Visitor visitor) {
        Visitor existingVisitor = getVisitorById(visitorId);

        visitorRepo.save(existingVisitor);
    }

    public void deleteVisitor(Integer visitorId) {
        Visitor visitor = getVisitorById(visitorId);
        visitorRepo.delete(visitor);
    }
}