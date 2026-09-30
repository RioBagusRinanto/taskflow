package id.rubixtudio.taskflow.task;

import id.rubixtudio.taskflow.task.dto.CreateTaskRequest;
import id.rubixtudio.taskflow.task.dto.TaskResponse;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskResponse createTask(CreateTaskRequest request) {

        Task task = new Task();
        task.setTitle(request.title());
        task.setDescription(request.description());

        Task savedTask = taskRepository.save(task);

        return new TaskResponse(
                savedTask.getId(),
                savedTask.getTitle(),
                savedTask.getDescription(),
                savedTask.isCompleted(),
                savedTask.getCreatedAt(),
                savedTask.getUpdatedAt()
        );
    }
}