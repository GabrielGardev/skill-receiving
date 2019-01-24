package todoList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import todoList.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

}
