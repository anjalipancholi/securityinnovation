package securityinnovation.repository;

import securityinnovation.data.UrlMapping;

public interface UrlShortenerRepository {
    void insertLongUrl(String urlCode, String longUrl);
    String getLongUrl(String urlCode);
}
