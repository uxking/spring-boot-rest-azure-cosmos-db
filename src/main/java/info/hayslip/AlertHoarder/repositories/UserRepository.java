package info.hayslip.AlertHoarder.repositories;

import com.microsoft.azure.spring.data.cosmosdb.repository.DocumentDbRepository;
import info.hayslip.AlertHoarder.models.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends DocumentDbRepository<User, String> {
}
