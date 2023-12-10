import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class HippodromeConstructorTest {

    @Test
    void argumentIsNull_ExceptionTest() {
        List<Horse> nullList = null;
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () ->  {
            new Hippodrome(nullList);
        });
        assertEquals("Horses cannot be null.", iae.getMessage());
    }
    @Test
    void listIsEmpty_ExceptionTest() {
        List<Horse> emptyList = new ArrayList<>();
        IllegalArgumentException iae =  assertThrows(IllegalArgumentException.class, () -> {
            new Hippodrome(emptyList);
        });
        assertEquals("Horses cannot be empty.", iae.getMessage());
    }


}