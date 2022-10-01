package common.mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {

    @Test
    public void getListSize() {
        List list = mock(List.class);
        when(list.size()).thenReturn(10);
        assertEquals(10, list.size());
    }

    @Test
    public void getListSizeWithMultipleReturnValues() {
        List list = mock(List.class);
        when(list.size()).thenReturn(10).thenReturn(20);
        assertEquals(10, list.size()); // First time call
        assertEquals(20, list.size()); // Second time call
    }

    @Test
    public void mockListGet() {
        List list = mock(List.class);
        when(list.get(0)).thenReturn("First value");
        assertEquals("First value", list.get(0));
        assertNull(list.get(1));
    }

    @Test
    public void mockListGetWithAny() {
        List list = mock(List.class);
        when(list.get(Mockito.anyInt())).thenReturn("Same value");
        assertEquals("Same value", list.get(9));
        assertEquals("Same value", list.get(0));
    }

    int divide(int num1, int num2) {
        return num1/num2;
    }
    @Test
    public void letsMockListGetToThrowException() {
        List<String> list = mock(List.class);
        Exception exception = assertThrows(ArithmeticException.class, () -> divide(1,0));
        assertTrue(exception.getMessage().contains("zero"));
    }
    @Test
    public void letsMockListGetWithAny() {
        List<String> list = mock(List.class);
        Mockito.when(list.get(Mockito.anyInt())).thenReturn("Test value");
        assertEquals("Test value", list.get(0));
        assertEquals("Test value", list.get(1));
    }

    @Test
    public void bddAliases_UsingGivenWillReturn() {
        List<String> list = mock(List.class);

        //given
        given(list.get(Mockito.anyInt())).willReturn("Test value");

        //then
        assertEquals("Test value", (list.get(0)));
        assertEquals("Test value", (list.get(1)));
    }

}
