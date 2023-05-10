package org.joozis.test;

import java.util.Scanner;

class Myexe extends Exception {
	public Myexe(String msg) {
		super(msg);
	}
}

class Charec { // 캐릭터 선택 클라스
	Scanner sss = new Scanner(System.in);
	Scanner ssss = new Scanner(System.in);
	String ch1, ch2, ch3;
	int ccount;

	public Charec() {
		this.ch1 = "멍청이";
		this.ch2 = "바보";
		this.ch3 = "돼지";
	}

	void toStirng() {
		System.out.println("캐릭터를 선택해 주세요.(1번, 2번, 3번)");
		System.out.println("1. " + ch1 + " : 멍청함");
		System.out.println("2. " + ch2 + " : 바보임");
		System.out.println("3. " + ch3 + " : 돼지임");
	}

	void subEng() {
		System.out.println("1. 영어단어");

		System.out.println("영어단어를 선택하셨습니다 !! ");
		System.out.println("영단어 문제 !");
		System.out.println(" 1. count : ");
		String coount = sss.next();

		if (coount.equals("세다")) {
			System.out.println("맞았습니다 ! 다음문제 !");
			ccount++;
		} else {
			System.out.println("틀렸습니다! 다음문제 !");
		}

		System.out.println("2. math : ");
		String coount2 = sss.next();

		if (coount2.equals("수학")) {
			System.out.println("맞았습니다 ! 다음문제 !");
			ccount++;
		} else {
			System.out.println("틀렸습니다! 다음문제 !");
		}
		System.out.println("3. hunt : ");
		String coount3 = sss.next();
		if (coount3.equals("사냥하다")) {
			System.out.println("맞았습니다 ! 다음문제 !");
			ccount++;
		} else {
			System.out.println("틀렸습니다! 다음문제 !");
		}
		System.out.println("4. English : ");
		String coount4 = sss.next();
		if (coount4.equals("영어")) {
			System.out.println("맞았습니다 ! 다음문제 !");
			ccount++;
		} else {
			System.out.println("틀렸습니다! 다음문제 !");
		}
		System.out.println("5. Adventure : ");
		String coount5 = sss.next();
		if (coount5.equals("모험") || coount5.equals("모험심")) {
			System.out.println("맞았습니다 ! 공부 끝 !");
			ccount++;
		} else {
			System.out.println("틀렸습니다!");
		}
		System.out.println("맞은 문제는 총 : " + ccount + "문제 입니다 !");
		if (ccount >= 5) {
			System.out.println("공부 잘하셨네요 ! 추카포카~");

		} else if (ccount <= 4) {
			System.out.println("이것도 모르냐 ㅉ");
		}
	}

	void subHis() {

		System.out.println("한국사를 선택하셨습니다 !!");
		System.out.println("한국사 문제 >>");
		System.out.println("1. 임진왜란이 일어난 년도는 ?");
		String histo = sss.next();
		if (histo.equals("1592") || histo.equals("1592년")) {
			System.out.println("맞았습니다 !! 다음문제 !");
			ccount++;
		} else {
			System.out.println("틀렸습니다! 다음문제 !");
		}
		System.out.println("2. 1905년도 일본이 외교권을 뺏기위해 강제로 맺은 조약은 ?");
		String histo2 = sss.next();
		if (histo2.equals("을사늑약")) {
			System.out.println("맞았습니다 !! 다음문제 !");
			ccount++;
		} else if (histo2.equals("을사조약")) {
			System.out.println("을사늑약이라고 하세요 이자식아");
			System.out.println("맞았다고는 해줌 ㅋ");
			ccount++;
		} else {
			System.out.println("틀렸습니다! 다음문제 !");
		}
		System.out.println("3. 6.25전쟁이 일어난 년도는 ?");
		String histo3 = sss.next();
		if (histo3.equals("1950") || histo3.equals("1950년")) {
			System.out.println("맞았습니다 !! 다음문제 !");
			ccount++;
		} else {
			System.out.println("틀렸습니다! 다음문제 !");
		}
		System.out.println("4.고구려 건국일은 ?");
		String histo4 = sss.next();
		if (histo4.equals("기원전 37년") || histo4.equals("37년") || histo4.equals("37")) {
			System.out.println("맞았습니다 !! 다음문제 !");
			ccount++;
		} else {
			System.out.println("틀렸습니다! 다음문제 !");
		}
		System.out.println("5. 이토히로부미가 암살된 년도는 ?");
		String histo5 = sss.next();
		if (histo5.equals("1909") || histo5.equals("1909년")) {
			System.out.println("맞았습니다 !! 공부 끝 !");
			ccount++;
		} else {
			System.out.println("틀렸습니다!");
		}
		System.out.println("맞은 문제는 총 : " + ccount + "문제 입니다 !");
		if (ccount >= 5) {
			System.out.println("공부 잘하셨네요 ! 추카포카~");

		} else if (ccount <= 4) {
			System.out.println("이것도 모르냐 ㅉ");

		}
	}

	void subEnghis() {
		System.out.println("영문학 공부를 시작합니다 !!");
		System.out.println("영문학 문제 시작 !!");
		System.out.println("1. 셰익스피어 4대 비극 중 한가지를 적으시오.(한국어)");
		String enghis = sss.next();
		if (enghis.equals("햄릿") || enghis.equals("오셸로") || enghis.equals("리어왕") || enghis.equals("맥베스")) {
			System.out.println("맞았습니다 !! 다음문제 !");
			ccount++;
		} else {
			System.out.println("틀렸습니다! 다음문제 !");
		}
		System.out.println("2. 최초의 영어로 작성된 영문학을 쓰시오. (한국어)");
		String enghis2 = sss.next();
		if (enghis2.equals("베어울프")) {
			System.out.println("맞았습니다 !! 다음문제 !");
			ccount++;
		} else {
			System.out.println("틀렸습니다! 다음문제 !");
		}
		System.out.println("3. 셰익스피어의 고향을 쓰시오 (한국어)");
		String enghis3 = sss.next();
		if (enghis3.equals("스트래트퍼트") || enghis3.equals("스트랫포드") || enghis3.equals("스트랫포드 어펀 에이븐")) {
			System.out.println("맞았습니다 !! 다음문제 !");
			ccount++;
		} else {
			System.out.println("틀렸습니다! 다음문제 !");
		}
		System.out.println("4. 영문학 3대 비극 중 에밀리 브론테가 작성한 작품을 쓰시오 (한국어)");
		String enghis4 = sss.next();
		if (enghis4.equals("비극의 폭풍")) {
			System.out.println("맞았습니다 !! 다음문제 !");
			ccount++;
		} else {
			System.out.println("틀렸습니다! 다음문제 !");
		}

		System.out.println("5. 노르만 정복이 일어난 년도는 ? (한국어)");
		String enghis6 = ssss.next();

		if (enghis6.equals("1066") || enghis6.equals("1066년")) {
			System.out.println("맞았습니다 !! 공부 끝 !");
			ccount++;
		} else {
			System.out.println("틀렸습니다!!");
		}

		System.out.println("맞은 문제는 총 : " + ccount + "문제 입니다 !");
		if (ccount >= 5) {
			System.out.println("공부 잘하셨네요 ! 추카포카~");

		} else if (ccount <= 4) {
			System.out.println("이것도 모르냐 ㅉ");
		}
	}

	void exit() {
		System.out.println("게임을 끝내겠습니다.");
		System.exit(0);
	}
}

class Map { // 맵 선택 클라스
	String map = "학교";
	String map2 = "집";
	String map3 = "서면";
	String map4 = "바다";

	public String getMap() {
		return map;
	}

	public String getMap2() {
		return map2;
	}

	public String getMap3() {
		return map3;
	}

	public String getMap4() {
		return map4;
	}

	void toStirng() {
		System.out.println("장소를 선택하쇼 (1번, 2번, 3번, 4번)");
		System.out.println("1. " + map + "로 간다.");
		System.out.println("2. " + map2 + "로 간다.");
		System.out.println("3. " + map3 + "로 간다.");
		System.out.println("4. " + map4 + "로 간다.");
	}
}

class Mapmini extends Map {
	String sing = "노래방";
	String eat = "맛집 탐방";
	String game = "피씨방"; // 서면에서 사용할 String
	String swim = "수영";
	String game2 = "길거리 게임";
	String hunt = "헌팅"; // 바다에서 사용할 String
	String study = "공부";
	String sleep2 = "잠이나 자자";
	String fig = "나도 CC를 할 수 있을까?"; // 학교에서 사용할 String
	String sleep = "못 일어남";
	String eat2 = "집 밥최고";
	String game3 = "게임 최고"; // 집에서 사용할 String

	public String getMap() {
		try {
			System.out.println("==============================");
			System.out.println("학교에 도착을 했다");
			System.out.println("==============================");
			System.out.println("학교에서 뭘 해야할까?(1번 2번 3번)");
			System.out.println("");
			System.out.println("1. 학생이면 당연히 " + study);
			System.out.println("2. 학생이면 학교에선 " + sleep2);
			System.out.println("3. 친구를 만났다 ! " + fig);
		} catch (Exception e) {
			System.out.println(" 다시입력하세요");
		}
		return null;
	}

	public String getMap2() {

		System.out.println("==============================");
		System.out.println("집에 도착을 했다");
		System.out.println("==============================");
		System.out.println("집에서 뭘 할까? (1번 2번 3번)");
		System.out.println("1. 알람은 무시해 " + sleep);
		System.out.println("2. 일단 먹자 " + eat2);
		System.out.println("3. 집에선 " + game3);
		return null;
	}

	public String getMap3() {
		System.out.println("==============================");
		System.out.println("서면에 도착했다 !!");
		System.out.println("==============================");
		System.out.println("서면에서 뭘 할까? (1번 2번 3번)");
		System.out.println("1. 코노코노 " + sing);
		System.out.println("2. 먹으려고 태어난건데, " + eat);
		System.out.println("3. 게임 쵝오 " + game);
		return null;
	}

	public String getMap4() {
		try {
			System.out.println("==============================");
			System.out.println("광안리에 도착했다 !!");
			System.out.println("==============================");
			System.out.println("광안리에서 뭘 할까? (1번 2번 3번)");
			System.out.println("1. 바다에선 수영이지 " + swim);
			System.out.println("2. 길거리 게임 시작 " + game2);
			System.out.println("3. 사냥? " + hunt);
		} catch (Exception e) {

		}
		return null;
	}
}

class Game {
	void game() {
		try {
			System.out.println("=====================");
			System.out.println("가위바위보 게임을 시작 합니다. ( 5번안에 못 이기면 사망)");
			System.out.println("=====================");
			Scanner sc2 = new Scanner(System.in);
			int s = 1;
			int r = 2;
			int p = 3;
			int count = 0;
			String player;
			String sel;
			System.out.println("가위바위보 게임을 하시겠습니까? (Y/N)");
			sel = sc2.next();

			while (sel.equals("y") || sel.equals("Y")) {
				for (int i = 0; i < 5; i++) {
					count++;
					System.out.println("카운트 시작 !! " + count + "번째");
					int num = ((int) (Math.random() * 3) + 1);

					System.out.println("가위,바위,보 중에 하나를 입력하세요.");
					player = sc2.next();
					System.out.println("컴퓨터가 낸 것은?");
					System.out.println(num);
					if (player.equals("가위")) {
						if (num == 1) {
							System.out.println("'1'바위");
							System.out.println("너는 가위");
							System.out.println("졌습니다.");
						} else {
							throw new Myexe("다시 입력해주세요.");
						}
						if (num == 2) {
							System.out.println("'2'는 가위");
							System.out.println("너는 가위");
							System.out.println("비김");
						} else {
							throw new Myexe("다시 입력해주세요.");
						}
						if (num == 3) {
							System.out.println("'3'은 보");
							System.out.println("너는 가위");
							System.out.println("져따");
						} else {
							throw new Myexe("다시 입력해주세요.");
						}
					}
					if (player.equals("바위")) {
						if (num == 1) {
							System.out.println("1은 바위");
							System.out.println("너는 바위");
							System.out.println("비김");
						} else {
							throw new Myexe("다시 입력해주세요.");
						}
						if (num == 2) {
							System.out.println("2는 가위");
							System.out.println("너는 바위");
							System.out.println("이겨따!");
						} else {
							throw new Myexe("다시 입력해주세요.");
						}
						if (num == 3) {
							System.out.println("3은 보");
							System.out.println("너는 바위");
							System.out.println("져따");
						} else {
							throw new Myexe("다시 입력해주세요.");
						}
					} else {
						throw new Myexe("다시 입력해주세요.");
					}
					if (player.equals("보")) {
						if (num == 1) {
							System.out.println("1은 바위");
							System.out.println("너는 보");
							System.out.println("이겨따");
						} else {
							throw new Myexe("다시 입력해주세요.");
						}
						if (num == 2) {
							System.out.println("2는 가위");
							System.out.println("너는 보");
							System.out.println("져따");
						} else {
							throw new Myexe("다시 입력해주세요.");
						}
						if (num == 3) {
							System.out.println("3은 보");
							System.out.println("너는 보");
							System.out.println("비김");
						} else {
							throw new Myexe("다시 입력해주세요.");
						}
					} else {
						throw new Myexe("다시 입력해주세요.");
					}
				}
			}
		} catch (Myexe e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("다시 입력해주세요");
		}
		System.exit(0);
	}
}

class StudyGame {
	void studyGame() {
		Scanner sss = new Scanner(System.in);
		Charec cha = new Charec();
		while (true) {
			try {
				System.out.println("공부를 시작하겠습니까? (Y/N)");
				String aa = sss.next();

				if (aa.equals("y") || aa.equals("Y")) {
					System.out.println("================================");
					System.out.println("공부를 시작합니다!(5점 이상이면 공부 끝 !)");
					System.out.println("================================");
					System.out.println("");

					System.out.println("과목을 선택하시오.(1. 영어단어 2. 한국사 3. 영문학)");
					int gogo = sss.nextInt();
					if (gogo == 1) {
						cha.subEng();

					} else if (gogo == 2) {
						cha.subHis();

					} else if (gogo == 3) {
						cha.subEnghis();
					} else {
						throw new Myexe("다시 입력해주세요.");
					}
				} else if (aa.equals("n") || aa.equals("N")) {
					cha.exit();
				}
			} catch (Myexe e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println("다시 입력해주세요");
			}
		}
	}
}

class Date {
	void dating() {
		try {
			System.out.println(" 게임 시~ 작!");

			Scanner ss = new Scanner(System.in);
			String q, a;
			int b;
			System.out.println("*******************게임 방법 *************************");
			System.out.println("선택하는 말마다 결말 바뀜 알맞는 대답 ㄱㄱ");
			System.out.println("****************************************************");
			System.out.println("");
			System.out.println("학교에서 친구를 만났다 !!");
			System.out.println("무슨 말을 해야할까?");
			System.out.println("===============");
			System.out.println("1. 밥먹으러 갈래? 2. 공부는 하긴하니? 3. 왜 살아?");
			System.out.println("===============");
			int cho = ss.nextInt();
			if (cho == 1) {
				System.out.println("너 : 밥먹으러 갈래?");
				System.out.println("========================================");
				System.out.println("친구 : 뭐 먹을 건데?");
				System.out.println("========================================");
				System.out.println("1. 마라탕 2. 학식 3. 니가 골라");
				int eeat = ss.nextInt();
				if (eeat == 1) {
					System.out.println("너 : 마라탕은 어때?");
					System.out.println("========================================");
					System.out.println("친구 : 좋아 ! 가자 !");
					System.out.println("========================================");
					System.out.println("마라탕 집으로 이동");
					System.out.println(". . 이동중 . .");
					Thread.sleep(1500);
					System.out.println(". . 이동중 . .");
					Thread.sleep(1500);
					System.out.println(". . 이동중 . .");
					Thread.sleep(1500);
					System.out.println("마라탕 집 도착 !");
					System.out.println("마라탕을 먹으면서 무슨 얘기를 할까?");
					System.out.println("1. 나 사실 너 좋아했어. 2. 자기야 3. 주말에 나랑 영화볼래?");
					int like = ss.nextInt();
					if (like == 1) {
						System.out.println("너 : 나 사실 너 좋아했어 사귀자");
						Thread.sleep(1000);
						System.out.println("친구 : 뭐? 미쳤어? 밥 맛 떨어지게 진짜 ;(퍽)");
						Thread.sleep(1500);
						System.out.println(". . . .");
						Thread.sleep(1500);
						System.out.println(". . . .");
						Thread.sleep(1500);
						System.out.println("뜨거운 마라탕에 맞아 사망 하셨습니다.");
					} else if (like == 2) {
						System.out.println("너 : 자기야");
						Thread.sleep(1000);
						System.out.println("친구 : 웅 자기야");
						Thread.sleep(1000);
						System.out.println("너 : (어? 자기야라고 했다...)");
						Thread.sleep(1000);
						System.out.println("친구 : 라고 할뻔 (퍽)");
						Thread.sleep(1500);
						System.out.println(". . . .");
						Thread.sleep(1500);
						System.out.println(". . . .");
						Thread.sleep(1500);
						System.out.println("집게에 꽂혀 사망하셨습니다.");
					} else if (like == 3) {
						System.out.println("너 : 이번에 ***배우 영화 개봉했던데 주말에 시간 있으면 나랑 보러가자 ! ");
						Thread.sleep(1000);
						System.out.println("친구 : 어? 나 그거 보고 싶었는데 !! 좋아 보러가자 !!");
						Thread.sleep(1000);
						System.out.println("너 : (어? 된건가? 우와 데이트다 !!!)");
						Thread.sleep(1000);
						System.out.println("==================주말=====================");
						System.out.println("너 : 헤헤 설레서 일찍 도착했따 !");
						Thread.sleep(1000);
						System.out.println(". . . .");
						Thread.sleep(1000);
						System.out.println(". . . .");
						Thread.sleep(1000);
						System.out.println(". . . .");
						Thread.sleep(1000);
						System.out.println("너 : 음... 왜 안오지? 무슨 일 있나? ");
						Thread.sleep(1000);
						System.out.println(". . . .");
						Thread.sleep(1000);
						System.out.println(". . . .");
						Thread.sleep(1000);
						System.out.println(". . . .");
						Thread.sleep(1000);
						System.out.println("=============12시간 뒤=================");
						Thread.sleep(1000);
						System.out.println("기다리다 동상에 걸려서 사망하셨습니다 !! ");
						Thread.sleep(1000);
						System.err.println("커플은 상상의 동물입니다. 그런 엔딩은 불가능 합니다 !!!!!!!!");
						Thread.sleep(2500);
					} else {
						throw new Myexe("사망하셨습니다.");
					}
				} 
				
				if (eeat == 2) {
					System.out.println("너 : 학식? 미대 치돈!");
					System.out.println("========================================");
					System.out.println("친구 : 미안 나 약속 있는 걸 깜빡 했네 ㅎㅎ");
					System.out.println("========================================");
					System.out.println("===========친구를 잃었습니다. ===============");
				} 
				if (eeat == 3) {
					System.out.println("너 : 니가 골라 ;");
					System.out.println("========================================");
					System.out.println("========================================");
					Thread.sleep(2000);
					System.out.println("...........");
					Thread.sleep(2000);
					System.out.println("...........");
					Thread.sleep(2000);
					System.out.println("...........");
					Thread.sleep(2000);
					System.out.println("야생의 친구가 도망갔다.");
					Thread.sleep(2000);
				} 
			} 
			if (cho == 2) {
				System.out.println("너 : 공부는 하긴 하니?");
				System.out.println("친구 : ㅇ");
			} 
			if (cho == 3) {
				System.out.println("너 : 왜 살아?");
				System.out.println("친구 : (푹)");
				System.out.println("========================================");
				System.out.println("============= 사망하셨습니다 ===============");
				System.out.println("========================================");
			} else {
				throw new Myexe("사망하셨습니다.");
			}
		} catch (Myexe e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("사망하셨습니다.");
		}
		System.exit(0);
	}
}

public class Else_mini {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Charec ch = new Charec();
		Map ma = new Map();
		Mapmini mini = new Mapmini();
		Game ga = new Game();
		MiniGame mi = new MiniGame();
		Game2 g2 = new Game2();
		StudyGame study = new StudyGame();
		Date da = new Date();
		while (true) {
			try {
				System.out.println("이름 없는게임을 시작하시겠습니까?(Y / N)");
				String str = sc.next();
				int num2;
				int num3;
				if (str.equalsIgnoreCase("y")) {
					System.out.println("=======================================");
					System.out.println("게임을 시작하겠습니다~~~~");
					System.out.println("=======================================");

				} else if (str.equalsIgnoreCase("n")) {
					break;
				} else {
					throw new Myexe("다시 입력해주세요.");
				}
				ch.toStirng();
				int num = sc.nextInt();

				if (num == 1) {
					System.out.println("당신이 선택한 캐릭터는 " + ch.ch1);
					System.out.println("----------------------------");
				} else if (num == 2) {
					System.out.println("당신이 선택한 캐릭터는 " + ch.ch2);
					System.out.println("----------------------------");
				} else if (num == 3) {
					System.out.println("당신이 선택한 캐릭터는 " + ch.ch3);
					System.out.println("----------------------------");

				} else {
					throw new Myexe("다시 입력해주세요.");
				}
				ma.toStirng();
				num2 = sc.nextInt();
				if (num2 == 1) {
					System.out.println("======== 학교 이동 중입니다 =============");
					System.out.println("======== 학교 이동 중입니다 =============");
					System.out.println("");
					mini.getMap();
					num3 = sc.nextInt();
					switch (num3) {
					case 1:
						System.out.println("공부를 시작해보자 !! "); //열공 엔딩
						study.studyGame();
						break;
					case 2:
						System.out.println("학교 학점시스템 업데이트 예정입니다. "); // 졸업엔딩 이야기로 만들기
						break;
					case 3:
						System.out.println("데이트 하자 헤헤"); // 사망엔딩
						da.dating();
						break;
					}
				} else if (num2 == 2) {
					System.out.println("========집 이동 중입니다 =============");
					System.out.println("========집 이동 중입니다 =============");
					System.out.println("");
					mini.getMap2();
					num3 = sc.nextInt();
					switch (num3) {
					case 1:
						System.out.println("꿈을 꿨다! 로또 꿈이다! 인생역전 하자아"); // 허황된 꿈 엔딩
						g2.toString2();
						break;
					case 2:
						System.out.println("우걱우걱 집밥게임이 곧 업데이트 될 예정입니다."); // 음식관련 게임 만들기
						break;
					case 3:
						System.out.println("몬스터 죽이기 게임이 곧 업데이트 될 예정입니다."); // 몬스터 HP, 주인공 HP설정 후 랜덤으로 데미지 계산 게임 
						break;
					}
				} else if (num2 == 3) {
					System.out.println("======== 서면 이동 중입니다 =============");
					System.out.println("======== 서면 이동 중입니다 =============");
					System.out.println("");
					mini.getMap3();
					num3 = sc.nextInt();
					switch (num3) {
					case 1:
						System.out.println("성대 결절로 사망.."); // 랜덤 노래맞추기 게임 만들어보기
						break;
					case 2:
						System.out.println("맛집관련 게임이 곧 업데이트 될 예정입니다."); // 맛집 지도 브루마블게임 만들기
						break;
					case 3:
						System.out.println("========================");
						System.out.println("서면에서 구구단 함 ㄹㅇ");
						System.out.println("========================");
						mi.toString1();
						break;
					}
				} else if (num2 == 4) {
					System.out.println("======== 광안리 이동 중입니다 =============");
					System.out.println("======== 광안리 이동 중입니다 =============");
					System.out.println("");
					mini.getMap4();
					num3 = sc.nextInt();
					switch (num3) {
					case 1:
						System.out.println("익사관련된 게임이 곧 업데이트 될 예정입니다."); // 물고기 상어 나오는 HP게임 만들어보기
						break;
					case 2:
						System.out.println("곧 헌팅게임이 업데이트 될 예정입니다."); // 헌팅하고 랜덤으로 번호따기? 랜덤 헌팅게임 만들어보기
						break;
					case 3:
						System.out.println("===================");
						System.out.println("길거리에서 가위바위보 이기기!!");
						System.out.println("===================");
						ga.game();
						break;
					}
				} else {
					throw new Myexe("다시 입력해주세요.");
				}
			} catch (Myexe e) {
				System.out.println(e.getMessage());

			} catch (Exception e) {
				System.out.println("다시 입력해주세요!");
			}
		}
		System.out.println("게임을 종료합니다.");
		sc.close();
	}
}
