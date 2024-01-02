package com.sajo.mini.model.dao;

import com.sajo.mini.common.JDBCTemplate;
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
        String query = prop.getProperty("selectAllItem");

        try {
            pstmt = con.prepareStatement(query);
            rset = pstmt.executeQuery();
            itemDTOList = new ArrayList<>();

            while (rset.next()){
                ItemDTO item = new ItemDTO();
                item.setItemName(rset.getString("Item_Name"));
                item.setItemJob(rset.getString("JobCode"));
                item.setItemLevel(rset.getInt("Item_Level"));
                item.setItemPrice(rset.getInt("Item_Price"));
                item.setEffect(rset.getString("Item_Effect"));

                itemDTOList.add(item);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
        }
    return itemDTOList;
    }

    public int productRegistration(Connection con, ItemDTO itemDTO) {

        PreparedStatement pstmt = null;

        int result = 0;

        String query = prop.getProperty("insertItem");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, itemDTO.getItemName());
            pstmt.setInt(2, itemDTO.getItemJobNumber());
            pstmt.setInt(3, itemDTO.getItemPrice());
            pstmt.setInt(4, itemDTO.getItemLevel());
            pstmt.setString(5, itemDTO.getEffect());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTemplate.close(pstmt);
        }
        return  result;
    }

    public int productDelete(Connection con, String itemName) {
        PreparedStatement pstmt = null;

        int result = 0;

        String query = prop.getProperty("productDelete");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, itemName);

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTemplate.close(pstmt);
        }
        return result;
    }
}
