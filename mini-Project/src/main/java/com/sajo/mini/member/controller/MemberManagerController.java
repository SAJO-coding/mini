package com.sajo.mini.member.controller;

import com.sajo.mini.model.dto.ItemDTO;
import com.sajo.mini.model.dto.MemberDTO;

public class MemberManagerController {// 장바구니

//    //아이템 객체 배열
//    Item item1 = new Item("갑옷1", "딜러", 2000, 5, "방어력 +10");
//    Item item2 = new Item("신발1", "딜러", 3000, 8, "속도 +10");
//    Item item3 = new Item("바지1", "딜러", 5000, 4, "힐 +10");

    // 딜러 아이템 객체 배열
//    Item[] items = new Item[] {item1, item2, item3};

    // 임시 사용자 정보
//    MemberDTO member1 = new MemberDTO("yunha", "딜러", 5, 10000);




    // 장바구니
    int itemCount = 0;
    ItemDTO[] cart = new ItemDTO[10];

    MemberDTO mb = new MemberDTO();
    ItemDTO it = new ItemDTO();


    // 장바구니 내용 출력
    public void cartPrint(){
        System.out.println("=========== 장바구니 ===========");
        for(ItemDTO c : cart){
            if(c != null){
                System.out.println(c);
            }
        }

    }
    public int goldCaculator(int level,String job) { //healer, dealer, tanker
        int healer = 1;
        int dealer = 2;
        int tanker = 3;

//        String job = memberDTO.getUserJob();
//        int level = memberDTO.getUserLevel();
        // 동락님 연결해주세여

        int jobValue = 1;
        if (job.equals("heller") || job.equals("힐러")) {
            jobValue = healer;
        } else if (job.equals("dealer") || job.equals("딜러")) {
            jobValue = dealer;
        } else if (job.equals("tanker") || job.equals("탱커")) {
            jobValue = tanker;
        } else {

        }
        int ability;
        ability = level * jobValue;
        System.out.println("보유골드 : " + ability);

        //골드 비교 - 동락님
        return ability;
    }
    public boolean goldCompare(){
        for (int i = 0; i < cart.length; i++){
            if(cart[i] != null){
                if(mb.getUserGold() > cart[i].getItemPrice()){
                    return true;
                }
            }
        }
        return false;
    }


    public boolean levelCompare(){
        // 레벨 비교 - 성민님
//        itemCount++;
        return mb.getUserLevel() >= it.getItemLevel();
    }


//    public boolean levelCompare(/*int classLevel, int productLevel*/){
//        // 레벨 비교 - 성민님
//        for (int i = 0; i < cart.length; i++) {
//
//            if (cart[i] != null){
//
//                if (mb.getUserLevel() > cart[i].getItemLevel()){
//
//                    return true;
//                }
//            }
//        }
//        return false;
//    }



    public void itemCart(ItemDTO itemDTO){

        // 골드 비교와 레벨 비교 둘다 통과하면 장바구니에 넣기


        //리턴 값이 0(프로그램 종료면)이면 return


        System.out.println("장바구니에 담겼습니다.");

        cart[itemCount] = itemDTO;

        cartPrint();

        itemCount++;



    }



}
