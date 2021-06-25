package securityinnovation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import securityinnovation.dto.RedirectRequest;
import securityinnovation.dto.RedirectResponse;
import securityinnovation.dto.ShortenRequest;
import securityinnovation.dto.ShortenResponse;
import securityinnovation.repository.UrlShortenerRepository;

import java.util.UUID;

@Component
public class UrlShortenerServiceImpl implements UrlShortenerService {

    @Autowired
    private UrlShortenerRepository urlShortenerRepository;

    @Override
    public ShortenResponse getShortUrl(ShortenRequest shortenRequest) {
        UUID uuid = UUID.randomUUID();
        String urlCode = uuid.toString().substring(0, 8);
        urlShortenerRepository.insertLongUrl(urlCode, shortenRequest.getLongUrl());
        return new ShortenResponse("http://localhost:8080/r/"+urlCode);
    }

    @Override
    public RedirectResponse getLongUrl(RedirectRequest redirectRequest) {
        String longUrl = urlShortenerRepository.getLongUrl(redirectRequest.getCode());
        if (longUrl == null) {
            return new RedirectResponse("/generate");
        }
        return new RedirectResponse(longUrl);
    }
}
