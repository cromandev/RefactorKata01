import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.*;
import static org.mockito.Mockito.*;

public class AlarmTest {

    Sensor sensor;
    @Before
    public void before(){
        sensor=mock(Sensor.class);
    }

    @Test
    public void sensor26() {
        when(sensor.popNextPressurePsiValue())
            .thenReturn(26d);

        Alarm alarm = new Alarm(sensor);
        alarm.check();
        assertTrue(alarm.isAlarmOn());
    }

    @Test
    public void sensor15() {
        when(sensor.popNextPressurePsiValue())
            .thenReturn(15d);

        Alarm alarm = new Alarm(sensor);
        alarm.check();
        assertTrue(alarm.isAlarmOn());
    }

    @Test
    public void alarm19() {
        when(sensor.popNextPressurePsiValue())
            .thenReturn(19d);

        Alarm alarm = new Alarm(sensor);
        alarm.check();
        assertFalse(alarm.isAlarmOn());
    }
}
