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


        mc.selectNumber();
//        mmc.itemCart(item3);

    }
}
