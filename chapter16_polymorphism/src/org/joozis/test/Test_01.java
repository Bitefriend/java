package org.joozis.test;
class Employee{
	private String name; 
	private String dept;
	public Employee() {}
	
	public Employee(String name, String dept) {
		this.name = name;
		this.dept = dept;
	}
	// pay()메소드를 오버라이드해서 사용하기 위해
	// 굳이 부모 클래스에 얺어준 방식. 실제로는 의미가 없는 메소드
	// 나중에 추상 메소드를 배우자
	int pay() { 
		return 0;
	}
	void output() {
		System.out.println("이름은 : " + name);
		System.out.println("부서는 : " + dept);
		
	}
}
class SalaryWorker extends Employee{
	private int salary;
	public SalaryWorker() {}
	public SalaryWorker(String name, String dept, int salary) {
		super(name, dept);
		this.salary = salary;
	}

	@Override
	int pay() {
		return salary;
	}
	@Override
	void output() {
		super.output();
		System.out.println("기본급은 : " + salary);
	}
}
class SalesWorker extends SalaryWorker{
	private int salesVolume;
	private double salesIncentive;
	public SalesWorker() {}
	public SalesWorker(String name, String dept, int salary) {
		super(name, dept, salary);
;
	}
	public int getSalesVolume() {
		return salesVolume;
	}
	public void setSalesVolume(int salesVolume) {
		this.salesVolume = salesVolume;
		if(salesVolume >= 1000) {
			setSalesIncentive(0.1);
		}else if(salesVolume >= 500) {
			setSalesIncentive(0.05);
		}else {
			setSalesIncentive(0.01);
		}
	}
	public double getSalesIncentive() {
		return salesIncentive;
	}
	void setSalesIncentive(double salesIncentive) {
		
			this.salesIncentive = salesIncentive;
	}
	int salesPay() {
		return (int)(salesIncentive * super.pay());
	}
	@Override
	int pay() {
		return super.pay() + salesPay();
	}
	@Override
	void output() {
		super.output();
		System.out.println("판매 수당: " + salesPay());
		System.out.println("총 월급은 : " + this.pay());
		
	}
}
class PartTimeWorker extends Employee{
	private int workTime;
	private int payPerHour;
	public PartTimeWorker() {}
	public PartTimeWorker(String name, String dept, int workTime, int payPerHour) {
		super(name, dept);
		this.workTime = workTime;
		this.payPerHour = payPerHour;
	}
	@Override
	int pay() {
		return workTime * payPerHour;
	}
	@Override
	void output() {
		super.output();
		System.out.println("총 근무 시간 : " + workTime);
		System.out.println("시급 : " + payPerHour);
		System.out.println("월급 : " + this.pay());
	}
}
public class Test_01 {
	public static void main(String[] args) {
		
		Employee[] em = new Employee[3];
		em[0] = new SalaryWorker("아무개", "구트", 1900000);
		em[1] = new SalesWorker("아무무무개", "구트판매", 100000);
		em[2] = new PartTimeWorker("아무무개", "구트알바", 12, 90);
		
		em[0].output();
		System.out.println("----------------------------------");
		if(em[1] instanceof SalesWorker) {
			((SalesWorker)em[1]).setSalesVolume(1000);
		}
		em[1].output();
		System.out.println("----------------------------------");
		em[2].output();
		

	}

}
