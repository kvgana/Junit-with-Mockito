package common.mockito.business;

import common.business.ToDoBusinessImpl;
import common.data.api.ToDoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ToDoBusinessImplMockitoTest {

    @Test
    public void usingMockito() {
        ToDoService toDoService = mock(ToDoService.class);
        List<String> allToDos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Build");
        when(toDoService.retrieveTodos("User")).thenReturn(allToDos);
        ToDoBusinessImpl toDoBusinessImpl = new ToDoBusinessImpl(toDoService);
        List<String> todos = toDoBusinessImpl.retrieveToDosRelatedToSpring("User");
        Assertions.assertEquals(2, todos.size());
    }

    @Test
    public void usingMockitoUsingBDD() {
        ToDoService toDoService = mock(ToDoService.class);
        ToDoBusinessImpl toDoBusiness = new ToDoBusinessImpl(toDoService);
        List<String> allToDos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Build");
        given(toDoService.retrieveTodos("User")).willReturn(allToDos);
        List<String> filteredTodos = toDoBusiness.retrieveToDosRelatedToSpring("User");
        Assertions.assertEquals(filteredTodos.size(), 2);
    }
}
