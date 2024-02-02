package edu.kec.covid;
import java.util.Random;
import java.util.Scanner;

import edu.kec.covid.iservice.IHospitalService;
import edu.kec.covid.model.Patient;
import edu.kec.covid.service.HospitalService;

public class Covid {
	public static void main(String[] args) {
		IHospitalService hospitalService = new HospitalService();
		Scanner scanner= new Scanner(System.in);
//		Patient patient = new Patient(o,name, );
		
		System.out.print("Enter name: ");
		String name= scanner.nextLine();
		System.out.print("Enter aadhar id: ");
		Long aadharId = scanner.nextLong();
		System.out.print("Enter Latitude: ");
		Double latitude = scanner.nextDouble();
		System.out.print("Enter Longitude: ");
		Double longitude = scanner.nextDouble();
		
		Random random= new Random();
		boolean isPositive = (random.nextInt(1,10)>5)?true:false;
		if(isPositive) {
			System.out.println("Patient is affected..");
			Integer hospitalId = hospitalService.findNearByHospital(latitude, longitude);
			if(hospitalId > 0) {
				System.out.println("Found hospital");
			}
			else {
				System.out.println("Hospital not found in your area.");
			}
			
		}
		else {
			System.out.println("Patient is safe..");
		}
		
	}
}
132.342
-132.521