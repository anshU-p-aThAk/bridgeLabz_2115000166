import java.util.*;

interface MedicalRecord {
    void addRecord(String record);

    List<String> viewRecords();
}

abstract class Patient implements MedicalRecord {
    private final int patientId;
    private final String name;
    private final int age;
    private final List<String> medicalRecords = new ArrayList<>();

    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public void addRecord(String record) {
        medicalRecords.add(record);
    }

    @Override
    public List<String> viewRecords() {
        return new ArrayList<>(medicalRecords);
    }

    public abstract double calculateBill();

    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId + " | Name: " + name + " | Age: " + age);
    }
}

class InPatient extends Patient {
    private static final double DAILY_CHARGE = 2000;
    private final int daysAdmitted;
    private final double treatmentCost;

    public InPatient(int patientId, String name, int age, int daysAdmitted, double treatmentCost) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.treatmentCost = treatmentCost;
    }

    @Override
    public double calculateBill() {
        return (daysAdmitted * DAILY_CHARGE) + treatmentCost;
    }
}

class OutPatient extends Patient {
    private static final double CONSULTATION_FEE = 500;

    public OutPatient(int patientId, String name, int age) {
        super(patientId, name, age);
    }

    @Override
    public double calculateBill() {
        return CONSULTATION_FEE;
    }
}

public class HospitalManagement {
    public static void main(String[] args) {
        List<Patient> patients = List.of(
                new InPatient(101, "Rahul Sharma", 45, 5, 10000),
                new OutPatient(102, "Sneha Verma", 30));

        patients.get(0).addRecord("Diabetes Treatment");
        patients.get(1).addRecord("General Checkup");

        for (Patient patient : patients) {
            patient.getPatientDetails();
            System.out.println("Total Bill: " + patient.calculateBill());
            System.out.println("Medical Records: " + patient.viewRecords());
            System.out.println();
        }
    }
}
