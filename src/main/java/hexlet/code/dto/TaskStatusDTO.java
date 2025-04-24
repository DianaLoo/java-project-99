package hexlet.code.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TaskStatusDTO {
    private Long id;
    private String slug;
    private String name;
    private LocalDate createdAt;
}
