package securityinnovation.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import securityinnovation.data.UrlMapping;

@Component
public class UrlShortenerRepositoryImpl implements UrlShortenerRepository {

    @Autowired
    private UrlShortenerMongoRepository urlShortenerMongoRepository;

    @Override
    public void insertLongUrl(String urlCode, String longUrl) {
        String storedLongUrl = getLongUrl(urlCode);
        if (storedLongUrl != null) {
            return;
        }
        UrlMapping urlMapping = new UrlMapping(null, urlCode, longUrl);
        UrlMapping insertedUrlMapping = urlShortenerMongoRepository.insert(urlMapping);
    }

    @Override
    public String getLongUrl(String urlCode) {
        UrlMapping urlMapping = urlShortenerMongoRepository.findByUrlCode(urlCode);
        if (urlMapping == null) {
            return null;
        }
        return urlMapping.getLongUrl();
    }
}
