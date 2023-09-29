package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Boolean start = true;

		System.out.println("******************* Wellcome to application *******************");

		while (start) {

			System.out.println("\nPRESS 1 for add new student detail");
			System.out.println("PRESS 2 for display all students detail");
			System.out.println("PRESS 3 for get detail of specific student detail");
			System.out.println("PRESS 4 for delete students detail");
			System.out.println("PRESS 5 for update student detail");
			System.out.println("PRESS 6 for exit to application\n");

			try {

				int input = Integer.parseInt(br.readLine());

				switch (input) {
				case 1:
					// Inpute student
					System.out.println("Add your student id : ");
					int inputNewID = Integer.parseInt(br.readLine());

					System.out.println("Add your student name : ");
					String inputName = br.readLine();

					System.out.println("Add your student city : ");
					String inputCity = br.readLine();

					Student student = new Student(inputNewID, inputName, inputCity);

					int result = studentDao.insert(student);

					System.out.println("Your student is insertad : " + result);
					break;

				case 2:
					// get all student
					List<Student> studentlist = studentDao.getAllStudent();
					System.out.println("Your student list : ");

					for (Student students : studentlist) {
						System.out.println(students);
					}

					break;

				case 3:
					// get student
					System.out.println("Add your student id : ");
					int inputID = Integer.parseInt(br.readLine());

					Student studentById = studentDao.getStudent(inputID);
					if (studentById != null) {
						System.out.println("Your student list : " + studentById);
					} else {
						System.out.println("Invalid Input Try with another one !!");
					}

					break;

				case 4:
					// delete student
					System.out.println("Add your student id : ");
					int inputDeleteID = Integer.parseInt(br.readLine());

					studentDao.deleteStudent(inputDeleteID);
					System.out.println("Your student has been deleted!");

					break;
				case 5:
					// update student
					System.out.println("Add your student id : ");
					int inputUpateID = Integer.parseInt(br.readLine());

					System.out.println("Add your student name : ");
					String inputUpdateName = br.readLine();

					System.out.println("Add your student city : ");
					String inputUpdateCity = br.readLine();

					Student Updatestudent = new Student(inputUpateID, inputUpdateName, inputUpdateCity);

					studentDao.updateStudent(Updatestudent);

					System.out.println("Your student has been updated!");
					break;
				case 6:
					// Exit
					System.out.println("Thank you for using our application!");
					start = false;
					break;
				default:
					System.out.println("Invalid Input Try with another one !!");
					break;
				}

			} catch (Exception e) {
				System.out.println("Invalid Input Try with another one !!");
				System.out.println(e.getMessage());
			}
		}

	}
}
