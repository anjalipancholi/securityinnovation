package securityinnovation.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
@AllArgsConstructor
public class UrlMapping {

    @Id
    public String id;

    @Indexed
    private String urlCode;
    private String longUrl;
}
