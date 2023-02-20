package fx24.backend.pendekin.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LinkRequestDto {
    /*
    FIXME :
        - make link variable notblank
        - solve jakarta validation error
     */
    private String link;
}
