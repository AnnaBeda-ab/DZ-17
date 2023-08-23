package api.models.parameters.project;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)

public class CreateProject {

  private String name;
  private String description;
  private int owner_id;
  private String identifier;
  private String start_date;
  private String end_date;
}
