package common.data.api;

import java.util.List;

public interface ToDoService {
    public List<String> retrieveTodos(String user);

    public void deleteTodo(String todo);
}
