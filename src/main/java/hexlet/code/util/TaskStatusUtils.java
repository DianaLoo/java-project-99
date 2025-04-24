package hexlet.code.util;

import hexlet.code.model.TaskStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskStatusUtils {


    @Bean
    public List<TaskStatus> getDefaultTaskStatuses() {

        TaskStatus draft = createTaskStatus("Draft", "draft");
        TaskStatus toReview = createTaskStatus("To Review", "to_review");
        TaskStatus toBeFixed = createTaskStatus("To Be Fixed", "to_be_fixed");
        TaskStatus toPublish = createTaskStatus("To Publish", "to_publish");
        TaskStatus published = createTaskStatus("Published", "published");

        return List.of(draft, toReview, toBeFixed, toPublish, published);
    }

    private TaskStatus createTaskStatus(String name, String slug) {
        TaskStatus taskStatus = new TaskStatus();
        taskStatus.setName(name);
        taskStatus.setSlug(slug);
        return taskStatus;
    }
}
