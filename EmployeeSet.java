// @author Stefanie Gutierrez
// 9/12/2019
// CS 272
// Lab 3: Collection class
// Purpose: work with and create collection arrays

package lab3;

import java.util.Arrays;

public class EmployeeSet {

	//test cases
	public static void main(String[] args) {
		
		Employee emp01 = new Employee();
		Employee emp02 = new Employee();
		Employee emp03 = new Employee();
		Employee emp04 = new Employee();
		Employee emp05 = new Employee();
		Employee emp06 = new Employee();
		Employee emp07 = new Employee();
		Employee emp08 = new Employee();
		Employee emp09 = new Employee();
		Employee emp10 = new Employee();
		Employee emp11 = new Employee();
		Employee emp12 = new Employee();
		
		
		EmployeeSet empBag = new EmployeeSet();
		
		empBag.add(emp01);
		empBag.add(emp02);
		empBag.add(emp03);

		
		
		System.out.println(empBag.capacity());
		System.out.println(empBag.size());
		
		emp01.setEmployeeName("Stefanie Gutierrez");
		emp01.setEmployeeNo(200015);
		emp01.setEmployeeAge(19);
		emp01.setEmployeeState("NM");
		emp01.setEmployeeZipCode(88003);
		emp01.addAdvisors(100034);
		emp01.addAdvisors(100450);
		emp01.addAdvisors(100369);
		
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
		
		emp02.setEmployeeName("Omar Black");
		emp02.setEmployeeNo(200345);
		emp02.setEmployeeAge(23);
		emp02.setEmployeeState("NM");
		emp02.setEmployeeZipCode(88006);
		emp02.addAdvisors(100345);
		emp02.addAdvisors(100586);
		emp02.addAdvisors(100470);
		
		empBag.remove(200115);
		System.out.println(empBag.size());
		
		System.out.println(empBag.contains(emp02));
		//test core_dataset.csv

	} // end main
	
	private int size;
	private int cap;
	private Employee[] employeeList;
	
	
	//default constructor
	public EmployeeSet() {
		
		//initialize instance with capacity to 10
		employeeList = new Employee[10];
		size = 0;
		
		
	}// end EmployeeSet constructor
	
	//copy constructors
	public EmployeeSet(Object obj) {
		
		//precondition - obj should not be null
		if (obj != null && obj instanceof EmployeeSet) {
			
		//new instance and copies content of object to new instance
			
			cap = ((EmployeeSet) obj).capacity();
			size = ((EmployeeSet) obj).size();
			employeeList = ((EmployeeSet) obj).employeeList;
			
		} // end precondition
		
	}// end EmployeeSet copy
	
	//returns num of elements in collection
	public int size() {
		
		size = 0;
		
		for (int i = 0; i < cap; i++ ) {
			
			if (employeeList[i] != null) {
				
				size++;
			}
			
		}
		
		return size;
		
	} // end size function
	
	
	// returns capacity of collection instance
	public int capacity() {
		
		cap = employeeList.length;
		
		return cap;
		
	} // end capacity function
	
	//add new employee object to collection
	public void add(Employee a) {
		
		//precondition - object should not be null
		if (a != null && a instanceof Employee) {
			
			//find first available space within collection
			if (size < employeeList.length) {
				
				employeeList[size] = a;
				size++;
				
			} // end if
			
			
			//implement method ensureCapacity to double space in array
			else {
				
				ensureCapacity(capacity() * 2);
				employeeList[size()] = a;
				
			} // end else
			
			
		} // end precondition
		
		//throw exceptions
		
	} // end add function
	
	// check if collection contains input parameter
	public boolean contains(Employee a) {
		
		//precondition - object should not be null
		if(a != null && a instanceof Employee) {
			
			//search for employee object within array
			for (int i = 0; i < size; i++) {
				
				//true if object is found
				if (employeeList[i].equals(a))
					return true;
				
			} // end for
			
		} // end precondition
		
		
		return false;
		
	} // end contains function
	
	
	//remove certain employee from collection
	public boolean remove(int eno) {
		
		
		//increment through array
		for (int i = 0; i < size; i++) {
			
			//implement method equals to test given eno to collection
			if(employeeList[i].getEmployeeNo() == (eno)) {
				
				//truncate array 
				employeeList[i] = employeeList[size - 1];
				employeeList[size - 1] = null;
				
				System.out.println("h");
				
				size--;
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	//guarantees the capacity of the collection
	private void ensureCapacity(int minimumCapacity) {
		
		//precondition - argument should be positive
		if(minimumCapacity >= 0) {
			
			//check if collection smaller then input parameter
			if(cap <= minimumCapacity) {
				
				//sets capacity to minimumCapacity with tmp array
				Employee tmp[] = new Employee[minimumCapacity];
				
				//enlarges array to hold minimumCapacity objects with tmp array
				for(int i = 0; i < size; i++) {
					
					tmp[i] = employeeList[i];
					
				} // end for
				
				employeeList = tmp;
				cap = cap * 2;
				
				
			} // end if inner
			
		} // end precondition
		
		else return;

	} // end ensureCapacity function
	
	
	// place objects in ascending order by employee no array
	public void addOrdered(Employee a) {
		
		//precondition - object should not be null 
		//objects in array are already in ascending order of employee no
		if(a != null) {
			
			//call add function to ensure capacity is large enough
			//and add object to array
			add(a);
			Arrays.sort(employeeList);
			
		} // end precondition
		
		
		
		
	} // end addOrdered function
	
	public void printtest() {
		
		for(int i = 0; i < size; i++) {
			
			if(employeeList[i] != null)
				System.out.print(employeeList[i] + " ");
			
		}
		
		System.out.println();
		
	}
	
	
	
	
	

}
