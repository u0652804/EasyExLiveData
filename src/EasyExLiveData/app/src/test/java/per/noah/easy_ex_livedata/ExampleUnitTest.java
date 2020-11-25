package per.noah.easy_ex_livedata;

import org.junit.Test;

import static org.junit.Assert.*;
import static per.noah.easy_ex_livedata.Until.enableTimber;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        new Until().initTimber(enableTimber);//fail
        assertEquals(4, 2 + 2);
    }
}