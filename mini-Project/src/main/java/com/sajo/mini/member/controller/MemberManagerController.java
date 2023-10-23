package com.sajo.mini.member.controller;

import com.sajo.mini.model.dto.ItemDTO;
import com.sajo.mini.model.dto.MemberDTO;

import java.util.ArrayList;
import java.util.Scanner;

import static com.sajo.mini.member.controller.ProductController.*;


public class MemberManagerController {// 장바구니



    // 입력 받기
    Scanner sc = new Scanner(System.in);



    // 사용자 정보
    // MemberController.user

    // 장바구니 아이템
    private static ArrayList<ItemDTO> cartItem = new ArrayList<>();


    // 장바구니 가격 총합
    static int cartSum = 0;


    // 장바구니 내용 출력
    // 장바구니 내용 출력하는 메소드
    public void cartPrint(){
        cartSum = 0;
        System.out.println();
        System.out.println("*•.¸✨¸.•*” 장바구니 *•.¸✨¸.•*”");
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


        if(MemberController.user.getUserGold() < cartSum){
            System.out.println("돈이 부족하여 구매할 수 없습니다.");
            System.out.println("남은 골드 : " + MemberController.user.getUserGold());
            // selectNumber() 메인으로 호출하는 방법?
            return;

        }else{
            System.out.println("*•.¸✨¸.•*” 구매가 완료되었습니다 *•.¸✨¸.•*”");

            // 골드 차감
            int currGold = MemberController.user.getUserGold() - cartSum;
            MemberController.user.setUserGold(currGold);
            System.out.println("남은 골드 : " + MemberController.user.getUserGold());

            // 재고에서 아이템 제거
            for(ItemDTO item : cartItem){
                if(item.getItemJob().equals("힐러")){
                    healerItemDTO.remove(item);
                }
                if(item.getItemJob().equals("탱커")){
                    tankerItemDTO.remove(item);
                }
                if(item.getItemJob().equals("딜러")){
                    dealerItemDTO.remove(item);
                }
            }
            cartItem.clear();
            cartSum = 0;

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
    public boolean goldCompare(ItemDTO itemDTO){

                if(MemberController.user.getUserGold() >= itemDTO.getItemPrice()){
                    return true;
                }
        return false;
    }



    public boolean levelCompare(ItemDTO itemDTO){
        // 레벨 비교 - 성민님
            if (MemberController.user.getUserLevel() >= itemDTO.getItemLevel()){
                return true;
            }
        return false;
    }



    public void itemCart(ItemDTO itemDTO){

        //리턴 값이 null(해당 카테고리 제품 매진)이면 return
        if(itemDTO!=null) {

            // test
//            System.out.println("levelCompare : " + levelCompare(itemDTO));
//            System.out.println("goldCompare : " + goldCompare(itemDTO));

            // 골드 비교와 레벨 비교 둘다 통과하면 장바구니에 넣기
        if(!goldCompare(itemDTO)){  // if문의 {} 안에 있는 코드를 실행하려면 조건절의결과가 true
            System.out.println("골드가부족해");
        }

        if(!levelCompare(itemDTO)){
            System.out.println("레벨이부족해");
        }

        if(goldCompare(itemDTO) && levelCompare(itemDTO)){
            // 장바구니 ArrayList에 아이템 추가
            System.out.println(" [ 장바구니에 담겼습니다.] ");
            cartItem.add(itemDTO);
        }

            // 장바구니 확인
            cartPrint();

            System.out.println();
            System.out.print("아이템을 더 구매하시겠습니까?(y/n) : ");
            char c = sc.next().charAt(0);

            MemberController mc = new MemberController();

            if (c == 'y') {
                System.out.println("yes");
                mc.productCategory();
            } else if (c == 'n') {
                return;

            }
        }
        else{
            System.out.println("품절 (┬┬﹏┬┬)");
            return;
        }


    }



}
