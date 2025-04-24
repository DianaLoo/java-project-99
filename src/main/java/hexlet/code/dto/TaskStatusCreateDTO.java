package hexlet.code.dto;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TaskStatusCreateDTO {

    @Size(min = 1)
    private String slug;

    @Size(min = 1)
    private String name;
}
