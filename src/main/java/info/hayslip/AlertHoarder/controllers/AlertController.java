package info.hayslip.AlertHoarder.controllers;

import com.azure.data.cosmos.NotFoundException;
import info.hayslip.AlertHoarder.models.Alert;
import info.hayslip.AlertHoarder.models.StatusMessage;
import info.hayslip.AlertHoarder.repositories.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/v1/alerts")
public class AlertController {

    @Autowired
    private AlertRepository alertRepository;

    @GetMapping("/all")
    public Iterable getAllAlerts() {
        if (StreamSupport.stream(alertRepository.findAll().spliterator(), false).count() > 0) {
            return alertRepository.findAll();
        } else {
            throw new ValidationException("No records found.");
        }
    }

    @PostMapping("/add")
    public StatusMessage addAlert(@Valid @RequestBody Alert alert) {
        Alert returnedAlert = alertRepository.save(alert);
        if (returnedAlert.getAlertId().isEmpty()) {
            throw new ValidationException("Error accessing Cosmos database.");
        }
        return new StatusMessage("200", "Alert Added");
    }


    @DeleteMapping("/delete/{id}")
    public StatusMessage deleteAlert(@PathVariable String id) throws NotFoundException {
        if (alertRepository.findById(id).isEmpty()) {
            throw new NotFoundException("No alert found with id: " + id);
        }
        alertRepository.deleteById(id);
        return new StatusMessage("200", "alert deleted.");
    }

    @GetMapping("find/{id}")
    public Alert findAlert(@PathVariable String id) throws NotFoundException {
        return alertRepository.findById(id).orElseThrow(
                () -> new NotFoundException("No alert found with id: " + id)
        );
    }
}
