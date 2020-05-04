/**
 * The SchoolRoomBooking program implements an application that
 * enables the local clubs/society to Book the school rooms/halls for activities nad other purposes.
 *
 * @author  Shamanth Komala Lakshminarayana
 * @UniNumber U2051870
 * @since   2020-15-04
 */

package schoolroombooking;


import schoolroombooking.manager.ManagerLogin;
import schoolroombooking.clerk.ClerkLogin;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SchoolRoomMgmt extends JFrame {
    static SchoolRoomMgmt frame;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame= new SchoolRoomMgmt();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println("Application is Ready!!!!");
    }

    /**
     * Create the frame.
     */
    public SchoolRoomMgmt() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblSchoolRoomMgmtManagement = new JLabel("School Room Booking Management ");
        lblSchoolRoomMgmtManagement.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblSchoolRoomMgmtManagement.setForeground(Color.GRAY);

        JButton btnAdminLogin = new JButton("Manager Login");
        btnAdminLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ManagerLogin.main(new String[]{});
                frame.dispose();
            }
        });
        btnAdminLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));

        JButton btnLibrarianLogin = new JButton("Clerk Login");
        btnLibrarianLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                ClerkLogin.main(new String[]{});
                frame.dispose();
            }
        });
        btnLibrarianLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(64)
                                                .addComponent(lblSchoolRoomMgmtManagement))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(140)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
                                                        .addComponent(btnLibrarianLogin, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btnAdminLogin, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))))
                                .addContainerGap(95, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblSchoolRoomMgmtManagement)
                                .addGap(32)
                                .addComponent(btnAdminLogin, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(btnLibrarianLogin, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(70, Short.MAX_VALUE))
        );
        contentPane.setLayout(gl_contentPane);
    }
}
