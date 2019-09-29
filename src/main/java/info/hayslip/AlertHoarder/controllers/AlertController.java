package info.hayslip.AlertHoarder.controllers;

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
           if(returnedAlert.getAlertId().isEmpty()) {
               throw new ValidationException("Error accessing Cosmos database.");
           }
           return new StatusMessage("200", "Alert Added");
    }
}
