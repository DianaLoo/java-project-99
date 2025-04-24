package hexlet.code.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class TaskCreateDTO {
    @NotBlank
    private String title;

    private Long index;

    @JsonProperty("assignee_id")
    private Long assigneeId;

    private String content;

    @NotBlank
    private String status;

    private List<Long> taskLabelIds;
}
