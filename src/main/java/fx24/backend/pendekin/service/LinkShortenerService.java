package fx24.backend.pendekin.service;

import fx24.backend.pendekin.dto.LinkRequestDto;

public interface LinkShortenerService {

    String createShortLink(LinkRequestDto linkRequestDto);
    String getOrignalLink(String shortUrl) throws Exception;
}
