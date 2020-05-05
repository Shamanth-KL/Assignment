package schoolroombooking.room;

import schoolroombooking.common.Constant;
import schoolroombooking.common.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class BookRoomDao {

    public static List<String> getAvilableRooms() {
        List<String> roomids = new ArrayList();
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement(Constant.ROOMS_SELECT_ACTIVE);
            ps.setBoolean(1, true);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                roomids.add(rs.getString("roomid"));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return roomids;
    }

    public static int save(String roomid, String bookedby, String guestid, String guestaddress, String guestcontact, String bookedfor,
                           Timestamp bookedfrom, Timestamp bookedto, String reason) {
        int status = 0;
        try {
            Connection con = DB.getConnection();
            // status = updatebook(roomid);//updating quantity and issue
            if (status == 0) {
                PreparedStatement ps = con.prepareStatement(Constant.BOOK_ROOMS_INSERT);
                ps.setString(1, roomid);
                ps.setString(2, bookedby);
                ps.setString(3, guestid);
                ps.setString(4, guestaddress);
                ps.setString(5, guestcontact);
                ps.setString(6, bookedfor);
                ps.setTimestamp(7, bookedfrom);
                ps.setTimestamp(8, bookedto);
                ps.setString(9, reason);
                status = ps.executeUpdate();
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
}