package org.joonzis.ex;
/*
 * DepositExceptio     : 마이너스 입금 처리, 예외 코드 1000
 * WithdrawException   : 잔액초과 출금 처리, 예외 코드 2000
 *                     : 마이너스 출금 처리, 예외 코드 2001
 */
class BankAccount{
	//필드
	private String no;    // 계좌 번호
	private long balance; // 계좌 잔액
	public BankAccount(String no, long balance) {
		this.no = no;
		this.balance = balance;
	}
	//입금
	public void deposit(long money) throws DepositException {
		//"0보다 작으면 입금 불가!"
		if(money < 0) {
			throw new DepositException(1000, "입금실패");
		}
		balance += money;
	}
	//출금
	public void withdraw(long money)throws WithdrawException {
		//"0보다 작으면 출금 불가!"
		//"잔액보다 크면 출금 불가!"
		if(money < 0) {
			throw new WithdrawException(2000, "출금 불가");
		}else if(money > balance) {
			throw new WithdrawException(2001, "출금 불가");
		}
		balance -= money;
	}
	//조회
	public void inquiry() {
		System.out.println("계좌 번호 : " + no);
		System.out.println("계좌 잔액 : " + balance);
	}
	//이체
	public void transfer(BankAccount account, long money)throws DepositException, WithdrawException {
		withdraw(money);
		account.deposit(money);

		//		if(balance < money) {
//			throw new WithdrawException(2001, "출금 불가");
//		}else if(balance > money) {
//			
//			account.balance+=money;
//			
//		}
//		balance-=money;
	}
}
class DepositException extends Exception{
	private static final long serialVersionUID = 1L;
	private int errCode;
	public DepositException(int errCode, String msg) {
		super(msg);
		this.errCode = errCode;
	}
	public int getErrCode() {
		return errCode;
	}
	
}
class WithdrawException extends Exception{
	private static final long serialVersionUID = 1L;
	private int errCode;
	public WithdrawException(int errCode, String msg) {
		super(msg);
		this.errCode = errCode;
	}
	public int getErrCode() {
		return errCode;
	}
}

public class Ex09_exception {
	public static void main(String[] args) {
		BankAccount parent = new BankAccount("123-456", 0);
		BankAccount child = new BankAccount("654-321", 0);
		
		try {
			//1. 부모계좌에 10,000원 입금 - 입금 예외
			//2. 부모계좌에 5,000원 출금 - 출금 예외
			//3. 부모 계좌에서 자식 계좌로 5,000원 이체 - 입금,출금 예외
			parent.deposit(10000);
			parent.inquiry();
			System.out.println("------");
			parent.withdraw(5000);
			parent.inquiry();
			System.out.println("------");
			System.out.println("이체 상황 ");
			parent.transfer(child, 5000);
			System.out.println("----애기 계좌----");
			child.inquiry();
			System.out.println("-----엄마계좌----");
			parent.inquiry();
			
			
			
		} catch (DepositException e) {
			System.out.println("DepositException 에러 메세지 : " + e.getMessage()
			+ "(코드 : " + e.getErrCode() + ")");
		}  catch(WithdrawException e) {
	        System.out.println("WithdrawException 에러 메세지 : " + e.getMessage()
	        + "(코드 : " + e.getErrCode() + ")");
		}
			
		
	}

}
