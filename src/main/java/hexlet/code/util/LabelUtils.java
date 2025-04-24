package hexlet.code.util;

import hexlet.code.model.Label;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LabelUtils {

    @Bean
    public List<Label> getDefaultLabels() {

        Label bug = createLabel("bug");
        Label feature = createLabel("feature");

        return List.of(bug, feature);
    }

    private Label createLabel(String name) {
        Label label = new Label();
        label.setName(name);
        return label;
    }
}
