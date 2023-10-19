package com.sajo.mini.member.controller;

import com.sajo.mini.model.dto.ProductDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductController {
    ArrayList<ProductDTO> healerproduct = new ArrayList<>();
    ArrayList<ProductDTO> tankerproduct = new ArrayList<>();
    ArrayList<ProductDTO> dealerproduct = new ArrayList<>();



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

    private void productRegistration() {
        while (true) {
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
            sc.nextLine();
            System.out.println("아이템 설명을 입력해주세요 : ");
            String demonstration = sc.nextLine();
            System.out.println("계속 입력하겠습니까? (y/n) : ");
            char ch = sc.nextLine().toUpperCase().charAt(0);


            if (job.equals("힐러")) {
                healerproduct.add(new ProductDTO(productName, job, levelRestriction, price, demonstration));
                System.out.println(healerproduct);
            } else if (job.equals("탱커")) {
                tankerproduct.add(new ProductDTO(productName, job, levelRestriction, price, demonstration));
                System.out.println(tankerproduct);
            } else if (job.equals("딜러")) {
                dealerproduct.add(new ProductDTO(productName, job, levelRestriction, price, demonstration));
                System.out.println(dealerproduct);
            }

            if (ch == 'N') {
                break;
            }
        }
    }


    private void productList() {
        System.out.println("------------ 등록된 아이템 ------------");
            System.out.println(healerproduct);
            System.out.println(tankerproduct);
            System.out.println(dealerproduct);

    }

    private void productDelete() {
            System.out.println("===== 아이템 삭제 =====");
            System.out.println("삭제할 아이템명 입력 : ");
            String ProductName = sc.nextLine();
            productList();

                for (ProductDTO healer : healerproduct) {
                    if (healer.getProductName().contains(ProductName)) {
                        healerproduct.remove(healer);
                        break;
                    }
                }

                for (ProductDTO tanker : tankerproduct) {
                    if (tanker.getProductName().contains(ProductName)) {
                        tankerproduct.remove(tanker);
                        break;
                    }
                }

                for (ProductDTO dealer : dealerproduct) {
                    if (dealer.getProductName().contains(ProductName)) {
                        dealerproduct.remove(dealer);
                        break;
                    }
                }

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
                System.out.println(dealerproduct);
                System.out.print("구매를 원하는 아이템의 번호를 입력해주세요 : ");
                want =sc.nextInt();
                wantBuy.add(dealerproduct.get(want));
                break;
            default:
                System.out.println("존재하는 번호가 아닙니다.");
                System.out.println("다시 입력해주세요");
        }


        return wantBuy;
    }





}
