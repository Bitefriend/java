package org.joozis.test;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
class Gift{
    int coun = 0;

    public int getCoun() {
        return coun;
    }
    void toString3(){
        if (coun == 1) {
            System.out.println("1개 맞았습니다! 상품 없엉");
        } else if (coun == 0) {
            System.out.println("운도 없네");
        } else if (coun == 2){
            System.out.println("2개 맞았습니다! 짝짝 근데 2개도 없엉");
        } else if (coun == 3) {
            System.out.println("3개 맞았습니다!!");
            System.out.println("@@ 5000원 @@");
        }else if(coun == 4){
            System.out.println("4개나 맞았습니다!!!!!");
            System.out.println("@@@ 5만원 @@@");
        } else if (coun == 5) {
            System.out.println("미띤 5개야!!!!!!!!");
            System.out.println("@@@@ 5천만원 @@@@");
        } else if (coun == 6) {
            System.out.println("1등 당첨 쨕쨕쨕쨕쨕쨕쨕쟈ㅉㄱ쨕쨕 박수~~");
            System.out.println("@@@@@ 상금 30억 @@@@@");
            System.out.println("이 기부되었습니다.");
        }
    }
}
public class Game2 extends Gift {
        void toString2() {
            System.out.println("====================");
            System.out.println("꿈속에 로또 세계로 날라왔다!");
            System.out.println("====================");

            Random r2 = new Random();
            Scanner r4 = new Scanner(System.in);
            int[] nn = new int[6];
            int[] n3 = new int[6];

            for (int i = 0; i < n3.length; i++) {
                nn[i] = r2.nextInt(45) + 1;
            }
            System.out.println("로또 번호는 : " + Arrays.toString(nn));
            for (int j = 0; j < n3.length; j++) {
                System.out.println("로또 번호 맞추게 숫자 6개 입력하세연 ~");
                n3[j] = r4.nextInt();
            }
            String result = "";
            for (int i = 0; i < nn.length; i++) {
                for (int j = 0; j < n3.length; j++) {
                    if (nn[i] == n3[j]) {
                        coun++;
                        result += Integer.toString(nn[i]) + " ";
                    }
                }
            }
            System.out.println("총 맞은 갯수는 : " + coun);
            toString3();
        }
}
