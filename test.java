package test;

import java.util.*;

public class test {

	public static void main(String[] args) {

		Hospital hospital_1 = new Hospital("New Hope Care");
		Hospital hospital_2 = new Hospital("Urgent Care Medical");
		
		Doctor doctor_1 = new Doctor("dr.Sara", 12345, "Eyes");
		Doctor doctor_2 = new Doctor("dr.Ahmad", 1234, "Dental");

		Medicine medicine_1 = new Medicine("Ibuprofen", 19);
		Medicine medicine_2 = new Medicine("Panadol Night", 12);

		Appointment appointment_1 = new Appointment(2324);
		Appointment appointment_2 = new Appointment(9668);

		// Nurse class objects

		
		Patient[] patientObjects = new Patient[5];
		patientObjects[0] = new Patient("Esraa", 19, 12345, "esra@gmail.com", 45, 160, "A+");
		patientObjects[1] = new Patient("Aryaf", 19, 12345, "Aryaf@gmail.com", 45, 160, "A+");
		patientObjects[2] = new Patient("Rana", 19, 12345, "Rana@egmail.com", 45, 160, "A+");
		patientObjects[3] = new Patient("Ali", 30, 12345, "Ali@egmail.com", 70, 160, "O+");
		patientObjects[5] = new Patient("Wafaa", 10, 12345, "Wafaa@egmail.com", 45, 150, "B+");
        
		ArrayList<Object> patientList = new ArrayList<Object>(); 
		hospital_1.fillArrayOfPatients(patientList,patientObjects);
		
		Patient[] patients = new Patient[10];
		Scanner read = new Scanner(System.in);
		int choice;
		do {
			System.out.println("To add patients, please enter 1.");
			System.out.println("To delete  patients, please enter 2.");
			System.out.println("To compare patients, please enter 3.");
			System.out.println("To get the number of patient objects, please enter 4.");
			System.out.println("To generate a system report, please enter 5.");
			System.out.println("To exit the program, please enter 0.");
			choice = read.nextInt();

			switch (choice) {
			case 1:
				if (hospital_1.isFull(patients)) {
					hospital_1.expandList(patients);
				}
				hospital_1.addPatient(patients);
				break;
			case 2:
				if (hospital_1.isEmpty(patients))
					System.out.println("There is no patients to delete");
				else
					hospital_1.deletePatient(patients);
				break;
			case 3:
				hospital_1.equal(patients);
				break;
			case 4:
				Patient.getNumberOfPatienObjects();
				break;
			case 5:
				hospital_1.Display();
				break;
			default:
				System.out.println("Invalid choice, Please try again.");
			}

		} while (choice != 0);

	}
}

class Hospital {

	private String hospitalName;
	private static int numberOfHospitalObjects = 0;

	public Hospital() {
		numberOfHospitalObjects++;
	}

	public Hospital(String hospitalName) {
		this.setHospitalName(hospitalName);
		numberOfHospitalObjects++;
	}

	public void addPatient(Patient[] patient) {
		Scanner read = new Scanner(System.in);
		System.out.println("Please enter the patient's information: name, age, id, email, weight, height ,and bloodType.");
		String info = read.nextLine();
		String[] infoArray = info.split(",");
		int index = 0;
		while (patient[index] != null) {
			index++;
		}
		patient[index] = new Patient(infoArray[0],Integer.parseInt(infoArray[1]),Integer.parseInt(infoArray[2]),infoArray[3],
				Double.parseDouble(infoArray[4]),Double.parseDouble(infoArray[5]),infoArray[6]);
	}

	public boolean isFull(Patient[] patients) {
		for (int i = 0; i < patients.length; i++) {
			if (patients[i] == null)
				return false;
		}
		return true;
	}

	public Patient[] expandList(Patient[] patients) {
		Patient[] expandedPatients = new Patient[patients.length * 2];
		for (int i = 0; i < patients.length; i++) {
			expandedPatients[i] = patients[i];
		}
		return expandedPatients;
	}

	public void deletePatient(Patient[] patients) {
		Scanner read = new Scanner(System.in);
		System.out.println("This is currently the patient list: ");
		for (int i = 0; i < patients.length; i++) {
			System.out.println(i + " " + patients[i]);
		}
		System.out.println("Enter the number of the patient to remove: ");
		int index = read.nextInt();
		patients[index] = null;
	}
    
    public boolean isEmpty(Patient[] patients) {
    	for(int i = 0 ; i < patients.length ; i++) {
    		if (patients[i] == null)
    			return true;
    	}
    	return false;
    }
	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public boolean equal(Patient[] patients) {
		Scanner read = new Scanner(System.in);
		System.out.println("This is currently the patient list: ");
		for (int i = 0; i < patients.length; i++) {
			System.out.println(i + " " + patients[i]);
		}
		System.out.println("Please enter the number of the first patient:");
		int index1 = read.nextInt();
		System.out.println("Please enter the number of the second patient:");
		int index2 = read.nextInt();
		if(patients[index1].equals(patients[index2]))
			return true;
		return false;
	}

	public boolean equal(Doctor[] dr) {
		Scanner read = new Scanner(System.in);
		System.out.println("This is currently the patient list: ");
		for (int i = 0; i < dr.length; i++) {
			System.out.println(i + " " + dr[i]);
		}
		System.out.println("Please enter the number of the first doctor:");
		int index1 = read.nextInt();
		System.out.println("Please enter the number of the second doctor:");
		int index2 = read.nextInt();
		if(dr[index1].equals(dr[index2]))
			return true;
		return false;
	}

	public void Display() {
        
	}

	@Override
	public String toString() {
		return "The HospitalName :" +  hospitalName ;
	}

	public void fillArrayOfPatients(ArrayList<Object> listPatient, Patient[] patientArr) {
        for(Object obj : patientArr) {
        	listPatient.add(obj);
        }
        
	}

	public static int getNumberOfHospitalObjects() {
		return numberOfHospitalObjects;

	}

}

interface Person {

	static final String name = null;
	static final int id = 0;
	static final String email = null;

	abstract String getName();

	abstract void setName(String name);

	abstract int getID();

	abstract void setID(int id);

	abstract String getEmail();

	abstract void setEmail(String email);
}

abstract class Staff implements Person {
	private String staffName;
	private int staffId;
	private String staffEmail;
	private String userName;
	protected String password; // at least one data field that is protected

	public Staff() {

	}

	public Staff(String username, String password) {
		this.userName = username;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String name) {
		this.userName = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return staffName;
	}

	public void setName(String name) {
		staffName = name;
	}

	public int getID() {
		return staffId;
	}

	public void setID(int id) {
		staffId = id;
	}

	public String getEmail() {
		return staffEmail;
	}

	public void setEmail(String email) {
		staffEmail = email;
	}

}

class Patient extends Appointment implements Person {
	private String patientName;
	private int age;
	private int patientId;
	private String patientEmail;
	private double weight;
	private double height;
	private String bloodType;
	ArrayList<Appointment> appointments;
	Doctor doctor;
	private static int numberOfPatientObjects = 0;

	public Patient() {
		numberOfPatientObjects++;
	}

	public Patient(String name, int age, int id, String email, double weight, double height, String bloodType) {
		this.patientName = name;
		this.age = age;
		this.patientId = id;
		this.patientEmail = email;
		this.weight = weight;
		this.height = height;
		this.bloodType = bloodType;
		numberOfPatientObjects++;
	}

	public String getName() {
		return this.patientName;
	}

	public void setName(String name) {
		this.patientName = name;
	}

	public int getID() {
		return this.patientId;
	}

	public void setID(int id) {
		this.patientId = id;
	}

	public String getEmail() {
		return patientEmail;
	}

	public void setEmail(String email) {
		this.patientEmail = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public ArrayList<Appointment> getAppointments() {
		return this.appointments;
	}

	public void setAppointments(ArrayList<Appointment> appointments) {
		this.appointments = appointments;
	}

	public Doctor getDoctor() {
		return this.doctor;
	}

	public void setDoctor(Doctor dr) {
		this.doctor = dr;
	}

	@Override
	public String toString() {
		return "The patient name: " + patientName + ", age: " + age + ", id: " + patientId + ", email: " + patientEmail
				+ ", bloodType: " + bloodType + ", weight: " + weight + ", and height: " + height + ".";
	}

	public void calculateTotalBMI(double weight, double height) {
		double BMI = weight / (height * height);

		if (BMI < 18.5) {
			System.out.println("Underweight.");
		}

		else if (BMI > 25 | BMI == 25) {
			System.out.println("Overweight.");
		} else
			System.out.println("Healthy.");

	}

	public static int getNumberOfPatienObjects() {
		return numberOfPatientObjects;
	}
}

class Doctor extends Staff {

	private ArrayList<Patient> patients; // aggregation relationship
	private String doctorName;
	private int doctorId;
	private String specialty;
	private int numberOfDoctorObjects;

	public Doctor() {
		numberOfDoctorObjects++;
	}

	public Doctor(String name, int id, String specialty) {
		setDoctorName(name);
		setDoctorId(id);
		this.specialty = specialty;
		numberOfDoctorObjects++;
	}

	public String getDoctorSpecialty() {
		return this.specialty;

	}

	public void setDoctorSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public ArrayList<Patient> getPatients() {
		return this.patients;
	}

	public void setPatients(ArrayList<Patient> patients) {
		this.patients = patients;
	}

	public void addPatient(String patient) {
		ArrayList<String> ptn = new ArrayList();
		if (ptn.contains(patient)) {
			System.out.println("This patient is already registered.");
		} else
			ptn.add(patient);
	}

	public void deletePatient(String patient) {
		ArrayList<String> pnt = new ArrayList();
		if (!(pnt.isEmpty())) {
			pnt.remove(patient);
		} else
			System.out.println("There is no patient registered is this name.");
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String name) {
		this.doctorName = name;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int id) {
		this.doctorId = id;
	}

	public int getNumberOfDoctorObjects() {
		return numberOfDoctorObjects;
	}

	@Override
	public String toString() {
		return "The doctor name: " + doctorName + ", id: " + doctorId + " and specialty: " + specialty + ".";

	}
}

class Nurse extends Staff {

	private static int Nurseobj = 0;

	public static int getNumberofObjects() {
		return Nurseobj;
	}
}

class Medicine extends Doctor {

	private String medicine_name;
	private int medicine_cost;
	private int numberOfMedicineObjects;

	public Medicine() {
		numberOfMedicineObjects++;
	}

	public Medicine(String medicine_name, int medicine_cost) {
		this.medicine_name = medicine_name;
		this.medicine_cost = medicine_cost;
		numberOfMedicineObjects++;
	}

	public String getMedicineName() {
		return medicine_name;

	}

	public void setMedicineName(String name) {
		this.medicine_name = name;
	}

	public int getMedicineCost() {
		return medicine_cost;

	}

	public void setMedicineCost(int cost) {
		this.medicine_cost = cost;
	}

	public String prescribe(Patient patient, Doctor dr) {
		return "This is a prescription for: " + patient.getName() + "prescribed by dr." + dr.getDoctorName() + ".";

	}

	public boolean equal(Medicine medicine1, Medicine medicine2) {
		if (medicine1 == medicine2)
			return true;
		else
			return false;
	}

	public void printReceipt(String medName, Medicine pres, int cost, Doctor dr, Patient patientName) {
		System.out.printf("%-10s %-10s %-10s %-10s %-10s", "Medicine name", "The prescription",
				"The cost" + "The doctor" + "The patient");
		System.out.printf("%-10s %-10s %-10d %-10s %-10s", this.medicine_name, pres.prescribe(patientName, dr),
				this.medicine_cost + dr.getDoctorName() + patientName.getName());

	}

	@Override
	public String toString() {
		return "The medicine name is: " + getMedicineName() + ", the medicine cost:" + getMedicineCost();

	}

	public int getNumberOfMedicineObjects() {
		return numberOfMedicineObjects;

	}

}

class Appointment extends Hospital {

	private int appointmentNumber;
	private static int numberOfAppointmentObjects = 0;

	public Appointment() {
		numberOfAppointmentObjects++;
	}

	public Appointment(int number) {
		this.appointmentNumber = number;
		numberOfAppointmentObjects++;
	}

	public int getAppointmentNumber() {
		return appointmentNumber;
	}

	public void setAppointmentNumber(int number) {
		this.appointmentNumber = number;
	}

	public void addAppintment(String day) {
		ArrayList<String> appnts = new ArrayList();
		if (appnts.contains(day)) {
			System.out.println("There is already an appointment in this day.");
		} else
			appnts.add(day);
	}

	public void deleteAppointment(String day) {
		ArrayList<String> appnts = new ArrayList();
		if (!(appnts.isEmpty())) {
			appnts.remove(appnts);
		} else
			System.out.println("There is no appointments in this day.");
	}

	@Override
	public String toString() {
		return "The appointment number is: " + appointmentNumber + ".";
	}

	public static int getNumberOfAppointmentObjects() {
		return numberOfAppointmentObjects;
	}

}
