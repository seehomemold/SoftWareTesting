import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {
    private static Vehicle vehicle;
    private static Vehicle vehicle1;
    @BeforeAll
    static void initAll(){
        vehicle= new Vehicle();
        vehicle1 = new Vehicle(20,"east");
    }
    @Test
    void testFinalize() {
        vehicle.finalize();
        assertEquals(1,vehicle1.totalVehicle());
    }

    @Test
    void setSpeed() {
        int speed = 3;
        vehicle1.setSpeed(speed);
        assertEquals(speed,vehicle1.getSpeed());
    }

    @Test
    void setDir() {
        String dir = "south";
        vehicle1.setDir(dir);
        assertEquals(dir,vehicle1.getDir());
    }

    @Test
    void getSpeed() {
        vehicle1.getSpeed();
        assertEquals(3,vehicle1.getSpeed());
    }

    @Test
    void getDir() {
        vehicle1.getDir();
        assertEquals("east",vehicle1.getDir());
    }

    @Test
    void totalVehicle() {
        assertEquals(2,vehicle1.totalVehicle());
    }
}