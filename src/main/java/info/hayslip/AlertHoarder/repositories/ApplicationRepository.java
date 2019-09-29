package info.hayslip.AlertHoarder.repositories;

import com.microsoft.azure.spring.data.cosmosdb.repository.DocumentDbRepository;
import info.hayslip.AlertHoarder.models.Application;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends DocumentDbRepository<Application, String> {
}
