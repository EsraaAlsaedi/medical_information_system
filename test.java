package test;

import java.io.*;
import java.util.*;

public class test {

	public static void main(String[] args) throws Exception {

		Hospital hospital_1 = new Hospital("New Hope Care");
		Hospital hospital_2 = new Hospital("Urgent Care Medical");

		System.out.println(hospital_1.toString());
		hospital_2.setHospitalName("New Hope Care");

		System.out.println(
				"The patient from a file: \n" + hospital_1.readFile(new File("/Users/esra/Documents/projectFile.txt")));

		Patient patient_1 = new Patient("Esraa", 19, 12345, "esra@gmail.com", 50, 160, "A+");
		Patient patient_2 = new Patient("Aryaf", 19, 12345, "Aryaf@gmail.com", 45, 160, "A+");
		Patient patient_3 = new Patient("Rana", 19, 12345, "Rana@egmail.com", 45, 160, "A+");

		System.out.print("Patient " + patient_1.getName() + " " + "is ");
		patient_1.calculateTotalBMI(patient_1.getWeight(), patient_1.getHeight());

		Medicine medicine_1 = new Medicine("Ibuprofen", 19);
		Medicine medicine_2 = new Medicine("Panadol Night", 12);

		Appointment appointment_1 = new Appointment(2324);
		Appointment appointment_2 = new Appointment(9668);

		Nurse nurse_1 = new Nurse("Nurse Abeer", "From 9AM to 5PM");
		Nurse nurse_2 = new Nurse("Nurse Khaled", "From 5PM to 9AM");

		Doctor[] doctorObjects = new Doctor[5];
		doctorObjects[0] = new Doctor("dr.Sara", 2234, "Eyes");
		doctorObjects[1] = new Doctor("dr.Ahmad", 1234, "Dental");
		doctorObjects[2] = new Doctor("dr.Muhammad", 4345, "Dermatology");
		doctorObjects[3] = new Doctor("dr.Salma", 9876, "Surgery");
		doctorObjects[4] = new Doctor("dr.Wafaa", 3454, "Neurology");

		System.out.println(medicine_1.prescribe(patient_3, doctorObjects[3], medicine_1));
		System.out.println(medicine_2.prescribe(patient_2, doctorObjects[1], medicine_2));

		System.out.println("\nThe available doctors list: ");

		ArrayList<Object> doctorList = new ArrayList<Object>();
		hospital_1.fillArrayOfDoctors(doctorList, doctorObjects);

		Patient[] patients = new Patient[10];
		Scanner read = new Scanner(System.in);
		int choice = 0;
        int count = 0;
		do {
			System.out.println();
			System.out.println("To add patients, please enter 1.");
			System.out.println("To delete  patients, please enter 2.");
			System.out.println("To compare patients, please enter 3.");
			System.out.println("To get the number of patient objects, please enter 4.");
			System.out.println("To generate a system report, please enter 5.");
			System.out.println("To exit the program, please enter 0.");

			try {
				choice = read.nextInt();
				switch (choice) {
				case 1:
					hospital_1.addPatient(patients);
					count++;
					break;
				case 2:
					hospital_1.deletePatient(patients);
					count++;
					break;
				case 3:
					if (hospital_1.equal(patients)) {
						System.out.println("The two patients are the same");
					} else
						System.out.println("The two patients are not the same");
					count++;
					break;
				case 4:
					System.out
							.println("The number of Patient objects is: " + Patient.getNumberOfPatienObjects());
					count++;
					break;
				case 5:
					hospital_1.Display(count);
					count++;
					break;
				case 0:
					System.out.println("The program Ended.");
					break;
				default:
					System.out.println("Please choose an option from 0 to 5 only.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Please choose an option from 0 to 5 only.");
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
		System.out.println("Please enter the patient's information: "
				+ "name, age, id, email, weight, height ,and bloodType seperated by a comma.");
		System.out.println("This is currently the patient list: ");
		for (int i = 0; i < patient.length; i++) {
			System.out.println(i + " " + patient[i]);
		}
		String info = read.nextLine();
		String[] infoArray = info.split(",");
		Patient newPatient = new Patient(infoArray[0].trim(), Integer.parseInt(infoArray[1].trim()),
				Integer.parseInt(infoArray[2].trim()), infoArray[3].trim(), Double.parseDouble(infoArray[4].trim()),
				Double.parseDouble(infoArray[5].trim()), infoArray[6].trim());

		for (int i = 0; i < patient.length; i++) {
			if (patient[i] == null) {
				patient[i] = newPatient;
				break;
			}
		}
		System.out.println("Patient " + newPatient.getName() + " has been added.");
	}

	public Patient readFile(File file) throws IOException {
		Scanner input = new Scanner(file);
		String patientFile = null;
		Patient newPatient = null;

		while (input.hasNext()) {
			patientFile = input.nextLine();
		}
		input.close();
		try {
			String[] infoArray = patientFile.split(",");
			newPatient = new Patient(infoArray[0].trim(), Integer.parseInt(infoArray[1].trim()),
					Integer.parseInt(infoArray[2].trim()), infoArray[3].trim(), Double.parseDouble(infoArray[4].trim()),
					Double.parseDouble(infoArray[5].trim()), infoArray[6].trim());
			return newPatient;
		} catch (Exception e) {
			System.out.println("Check again, there is a problem with your inputs.");
		}
		return newPatient;

	}

	public void deletePatient(Patient[] patients) {
		Scanner read = new Scanner(System.in);
		System.out.println("This is currently the patient list: ");
		for (int i = 0; i < patients.length; i++) {
			System.out.println(i + " " + patients[i]);
		}

		System.out.println("Enter the number of the patient to remove: ");
		int index = read.nextInt();

		for (int i = index; i < patients.length - 1; i++) {
			patients[i] = patients[i + 1];
		}
		patients[patients.length - 1] = null;

		System.out.println("The patient has been deleted");
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
		if (patients[index1].equals(patients[index2]))
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
		if (dr[index1].equals(dr[index2]))
			return true;
		return false;
	}

	public void Display(int count) {
		Scanner read = new Scanner(System.in);
		int rating=0;
		System.out.println();
		System.out.println("-------------System Details-------------");
		System.out.printf("%s",Hospital.getNumberOfHospitalObjects()+" patients has been added/deleted.\n");
		System.out.printf("%s","You used "+ count + " options from the system.\n");
		System.out.println();
		System.out.println("Please rate your experience with us :)");
		System.out.println("For Satisfied and happy, please enter 1");
		System.out.println("For Slightly Satisfied, please enter 2");
		System.out.println("For Neutral, please enter 3");
		System.out.println("For Dissatisfied, please enter 4");
		System.out.println("For Very Dissatisfied, please enter 5");
		
		rating= read.nextInt();
        switch(rating) {
        case 1:
        case 2:
        case 3:
        case 4:
        case 5: System.out.println("Thank you for your time!"); break;
        }
	}

	@Override
	public String toString() {
		return "The HospitalName :" + hospitalName;
	}

	public void fillArrayOfDoctors(ArrayList<Object> listDoctor, Doctor[] doctorArr) {
		for (Object obj : doctorArr) {
			listDoctor.add(obj);
		}
		for (Object obj : listDoctor) {
			System.out.println(obj);
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

	private String nurse_name;
	private String shift_Schedule;
	private static int numberOfNurseObjects = 0;

	public Nurse() {
		numberOfNurseObjects++;
	}

	public Nurse(String name, String shiftSchedule) {
		this.nurse_name = name;
		this.shift_Schedule = shiftSchedule;
		numberOfNurseObjects++;
	}

	public String getNurseName() {
		return nurse_name;
	}

	public void setNurseName(String nurse_name) {
		this.nurse_name = nurse_name;
	}

	public String getShiftSchedule() {
		return shift_Schedule;
	}

	public void setShiftSchedule(String shiftSchedule) {
		this.shift_Schedule = shiftSchedule;
	}

	public String toString() {
		return "The nurse's name is: " + getNurseName() + "Shift Schedule: " + shift_Schedule;
	}

	public static int getNumberOfNurseObjects() {
		return numberOfNurseObjects;
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

	public String prescribe(Patient patient, Doctor dr, Medicine name) {
		return "This is a prescription of " + name.getMedicineName() + " for: " + patient.getName() + " prescribed by "
				+ dr.getDoctorName() + ".";

	}

	public boolean equal(Medicine medicine1, Medicine medicine2) {
		if (medicine1 == medicine2)
			return true;
		else
			return false;
	}

	public void printReceipt(Medicine medName, Medicine pres, int cost, Doctor dr, Patient patientName) {
		System.out.printf("%-10s %-10s %-10s %-10s %-10s", "Medicine name", "The prescription",
				"The cost" + "The doctor" + "The patient");
		System.out.printf("%-10s %-10s %-10d %-10s %-10s", this.medicine_name, pres.prescribe(patientName, dr, medName),
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
