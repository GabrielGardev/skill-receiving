package todoList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import todoList.bindingModel.TaskBindingModel;
import todoList.entity.Task;
import todoList.repository.TaskRepository;

import javax.validation.constraints.Max;
import java.util.List;

@Controller
public class TaskController {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView){
        modelAndView.setViewName("base-layout");
        modelAndView.addObject("view", "task/index");
        modelAndView.addObject("tasks", this.taskRepository.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create(ModelAndView modelAndView){
        modelAndView.setViewName("base-layout");
        modelAndView.addObject("view", "task/create");
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(Task task){
        this.taskRepository.saveAndFlush(task);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable(value = "id") Integer id,ModelAndView modelAndView ){
        Task task = this.taskRepository.findById(id).get();

        modelAndView.setViewName("base-layout");
        modelAndView.addObject("view", "task/edit");
        modelAndView.addObject("task", task);
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable(value = "id") Integer id, TaskBindingModel taskBindingModel){
        Task taskToEdit = this.taskRepository.findById(id).get();
        taskToEdit.setTitle(taskBindingModel.getTitle());
        taskToEdit.setComments(taskBindingModel.getComments());
        this.taskRepository.saveAndFlush(taskToEdit);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable(value = "id") Integer id, ModelAndView modelAndView){
        Task task = this.taskRepository.findById(id).get();

        modelAndView.setViewName("base-layout");
        modelAndView.addObject("view", "task/delete");
        modelAndView.addObject("task", task);

        return modelAndView;
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") Integer id){
        this.taskRepository.deleteById(id);

        return "redirect:/";
    }
}
