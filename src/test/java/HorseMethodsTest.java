import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class HorseMethodsTest {
    public Horse HORSE_WITH_3_PARAMS;
    public Horse HORSE_WITH_2_PARAMS;
    public HorseMethodsTest() {
        this.HORSE_WITH_2_PARAMS = new Horse("NoName", 100);
        this.HORSE_WITH_3_PARAMS = new Horse("Anonimous", 200, 999.99);
    }
    @Test
    void getName_CorrectReturnTest() {
        assertEquals("Anonimous", HORSE_WITH_3_PARAMS.getName());
    }
    @Test
    void getSpeed_CorrectReturnTest() {
        assertEquals(200, HORSE_WITH_3_PARAMS.getSpeed());
    }
    @Test
    void getDistance_CorrectReturnTest() {
        assertEquals(0, HORSE_WITH_2_PARAMS.getDistance()); //constructor with 2 params (distance must be == 0)
        assertEquals(999.99, HORSE_WITH_3_PARAMS.getDistance());
    }
    @Test
    void move_WorkCorrectTest() {
        try(MockedStatic<Horse> mockedStatic = Mockito.mockStatic(Horse.class)) {
            mockedStatic.when(() -> Horse.getRandomDouble(0.2, 0.9)).thenReturn(0.4);
            HORSE_WITH_2_PARAMS.move(); //distance = 0 + (100 * 0.4) = 40.0
            assertEquals(40.0, HORSE_WITH_2_PARAMS.getDistance());
            mockedStatic.verify(() -> Horse.getRandomDouble(0.2, 0.9));
        }
    }


}