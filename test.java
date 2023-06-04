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
	 String name = null ;
}
abstract class Staff implements Person{
	  
	  
	}
	 
class Patient extends Appointment implements Person{
	    private String patientName;
	    private int age;
	    private int id;
	    private String email;
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
			this.id=id;
			this.email=email;
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
			return this.id;
		}
		
		public void setID(int id) {
			this.id=id;
		}
		
		public String getEmail() {
			return email;
		}
		
		public void setEmail(String email) {
			this.email=email;
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
			return "The patient name: "+ patientName + ", age: "+ age +", id: "+id
					+", email: "+email+", bloodType: "+ bloodType+", weight: "+weight+", and height: "+height;
		}
		public void calculateTotalBMI(double weight,double height) {
			double BMI = weight/(height*height);
			
			if(BMI<18.5) {
				System.out.println("Underweight");
			}
			    
			else if (BMI>25 | BMI==25) {
				System.out.println("Overweight");
			}
			else
				System.out.println("Healthy");
			
			}
		
		public static int getNumberOfPatienObjects() {
			return numberOfPatientObjects;
		}
	}
class Doctor extends Staff{ 
	  
	   private ArrayList<Patient> patients; //aggregation relationship
	   
	   private static int doctorObj = 0;
	   
	   public Doctor() {
		   doctorObj++;
	   }
	   
	   public String prescribe(Patient patient,Doctor doctor) {
		   return null;
	   }
	   
	   public static int getNumberofObjects() {
		   return doctorObj;
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
			System.out.println("There is already an appointment in this day");
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
			System.out.println("There is no appointments in this day, try again.");
	}
	public String toString() {
		return "The appointment number is: "+appointmentNumber;
	  }
	public static int getNumberOfAppointmentObjects() {
		return numberOfAppointmentObjects;
	}
		
	}




