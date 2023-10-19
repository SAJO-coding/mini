package com.sajo.mini.member.controller;

import com.sajo.mini.model.dto.ItemDTO;
import com.sajo.mini.model.dto.MemberDTO;

public class MemberManagerController {



    // 딜러 아이템 객체 배열
//    Item[] items = new Item[] {item1, item2, item3};

    // 임시 사용자 정보
    MemberDTO member1 = new MemberDTO("yunha", "딜러", 5, 10000);


    // 장바구니
    int itemCount = 0;
    ItemDTO[] cart = new ItemDTO[10];


    // 장바구니 내용 출력
    public void cartPrint(){
        System.out.println("=========== 장바구니 ===========");
        for(ItemDTO c : cart){
            if(c != null){
                System.out.println(c);
            }
        }
    }



    // 장바구니에 아이템 담기
        //해당 아이템 번호를 받았다고 가정
    public void itemCart(ItemDTO itemDTO){

        if(member1.getUserJob() != itemDTO.getItemJob()){
            System.out.println("직업이 맞지 않아 담을 수 없습니다.");
        }
        if(member1.getUserLevel() < itemDTO.getItemLevel()){
            System.out.println("레벨이 낮아서 담을 수 없습니다.");
        }
        else{
            cart[itemCount] = itemDTO;

            cartPrint();

            itemCount++;

        }

    }



}
