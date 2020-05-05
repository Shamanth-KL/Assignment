package schoolroombooking.common;

public interface Constant {
    String USER_NAME = "manager";
    String PASSWORD = "manager";

    String CLERK_INSERT = "insert into clerk(name, password, email, address, city, contact) values(?,?,?,?,?,?)";
    String CLERK_DELETE = "delete from clerk where id=?";
    String CLERK_LOGIN_SELECT = "select * from clerk where name=? and password=?";

    String ROOMS_INSERT = "insert into rooms(roomid, name, capacity, room_type, available) values(?,?,?,?,?)";
    String ROOMS_SELECT_ACTIVE = "select roomid from rooms where available=?";
    String BOOK_ROOMS_INSERT = "insert into bookroom(roomid, bookedby, guestid, guestaddress, guestcontact, bookedfor, bookedfrom, bookedto, reason) values(?,?,?,?,?,?,?,?,?)";
    String BOOK_ROOMS_DELETE = "delete from bookroom where bookroom_id=?";
}
