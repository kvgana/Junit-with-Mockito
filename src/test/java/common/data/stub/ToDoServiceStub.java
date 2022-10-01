package common.data.stub;

import common.data.api.ToDoService;

import java.util.Arrays;
import java.util.List;

public class ToDoServiceStub  implements ToDoService {
    public List<String> retrieveTodos(String user) {
        return Arrays.asList("Learn Spring MVC", "Learn Spring",
                "Learn to Code");
    }

    public void deleteTodo(String user) {

    }
}
