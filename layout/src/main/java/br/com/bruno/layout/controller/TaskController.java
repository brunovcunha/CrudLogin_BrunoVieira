package br.com.bruno.layout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import br.com.bruno.layout.dao.TaskDao;
import br.com.bruno.layout.model.Task;

import java.util.List;

@Controller
public class TaskController {

    @Autowired
    private TaskDao taskDao;

    @GetMapping("create")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("create");
        mv.addObject("task", new Task());
        return mv;
    }

    @PostMapping("/create")
public String createOrUpdate(Task task) {
    if (task.getId() == null) {
        taskDao.createTask(task);
    } else {
        taskDao.updateTask(task);
    }
    return "redirect:/list";
}


    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("list");
        List<Task> tasks = taskDao.getTasks();
        mv.addObject("tasks", tasks);
        return mv;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("create");

        Task task = taskDao.getTaskById(id);
        mv.addObject("task", task);

        return mv;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        taskDao.deleteTask(id);
        return "redirect:/list";
    }
}
