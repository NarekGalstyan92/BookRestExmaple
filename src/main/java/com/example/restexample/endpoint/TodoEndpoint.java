package com.example.restexample.endpoint;

import com.example.restexample.dto.ToDoDto;
import com.example.restexample.exception.EntityNotFundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TodoEndpoint {

    private final RestTemplate restTemplate;

    @GetMapping("/todos")
    public ResponseEntity<List<ToDoDto>> getAllToDos() {
        ResponseEntity<ToDoDto[]> forEntity = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/todos/", ToDoDto[].class);
        if (forEntity.hasBody()) {
            ToDoDto[] todos = forEntity.getBody();
            return ResponseEntity.ok(Arrays.asList(todos));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/todos/{id}")
    public ResponseEntity<ToDoDto> getToDoById(@PathVariable("id") int id) throws EntityNotFundException {
        ResponseEntity<ToDoDto> responseEntity = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/todos/" + id, ToDoDto.class);
        if (responseEntity.hasBody()) {
            return ResponseEntity.ok(responseEntity.getBody());
        }
        throw new EntityNotFundException("Todo with " + id + " id does not exist");
    }

}
