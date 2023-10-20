package com.sajo.mini.member.controller;

import com.sajo.mini.model.dto.ItemDTO;

import java.util.ArrayList;

import java.util.Scanner;

public class ProductController { // 연산기능

    //아이템 객체 배열
//    ItemDTO item1 = new ItemDTO("갑옷1", "딜러", 2000, 5, "방어력 +10");
//    ItemDTO item2 = new ItemDTO("신발1", "딜러", 3000, 8, "속도 +10");
//    ItemDTO item3 = new ItemDTO("바지1", "딜러", 5000, 4, "힐 +10");
    ArrayList<ItemDTO> healerItemDTO = new ArrayList<>();
    ArrayList<ItemDTO> tankerItemDTO = new ArrayList<>();
    ArrayList<ItemDTO> dealerItemDTO = new ArrayList<>();

    {
        healerItemDTO.add(new ItemDTO("갑옷1", "힐러", 2000, 5, "방어력 +10"));
        tankerItemDTO.add(new ItemDTO("신발1", "탱커", 3000, 8, "속도 +10"));
        dealerItemDTO.add(new ItemDTO("바지1", "딜러", 5000, 4, "힐 +10"));
    }


    Scanner sc = new Scanner(System.in);
    public void selectNumber(){
        while(true) {
            System.out.println("=========== 메뉴 선택 ===========");
            System.out.println("1. 아이템 등록");
            System.out.println("2. 아이템 조회");
            System.out.println("3. 아이템 삭제");
            System.out.println("4. 종료");
            System.out.print("번호를 입력해주세요 : ");
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
            System.out.println("=========== 아이템 등록 ===========");
            System.out.print("아이템 명을 입력해주세요 : ");
            String productName = sc.nextLine();
            System.out.println("힐러 / 탱커 / 딜러");
            System.out.print("등록하시려는 아이템의 직업분류를 입력해주세요 : ");
            String job = sc.nextLine();
            System.out.print("아이템의 레벨을 입력해주세요 : ");
            int levelRestriction = sc.nextInt();
            System.out.print("아이템의 가격을 입력해주세요 : ");
            int price = sc.nextInt();
            sc.nextLine();
            System.out.print("아이템 이펙트를 입력해주세요 : ");
            String demonstration = sc.nextLine();
            System.out.print("계속 입력하겠습니까? (y/n) : ");
            char ch = sc.nextLine().toUpperCase().charAt(0);


            if (job.equals("힐러")) {
                healerItemDTO.add(new ItemDTO(productName, job, levelRestriction, price, demonstration));
                System.out.println(healerItemDTO);
            } else if (job.equals("탱커")) {
                tankerItemDTO.add(new ItemDTO(productName, job, levelRestriction, price, demonstration));
                System.out.println(tankerItemDTO);
            } else if (job.equals("딜러")) {
                dealerItemDTO.add(new ItemDTO(productName, job, levelRestriction, price, demonstration));
                System.out.println(dealerItemDTO);
            }

            if (ch == 'N') {
                break;
            }
        }
    }


    private void productList() {
        System.out.println("=========== 등록된 아이템 ===========");
        for(int i = 0 ; i < healerItemDTO.size(); i++){
            System.out.println(healerItemDTO.get(i) + " ");

        }

        for(int i = 0 ; i < tankerItemDTO.size(); i++){
            System.out.println(tankerItemDTO.get(i) + " ");

        }

        for(int i = 0 ; i < dealerItemDTO.size(); i++){
            System.out.println(dealerItemDTO.get(i) + " ");

        }
    }

    private void productDelete() {
        productList();
        System.out.println("=========== 아이템 삭제 ===========");
            System.out.print("삭제할 아이템명 입력 : ");
            String ProductName = sc.nextLine();

            for (ItemDTO healer : healerItemDTO) {
                if (healer.getItemName().contains(ProductName)) {
                    healerItemDTO.remove(healer);
                    break;
                }
            }

            for (ItemDTO tanker : tankerItemDTO) {
                if (tanker.getItemName().contains(ProductName)) {
                    tankerItemDTO.remove(tanker);
                    break;
                }
            }

            for (ItemDTO dealer : dealerItemDTO) {
                if (dealer.getItemName().contains(ProductName)) {
                    dealerItemDTO.remove(dealer);
                    break;
                }
            }

        }


    public ItemDTO buyProduct(int answer){
//        dealerItemDTO.add(item1);
//        dealerItemDTO.add(item2);
//        dealerItemDTO.add(item3);

        ItemDTO wantBuy = new ItemDTO();
        //선택한 번호의 템을 출력한다.
        int want;
        switch (answer){
            case 1:

                for(int i = 0; i < healerItemDTO.size(); i++){
                    System.out.println((i+1) + "번 " + healerItemDTO.get(i));
                }
                System.out.print("구매를 원하는 아이템의 번호를 입력해주세요 : ");
                want =sc.nextInt();
                wantBuy=healerItemDTO.get(want-1);
                break;
            case 2 :
                for(int i = 0; i < tankerItemDTO.size(); i++){
                    System.out.println((i+1) + "번 " + tankerItemDTO.get(i));
                }
                System.out.print("구매를 원하는 아이템의 번호를 입력해주세요 : ");
                want =sc.nextInt();
                wantBuy=tankerItemDTO.get(want-1);
                break;
            case 3 :
                for(int i = 0; i < dealerItemDTO.size(); i++){
                    System.out.println((i+1) + "번 " + dealerItemDTO.get(i));
                }
                System.out.print("구매를 원하는 아이템의 번호를 입력해주세요 : ");
                want =sc.nextInt();
                wantBuy=dealerItemDTO.get(want - 1);
                break;
            case 9 :
                System.out.println("물건 구매를 종료합니다.");
                return wantBuy;
            default:
                System.out.println("존재하는 번호가 아닙니다.");
                System.out.println("다시 입력해주세요");
        }


        return wantBuy;
    }






}
