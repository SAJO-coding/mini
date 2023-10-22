package com.sajo.mini.member.controller;

import com.sajo.mini.model.dto.ItemDTO;
import com.sajo.mini.model.dto.MemberDTO;

import java.util.ArrayList;
import java.util.Scanner;


public class MemberManagerController {// 장바구니



    // 입력 받기
    Scanner sc = new Scanner(System.in);



    // 사용자 정보

    // 장바구니 아이템
    private static ArrayList<ItemDTO> cartItem = new ArrayList<>();


    // 장바구니 가격 총합
    int cartSum = 0;


    // 장바구니 내용 출력
    // 장바구니 내용 출력하는 메소드
    public void cartPrint(){

        System.out.println();
        System.out.println("=========== 장바구니 ===========");
        if(cartItem.size() == 0){
            System.out.println("비어있습니다.");
        } else {
            for(int i = 0; i < cartItem.size(); i++){
                System.out.println((i + 1) + " : " + cartItem.get(i));
                cartSum += cartItem.get(i).getItemPrice();
            }
        }

        System.out.println();
        System.out.println("담은 아이템 개수 : " + cartItem.size());
        System.out.println("가격 총합 : " + cartSum + " Gold");

    }



    public void itemBuy(){

        System.out.println();
        //장바구니 출력 후 구매하시겠습니까? 출력
        //구매한다고 하면 돈 차감, 재고에서 삭제
        //구매 안하면 다시 선택지로


//        cartPrint();

        if(MemberController.user.getUserGold() < cartSum){
            System.out.println("돈이 부족하여 구매할 수 없습니다.");
            System.out.println("남은 골드 : " + MemberController.user.getUserGold());
            // 메인 페이지로 selectNumber() 호출하는 방법?


        }else{
            System.out.println("=========== 구매가 완료되었습니다 ===========");

            // 골드 차감
            int currGold = MemberController.user.getUserGold() - cartSum;
            MemberController.user.setUserGold(currGold);
            System.out.println("남은 골드 : " + MemberController.user.getUserGold());

            // 재고에서 아이템 제거


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
        for (int i = 0; i < cartItem.size(); i++){
            if(cartItem.get(i) != null){
                if(MemberController.user.getUserGold() > cartItem.get(i).getItemPrice()){
                    return true;
                }
            }
        }
        return false;
    }


//    public boolean levelCompare(){
//        // 레벨 비교 - 성민님
////        itemCount++;
//        return mb.getUserLevel() >= it.getItemLevel();
//    }


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


        // 장바구니 ArrayList에 아이템 추가
        System.out.println(" [ 장바구니에 담겼습니다.] ");
        cartItem.add(itemDTO);

        // 장바구니 확인
        cartPrint();

        System.out.println();
        System.out.print("아이템을 더 구매하시겠습니까?(y/n) : ");
        char c = sc.next().charAt(0);

        MemberController mc = new MemberController();

        if(c == 'y'){
            System.out.println("yes");
            mc.productCategory();
        }else if( c == 'n'){
            // 구매 메소드
            itemBuy();
        }


    }



}
