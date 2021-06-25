package securityinnovation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ShortenRequest {
    private String longUrl;
}
