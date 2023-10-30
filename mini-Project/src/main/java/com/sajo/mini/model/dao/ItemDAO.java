package com.sajo.mini.model.dao;

import com.sajo.mini.model.dto.ItemDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ItemDAO {

    private Properties prop = new Properties();
    public ItemDAO(){
        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/sajo/mini/mapper/order-query.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<ItemDTO> selectAllItem(Connection con) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        List<ItemDTO> itemDTOList = null;
        String query = prop.getProperty("selectAllCategory");

        try {
            pstmt = con.prepareStatement(query);
            rset = pstmt.executeQuery();
            itemDTOList = new ArrayList<>();

            while (rset.next()){
                ItemDTO item = new ItemDTO();
                item.setItemName(rset.getString("아이템명"));
                item.setItemJob(rset.getString("직업"));
                item.setItemLevel(rset.getInt("레벨"));
                item.setItemPrice(rset.getInt("가격"));
                item.setEffect(rset.getString("효과"));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return itemDTOList;
    }
}
