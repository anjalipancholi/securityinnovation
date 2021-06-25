package securityinnovation.service;

import securityinnovation.dto.RedirectRequest;
import securityinnovation.dto.RedirectResponse;
import securityinnovation.dto.ShortenRequest;
import securityinnovation.dto.ShortenResponse;

public interface UrlShortenerService {
    ShortenResponse getShortUrl(ShortenRequest shortenRequest);

    RedirectResponse getLongUrl(RedirectRequest redirectRequest);
}
