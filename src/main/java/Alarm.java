public class Alarm implements AlarmAction
{
    public static final double LowPressureThreshold = 17;
    public static final double HighPressureThreshold = 21;

    private final SensorAction sensor;

    boolean alarmOn = false;


    public Alarm(SensorAction sensor){
        this.sensor=sensor;
    }

    public void check()
    {
        double psiPressureValue = sensor.popNextPressurePsiValue();

        if (!isPressureInRange(psiPressureValue))
        {
            alarmOn = true;
        }
    }

    private boolean isPressureInRange(double psiPressureValue) {
        return psiPressureValue >= LowPressureThreshold
            &&  psiPressureValue <= HighPressureThreshold;
    }

    public boolean isAlarmOn()
    {
        return alarmOn; 
    }
}
