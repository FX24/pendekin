package fx24.backend.pendekin.service;

import fx24.backend.pendekin.dto.LinkRequestDto;
import fx24.backend.pendekin.model.Link;
import fx24.backend.pendekin.repository.LinkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class LinkShortenerServiceImpl implements LinkShortenerService {

    private final LinkRepository linkRepository;

    @Override
    public String createShortLink(LinkRequestDto linkRequestDto) {
        String shortUrl;

        do {
            shortUrl = generateShortUrl();
        } while (linkRepository.existsByShortLink(shortUrl));

        Link link = Link.builder()
                .shortLink(shortUrl)
                .originalLink(linkRequestDto.getLink())
                .redirectCount(1)
                .build();

        linkRepository.save(link);

        return shortUrl;
    }

    @Override
    public String getOrignalLink(String shortLink) throws Exception {
        Optional<Link> optionalLink = linkRepository.findByShortLink(shortLink);

        if (optionalLink.isEmpty()) {
            throw new Exception("Link Not Found");
        }

        Link link = optionalLink.get();
        link.setRedirectCount(link.getRedirectCount() + 1);
        linkRepository.save(link);

        return link.getOriginalLink();
    }

    private static String generateShortUrl() {
        int leftLimit = 48;
        int rightLimit = 122;
        int length = 6;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit+1)
                .filter(i ->
                        (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
