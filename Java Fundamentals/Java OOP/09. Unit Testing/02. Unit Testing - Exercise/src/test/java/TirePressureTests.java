import org.junit.Test;
import org.mockito.Mockito;
import p06_TirePressureMonitoringSystem.Alarm;
import p06_TirePressureMonitoringSystem.Sensor;

import java.lang.reflect.Field;

import static org.junit.Assert.assertTrue;

public class TirePressureTests {
    private static final double LOW_TIRE_PRESSURE = 15;
    private static final double HIGH_TIRE_PRESSURE = 22;

    @Test
    public void alarmShouldTurnOnWhenThePressureIsLow() throws NoSuchFieldException, IllegalAccessException {
        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue())
                .thenReturn(LOW_TIRE_PRESSURE);

        Alarm alarm = new Alarm();
        Field sensor1 = Alarm.class.getDeclaredField("sensor");
        sensor1.setAccessible(true);
        sensor1.set(alarm, sensor);

        alarm.check();

        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void alarmShouldTurnOnWhenThePressureIsHigh() throws NoSuchFieldException, IllegalAccessException {
        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue())
                .thenReturn(HIGH_TIRE_PRESSURE);

        Alarm alarm = new Alarm();
        Field sensor1 = Alarm.class.getDeclaredField("sensor");
        sensor1.setAccessible(true);
        sensor1.set(alarm, sensor);

        alarm.check();

        assertTrue(alarm.getAlarmOn());
    }
}
