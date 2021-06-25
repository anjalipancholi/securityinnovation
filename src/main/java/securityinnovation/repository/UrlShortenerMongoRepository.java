package securityinnovation.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import securityinnovation.data.UrlMapping;

public interface UrlShortenerMongoRepository extends MongoRepository<UrlMapping, String> {

    @Query("{'urlCode': ?0}")
    UrlMapping findByUrlCode(String urlCode);
}
