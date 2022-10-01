package common.business;

import common.data.api.ToDoService;

import java.util.ArrayList;
import java.util.List;

public class ToDoBusinessImpl {
    private ToDoService toDoService;

    public ToDoBusinessImpl(ToDoService toDoService){
        this.toDoService = toDoService;
    }

    public List<String> retrieveToDosRelatedToSpring(String user) {
        List<String> filteredToDos = new ArrayList<>();
        List<String> allToDos = toDoService.retrieveTodos(user);
        for (String todo: allToDos){
            if(todo.contains("Spring")){
                filteredToDos.add(todo);
            }
        }
        return filteredToDos;
    }

    public void deleteToDosNotRelatedToSpring(String user) {
        List<String> allTodos = toDoService.retrieveTodos(user);
        for(String todo: allTodos) {
            if(!todo.contains("Spring")) {
                toDoService.deleteTodo(todo);
            }
        }
    }
}
