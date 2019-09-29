package info.hayslip.AlertHoarder.services;
import org.springframework.stereotype.Service;

import java.util.Dictionary;
import java.util.Hashtable;

@Service
public class VersionService {
    private Dictionary versionDescription = new Hashtable();

    public Dictionary getVersionDescription() {
        versionDescription.put("1", "API Version 1.0");
        return versionDescription;
    }

}