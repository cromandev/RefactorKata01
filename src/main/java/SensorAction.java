import java.util.Random;

// The reading of the pressure value from the sensor is simulated in this implementation.
// Because the focus of the exercise is on the other class.

public interface SensorAction {
    double popNextPressurePsiValue();
}
