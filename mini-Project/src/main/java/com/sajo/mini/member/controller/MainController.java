package com.sajo.mini.member.controller;


public class MainController {

    public static void main(String[] args) {

        MemberController mc = new MemberController();
        MemberManagerController mmc = new MemberManagerController();
        ProductController pc = new ProductController();



        // 회원정보 입력 및 아이템
        mc.infoUser();
        mc.selectNumber();
//        mmc.itemCart(item3);


    }

}
