package hexlet.code.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
public class TaskDTO {
    private Long id;
    private Long assigneeId;
    private String title;
    private Long index;
    private String content;
    private String status;
    private LocalDate createdAt;
    private List<Long> taskLabelIds;
}
