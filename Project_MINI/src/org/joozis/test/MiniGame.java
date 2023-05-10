package org.joozis.test;

import java.util.Random;
import java.util.Scanner;

public class MiniGame {
    void toString1() {
        System.out.println("==================");
        System.out.println("구구단 게임을 시작합니다(Y/N)");
        System.out.println("==================");

        Scanner sc3 = new Scanner(System.in);
        Random ran = new Random();
        String nun = sc3.next();
        while(nun.equals("y")|| nun.equals("Y")) {
            int count = 0;

            for (int i = 1; i < 4;i++) {
                int r = ran.nextInt(9) + 1;
                int r2 = ran.nextInt(9) + 1;

                System.out.println(i + "번 문제 ! 구구단을 외자! " + r + "x" + r2 + "= (   )");

                int player = sc3.nextInt();
                if (player == r * r2) {
                    System.out.println("정답 ! 쨕쨕쨕");
                    count++;
                } else if (player != r * r2) {
                    System.out.println("틀렸어 멍청아");
                }
            }
                System.out.println("================================");

                if (count == 3){
                    System.out.println("어릴떄 공부 좀 하셨군여~");
                } else if (count == 0) {
                    System.out.println("===========쯧쯧=============");

                }else {
                    System.out.println("3문제 중에 " + count + "문제 맞추셨습니다~");
                }
                System.out.println("게임 그만할게요~ Y/N");
                String un = sc3.next();
               if(un.equals("Y")||un.equals("y"))
                   System.out.println("================================");
                   System.out.println("캐릭터 실성해서 사망");
            System.out.println("================================");
               System.exit(0);
        }
    }
}
