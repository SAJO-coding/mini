package com.sajo.mini.member.controller;

import com.sajo.mini.model.dto.ItemDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductController { // 연산기능

    //아이템 객체 배열
    ItemDTO item1 = new ItemDTO("갑옷1", "딜러", 2000, 5, "방어력 +10");
    ItemDTO item2 = new ItemDTO("신발1", "딜러", 3000, 8, "속도 +10");
    ItemDTO item3 = new ItemDTO("바지1", "딜러", 5000, 4, "힐 +10");
    ArrayList<ItemDTO> healerItemDTO = new ArrayList<>();
    ArrayList<ItemDTO> tankerItemDTO = new ArrayList<>();
    ArrayList<ItemDTO> dealerItemDTO = new ArrayList<>();
    Scanner sc = new Scanner(System.in);


    //아이템 객체
    ItemDTO ditem1 = new ItemDTO("갑옷1", "딜러", 2000, 5, "방어력 +10");
    ItemDTO ditem2 = new ItemDTO("신발1", "딜러", 3000, 8, "속도 +10");
    ItemDTO ditem3 = new ItemDTO("바지1", "딜러", 5000, 4, "힐 +10");
    ItemDTO hitem1 = new ItemDTO("갑옷1", "힐러", 2000, 5, "방어력 +10");
    ItemDTO hitem2 = new ItemDTO("신발1", "힐러", 3000, 8, "속도 +10");
    ItemDTO hitem3 = new ItemDTO("바지1", "힐러", 5000, 4, "힐 +10");
    ItemDTO titem1 = new ItemDTO("갑옷1", "탱커", 1000, 7, "방어력 +10");
    ItemDTO titem2 = new ItemDTO("신발1", "탱커", 3000, 8, "속도 +10");
    ItemDTO titem3 = new ItemDTO("바지1", "탱커", 5000, 4, "힐 +10");



    public ArrayList<ItemDTO> butProduct(int answer){

        dealerItemDTO.add(ditem1);
        dealerItemDTO.add(ditem2);
        dealerItemDTO.add(ditem3);


    public ItemDTO buyProduct(int answer){
        dealerItemDTO.add(item1);
        dealerItemDTO.add(item2);
        dealerItemDTO.add(item3);

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
            default:
                System.out.println("존재하는 번호가 아닙니다.");
                System.out.println("다시 입력해주세요");
        }


        return wantBuy;
    }





}
