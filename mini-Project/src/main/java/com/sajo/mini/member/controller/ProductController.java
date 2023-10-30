package com.sajo.mini.member.controller;

import com.sajo.mini.model.dto.ItemDTO;

import javax.management.Query;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.*;

import static com.sajo.mini.common.JDBCTemplate.close;
import static com.sajo.mini.common.JDBCTemplate.getConnection;

public class ProductController { // 연산기능
    Connection con = getConnection();
    PreparedStatement pstmt1 = null;
    PreparedStatement pstmt2 = null;
    PreparedStatement pstmt3 = null;
    ResultSet rset1 = null;
    Properties prop = new Properties();
    List<Map> itemList = null;


    //아이템 객체 배열
    ItemDTO item1 = new ItemDTO("갑옷1", "딜러", 2000, 5, "방어력 +10");
    ItemDTO item2 = new ItemDTO("신발1", "딜러", 3000, 8, "속도 +10");
    ItemDTO item3 = new ItemDTO("바지1", "딜러", 5000, 4, "힐 +10");
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

    private void productRegistration() {


        int result = 0;

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/sajo/mini/mapper/order-query.xml"));

            String query1 = prop.getProperty("insertItem");
            while (true) {
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

                int jobNumber = 0;
                switch (job){
                    case "힐러" : jobNumber = 1; break;
                    case "탱커" : jobNumber = 2; break;
                    case "딜러" : jobNumber = 3; break;
                }


                pstmt1 = con.prepareStatement(query1);
                pstmt1.setString(1, productName);
                pstmt1.setInt(2, jobNumber);
                pstmt1.setInt(3, price);
                pstmt1.setInt(4, levelRestriction);
                pstmt1.setString(5, demonstration);


                result = pstmt1.executeUpdate();

                if (ch == 'N') {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(pstmt1);
            close(con);
        }


    }


    private void productList() {


        System.out.println("");
        System.out.print("*•.¸✨¸.•*” 등록된 아이템 *•.¸✨¸.•*”");
        Connection con = getConnection();
        PreparedStatement pstmt4 = null;
        ResultSet rset4 = null;
        ItemDTO itemDTO = null;
        List<ItemDTO> itemList = null;

        Properties prop = new Properties();
        try {
            try {
                prop.loadFromXML(new FileInputStream("src/main/java/com/sajo/mini/mapper/order-query.xml"));

            String query4 = prop.getProperty("selectAllCategory");
            pstmt4 = con.prepareStatement(query4);

            rset4 = pstmt4.executeQuery();
            itemList = new ArrayList<>();


            while (rset4.next()){
                itemDTO = new ItemDTO();

                itemDTO.setItemName(rset4.getString("Item_Name"));
                itemDTO.setItemJob(rset4.getString("JobCode"));
                itemDTO.setItemPrice(rset4.getInt("Item_Price"));
                itemDTO.setItemLevel(rset4.getInt("Item_Level"));
                itemDTO.setEffect(rset4.getString("Item_Effect"));

                itemList.add(itemDTO);




            }} catch (IOException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset4);
            close(pstmt4);
            close(con);
        }
        for(ItemDTO itemdto : itemList){
            System.out.println(itemdto);
        }

//        for(int i = 0 ; i < healerItemDTO.size(); i++){
//            System.out.print(healerItemDTO.get(i) + " ");
//
//        }
//
//        for(int i = 0 ; i < tankerItemDTO.size(); i++){
//            System.out.print(tankerItemDTO.get(i) + " ");
//
//        }
//
//        for(int i = 0 ; i < dealerItemDTO.size(); i++){
//            System.out.print(dealerItemDTO.get(i) + " ");
//
//        }



    }

    private void productDelete() {
        System.out.println("*•.¸✨¸.•*” 아이템 삭제 *•.¸✨¸.•*”");

        Connection con = getConnection();
        PreparedStatement pstmt3 = null;
        int result = 0;

        Properties prop = new Properties();
        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/sajo/mini/mapper/order-query.xml"));
            String query3 = prop.getProperty("deleteItem");
            System.out.println("삭제할 아이템 명을 입력하세요 : ");
            String Item_Name = sc.nextLine();

            pstmt3 = con.prepareStatement(query3);
            pstmt3.setString(1, Item_Name);

            result = pstmt3.executeUpdate();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(pstmt3);
            close(con);
        }


//            for (ItemDTO healer : healerItemDTO) {
//                if (healer.getItemName().contains(ProductName)) {
//                    healerItemDTO.remove(healer);
//                    break;
//                }
//            }
//
//            for (ItemDTO tanker : tankerItemDTO) {
//                if (tanker.getItemName().contains(ProductName)) {
//                    tankerItemDTO.remove(tanker);
//                    break;
//                }
//            }
//
//            for (ItemDTO dealer : dealerItemDTO) {
//                if (dealer.getItemName().contains(ProductName)) {
//                    dealerItemDTO.remove(dealer);
//                    break;
//                }
//            }

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
