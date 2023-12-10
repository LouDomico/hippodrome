import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HippodromeMethodsTest {

    @Test
    void getHorses_CorrectListSequenceTest() {
        List<Horse> expected = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            expected.add(new Horse("" + i, 10));
        }
        Collections.sort(expected, ((o1, o2) -> Integer.parseInt(o1.getName()) - Integer.parseInt(o2.getName())));
        Hippodrome hippodrome = new Hippodrome(expected);

        for (int i = 0; i < hippodrome.getHorses().size(); i++) {
            Horse horseFromHippodrome = hippodrome.getHorses().get(i);
            assertEquals(expected.get(i).getName(), horseFromHippodrome.getName());
        }
    }
    @Test
    void move_CorrectWorkTest_WithMockedHorses() {
        List<Horse> mockedHorses = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Horse horse = Mockito.mock(Horse.class);
            mockedHorses.add(horse);
        }
        Hippodrome hippodrome = new Hippodrome(mockedHorses);
        hippodrome.move();
        hippodrome.getHorses().stream().forEach(horse -> Mockito.verify(horse).move());
    }
    @Test
    void getWinner_ShouldReturnMaxDistanceValue() {
        List<Horse> horses = new ArrayList<>(List.of(
                new Horse("1", 10, 15),
                new Horse("2", 10, 47),
                new Horse("3", 10, 85),
                new Horse("4", 10, 36)
        ));
        assertEquals(85, new Hippodrome(horses).getWinner().getDistance());
    }


}