package org.joozis.test;

import java.util.Scanner;

class Player{
	
private String player;
private String player2;

int score = 0;
 Player() {
	this.player = player;
	this.player2 = player2;
}
 
 public void setPlayer(String player) {
	this.player = player;
}
 
 public void setPlayer2(String player2) {
	this.player2 = player2;
}
 
void show() {
	System.out.println(player + "와" + player2 + "님의 오목게임 준비.");
}
}
interface Omok{
	public void show();
	
	public int OmokAct(char x, int y, int turn);
	
}
class OmokA implements Omok{
	int[][] line = new int[19][19];
	
	public void show() {
		int xx = 64;
		int xy = 0;
		
		for (int[] Y : line) {
			xy ++; // Line 인덱스 값에 맞춰서 Y 반복 증가
			System.out.println(xy < 10 ? xy + "" : xy);
			// 3항 연산을 써서 라인을 간단하게 출력
			// 세로는 0부터 9까지 (10줄)라면 10 + "" : 그게 아니라도 10
			// 이 방식이 아니면 true false 가 나옴
			
			// ? 연산은 if문, else문을 간결하게 쓰는 용도
			// 좌측에  Y좌표 표시
			for(int j : Y ) {
				if(j == 1) {
					System.out.print(" x돌"); // x돌
				}else if (j == 2) {            // j차례는 2번
					System.out.print(" y돌"); // y돌
				}else {
					System.out.print(" ."); //  Line 구분 짓고, 오목알을 넣기위한 . 공백
				}
			}
			System.out.println();
		}
		System.out.println(" ");
		for(int[] X : line) {
			xx ++;
			System.out.print(" " + (char)xx);
		}
		System.out.println();
	} // 하단 라인?
	

	@Override
	public int OmokAct(char x, int y, int turn) { // x축을 char형으로 y축은 정수값으로
		
		int charx = (x) - 17;
		//x축은 아스키 코드 숫자로 변경, 돌 박아야하는 용 (x좌표값)
		
		int chary = --y;
		//배열에 넣는 값 -1
		int cnt = 0 ;
		// 가로 세로 킹각선 체킹
		int _x,_y = 0; // 오목알 역할, .을 바꿔줄 변수
		// 언더바 = 리터럴
		String name = new String();
		//사용자 name 클래스 선언
		name = (turn == 1)? "x돌" : "y돌";
		//사용자의 차례변경문 turn 값이 1이라면  x돌을 그 외에는 y돌
		// player 사용자를 x player2 사용자를 y로 설정
		// 마찬가지로 3항 연산을 사용
		if(line[charx][chary] != 0) {
			// 라인에 Y와 X축이 0이 아니라면 이미 오목돌이 있는 것
			// 오목판을 만들 필요 x
			System.out.println("이미 있음");
			return 0;
		}else {
			line[charx][chary] = turn; // 그게 아니라면 턴 바꿈
		}
		// 가로축 세로 축 확인 용
		_x = charx;
		_y = chary;
		cnt = 0;
		// 라인에 있는 _y축 _x축 오목알이 과 x축(오목알 가로)가 0보다 크다
		// x축 .을 1개 제거
		// 오목알을 체크할거임 즉 5개가 되면 종료를 시킬거
		while(line[_y][_x] == turn && _x > 0) {
			_x--;
			
		}while(line[_y][++x] == turn && _x <= 10) {
			cnt++;
		}
		if(cnt == 5) {
			System.out.println(name + "승리");
			return 0;
		}
		_x = charx;
		_y = chary;
		cnt = 0;
		while(line[_y][_x] == turn && _y >0) {
			_y++;
			
		}while(line[++y][_x] == turn && _y <= 10) {
			cnt++;
		}
		if(cnt ==5) {
			System.out.println(name + "승리");
			return 0;
		}
		_x = charx;
		_y = chary;
		cnt = 0;
		while(line[_y][_x] == turn && _y >0) {
			_y--;
			_x--;
			
		}while(line[++y][_x] == turn && _y <= 10) {
			cnt++;
		}
		if(cnt ==5) {
			System.out.println(name + "승리");
			return 0;
		}
		//오른쪽 위 세로축 플러스 x축 마이너스
		//오른쪽 아래 가로세로축 마이너스
		
		return 0;
	}
}
public class Project_MINI01 {
	public static void main(String[] args) {
		// 오목 게임
		// 2차원 배열을 이용해서 .. 
		// Interface Omok.LOADING 
		// A.user B.user가 번갈아가면서 누를거임
		
		Scanner sc = new Scanner(System.in);
		
		Player p = new Player();
		OmokA o = new OmokA();
		
		String y = "y", Y = "Y", n = "n", N = "N";
		String sel, name1,name2;
		int turn = 0; // 차례를 알려주는 변수 ( 0 = player, 1 = player2)
		char x ; // x 축을 입력받는 아스키 코드 변수
		int y1 = 0;
		
		System.out.println("오목게임을 시작하시겠습니까? (Y/N)");
		sel = sc.next();
		if(sel.equals(y) || sel.equals(Y)) {
			System.out.println("게임을 시작합니다. Player, Player2 순서를 정하세요");
			System.out.println("Player 이름 입력 >>");
			name1 = sc.next();
			p.setPlayer(name1);
			System.out.println("Player2 이름 입력 >>");
			name2 = sc.next();
			p.setPlayer2(name2);
			System.out.println("플레이어 생성이 종료되었습니다.");
			p.show();
			
			boolean loop = true;
			
			while(loop) { //플레이어 생성 끝나면 시작
				o.show();
				System.out.println("x좌표 입력");
				x = sc.next().charAt(0);
				System.out.println("y좌표 입력");
				y1 = sc.nextInt();
				turn = (turn == 1)? 2 : 1 ; // x,y값입력이 끝나면 턴 넘김
				o.OmokAct(x, y1, turn);
				System.out.println("다음턴 입니다.");
				// turn이 1아니면 2 또는 1 // 턴제 바꿔주기
				loop = false ; // 누가 이겼는지 설정하고 loop 닫기
			}
			System.out.println("게임 종료");
			sc.close();
		}else if(sel.equals(n) || sel.equals(N)) {
			System.out.println("프로그램 종료");
		}
		
	
	}
}
