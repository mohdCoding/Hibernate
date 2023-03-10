package com.application.main;

import java.util.Scanner;

import com.application.entity.Student;
import com.application.service.ServiceImpl;

public class Application {

	public static void main(String[] args) {

		System.out.println("WELCOME TO MY APPLICATION");

		System.out.println("HERE ARE OUR SERVICES");
		Boolean execute = true;
		String status = null;
		ServiceImpl service = new ServiceImpl();
		while (execute) {
			System.out.println("1. CREATE A NEW STUDENT RECORD");
			System.out.println("2. READ A STUDENT RECORD");
			System.out.println("3. UPDATE A STUDENT RECORD");
			System.out.println("4. DELETE A STUDENT RECORD\n");

			System.out.println("TYPE YOUR OPTION BELOW");

			Scanner in = new Scanner(System.in);
			Integer userOption = in.nextInt();
			in.nextLine();

			if (userOption.equals(1)) {

				System.out.println("ENTER THE NAME OF THE STUDENT");

				String name = in.nextLine();

				System.out.println("ENTER THE AGE OF THE STUDENT");
				Integer age = in.nextInt();

				Student student = new Student();
				student.setName(name);
				student.setAge(age);
				status = service.save(student);

				if (status.equals("success"))
					System.out.println("STUDENT RECORD ADDED SUCCESSFULLY");
				else
					System.out.println("FAILED TO ADD THE RECORD");
			} else if (userOption.equals(2)) {

				System.out.println("ENTER THE ID OF THE STUDENT");
				Integer id = in.nextInt();

				Student student = service.get(id);

				if (student != null) {
					System.out.println("ID = " + student.getId());
					System.out.println("NAME = " + student.getName());
					System.out.println("AGE = " + student.getAge());
				} else
					System.out.println("OOPS! NO RECORD FOUND FOR THIS ID");

			} else if (userOption.equals(3)) {

				System.out.println("ENTER THE ID OF THE STUDENT TO UPDATE");
				Integer id = in.nextInt();
				in.nextLine();
				System.out.println("ENTER THE NAME OF THE STUDENT TO UPDATE");
				String name = in.nextLine();

				System.out.println("ENTER THE AGE OF THE STUDENT TO UPDATE");
				Integer age = in.nextInt();

				Student student = new Student();
				student.setId(id);
				student.setName(name);
				student.setAge(age);

				status = service.saveOrUpdate(student);

				if (status.equals("success"))
					System.out.println("SUCCESSFULLY UPDATE THE RECORD FOR GIVEN ID");
				else
					System.out.println("FAILED UPDATE THE RECORD FOR GIVEN ID");

			} else if (userOption.equals(4)) {

				System.out.println("ENTER THE ID OF THE STUDENT TO DELETE");
				Integer id = in.nextInt();

				status = service.delete(id);

				if (status.equals("success"))
					System.out.println("SUCCESSFULLY DELETED THE RECORD FOR GIVEN ID");
				else
					System.out.println("DELETION FAILED - NO RECORD AVAILABLE BY THIS ID");

			} else {
				System.out.println("INVALID OPERATION CHOOSE BETWEEN 1 TO 4");
			}

			System.out.println("WANT TO CONTINUE EXECUTION? TYPE  'Yes' OR 'No' ");
			String option = in.next();

			if (option.equalsIgnoreCase("No")) {
				execute = false;
				System.out.println("THANKS FOR USING OUR APPLICATOIN");
			}
		}

	}

}
