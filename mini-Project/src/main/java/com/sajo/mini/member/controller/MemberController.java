package com.sajo.mini.member.controller;

import com.sajo.mini.model.dto.MemberDTO;

import java.util.Scanner;

public class MemberController {
    /* 시작 정보입력
     *  사용자 서비스 */
    Scanner sc = new Scanner(System.in);
    static MemberDTO user; // user 변수명 수정
    MemberManagerController mmc = new MemberManagerController();
    ProductController pc = new ProductController();



        // 사용자 정보를 입력받는 메소드
    public void infoUser() {

        System.out.print("닉네임을 입력해주세요 : ");
        String name = sc.nextLine();
        System.out.print("레벨을 입력해주세요 : ");
        int level = sc.nextInt();
//        sc.nextLine();
        System.out.print("직업을 입력해주세요 (힐러,탱커,딜러 중 선택): ");
        String job = sc.next();

        user = new MemberDTO(name, job, level, mmc.goldCaculator(level, job));
        selectNumber();
    }



    // 상점 메뉴를 선택하는 메소드
    public void selectNumber(){

        while (true) {
            System.out.println();
            System.out.println("*•.¸✨¸.•*” 선택지 *•.¸✨¸.•*”");
            System.out.println("1. 물건 보기");
            System.out.println("2. 장바구니 확인");
            System.out.println("3. 구매하기");
            System.out.println("9. 메인 페이지로");
            System.out.print("번호를 입력해주세요 : ");

            int answer = sc.nextInt();
            switch (answer) {
                case 1:
                    productCategory();
                    break;
                case 2:
                    mmc.cartPrint();
                    break;
                case 3:
                    mmc.itemBuy();
                    break;
                case 9:
                    return;
                default:
                    System.out.println("존재하는 번호가 아닙니다.");
                    System.out.println("다시 입력해주세요");
                    break;

            }
        }

    }

    public void productCategory(){


            System.out.println("1. 힐러");
            System.out.println("2. 탱커");
            System.out.println("3. 딜러");
            System.out.println("9. 물건 구매 종료");
            System.out.print("원하시는 아이템 카테고리의 번호를 입력해주세요 : ");
            int answer = sc.nextInt();

                mmc.itemCart(pc.buyProduct(answer));



    }



}
