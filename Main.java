import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Scanner;
import java.sql.*;
public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bank", "root", "");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from bank");
            while (rs.next())
            System.out.println(rs.getString("Name")+"  "+rs.getString("DOB")+"  "
                    +rs.getString("Nominee"));



            Bank bank = new Bank();
            IDGENARATOR.currentMonth = Calendar.getInstance();

            JFrame jf = new JFrame();
            JPanel panel = new JPanel();
            JButton B = new JButton("Create Account");
            B.setPreferredSize(new Dimension(200, 50));
            B.setBackground(Color.orange);
            B.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
            panel.setBackground(Color.DARK_GRAY);
            panel.setLayout(new FlowLayout());
            jf.add(panel);
            panel.add(B);       //some sql and gui aplly
            jf.setSize(400, 400);
            jf.setVisible(true);
            jf.setResizable(false);
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            B.addActionListener(new ActionListener() {
                private JTextField tf, answerfield2, tf1, answerfield3, tf2, answerfield4;

                public void actionPerformed(ActionEvent Event) {
                    JFrame secondframe = new JFrame("Create Account");
                    JPanel panel1 = new JPanel();
                    tf = new JTextField("Enter your name");
                    tf.setBackground(Color.orange);
                    tf.setPreferredSize(new Dimension(160, 30));
                    tf.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
                    tf.setEditable(false);

                    answerfield2 = new JTextField(null);
                    answerfield2.setPreferredSize(new Dimension(200, 50));
                    answerfield2.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
                    answerfield2.setEditable(true);

                    tf1 = new JTextField("Enter DOB");
                    tf1.setBackground(Color.orange);
                    tf1.setPreferredSize(new Dimension(160, 30));
                    tf1.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
                    tf1.setEditable(false);

                    answerfield3 = new JTextField(null);
                    answerfield3.setPreferredSize(new Dimension(200, 50));
                    answerfield3.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
                    answerfield3.setEditable(true);

                    tf2 = new JTextField("Enter Nominee");
                    tf2.setBackground(Color.orange);
                    tf2.setPreferredSize(new Dimension(160, 30));
                    tf2.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
                    tf2.setEditable(false);

                    answerfield4 = new JTextField(null);
                    answerfield4.setPreferredSize(new Dimension(200, 50));
                    answerfield4.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
                    answerfield4.setEditable(true);


                    JButton B1 = new JButton("Create");
                    B1.setPreferredSize(new Dimension(260, 50));
                    B1.setBackground(Color.orange);
                    B1.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));

                    panel1.setBackground(Color.DARK_GRAY);
                    panel1.setLayout(new FlowLayout());
                    secondframe.add(panel1);
                    panel1.add(tf);
                    panel1.add(answerfield2);
                    panel1.add(tf1);
                    panel1.add(answerfield3);
                    panel1.add(tf2);
                    panel1.add(answerfield4);
                    panel1.add(B1);

                    secondframe.setSize(400, 400);
                    secondframe.setVisible(true);
                    secondframe.setResizable(false);
                    secondframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    B1.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent Event) {
                            if (answerfield2.getText().equals("") || answerfield3.getText().equals("") || answerfield4.getText().equals("")) {
                                JOptionPane.showMessageDialog(null, "please fill the box");
                            } else
                                JOptionPane.showMessageDialog(null, "Your Account has been Created and your id is "
                                        + bank.create_account(answerfield2.getText(), answerfield3.getText(), answerfield4.getText()));

                            String sql = "INSERT INTO bank (Name, DOB, Nominee) " +
                                    "VALUES ( '" + answerfield2.getText()+ "','" + answerfield3.getText()+ "','" + answerfield4.getText()+"')";
try{
    stmt.executeUpdate(sql);
    System.out.println(sql);
    con.close();
}
catch (Exception e){}

                        }

                    });
                }

            });
            System.out.println("Enter your id");
            Scanner scanner = new Scanner(System.in);
            String id = scanner.next();
            bank.print(id);

        }
        catch (Exception e){

        }
    }
}

//this is not complete project further thing have to be done
