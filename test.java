package test;

import java.util.*;
public class test {
	 
	  public static void main(String[] args){
	  
	   
  }
}
class Hospital {
	  
	private static int Hospital = 0;
	
	
	
}
interface Person{
	 
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
abstract class Staff implements Person{
    private String staffName;
    private int staffId;
    private String staffEmail;
    private String userName;
    protected String password;

    public Staff() {
      
    }

    public Staff(String username, String password) {
        this.userName=username;
        this.password=password;
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
    public int getID(){
        return staffId;
    }
    public void setID(int id){
        staffId = id;
    }
    public String getEmail(){
        return staffEmail;
    }
    public void setEmail(String email){
        staffEmail = email;
    }
	  
}
	 
class Patient extends Appointment implements Person{
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
		
		public Patient(){
			numberOfPatientObjects++;
		}
		
		public Patient(String name,int age,int id,String email,double weight,double height,String bloodType) {
			this.patientName = name;
			this.age = age;
			this.patientId=id;
			this.patientEmail=email;
			this.weight=weight;
			this.height=height;
			this.bloodType=bloodType;
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
			this.patientId=id;
		}
		
		public String getEmail() {
			return patientEmail;
		}
		
		public void setEmail(String email) {
			this.patientEmail=email;
		}
		
		public int getAge() {
			return age;
		}
		
		public void setAge(int age) {
			this.age = age;
		}
		
		public double getWeight(){
			return weight;
		}
		
		public void setWeight(double weight) {
			this.weight=weight;
		}
		
		public double getHeight(){
			return height;
		}
		
		public void setHeight(double height) {
			this.height=height;
		}
		
		public String getBloodType() {
			return bloodType;
		}
		
		public void setBloodType(String bloodType) {
			this.bloodType=bloodType;
		}
		
		public ArrayList<Appointment> getAppointments(){
			return this.appointments;
		}
		
		public void setAppointments(ArrayList<Appointment> appointments){
			 this.appointments=appointments;
		}
		
		public Doctor getDoctor() {
			return this.doctor;
		}
		
		public void setDoctor(Doctor dr) {
			this.doctor=dr;
		}
		
		@Override
		public String toString() {
			return "The patient name: "+ patientName + ", age: "+ age +", id: "+ patientId
					+", email: "+patientEmail+", bloodType: "+ bloodType+", weight: "+weight+", and height: "+height+".";
		}
		public void calculateTotalBMI(double weight,double height) {
			double BMI = weight/(height*height);
			
			if(BMI<18.5) {
				System.out.println("Underweight.");
			}
			    
			else if (BMI>25 | BMI==25) {
				System.out.println("Overweight.");
			}
			else
				System.out.println("Healthy.");
			
			}
		
		public static int getNumberOfPatienObjects() {
			return numberOfPatientObjects;
		}
	}

class Doctor extends Staff{ 
	  
	   private ArrayList<Patient> patients; //aggregation relationship
	   private String doctorName; 
	   private int doctorId;
	   private String specialty;
	   private int numberOfDoctorObjects;
	   
	   public Doctor(){
	       numberOfDoctorObjects++;
	    }
	   
	    public Doctor(String name,int id,String specialty){
	    	setDoctorName(name);
	    	setDoctorId(id);
	        this.specialty=specialty;
	        numberOfDoctorObjects++;
	    }
	    
	    public String getDoctorSpecialty(){
	        return this.specialty;
	        
	    }
	    
	    public void setDoctorSpecialty(String specialty){
	        this.specialty=specialty;
	    }
	    
	    public ArrayList<Patient> getPatients(){
			return this.patients;
		}
		
		public void setPatients(ArrayList<Patient> patients){
			 this.patients=patients;
		}
		
		public void addPatient(String patient) {
			ArrayList<String> ptn = new ArrayList();
			if(ptn.contains(patient)) {
				System.out.println("This patient is already registered.");
			}
			else
			ptn.add(patient);
		}
		
		public void deletePatient(String patient) {
			ArrayList<String> ptn = new ArrayList();
			if(!(ptn.isEmpty())) {
			ptn.remove(patient);
			}
			else
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

		public int getNumberOfDoctorObjects(){
	        return numberOfDoctorObjects;
	    }
		
		@Override
	    public String toString(){
	        return "The doctor name: "+ doctorName +", id: "+ doctorId +" and specialty: "+ specialty+".";
	        
	    }
	}
	
class Nurse extends Staff{
    
	
	private static int Nurseobj = 0;
	
    
    public static int getNumberofObjects() {
    	return Nurseobj;
    }
}

class Medicine extends Doctor{
		
	private String bloodType;
	private static int bloodBankObj = 0;
	
	public String prescribe(Patient patient,Doctor doctor) {
		   return null;
	   }
}

class Appointment extends Hospital{
	
	private int appointmentNumber;
	private static int numberOfAppointmentObjects = 0;
	
	public Appointment() {
		numberOfAppointmentObjects++;
	}
	
	public Appointment(int number) {
		this.appointmentNumber=number;
		numberOfAppointmentObjects++;
	}
	
	public int getAppointmentNumber() {
		return appointmentNumber;
	}
	
	public void setAppointmentNumber(int number) {
		this.appointmentNumber=number;
	}
	
	public void addAppintment(String day) {
		ArrayList<String> appnts = new ArrayList();
		if(appnts.contains(day)) {
			System.out.println("There is already an appointment in this day.");
		}
		else
		appnts.add(day);
	}
	
	public void deleteAppointment(String day) {
		ArrayList<String> appnts = new ArrayList();
		if(!(appnts.isEmpty())) {
		appnts.remove(appnts);
		}
		else
			System.out.println("There is no appointments in this day.");
	}
	public String toString() {
		return "The appointment number is: "+appointmentNumber+".";
	  }
	public static int getNumberOfAppointmentObjects() {
		return numberOfAppointmentObjects;
	}
		
	}




