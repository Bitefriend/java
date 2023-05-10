package org.joozis.test;

class Employee{
	String name;
	String dept;

	public Employee() {}
	public Employee(String name, String dept) {
		this.dept = dept;
		this.name = name;
	}
	
	void output() {
		System.out.println("이름 : " + name + "\n부서 : " + dept);
	}
}
class SalaryWorker extends Employee{
	int salary;
	
	public SalaryWorker() {}
	public SalaryWorker(String name, String dept, int salary) {
		super(name,dept);
		this.salary = salary;
	}
	int pay() {
		return salary;
	}
	void output() {
		super.output();
		System.out.println("월급 : " + salary + "원");
	}
}
//판매 기본급 int salesPay() : 수당 = 기본급 * 판매인센티브
class SalesWorker extends SalaryWorker{
	double salesIncentive;
	public SalesWorker() {}
	public SalesWorker(String name, String dept, int salary, double salesIncentive) {
		super(name, dept, salary);
		this.salesIncentive = salesIncentive;
	} 
	int salesPay() { // 수당
		return (int) (salary * salesIncentive);
	}
	int pay() {// 수당 + 급여
		return salary + salesPay();
	}
	
	void output() {
		super.output();
		System.out.println("수당 : " + salesPay() + "\n전체월급 : " + pay() + "원");
	}
}
class PartTimeWorker extends Employee{
	int salary;
	int workTime, payPerHour;
	public PartTimeWorker() {}
	public PartTimeWorker(String name, String dept, int workTime, int payPerHour) {
		super(name, dept);
		this.workTime = workTime;
		this.payPerHour = payPerHour;
  }
   int pay() {
	   return workTime * payPerHour * 30;
   }
   void output() {
	   super.output();
	    System.out.println("일하는 시간 : " + workTime + "시간" + "\n시급 : " + payPerHour + "원" + "\n월급 : " + pay() + "원");
	
   }
}
public class Ex03_Main {
	public static void main(String[] args) {
		SalaryWorker sa = new SalaryWorker("김아무개", "인사과", 9000000);
		sa.output();
		
		System.out.println("-------------------------");
		
		SalesWorker so = new SalesWorker("이아무개", "판매", 1500000, 0.1);
		so.output();
		
		System.out.println("-------------------------");
		
		PartTimeWorker pa = new PartTimeWorker("조아무개", "알바", 12,10000 );
		pa.output();
	}
}
