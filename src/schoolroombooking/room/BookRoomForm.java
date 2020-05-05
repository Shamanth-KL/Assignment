package schoolroombooking.room;

import com.github.lgooddatepicker.components.DateTimePicker;

import com.github.lgooddatepicker.components.DateTimePicker;
import schoolroombooking.clerk.ClerkSuccess;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class BookRoomForm extends JFrame {
    static BookRoomForm frame;
    private JPanel contentPane;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextArea textArea_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextArea textArea_6;
    private DateTimePicker dateTimePicker1;
    private DateTimePicker dateTimePicker2;
    private JComboBox comboBox;

    /**
     * Create the frame.
     */
    public BookRoomForm() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 80, 638, 714);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblNewLabel = new JLabel("Book Room");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel.setForeground(Color.GRAY);

        JLabel lblRoomNo = new JLabel("Room No:");

        textField_1 = new JTextField();
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setColumns(10);

        textArea_3 = new JTextArea(3, 20);
        textArea_3.setColumns(10);

        textField_4 = new JTextField();
        textField_4.setColumns(10);

        textField_5 = new JTextField();
        textField_5.setColumns(10);

        textArea_6 = new JTextArea(4, 20);
        textArea_6.setColumns(10);

        dateTimePicker1 = new DateTimePicker();
        add(dateTimePicker1);

        dateTimePicker2 = new DateTimePicker();
        add(dateTimePicker2);


        List<String> availableRooms = BookRoomDao.getAvilableRooms();
        if (0 == availableRooms.size()) {
            JOptionPane.showMessageDialog(BookRoomForm.this, "Please add Rooms!");
            ClerkSuccess.main(new String[]{});
            frame.dispose();
        }
        comboBox = new JComboBox(availableRooms.toArray());

        JLabel lblBookedBy = new JLabel("Booked By:");

        JLabel lblBookedByGuestId = new JLabel("Booked Guest Id:");

        JLabel lblBookedGuestAddress = new JLabel("Booked Guest Address:");

        JLabel lblBookedGuestContact = new JLabel("Booked Guest Contact :");

        JLabel lblBookedFor = new JLabel("Booked For:");

        JLabel lblBookedFrom = new JLabel("From:");

        JLabel lblBookedTo = new JLabel("To:");

        JLabel lblBookedReason = new JLabel("Reason:");

        JButton btnBookRoom = new JButton("Book Room");

        btnBookRoom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String roomId = (String) comboBox.getSelectedItem();
                String bookedBy = textField_1.getText();
                String guestId = textField_2.getText();
                String guestAddress = textArea_3.getText();
                String guestContact = textField_4.getText();
                String bookedFor = textField_5.getText();
                LocalDateTime bookedFrom = dateTimePicker1.getDateTimePermissive();
                LocalDateTime bookedTo = dateTimePicker2.getDateTimePermissive();
                String reason = textArea_6.getText();

                int i = BookRoomDao.save(roomId, bookedBy, guestId, guestAddress, guestContact, bookedFor, Timestamp.valueOf(bookedFrom), Timestamp.valueOf(bookedTo), reason);
                if (i > 0) {
                    JOptionPane.showMessageDialog(BookRoomForm.this, "Room Booked successfully!");
                    ClerkSuccess.main(new String[]{});
                    frame.dispose();

                } else {
                    JOptionPane.showMessageDialog(BookRoomForm.this, "Sorry, unable to Book Room!");
                }//end of save if-else
            }
        });

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ClerkSuccess.main(new String[]{});
                frame.dispose();
            }
        });

        JLabel lblNewLabel_1 = new JLabel("Note: Please check Guest ID Carefully before booking Room!");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_1.setForeground(Color.RED);
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap(8, Short.MAX_VALUE)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(lblRoomNo)
                                                        .addComponent(lblBookedBy)
                                                        .addComponent(lblBookedByGuestId)
                                                        .addComponent(lblBookedGuestAddress)
                                                        .addComponent(lblBookedGuestContact)
                                                        .addComponent(lblBookedFor)
                                                        .addComponent(lblBookedFrom)
                                                        .addComponent(lblBookedTo)
                                                        .addComponent(lblBookedReason))
                                                .addGap(8)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(textArea_3, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(dateTimePicker1)
                                                        .addComponent(dateTimePicker2)
                                                        .addComponent(textArea_6, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
                                                .addGap(45))
                                        .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                                                .addGap(15)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                                        .addComponent(lblNewLabel_1)
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(btnBookRoom, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(47)
                                                                .addComponent(btnBack)))
                                                .addGap(100))))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(146)
                                .addComponent(lblNewLabel)
                                .addContainerGap(235, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(34)
                                .addComponent(lblNewLabel)
                                .addGap(40)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblRoomNo)
                                        .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(25)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblBookedBy)
                                        .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(25)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblBookedByGuestId)
                                        .addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(25)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblBookedGuestAddress)
                                        .addComponent(textArea_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(25)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblBookedGuestContact)
                                        .addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(25)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblBookedFor)
                                        .addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(25)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblBookedFrom)
                                        .addComponent(dateTimePicker1))
                                .addGap(25)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblBookedTo)
                                        .addComponent(dateTimePicker2))
                                .addGap(25)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblBookedReason)
                                        .addComponent(textArea_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(btnBookRoom, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnBack))
                                .addGap(18)
                                .addComponent(lblNewLabel_1)
                                .addGap(25))
        );
        contentPane.setLayout(gl_contentPane);
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new BookRoomForm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}