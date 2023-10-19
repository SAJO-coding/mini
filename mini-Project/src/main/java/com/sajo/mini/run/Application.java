package com.sajo.mini.run;

import com.sajo.mini.member.controller.MemberController;
import com.sajo.mini.member.controller.MemberManagerController;
import com.sajo.mini.member.controller.ProductController;
import com.sajo.mini.model.dto.ItemDTO;

public class Application {
    public static void main(String[] args) {

        MemberController mc = new MemberController();
        MemberManagerController mmc = new MemberManagerController();

        ProductController pc = new ProductController();

        //아이템 객체 배열
        ItemDTO itemDTO1 = new ItemDTO("갑옷1", "딜러", 2000, 5, "방어력 +10");
        ItemDTO itemDTO2 = new ItemDTO("신발1", "딜러", 3000, 8, "속도 +10");
        ItemDTO itemDTO3 = new ItemDTO("바지1", "딜러", 5000, 4, "힐 +10");

        mc.selectNumber();
//        mmc.itemCart(item3);

    }
}
