package nl.iprwc.persistence;
import nl.iprwc.model.Item;
import nl.iprwc.util.DatabaseConnection;

import java.sql.*;
import java.time.LocalDate;

public class ItemDao {

    Item item1 = new Item("Thinkpad T480", "Deze laptop is klein genoeg", 90);

    private DatabaseConnection database;


    public ItemDao(DatabaseConnection database){
        this.database = database;
    }

    public Item getItemFromId(int id) {
        Item item = null;
        String SQL = "SELECT*FROM item WHERE id = ?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = this.database.newConnection().prepareStatement(SQL);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            while(rs.next()){
                    item = new Item(
                        rs.getString(DatabaseInfo.itemColumnNames.name),
                        rs.getString(DatabaseInfo.itemColumnNames.description),
                        rs.getInt(DatabaseInfo.itemColumnNames.price)
                        );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        database.disconnect();
        return item;

    }
}

