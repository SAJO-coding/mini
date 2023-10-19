package com.sajo.mini.member.controller;

import com.sajo.mini.model.dto.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductController {
    ArrayList<Item> healerItem = new ArrayList<>();
    ArrayList<Item> tankerItem = new ArrayList<>();
    ArrayList<Item> dealerItem = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public List<Item> butProduct(int answer){
        ArrayList<Item> wantBuy = new ArrayList<>();
        //선택한 번호의 템을 출력한다.
        int want;
        switch (answer){
            case 1:
                System.out.println(healerItem);
                System.out.print("구매를 원하는 아이템의 번호를 입력해주세요 : ");
                want =sc.nextInt();
                wantBuy.add(healerItem.get(want));
                break;
            case 2 :
                System.out.println(tankerItem);
                System.out.print("구매를 원하는 아이템의 번호를 입력해주세요 : ");
                want =sc.nextInt();
                wantBuy.add(tankerItem.get(want));
                break;
            case 3 :
                System.out.println(dealerItem);
                System.out.print("구매를 원하는 아이템의 번호를 입력해주세요 : ");
                want =sc.nextInt();
                wantBuy.add(dealerItem.get(want));
                break;
            default:
                System.out.println("존재하는 번호가 아닙니다.");
                System.out.println("다시 입력해주세요");
        }


        return wantBuy;
    }





}
