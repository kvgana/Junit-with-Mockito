import MainClasses.Operations;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OperationsTest {

    @Order(1)
    @Test
    @DisplayName("Test add numbers - Positive")
    void testAdd() {
        assertEquals(6, Operations.add(2,3,1), "Expected value doesnt match the output");
    }

    @Order(4)
    @Test
    @DisplayName("Test Multiply numbers - Negative")
    void testMultiply() {
        assertAll(() -> assertNotEquals(6, Operations.multiply(2, 2)),
                () -> assertNotEquals(4, Operations.multiply(2, -2)));
    }

    public String getCapital(String country){
        Map<String,String> countryCapitalMap = new HashMap<String,String>();
        countryCapitalMap.put("Italy", "Rome");
        countryCapitalMap.put("Japan", "Tokyo");
        countryCapitalMap.put("Zimbabwe", "Harare");
        countryCapitalMap.put("Belgiaum", "Brussels");
        return countryCapitalMap.get(country);
    }

    @Order(2)
    @Test
    @DisplayName("Test Null response")
    void testNull() {
        assertNull(getCapital("Singapore"));
    }

    @Order(3)
    @Test
    @DisplayName("Test Exception")
    void testException() {
        assertThrows(NullPointerException.class, null);
    }

    @Order(5)
    @RepeatedTest(value = 3)
    @DisplayName("Test Arrays Equals")
    void testArrayEquals() {
        String[] s1 = {"String", "Array"};
        String[] s2 = {"String", "Array"};
        assertArrayEquals(s1, s2);
        System.out.println("Free memory"+ Runtime.getRuntime().freeMemory());
    }

    @Test
    @DisplayName("Test Iterable Equals for MAC OS only")
    @EnabledOnOs(value = OS.MAC)
    void testIterableEquals() {
        List<Integer> li1 = List.of(1,2,3);
        Set<Integer> s1 = new HashSet<>();
        s1.add(1); s1.add(2); s1.add(3);
        assertIterableEquals(li1,s1);
    }
}