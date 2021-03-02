import org.junit.Test;

import static junit.framework.TestCase.assertFalse;

public class AlarmTest {

    @Test
    public void foo() {
        Alarm alarm = new Alarm();
        assertFalse(alarm.isAlarmOn());
    }
}
