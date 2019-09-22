// @author Stefanie Gutierrez
// 9/2/2019
// CS 272
// Lab 2: Class definition and usage (OOP)
// Puprose: Implement the class to contain Elements. Practice equals method, static method and Test code.

package lab3;

import java.util.Arrays;

//import java.lang.reflect.Array;
//import java.util.Arrays;

public class Employee {
	
	public static void main(String[] args) {
		
		
		//create new Employee objects
		Employee empDefault = new Employee();
		Employee emp01 = new Employee();
		Employee emp02 = new Employee();
		
		//test all accessors
		System.out.println(empDefault.getEmployeeName() + empDefault.getEmployeeNo() + empDefault.getEmployeeAge() 
							+ empDefault.getEmployeeState() + empDefault.getEmployeeZipCode());
		
		System.out.println("\nEMPLOYEE: 00");
		//test toString method
		System.out.println(empDefault.toString());
		
		//test all mutators
		emp01.setEmployeeName("Stefanie Gutierrez");
		emp01.setEmployeeNo(200015);
		emp01.setEmployeeAge(19);
		emp01.setEmployeeState("NM");
		emp01.setEmployeeZipCode(88003);
		emp01.addAdvisors(100034);
		emp01.addAdvisors(100450);
		emp01.addAdvisors(100369);
		
		System.out.println("\nEMPLOYEE: 01");
		System.out.println(emp01.toString());
		
		//create new employee
		emp02.setEmployeeName("Valeira Valtierra");
		emp02.setEmployeeNo(200115);
		emp02.setEmployeeAge(22);
		emp02.setEmployeeState("NM");
		emp02.setEmployeeZipCode(88001);
		emp02.addAdvisors(100034);
		emp02.addAdvisors(100470);
		emp02.addAdvisors(100368);
		//test that it will only take 3 advisor no
		emp02.addAdvisors(100268);
		
		System.out.println("\nEMPLOYEE: 02");
		System.out.println(emp02.neatPrint());
		
		
		System.out.print("\nSame Employee: ");
		//test equal methods
		System.out.println(emp02.equals(emp01));
	
		System.out.println("\nAdvisors of Both Employees:");
		//test static method getAllAdvisors
		System.out.println(Arrays.toString(Employee.getAllAdvisors(emp01, emp02)));
		
	} // end main
	
	//instance variables
	private String employeeName;
	private int employeeNo;
	private int employeeAge;
	private String employeeState;
	private int employeeZipCode;
	private int numAdvisors;
	private int[] advisors;
	
	//default constructor
	public Employee() {
		
		employeeName = null;
		employeeNo = 0;
		employeeAge = 0;
		employeeState = null;
		employeeZipCode = 0;
		numAdvisors = 0;
		advisors = new int[3];
		
	}
	
	
	//copy constructor
	public Employee(Object obj) {
		
		if (obj != null && obj instanceof Employee) {
			
			this.employeeName = ((Employee) obj).getEmployeeName();
			this.employeeNo = ((Employee) obj).getEmployeeNo();
			this.employeeAge = ((Employee) obj).getEmployeeAge();
			this.employeeState = ((Employee) obj).getEmployeeState();
			this.employeeZipCode = ((Employee) obj).getEmployeeZipCode();
			this.advisors = ((Employee) obj).getAdvisors();
			// add advisors
			
		}
		
		
	}
	
	
	//accessor methods
	public String getEmployeeName() {
		return employeeName;
	}
	
	public int getEmployeeNo() {
		return employeeNo;
	}
	
	public int getEmployeeAge() {
		return employeeAge;
	}
	
	public String getEmployeeState() {
		return employeeState;
	}
	
	public int getEmployeeZipCode() {
		return employeeZipCode;
	}
	
	public int[] getAdvisors() {
		return advisors;
	}
	
	//mutators
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}


	public void setEmployeeNo(int employeeNo) {
		this.employeeNo = employeeNo;
	}

	public void setEmployeeAge(int employeeAge) {
		this.employeeAge = employeeAge;
	}
	
	public void setEmployeeState(String employeeState) {
		this.employeeState = employeeState;
	}

	public void setEmployeeZipCode(int employeeZipCode) {
		this.employeeZipCode = employeeZipCode;
	}

	//fill advisor array -- mutator
	public boolean addAdvisors(int empNum) {
		
		// if array exceeds 3 advisors 
		// do not allow adding of advisor
		if(numAdvisors > 2)
			return false;
		
		//add new advisor no to array
		else {
			
			advisors[numAdvisors] = empNum;
			numAdvisors = numAdvisors + 1;
			
			return true;
		} // end else
		
	}
	
	
	// toString method
	public String toString() {
		
		//neat print all information
		return String.format("%s, #%d, %d, %s,  %d, %d, %d, %d",  
				employeeName , employeeNo , employeeAge , employeeState , employeeZipCode, advisors[0], advisors[1], advisors[2]);
		
	}
	
	public String neatPrint() {
		
		//neat print all information
		return String.format("Name:\t  %s\nNo:\t  #%d\nAge:\t  %d\nState:\t  %s\nZip Code: %d\nAdvisors: #%d\n\t  #%d\n\t  #%d",  
					employeeName , employeeNo , employeeAge , employeeState , employeeZipCode, advisors[0], advisors[1], advisors[2]);
				
		
	}

	//equals method
	public boolean equals(Object obj) {
		
		
		// test if Employee object has contexts
		if (obj instanceof Employee && obj != null) {
			
			//test if two object Employee have the same Employee Number
			if(getEmployeeNo() == ((Employee) obj).getEmployeeNo())
				return true;
			
			else return false;
			
		} // end if outer
		
		// if Employee object has no contexts
		else
			return false;	
	
	
		
	} // end equals method
	
	
	// Static method get all advisors from two employees
	public static int[] getAllAdvisors(Employee e1, Employee e2) {
		
		//creat new array
		int[] allAdvisors = new int[6];
		
		//test if either obj is empty
		if (e1 != null && e2 != null) {
			
			
			//loop through to check for any repeats
			for (int i = 0; i < 3; i++) {
				
				for (int j = 0; j < 3; j++) {
					
					//if any repeat empty element in array 2 
					if (e1.advisors[i] == e2.advisors[j]) {
						
						e2.advisors[j] = 0;
						
						
					} // end inner if 
					
				} // end inner for loop
				
			} // end outer for loop

			
			//add all advisors from array 1 into new array allAdvisors
			for (int adNum = 0; adNum < 3; adNum = adNum + 1 ) {
				
				allAdvisors[adNum] = e1.advisors[adNum];
				
			} // end for
			
			//empty remaining advisors from array 2 into new array allAdvisors
			for (int adNum = 0; adNum < 3; adNum = adNum + 1) {
				
				allAdvisors[adNum + 3] = e2.advisors[adNum];
				
			} // end for
				
		} // end e1 != null if
		
		//completed advisor list for two employees
		return allAdvisors;
		
	} // end getAllAdvisors
	


} // end class Employee