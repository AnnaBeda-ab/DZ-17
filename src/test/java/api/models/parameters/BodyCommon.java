package api.models.parameters;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BodyCommon<T> {
    @Builder.Default
    private String jsonrpc = "2.0";
    @Builder.Default
    private int id = 1518863034;
    public String method;
    public T params;
}
