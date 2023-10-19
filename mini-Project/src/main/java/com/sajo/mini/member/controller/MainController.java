package com.sajo.mini.member.controller;

import com.sajo.mini.model.dto.Item;

import java.util.Scanner;

public class MainController {

    public static void main(String[] args) {

        MemberController mc = new MemberController();
        MemberManagerController mmc = new MemberManagerController();

        ProductController pc = new ProductController();

        //아이템 객체 배열
        Item item1 = new Item("갑옷1", "딜러", 2000, 5, "방어력 +10");
        Item item2 = new Item("신발1", "딜러", 3000, 8, "속도 +10");
        Item item3 = new Item("바지1", "딜러", 5000, 4, "힐 +10");

        mc.selectNumber();
//        mmc.itemCart(item3);

    }


}
