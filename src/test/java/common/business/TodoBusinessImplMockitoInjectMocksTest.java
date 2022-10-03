package common.business;

import common.data.api.ToDoService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplMockitoInjectMocksTest {

    @Mock
    ToDoService toDoService;

    @InjectMocks
    ToDoBusinessImpl toDoBusinessImpl;

    @Captor
    ArgumentCaptor<String> stringArgumentCaptor;

    @Test
    public void usingMockito() {
        List<String> allTodos = Arrays.asList("Learn Spring MVC",
                "Learn Spring", "Learn to Build");
        when(toDoService.retrieveTodos("User")).thenReturn(allTodos);
        List<String> filteredTodos = toDoBusinessImpl.retrieveToDosRelatedToSpring("User");
        assertEquals(2, filteredTodos.size());
    }

    @Test
    public void mockito_UsingBDD() {
        List<String> allTodos = Arrays.asList("Learn Spring MVC",
                "Learn Spring", "Learn to Build");
        //given
        given(toDoService.retrieveTodos("User")).willReturn(allTodos);
        //when
        List<String> todos = toDoBusinessImpl.retrieveToDosRelatedToSpring("User");
        //then
        assertEquals(todos.size(), 2);
    }

    @Test
    public void testDelete() {

        List<String> allTodos = Arrays.asList("Learn Spring MVC",
                "Learn Spring", "Learn to Build");
        when(toDoService.retrieveTodos("User")).thenReturn(allTodos);
        toDoBusinessImpl.deleteToDosNotRelatedToSpring("User");
        verify(toDoService).deleteTodo("Learn to Build");
        verify(toDoService, Mockito.never()).deleteTodo("Learn Spring MVC");
        verify(toDoService, Mockito.never()).deleteTodo("Learn Spring");
        verify(toDoService, Mockito.times(1)).deleteTodo("Learn to Build");
    }

    @Test
    public void captureArgument() {
        List<String> allTodos = Arrays.asList("Learn Spring MVC",
                "Learn Spring", "Learn to Build");
        Mockito.when(toDoService.retrieveTodos("User")).thenReturn(allTodos);
        toDoBusinessImpl.deleteToDosNotRelatedToSpring("User");
        Mockito.verify(toDoService).deleteTodo(stringArgumentCaptor.capture());
        assertEquals("Learn to Build", stringArgumentCaptor.getValue());
    }


}
