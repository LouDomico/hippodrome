import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class HorseConstructorTest {

    @ParameterizedTest
    @NullSource
    void firstArgumentIsNull(String name) {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> {
            new Horse(name, 1, 2);
        });
        assertEquals("Name cannot be null.", iae.getMessage());
    }
    @ParameterizedTest
    @MethodSource("blankAndTabNames")
    void firstArgumentIsBlankOrTab(String name) {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> {
            new Horse(name, 100, 100);
        });
        assertEquals("Name cannot be blank.", iae.getMessage());
    }
    @ParameterizedTest
    @ValueSource(doubles = -100.0)
    void secondArgumentIsNegatimeNumber(double speed) {
        IllegalArgumentException ioe = assertThrows(IllegalArgumentException.class, () -> {
            new Horse("Name", speed, 1000);
        });
        assertEquals("Speed cannot be negative.", ioe.getMessage());
    }
    @ParameterizedTest
    @ValueSource(doubles = -100.0)
    void thirdArgumentIsNegatimeNumber(double distance) {
        IllegalArgumentException ioe = assertThrows(IllegalArgumentException.class, () -> {
            new Horse("Name", 100, distance);
        });
        assertEquals("Distance cannot be negative.", ioe.getMessage());
    }
    static Stream<String> blankAndTabNames() {
        return Stream.of("", "  ", "  \n  ", "  \t ");
    }
}