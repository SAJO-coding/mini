package com.sajo.mini.member.controller;

import com.sajo.mini.model.dto.ProductDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductController {
    ArrayList<ProductDTO> healerproduct = new ArrayList<>();
    ArrayList<ProductDTO> tankerproduct = new ArrayList<>();
    ArrayList<ProductDTO> dealerlist = new ArrayList<>();


    {
        ProductDTO productDTO = new ProductDTO("제품명","이름",3,4,"기능");
        healerproduct.add(productDTO);
        tankerproduct.add(productDTO);
        dealerlist.add(productDTO);
    }
    Scanner sc = new Scanner(System.in);

    public List<ProductDTO> butProduct(int answer){
        ArrayList<ProductDTO> wantBuy = new ArrayList<>();
        //선택한 번호의 템을 출력한다.
        int want;
        switch (answer){
            case 1:
                System.out.println(healerproduct);
                System.out.print("구매를 원하는 아이템의 번호를 입력해주세요 : ");
                want =sc.nextInt();
                wantBuy.add(healerproduct.get(want));
                break;
            case 2 :
                System.out.println(tankerproduct);
                System.out.print("구매를 원하는 아이템의 번호를 입력해주세요 : ");
                want =sc.nextInt();
                wantBuy.add(tankerproduct.get(want));
                break;
            case 3 :
                System.out.println(dealerlist);
                System.out.print("구매를 원하는 아이템의 번호를 입력해주세요 : ");
                want =sc.nextInt();
                wantBuy.add(dealerlist.get(want));
                break;
            default:
                System.out.println("존재하는 번호가 아닙니다.");
                System.out.println("다시 입력해주세요");
        }


        return wantBuy;
    }





}
