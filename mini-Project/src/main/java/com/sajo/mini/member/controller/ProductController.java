package com.sajo.mini.member.controller;

import com.sajo.mini.model.dto.ProductDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductController {
    ArrayList<ProductDTO> healerproduct = new ArrayList<>();
    ArrayList<ProductDTO> tankerproduct = new ArrayList<>();
    ArrayList<ProductDTO> dealerlist = new ArrayList<>();



    Scanner sc = new Scanner(System.in);

    public void selectNumber(){
        while(true) {
            System.out.println("===== 메뉴 선택 =====");
            System.out.println("1. 아이템 등록");
            System.out.println("2. 아이템 조회");
            System.out.println("3. 아이템 삭제");
            System.out.println("4. 종료");
            int num1 = sc.nextInt();
            sc.nextLine();
            switch (num1){
                case 1:
                    productRegistration();
                    break;
                case 2:
                    productList();
                    break;
                case 3:
                    productDelete();
                    break;
                case 4: return;

            }
        }
    }

    private ProductDTO productRegistration() {
        while (true){
            System.out.println("===== 아이템 등록 =====");
            System.out.println("아이템 명을 입력해주세요 : ");
            String productName = sc.nextLine();
            System.out.println("등록하시려는 아이템의 직업????을 입력해주세요 : ");
            System.out.println("힐러 / 탱커 / 딜러");
            String job = sc.nextLine();
            System.out.println("아이템의 레벨을 입력해주세요 : ");
            int levelRestriction = sc.nextInt();
            System.out.println("아이템의 가격을 입력해주세요 : ");
            int price = sc.nextInt();
            System.out.println("아이템 설명을 입력해주세요 : ");
            String demonstration = sc.nextLine();
            ProductDTO product = new ProductDTO(productName, job, levelRestriction, price, demonstration);

            return product;
        }
    }

    private void productList() {
        System.out.println("------------ 등록된 아이템 ------------");
    }

    private void productDelete() {
    }

    public List<ProductDTO> butProduct(int answer){
        ArrayList<ProductDTO> wantBuy = new ArrayList<>();
        //선택한 번호의 템을 출력한다.
        int want;
        switch (answer){
            case 1:
                System.out.println(healerproduct);
                System.out.print("구매를 원하는 아이템의 번호를 입력해주세요 : ");
                want =sc.nextInt();
                wantBuy.add(healerproduct.get(want));
                break;
            case 2 :
                System.out.println(tankerproduct);
                System.out.print("구매를 원하는 아이템의 번호를 입력해주세요 : ");
                want =sc.nextInt();
                wantBuy.add(tankerproduct.get(want));
                break;
            case 3 :
                System.out.println(dealerlist);
                System.out.print("구매를 원하는 아이템의 번호를 입력해주세요 : ");
                want =sc.nextInt();
                wantBuy.add(dealerlist.get(want));
                break;
            default:
                System.out.println("존재하는 번호가 아닙니다.");
                System.out.println("다시 입력해주세요");
        }


        return wantBuy;
    }





}
