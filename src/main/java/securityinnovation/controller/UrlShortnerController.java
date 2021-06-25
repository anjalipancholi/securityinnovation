package securityinnovation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import securityinnovation.dto.RedirectRequest;
import securityinnovation.dto.RedirectResponse;
import securityinnovation.dto.ShortenRequest;
import securityinnovation.dto.ShortenResponse;
import securityinnovation.service.UrlShortenerService;

@RestController
public class UrlShortnerController {

    @Autowired
    private UrlShortenerService urlShortenerService;

    @GetMapping(path = "/r/{code}")
    public RedirectView redirectView(@PathVariable("code") String code) {
        RedirectResponse redirectResponse = urlShortenerService.getLongUrl(new RedirectRequest(code));
        RedirectView redirectView = new RedirectView(redirectResponse.getLongUrl());
        redirectView.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
        return redirectView;
    }

    @GetMapping(path = "/generate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ShortenResponse> generateView(@RequestParam("longUrl") String longUrl) {
        ShortenResponse shortenResponse = urlShortenerService.getShortUrl(new ShortenRequest(longUrl));
        return new ResponseEntity<>(shortenResponse, HttpStatus.OK);
    }
}
