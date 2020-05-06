package schoolroombooking.clerk;

import schoolroombooking.common.Constant;
import schoolroombooking.common.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ClerkDao {


    public static int save(String name, String password, String email, String address, String city, String contact) {
        int status = 0;
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement(Constant.CLERK_INSERT);
            ps.setString(1, name);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.setString(4, address);
            ps.setString(5, city);
            ps.setString(6, contact);
            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
}