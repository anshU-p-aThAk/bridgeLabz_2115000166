import java.util.*;

class Devices {
    protected int deviceId;
    protected String status;

    public Devices(int deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    public void displayStatus() {
        System.out.println("Device ID: " + deviceId + ", Status: " + status);
    }
}

class ThermoStat extends Devices {

    protected double temperatureSetting;

    public ThermoStat(int deviceId, String status, double temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }
}

public class SmartHome {
    public static void main(String[] args) {
        ThermoStat thermoStat1 = new ThermoStat(1, "ON", 20.0);
        thermoStat1.displayStatus();
    }
}
