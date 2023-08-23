package api.models.parameters.task;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateTask {
    private String title;
    private Integer project_id;
    private String color_id;
    private Integer column_id;
    private Integer owner_id;
    private Integer creator_id;
    private String date_due;
    private String description;
    private Integer category_id;
    private Integer score;
    private Integer swimlane_id;
    private Integer priority;
    private Integer recurrence_status;
    private Integer recurrence_trigger;
    private Integer recurrence_factor;
    private Integer recurrence_timeframe;
    private Integer recurrence_basedate;
    private String reference;
    private List<String> tags;
    private String date_started;
}