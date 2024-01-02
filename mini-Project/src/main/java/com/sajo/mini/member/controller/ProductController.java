package com.sajo.mini.member.controller;

import com.sajo.mini.model.dto.ItemDTO;
import com.sajo.mini.service.ProductService;

import javax.management.Query;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.*;

import static com.sajo.mini.common.JDBCTemplate.close;
import static com.sajo.mini.common.JDBCTemplate.getConnection;

public class ProductController { // 연산기능
    private ProductService productService = new ProductService();
    Connection con = getConnection();
    PreparedStatement pstmt1 = null;
    PreparedStatement pstmt2 = null;
    PreparedStatement pstmt3 = null;
    ResultSet rset1 = null;
    Properties prop = new Properties();
    List<Map> itemList = null;
    static ArrayList<ItemDTO> healerItemDTO = new ArrayList<>();
    static ArrayList<ItemDTO> tankerItemDTO = new ArrayList<>();
    static ArrayList<ItemDTO> dealerItemDTO = new ArrayList<>();

    static {
        healerItemDTO.add(new ItemDTO("갑옷1", "힐러", 20, 5, "방어력 +10"));
        tankerItemDTO.add(new ItemDTO("신발1", "탱커", 30, 8, "속도 +10"));
        dealerItemDTO.add(new ItemDTO("바지1", "딜러", 5, 4, "힐 +10"));
    }

    String Art = "\uD83D\uDC95\uD83C\uDF3C˚*•.¸✨¸.•*”\uD83D\uDC95\uD83C\uDF3C˚*•.¸✨¸.•*”\uD83D\uDC95\uD83C\uDF3C˚*•.¸✨¸.•*”";

    Scanner sc = new Scanner(System.in);
    public void selectNumber(){
        List<ItemDTO> itemDTOList = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("");
            System.out.println("");
            System.out.println("*•.¸✨¸.•*” 메뉴 선택 *•.¸✨¸.•*”");
            System.out.println("1. 아이템 등록");
            System.out.println("2. 아이템 조회");
            System.out.println("3. 아이템 삭제");
            System.out.println("4. 메인페이지로");
            System.out.print("번호를 입력해주세요 : ");
            int num1 = sc.nextInt();
            sc.nextLine();
            switch (num1){
                case 1:
                    productRegistration();
                    break;
                case 2:
                    productList();
                    break;
                case 3:
                    productDelete();
                    break;
                case 4: return;

            }
        }
    }

    public void productRegistration() {

        int result = 0;
        Scanner sc = new Scanner(System.in);
        ItemDTO itemDTO = new ItemDTO();

        do {
            System.out.println("");
            System.out.println("*•.¸✨¸.•*” 아이템 등록 *•.¸✨¸.•*”");
            System.out.print("아이템 명을 입력해주세요 : ");
            String productName = sc.nextLine();
            System.out.println("힐러 / 탱커 / 딜러");
            System.out.print("등록하시려는 아이템의 직업분류를 입력해주세요 : ");
            String job = sc.nextLine();
            System.out.print("아이템의 가격을 입력해주세요 : ");
            int price = sc.nextInt();
            System.out.print("아이템의 레벨을 입력해주세요 : ");
            int levelRestriction = sc.nextInt();
            sc.nextLine();
            System.out.print("아이템 이펙트를 입력해주세요 : ");
            String demonstration = sc.nextLine();
            System.out.print("계속 입력하겠습니까? (y/n) : ");
            char ch = sc.nextLine().toUpperCase().charAt(0);


            itemDTO.setItemName(productName);
            itemDTO.setItemJob(job);
            itemDTO.setItemPrice(price);
            itemDTO.setItemLevel(levelRestriction);
            itemDTO.setEffect(demonstration);


            if (ch == 'N') {
                break;
            }

        }while (true);

        productService.productRegistration(itemDTO);
        System.out.println("itemDTO = " + itemDTO);


    }


    public void productList() {


        System.out.println("");
        System.out.print("*•.¸✨¸.•*” 등록된 아이템 *•.¸✨¸.•*”");
        List<ItemDTO> itemDTOList = productService.selectAllItem();
        System.out.println(itemDTOList);

    }

    public void productDelete() {
        System.out.println("*•.¸✨¸.•*” 아이템 삭제 *•.¸✨¸.•*”");
        List<ItemDTO> itemDTOList = productService.selectAllItem();
        System.out.println(itemDTOList);
            System.out.println("삭제할 아이템 명을 입력하세요 : ");
            String Item_Name = sc.nextLine();

            productService.productDelete(Item_Name);



        }


    public ItemDTO buyProduct(int answer){


        ItemDTO wantBuy = new ItemDTO();
        //선택한 번호의 템을 출력한다.
        int want=0;
        switch (answer){
            case 1:

                if(0!=healerItemDTO.size()) {
                    for (int i = 0; i < healerItemDTO.size(); i++) {
                        System.out.println((i + 1) + "번 " + healerItemDTO.get(i));
                    }
                    System.out.print("구매를 원하는 아이템의 번호를 입력해주세요 (구매를 원하시지 않으면 0번을 눌러주세요): ");
                    want = sc.nextInt();
                    if(want==0){
                        wantBuy=null;
                        break;
                    }
                    wantBuy = healerItemDTO.get(want - 1);
                }
                else{
                    System.out.println("해당 카테고리 상품이 매진입니다.");
                    wantBuy=null;
                }
                break;
            case 2 :
                if(0!=tankerItemDTO.size()) {
                    for (int i = 0; i < tankerItemDTO.size(); i++) {
                        System.out.println((i + 1) + "번 " + tankerItemDTO.get(i));
                    }
                    System.out.print("구매를 원하는 아이템의 번호를 입력해주세요 (구매를 원하시지 않으면 0번을 눌러주세요): ");
                    want = sc.nextInt();
                    if(want==0){
                        wantBuy=null;
                        break;
                    }
                    wantBuy = tankerItemDTO.get(want - 1);
                }
                else{
                    System.out.println("해당 카테고리 상품이 매진입니다.");
                    wantBuy=null;
                }
                break;
            case 3 :
                if(0!=dealerItemDTO.size()) {
                    for (int i = 0; i < dealerItemDTO.size(); i++) {
                        System.out.println((i + 1) + "번 " + dealerItemDTO.get(i));
                    }
                    System.out.print("구매를 원하는 아이템의 번호를 입력해주세요 (구매를 원하시지 않으면 0번을 눌러주세요): ");
                    want = sc.nextInt();
                    if(want==0){
                        wantBuy=null;
                        break;
                    }
                    wantBuy = dealerItemDTO.get(want - 1);
                }
                else{
                    System.out.println("해당 카테고리 상품이 매진입니다.");
                    wantBuy=null;
                }
                break;
            case 9 :
                System.out.println("물건 구매를 종료합니다.");
                return wantBuy=null;
            default:
                System.out.println("존재하는 번호가 아닙니다.");
                System.out.println("다시 입력해주세요");
                wantBuy=null;
                break;
        }


        return wantBuy;
    }





}
