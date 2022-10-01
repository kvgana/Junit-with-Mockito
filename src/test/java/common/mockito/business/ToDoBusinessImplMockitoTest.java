package common.mockito.business;

import common.business.ToDoBusinessImpl;
import common.data.api.ToDoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ToDoBusinessImplMockitoTest {

    @Test
    public void usingMockito() {
        ToDoService toDoService = mock(ToDoService.class);
        List<String> allToDos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Code");
        when(toDoService.retrieveTodos("TestString")).thenReturn(allToDos);
        ToDoBusinessImpl toDoBusinessImpl = new ToDoBusinessImpl(toDoService);
        List<String> todos = toDoBusinessImpl.retrieveToDosRelatedToSpring("TestString");
        Assertions.assertEquals(2, todos.size());
    }
}
