package user;
import java.util.ArrayList;
import java.util.Scanner;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class Patient extends Person {
    private int patientId;

    public Patient(String name, int age, int patientId) {
        super(name, age);
        this.patientId = patientId;
    }

    public int getPatientId() {
        return patientId;
    }
}

class Doctor extends Person {
    private String specialization;

    public Doctor(String name, int age, String specialization) {
        super(name, age);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }
}

class Hospital {
    private ArrayList<Patient> patients;
    private ArrayList<Doctor> doctors;

    public Hospital() {
        patients = new ArrayList<>();
        doctors = new ArrayList<>();
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void listPatients() {
        System.out.println("Patients:");
        for (Patient patient : patients) {
            System.out.println("Name: " + patient.getName() + ", Age: " + patient.getAge() + ", Patient ID: " + patient.getPatientId());
        }
    }

    public void listDoctors() {
        System.out.println("Doctors:");
        for (Doctor doctor : doctors) {
            System.out.println("Name: " + doctor.getName() + ", Age: " + doctor.getAge() + ", Specialization: " + doctor.getSpecialization());
        }
    }
}

public class HospitalManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hospital hospital = new Hospital();

        while (true) {
            System.out.println("1. Add Patient\n2. Add Doctor\n3. List Patients\n4. List Doctors\n5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter patient name: ");
                    String patientName = scanner.nextLine();
                    System.out.print("Enter patient age: ");
                    int patientAge = scanner.nextInt();
                    System.out.print("Enter patient ID: ");
                    int patientId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    Patient patient = new Patient(patientName, patientAge, patientId);
                    hospital.addPatient(patient);
                    System.out.println("Patient added.");
                    break;
                case 2:
                    System.out.print("Enter doctor name: ");
                    String doctorName = scanner.nextLine();
                    System.out.print("Enter doctor age: ");
                    int doctorAge = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter doctor specialization: ");
                    String doctorSpecialization = scanner.nextLine();
                    Doctor doctor = new Doctor(doctorName, doctorAge, doctorSpecialization);
                    hospital.addDoctor(doctor);
                    System.out.println("Doctor added.");
                    break;
                case 3:
                    hospital.listPatients();
                    break;
                case 4:
                    hospital.listDoctors();
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
