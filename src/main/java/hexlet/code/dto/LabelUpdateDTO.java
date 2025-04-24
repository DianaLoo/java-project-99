package hexlet.code.dto;

import lombok.Getter;
import lombok.Setter;
import org.openapitools.jackson.nullable.JsonNullable;
import jakarta.validation.constraints.NotNull;

@Setter
@Getter
public class LabelUpdateDTO {
    @NotNull
    private JsonNullable<String> name;
}
