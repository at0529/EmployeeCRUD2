package maven_new2.EmployeeApp;

import java.util.List;
import maven_new1.akhil1.*;
import java.util.Map;
import java.util.Scanner;

public class EmployeeApp {

	List<Employee> list = null;

	Employee emp = null;

	EmployeeDao ed = new EmployeeDao();
	private static Scanner sc = new Scanner(System.in);

	private void createEmployee() {
		emp = EmployeeUtil.readEmployee();
		ed.createRecord(emp);
	}

	private void displayEmployee() {
		int a = EmployeeUtil.choosefind();
		ed = new EmployeeDao();
		switch (a) {
		case 1:
			System.out.println("Enter Id: ");
			int x = sc.nextInt();
			Employee emp = ed.findEmployeeByID(x);
			System.out.println(emp);
			break;
		case 2:
			System.out.println("Enter First Name: ");
			String x1 = sc.next();
			list = ed.findEmployeeByFirstName(x1);
			list.forEach(System.out::println);
			break;
		case 3:
			System.out.println("Enter Last Name: ");
			String x2 = sc.next();
			list = ed.findEmployeeByLastName(x2);
			list.forEach(System.out::println);
			break;
		case 4:
			System.out.println("Enter Salary: ");
			double x3 = sc.nextDouble();
			list = ed.findEmployeeBySalary(x3);
			list.forEach(System.out::println);
			break;
		case 5:
			System.out.println("Select the gender");
			System.out.println("	1.Male");
			System.out.println("	2.Female");
			int x4 = sc.nextInt();

			String x5 = null;
			if (x4 == 1) {
				x5 = "Male";
			} else if (x4 == 2) {
				x5 = "Female";
			} else {
				System.out.println("Enter either 1 or 2");
				break;
			}
			list = ed.findEmployeeByGender(x5);
			list.forEach(System.out::println);

			break;
		default:
			System.out.println("Enter the values in between 1 and 5");
			break;
		}

	}

	private void displayAll() {
		System.out.println("Enter the number of records to be displayed: ");
		ed = new EmployeeDao();
		int x = sc.nextInt();
		list = ed.findAll(x);
		list.forEach(System.out::println);

	}

	private void update() {
		System.out.println("Enter id of the employee: ");
		int id = sc.nextInt();
		emp = EmployeeUtil.readEmployee();
		ed = new EmployeeDao();
		boolean flag = ed.updateEmployeeById(emp, id);
		if (flag == true) {
			System.out.println("success");
		} else {
			System.out.println("record not found");
		}

	}

	private void delete() {
		System.out.println("Enter id of the employee: ");
		int id = sc.nextInt();
		ed = new EmployeeDao();
		boolean flag = ed.delete(id);
		if (flag == true) {
			System.out.println("success");
		} else {
			System.out.println("record not found");
		}
	}

	private void calcHra() {
		System.out.println("Enter id of the employee: ");
		int id = sc.nextInt();
		ed = new EmployeeDao();
		List<Double> list = ed.calcHra(id);
		System.out.println("Hra of employee is: ");
		list.forEach(System.out::println);
	}

	private void calcGrossSal() {
		System.out.println("Enter id of the employee: ");
		int id = sc.nextInt();
		ed = new EmployeeDao();
		List<Double> list = ed.calcGross(id);
		System.out.println("Gross Salary of employee is: ");
		list.forEach(System.out::println);

	}

	private void sortEmployee() {
		int x = EmployeeUtil.sortEmp();
		ed = new EmployeeDao();
		switch (x) {
		case 1:
			System.out.println("1. Ascending");
			System.out.println("2. Descending");
			int number = sc.nextInt();
			if (number == 1 || number == 2) {
				list = ed.sortId(number);
			}
			System.out.println("Employee records after sorting ");
			list.forEach(System.out::println);
			break;
		case 2:
			System.out.println("1. Ascending");
			System.out.println("2. Descending");
			int number1 = sc.nextInt();
			if (number1 == 1 || number1 == 2) {
				list = ed.sortFirstName(number1);
			}
			System.out.println("Employee records after sorting ");
			list.forEach(System.out::println);
			break;
		case 3:
			System.out.println("1. Ascending");
			System.out.println("2. Descending");
			int number2 = sc.nextInt();
			if (number2 == 1 || number2 == 2) {
				list = ed.sortLastName(number2);
			}
			System.out.println("Employee records after sorting ");
			list.forEach(System.out::println);
			break;
		case 4:
			System.out.println("1. Ascending");
			System.out.println("2. Descending");
			int number3 = sc.nextInt();
			if (number3 == 1 || number3 == 2) {
				list = ed.sortGender(number3);
			}
			System.out.println("Employee records after sorting ");
			list.forEach(System.out::println);
			break;
		case 5:
			System.out.println("1. Ascending");
			System.out.println("2. Descending");
			int number4 = sc.nextInt();
			if (number4 == 1 || number4 == 2) {
				list = ed.sortSalary(number4);
			}
			System.out.println("Employee records after sorting ");
			list.forEach(System.out::println);
			break;
		default:
			System.out.println("Enter values in between 1 and 5");
			break;
		}

	}
	
	private void groupByGen() {
		ed= new EmployeeDao();
		Map<String, Integer> map= ed.groupByGender(); 
		map.forEach((K, V)-> System.out.println("Gender: " + K + " Count: " + V));
	}

	public static void main(String[] args) {

		EmployeeApp app = new EmployeeApp();

		Employee emp = null;
		while (true) {
			int a = EmployeeUtil.chooseOperation();
			if (a == 10) {
				break;
			}
			switch (a) {
			case 1:
				app.createEmployee();
				break;
			case 2:
				app.displayEmployee();
				break;
			case 3:
				app.displayAll();
				break;
			case 4:
				app.update();
				break;
			case 5:
				app.delete();
				break;
			case 6:
				app.calcHra();
				break;
			case 7:
				app.calcGrossSal();
				break;
			case 8:
				app.sortEmployee();
				break;
			case 9:
				app.groupByGen();
				break;
			default:
				System.out.println("Enter the values in between 1 and 7");
				break;
			}
		}
	}

}
