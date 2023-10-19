package com.sajo.mini.member.controller;

import com.sajo.mini.model.dto.ItemDTO;

public class MainController {

    public static void main(String[] args) {

        MemberController mc = new MemberController();
        MemberManagerController mmc = new MemberManagerController();

        ProductController pc = new ProductController();



        // 회원정보 입력 및 아이템
        mc.selectNumber();
//        mmc.itemCart(item3);



    }


}
