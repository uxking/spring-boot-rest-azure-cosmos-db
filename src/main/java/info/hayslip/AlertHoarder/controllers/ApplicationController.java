package info.hayslip.AlertHoarder.controllers;

import info.hayslip.AlertHoarder.models.Application;
import info.hayslip.AlertHoarder.models.StatusMessage;
import info.hayslip.AlertHoarder.repositories.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.ValidationException;

@RestController
@RequestMapping("/api/v1/applications")
public class ApplicationController {

    @Autowired
    private ApplicationRepository applicationRepository;

    @GetMapping("/all")
    public Iterable<Application> getApplications() {
        Iterable<Application> returnedApplications = applicationRepository.findAll();
        if (!returnedApplications.iterator().hasNext()) {
            throw new ValidationException("No records found.");
        }
        return applicationRepository.findAll();
    }

    @PostMapping("/add")
    public StatusMessage addApplication(@Valid @RequestBody Application application) {
        Application returnedApplication = applicationRepository.save(application);
        if (returnedApplication.getAppId().isEmpty()) {
            throw new ValidationException("Error adding Application to Cosmos DB.");
        }
            return new StatusMessage("200", "Application Added");
    }
}
