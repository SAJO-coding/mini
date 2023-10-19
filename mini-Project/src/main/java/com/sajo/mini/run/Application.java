package com.sajo.mini.run;

import com.sajo.mini.member.controller.ProductController;
import com.sajo.mini.model.service.MemberController;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        MemberController mc = new MemberController();
        ProductController pc = new ProductController();
        System.out.println("이용할 서비스를 선택해주세요");
        System.out.println("1. 상인관리페이지");
        System.out.println("2. 구매자 페이지");
        int num1 = sc.nextInt();
        switch (num1){
            case 1 :
                pc.selectNumber();
                break;
            case 2 :
                mc.selectNumber();
                break;
        }
    }
}
