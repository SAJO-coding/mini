package com.sajo.mini.run;

import com.sajo.mini.member.controller.MemberController;

public class Application {
    public static void main(String[] args) {

        MemberController mc = new MemberController();
        mc.selectNumber();
        System.out.println("메인 받기 연습입니다.");

    }
}
