package fx24.backend.pendekin.repository;

import fx24.backend.pendekin.model.Link;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LinkRepository extends JpaRepository<Link, Integer> {

    Optional<Link> findByOriginalLink(String originalLink);
    Optional<Link> findByShortLink(String shortLink);
    Boolean existsByShortLink(String shortLink);

}
