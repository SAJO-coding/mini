package com.sajo.mini.model.service;

import com.sajo.mini.member.controller.ProductController;
import com.sajo.mini.model.dto.MemberDTO;

import java.util.Scanner;

public class MemberController {

        Scanner sc = new Scanner(System.in);
        ProductController pc = new ProductController();


    public void selectNumber(){

        System.out.print("닉네임을 입력해주세요 : ");
        String name = sc.nextLine();
        System.out.print("레벨을 입력해주세요 : ");
        int level = sc.nextInt();
        sc.nextLine();
        System.out.print("직업을 입력해주세요 (힐러,탱커,딜러 중 선택): ");
        String job = sc.nextLine();
        int a = 1 ; //직업 특성의 능력치와 연결할 부분

        MemberDTO memberDTO = new MemberDTO(name,level,level*a,job);


        while (true){
            System.out.println("===선택지===");
            System.out.println("1. 물건 보기");
            System.out.println("2. 장바구니 확인");
            System.out.println("3. 구매하기");
            System.out.println("9. 프로그램 종료");
            System.out.print("번호를 입력해주세요 : ");
            int answer = sc.nextInt();
            switch (answer){
                case 1 : productCategory();
                    break;
                case 2 :
                    break;
                case 3 : //buy 호출
                    break;
                case 4 :
                    return;
                default:
                    System.out.println("존재하는 번호가 아닙니다.");
                    System.out.println("다시 입력해주세요");
                    break;

            }
        }

    }

    public void productCategory(){
        while (true){
            System.out.println("1. 힐러");
            System.out.println("2. 탱커");
            System.out.println("3. 딜러");
            System.out.print("원하시는 아이템 카테고리의 번호를 입력해주세요 : ");
            int answer =sc.nextInt();
            pc.butProduct(answer);

        }

    }

}
