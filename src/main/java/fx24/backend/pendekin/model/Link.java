package fx24.backend.pendekin.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "link")
public class Link {

    @Id
    @GeneratedValue
    private Integer id;
    private String originalLink;

    @Column(unique = true)
    private String shortLink;
    private Integer redirectCount;

}
