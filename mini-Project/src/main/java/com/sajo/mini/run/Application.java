package com.sajo.mini.run;

import com.sajo.mini.member.controller.MemberController;
import com.sajo.mini.member.controller.ProductController;

import java.util.Scanner;

public class Application {//test
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);



        while (true) {
            System.out.println("*•.¸✨¸.•*” 페이지 선택 *•.¸✨¸.•*”");
            System.out.println("1. 상인관리페이지");
            System.out.println("2. 구매자 페이지");
            System.out.println("3. 프로그램 종료");
            System.out.print("이용할 서비스를 선택해주세요 : ");
            int num1 = sc.nextInt();
            switch (num1) {
                case 1:
                    ProductController pc = new ProductController();
                    pc.selectNumber();
                    break;
                case 2:
                    MemberController mc = new MemberController();
                    mc.infoUser();
                    break;
                case 3:
                    System.out.println("프로그램을 종료합니다.");
                    return;
            }
        }


    }
}
