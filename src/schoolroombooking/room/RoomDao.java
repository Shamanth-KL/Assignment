package schoolroombooking.room;

import schoolroombooking.common.Constant;
import schoolroombooking.common.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RoomDao {
    public static int save(String roomid, String name, long capacity, String roomType, boolean available) {
        int status = 0;
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement(Constant.ROOMS_INSERT);
            ps.setString(1, roomid);
            ps.setString(2, name);
            ps.setLong(3, capacity);
            ps.setString(4, roomType);
            ps.setBoolean(5, available);
            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
}
