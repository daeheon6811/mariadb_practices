package hr;

import java.util.List;
import java.util.Scanner;

public class HRMain2 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Salary[min max]> ");
		int minSalary = scanner.nextInt();
		int maxSalray = scanner.nextInt();
		
		System.out.println(minSalary +":" + maxSalray);
		
		EmployeeDao dao = new EmployeeDao();
		List<EmployeeVo> list = dao.findbySalray(minSalary,maxSalray);
		for(EmployeeVo vo : list) {
			System.out.println(vo);
		}
	}

}
