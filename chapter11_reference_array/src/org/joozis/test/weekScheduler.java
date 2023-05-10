package org.joozis.test;

import java.util.Scanner;

public class weekScheduler {
	Day[] days;
	Scanner sc = new Scanner(System.in);
	String[] week = {"일", "월", "화", "수","목","금", "토"};
	
	public weekScheduler() {
		days = new Day[7];
		for (int i = 0; i < days.length; i++) {
			days[i] = new Day();
		}
		
	}
	void menu() {
		System.out.println("************");
		System.out.println("1. 스케쥴 생성");
		System.out.println("2. 스케쥴 삭제");
		System.out.println("3. 스케쥴 수정");
		System.out.println("4. 스케쥴 보기");
		System.out.println("0. 종료");
		System.out.println("************");
		
	}
    void run() {
		while(true) {
			menu();
			System.out.println("작업 선택 >>");
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1 : makeSchedule();
			    break;
			case 2 : removeSchedule();
			    break;
			case 3 : modifySchedule();
			    break;
			case 4 : output();
			    break;
			case 0 : exit();
			    break;
			    
			    default : System.out.println("다시 입력하세요.");
			break;
			}
		}
	}
	void  makeSchedule(){
		System.out.println("스케쥴을 등록할 요일 선택(일~토) >>");
		String weekday = sc.next(); // 1. 스케쥴 생성 요일 입력
		for (int i = 0; i < week.length; i++) { //2. 요일에 해당하는 스케쥴 저장 위치 찾기
			if(weekday.equals(week[i])) {
				//입력한 요일과 요일 배열 값이 같으면.
				if(days[i].getSchedule() == null) { //  3. 해당 요일에 스케쥴이 있는지 확인
					//해당 요일에 스케줄이 비어 있으면
					System.out.println("등록할 스케쥴 입력 >>");//4. 등록할 스케쥴 입력
					String input = sc.next();
					days[i].setSchedule(input); // 5. 스케쥴을 days 배열 내 객체에 저장
				}else {
					// 해당 요일에 스케쥴이 이미 있으면
					System.out.println(week[i] + "일에 이미 스케쥴이 있습니다");
				}
			} 
		}
	}
	void removeSchedule() {
		//1. 삭제할 요일선택
		//2. 해당 요일 배열에서 찾기
		//3. 해당 요일에 스케쥴이 있는지 확인
		//4. 스케쥴이 있으면 삭제 > Day 객체의 필드 값 변경 null로 변경
		// 
		//5. 스케쥴이 없으면 > 해당 요일에 삭제할 스케쥴이 없습니다. 출력
		// ex) 월요일에 삭제할 스케쥴이 없습니다.
		System.out.println("삭제할 요일 입력.");
		String day = sc.next();
		for (int i = 0; i < week.length; i++) {	
		    if(day.equals(week[i])) {
		    	if(days[i].getSchedule() != null) {
		    		days[i] = null;
		    		// or day[i].setSchedule(null);
			    	System.out.println("삭제되었습니다.");
			    	days[i].setSchedule(day);
		    	
		    	}else {
		    		System.out.println(week[i] + "요일에 삭제할 스케쥴이 없습니다.");
		    	}
			 
		    }
		}
	}
	void modifySchedule() {
		System.out.println("수정할 요일 입력");
		String modi = sc.next();
		for (int i = 0; i < days.length; i++) {
			if(modi.equals(week[i])) {
				if(days[i].getSchedule() == null) {
					System.out.println(week[i] + "요일의 스케줄이 없습니다.");
					System.out.println("새 스케줄을 등록하시겠습니까?(yes / no) ");
					String yn = sc.next();
					if(yn.equalsIgnoreCase("yes")) {
						System.out.println("등록할 스케줄 입력");
						String schedule = sc.next();
						days[i].setSchedule(schedule);
					}else {
						System.out.println("변경된 스케줄이 없습니다.");
					}
							
						}else {
							System.out.println(week[i] + "요일의 기존 스케쥴을 변경합니다.");
							modi = sc.next();
							if(modi == "yes") {
								System.out.println("새 스케쥴 입력");
								String schedule =sc.next();
								days[i].setSchedule(schedule);
						
					}
				}
				
			}
		}
		//1. 수정할 요일 선택
		//2. 해당 요일 배열에서 찾기
		//3. 해당 요일에 스케쥴이 있는지 확인
		//4. 스케쥴이 있으면 > 해당 요일 스케쥴 변경
		// ex) 월요일의 기존 스케쥴을 변경합니다.
		//     " 변경할 스케쥴 입력>>"
		//5. 스케쥴이 없으면 > 선택
		// ex) "월요일에 스케줄이 없습니다."
		//     " 새 스케쥴을 등록하시겠습니까? (yes / no) >>"
		// 6. yes 입력 시 새 스케줄 입력
		//    no 입력시 변경된 스케쥴이 없습니다. 출력
		
	}
	void output() {
		System.out.println("<일주일 전체 스케쥴 입력>");
		for (int i = 0; i < days.length; i++) {
			System.out.println(week[i] + "요일 스케쥴 : ");
			days[i].output();
			
		}
	}
	void exit() {
		System.out.println("<스케쥴러를 종료합니다.>");
		sc.close();
		System.exit(0);
	}

	
}
