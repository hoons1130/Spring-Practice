package com.example.todolist.service;

import com.example.todolist.domain.Todo;
import com.example.todolist.dto.TodoCreateRequest;
import com.example.todolist.dto.TodoResponse;
import com.example.todolist.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    @Transactional
    public TodoResponse create(TodoCreateRequest request) {
        Todo todo = new Todo(
                request.name(),
                request.list(),
                request.date()
        );

        Todo savedTodo = todoRepository.save(todo);

        return TodoResponse.from(savedTodo);
    }

    public TodoResponse find(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Todo를 찾을 수 없습니다."));
        return TodoResponse.from(todo);
    }

    public List<TodoResponse> findAll() {
        List<Todo> todos = todoRepository.findAll();
        return todos.stream().map(TodoResponse::from).toList();
    }

    public void delete(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Todo를 찾을 수 없습니다."));
        todoRepository.deleteById(id);
    }
    @Transactional
    public TodoResponse update(Long id, TodoCreateRequest request) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Todo를 찾을 수 없습니다."));
        todo.update(request.name(), request.list());
        return TodoResponse.from(todo);

    }
}
