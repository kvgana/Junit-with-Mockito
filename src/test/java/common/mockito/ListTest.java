package common.mockito;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;

public class ListTest {

    @Test
    public void getListSize() {
        List list = mock(List.class);
        Mockito.when(list.size()).thenReturn(10);
        assertEquals(10, list.size());
    }

    @Test
    public void getListSizeWithMultipleReturnValues() {
        List list = mock(List.class);
        Mockito.when(list.size()).thenReturn(10).thenReturn(20);
        assertEquals(10, list.size()); // First time call
        assertEquals(20, list.size()); // Second time call
    }

    @Test
    public void mockListGet() {
        List list = mock(List.class);
        Mockito.when(list.get(0)).thenReturn("First value");
        assertEquals("First value", list.get(0));
        assertNull(list.get(1));
    }

    @Test
    public void mockListGetWithAny() {
        List list = mock(List.class);
        Mockito.when(list.get(Mockito.anyInt())).thenReturn("Same value");
        assertEquals("Same value", list.get(9));
        assertEquals("Same value", list.get(0));
    }
}
