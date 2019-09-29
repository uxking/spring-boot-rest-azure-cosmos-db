package info.hayslip.AlertHoarder.repositories;

import com.microsoft.azure.spring.data.cosmosdb.repository.DocumentDbRepository;
import info.hayslip.AlertHoarder.models.Alert;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertRepository extends DocumentDbRepository<Alert, Integer> {
    /* should be the <Entity, Id> values that DocumentDbRepository<x,y> needs */
}
