package common.mockito.business;

import common.business.ToDoBusinessImpl;
import common.data.api.ToDoService;
import common.data.stub.ToDoServiceStub;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class TodoBusinessImplStubTest {

    @Test
    public void usingAStub() {
        ToDoService toDoService = new ToDoServiceStub();
        ToDoBusinessImpl toDoBusinessImpl = new ToDoBusinessImpl(toDoService);
        List<String> todos = toDoBusinessImpl.retrieveToDosRelatedToSpring("TestString");
        Assertions.assertEquals(2, todos.size());

    }

}
