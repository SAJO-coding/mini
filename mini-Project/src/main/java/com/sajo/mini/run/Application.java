package com.sajo.mini.run;

import com.sajo.mini.member.controller.MemberController;
import com.sajo.mini.member.controller.MemberManagerController;
import com.sajo.mini.member.controller.ProductController;
import com.sajo.mini.model.dto.ItemDTO;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        MemberController mc = new MemberController();
        MemberManagerController mmc = new MemberManagerController();

        ProductController pc = new ProductController();

        //아이템 객체 배열
        ItemDTO itemDTO1 = new ItemDTO("갑옷1", "딜러", 2000, 5, "방어력 +10");
        ItemDTO itemDTO2 = new ItemDTO("신발1", "딜러", 3000, 8, "속도 +10");
        ItemDTO itemDTO3 = new ItemDTO("바지1", "딜러", 5000, 4, "힐 +10");

//        mmc.itemCart(item3);

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
