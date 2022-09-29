import MainTests.Operations;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParameterisedTests {

    public static int square(Integer a) {
        return a*a;
    }

//    @ParameterizedTest
//    @ValueSource(ints = {5, 2, 3})
//    @DisplayName("Test add numbers - Positive")
//    void testParameterise(Integer a) {
//        assertEquals(Math.pow(a,2), square(a));
//    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testFile.csv")
    @DisplayName("Test add numbers - Positive")
    void testParameteriseCsv(Integer a) {
        assertEquals(Math.pow(a,2), square(a));
    }
}
