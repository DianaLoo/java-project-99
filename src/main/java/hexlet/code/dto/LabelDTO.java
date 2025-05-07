package hexlet.code.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;
@Setter
@Getter
public class LabelDTO {
    private Long id;
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate createdAt;
}
