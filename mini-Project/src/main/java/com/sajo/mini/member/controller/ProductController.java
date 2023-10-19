package com.sajo.mini.member.controller;

import com.sajo.mini.product.Product;

import java.util.Scanner;

public class ProductController {
    Scanner sc = new Scanner(System.in);
    Product product = new Product();
    private void selectNumber() {
        while (true) {
            System.out.println("===== 메뉴 =====");
            System.out.println("1. 아이템 등록");
            System.out.println("2. 아이템 조회");
            System.out.println("3. 아이템 삭제");
            System.out.println("4. 종료");
            int num1 = sc.nextInt();
            sc.nextLine();
            switch (num1){
                case 1: productRegistration(); break;
                case 2: productList(); break;
                case 3: produceDelete(); break;
                case 4: return;
            }
        }
    }

    public void productRegistration(){

    }

    public void productList(){

    }

    public void produceDelete(){

    }
}
