package info.hayslip.AlertHoarder.controllers;

import info.hayslip.AlertHoarder.services.VersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Dictionary;

@RestController
public class VersionController {

   @Autowired
   private VersionService versionService;

    @RequestMapping("/version")
    public Dictionary getVersionDescription() {
        return versionService.getVersionDescription();
    }
}
