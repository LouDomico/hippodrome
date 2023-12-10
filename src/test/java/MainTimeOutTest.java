import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
@Disabled
class MainTimeOutTest {
    @Test
    @Timeout(value = 22000, unit = TimeUnit.MILLISECONDS)
    void MainTimeOut22SecondsTest() throws Exception {
        Main.main(new String[0]);
    }

}