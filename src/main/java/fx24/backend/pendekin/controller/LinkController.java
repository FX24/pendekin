package fx24.backend.pendekin.controller;


import fx24.backend.pendekin.constant.LinkProperty;
import fx24.backend.pendekin.dto.LinkRequestDto;
import fx24.backend.pendekin.service.LinkShortenerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.net.URI;

import static fx24.backend.pendekin.constant.LinkProperty.REDIRECT_URL_BASE;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class LinkController {

    @Value("${server.port}")
    private String port;

    private final LinkShortenerService linkShortenerService;

    @PostMapping("/shortener")
    public ResponseEntity<String> postShortUrl(
            @RequestBody LinkRequestDto linkRequestDto
            ) {
        StringBuilder redirectUrl = new StringBuilder(REDIRECT_URL_BASE);
        String shortUrl = linkShortenerService.createShortLink(linkRequestDto);

        redirectUrl.append(port).append("/").append(shortUrl);

        return ResponseEntity.ok(
                redirectUrl.toString()
        );
    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity<Void> getOriUrl(
            @PathVariable String shortUrl
    ) throws Exception {
        StringBuilder redirectUrl = new StringBuilder("https://");
        redirectUrl.append(linkShortenerService.getOrignalLink(shortUrl));

        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(redirectUrl.toString()))
                .build();
    }
}

