package com.in28minutes.learnspringsecurity.resources;

import com.in28minutes.Lgr;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.in28minutes.Lgr.logger;

@RestController
public class TodoResource {

    private static final List<Todo> TODO_LIST = List.of(
            new Todo("in28minutes", "LearnAWS"),
            new Todo("in28minutes", "Get AWS certified")
    );
    @GetMapping("/todos")
    public List retrieveAllTodos(){
        return TODO_LIST;
    }
    @GetMapping("users/{username}/todos")
    public Todo retrieveTodosForSpecificUser(
            @PathVariable String username){
        return TODO_LIST.get(0);
    }
    @PostMapping("users/{username}/todos")
    public void CreateTodoForSpecificUser(
            @PathVariable String username,
            @RequestBody Todo todo){
        logger.info("Create {} for {}", todo, username);
    }

}
record Todo(String username, String description){}
