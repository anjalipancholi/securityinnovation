package securityinnovation.service;

import securityinnovation.dto.RedirectRequest;
import securityinnovation.dto.RedirectResponse;
import securityinnovation.dto.ShortenRequest;
import securityinnovation.dto.ShortenResponse;

public interface UrlShortenerService {
    /**
     * Process the {@link ShortenRequest} and return the shortened url.
     */
    ShortenResponse getShortUrl(ShortenRequest shortenRequest);

    /**
     * Process the {@link RedirectRequest} and return the original long url.
     */
    RedirectResponse getLongUrl(RedirectRequest redirectRequest);
}
