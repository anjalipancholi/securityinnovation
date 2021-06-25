package securityinnovation.repository;

public interface UrlShortenerRepository {

    void insertLongUrl(String urlCode, String longUrl);

    String getLongUrl(String urlCode);
}
