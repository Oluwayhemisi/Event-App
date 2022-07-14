package africa.semicolon.mogbo.data.repositories;

import africa.semicolon.mogbo.data.models.Party;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PartyRepository extends MongoRepository<Party, String> {
}
