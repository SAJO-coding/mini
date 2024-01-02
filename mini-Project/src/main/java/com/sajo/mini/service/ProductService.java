package com.sajo.mini.service;

import com.sajo.mini.model.dao.ItemDAO;
import com.sajo.mini.model.dto.ItemDTO;

import java.sql.Connection;
import java.util.List;

import static com.sajo.mini.common.JDBCTemplate.*;


public class ProductService {
    private ItemDAO itemDAO = new ItemDAO();
    //카테고리 전체 조회용 메소드
    /* 설명. 카테고리 전체 조회용 메소드 */
    public List<ItemDTO> selectAllItem() {


        /* 순서 1. Connection 생성 */
        Connection con = getConnection();

        /* 순서 2. DAO의 모든 카테고리 조회용 메소드를 호출하여 결과 리턴받기 */
        List<ItemDTO> itemDTOList = itemDAO.selectAllItem(con);


        /* 순서 3. 커넥션 닫기 */
        close(con);

        /* 순서 4. 반환받은 값 리턴하기 */
        return itemDTOList;
    }

    public int productRegistration(ItemDTO itemDTO) {
        Connection con = getConnection();

        int registrationResult = 0;

        registrationResult = itemDAO.productRegistration(con, itemDTO);

        if(registrationResult > 0 ){
            commit(con);
            System.out.println("registrationResult = " + registrationResult);

        }else {
            rollback(con);
        }

        close(con);

        return registrationResult;
    }

    public int productDelete(String itemName) {
        Connection con = getConnection();

        int result = 0;
        result = itemDAO.productDelete(con, itemName);
        if(result > 0 ){
            commit(con);
            System.out.println("result = " + result);

        }else {
            rollback(con);
        }

        close(con);

        return result;
    }
}
