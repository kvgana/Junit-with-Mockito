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
        ToDoService toDoServiceStubObject = new ToDoServiceStub();
        ToDoBusinessImpl toDoBusinessImplForStubObject = new ToDoBusinessImpl(toDoServiceStubObject);
        List<String> todos = toDoBusinessImplForStubObject.retrieveToDosRelatedToSpring("User");
        Assertions.assertEquals(2, todos.size());
    }

}
