import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.*;
import static org.mockito.Mockito.*;

public class AlarmTest {

    Sensor sensor;
    Alarm alarm;
    @Before
    public void before(){
        sensor=mock(Sensor.class);
        alarm=spy(new Alarm(sensor));
    }

    @Test
    public void getPsiPressureValue() {
        double psi=26d;
        when(sensor.popNextPressurePsiValue())
            .thenReturn(psi);

        assertEquals(psi,alarm.getPsiPressureValue());
    }

    @Test
    public void isPressureInRange() {
        assertFalse(alarm.isPressureInRange(29));
        assertFalse(alarm.isPressureInRange(15));
        assertTrue(alarm.isPressureInRange(19));
    }

    @Test
    public void isAlarmOnActive() {
        when(alarm.getPsiPressureValue())
            .thenReturn(19d);
        alarm.check();
        assertFalse(alarm.isAlarmOn());
    }

    @Test
    public void isAlarmOnInactive() {
        when(alarm.getPsiPressureValue())
            .thenReturn(26d);

        alarm.check();
        assertTrue(alarm.isAlarmOn());
    }
}
