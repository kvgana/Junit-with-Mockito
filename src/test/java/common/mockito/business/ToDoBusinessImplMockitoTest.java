package common.mockito.business;

import common.business.ToDoBusinessImpl;
import common.data.api.ToDoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

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

    @Test
    public void testDeleteTodo(){
        ToDoService toDoService = mock(ToDoService.class);
        ToDoBusinessImpl toDoBusiness = new ToDoBusinessImpl(toDoService);
        List<String> allToDos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Build");
        when(toDoService.retrieveTodos("User")).thenReturn(allToDos);
        toDoBusiness.deleteToDosNotRelatedToSpring("User");
        verify(toDoService).deleteTodo("Learn to Build");
        verify(toDoService, Mockito.never()).deleteTodo("Learn Spring MVC");
        verify(toDoService, Mockito.never()).deleteTodo("Learn Spring");
        verify(toDoService, Mockito.times(1)).deleteTodo("Learn to Build");
    }

    @Test
    public void captureArgument() {
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor
                .forClass(String.class);

        ToDoService todoService = mock(ToDoService.class);

        List<String> allTodos = Arrays.asList("Learn Spring MVC",
                "Learn Spring", "Learn to Dance");
        Mockito.when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos);

        ToDoBusinessImpl todoBusinessImpl = new ToDoBusinessImpl(todoService);
        todoBusinessImpl.deleteToDosNotRelatedToSpring("User");
        Mockito.verify(todoService).deleteTodo(argumentCaptor.capture());
        assertEquals("Learn to Build", argumentCaptor.getValue());
    }
}
