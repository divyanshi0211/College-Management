
package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Create extends JFrame implements ActionListener {
    
    JButton cancel, submit;
    JTextField tfusername, tfpassword;
    Create(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40,20,100,20);
        add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(150,20,150,20);
        add(tfusername);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40,70,100,20);
        add(lblpassword);
        
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(150,70,150,20);
        add(tfpassword);
        
        submit = new JButton("Submit");
        submit.setBounds(40,140,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma",Font.BOLD, 15));
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(180,140,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD, 15));
        
        ImageIcon i1 = new  ImageIcon(ClassLoader.getSystemResource("icon/New Folder/icon2.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,20,200,200);
        add(image);
        
        add(cancel);
        setSize(600,300);
        setLocation(500,250);
        setVisible(true);
        
     
    }
     public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == submit){
           String username = tfusername.getText();
           String password = tfpassword.getText();
           
           try{
              if (username.equals("")){
                  JOptionPane.showMessageDialog(null," username is required");
                  setVisible(false);
                } 
                else{
                  Conn c = new Conn();
                  String query = "insert into createAc values('"+username+"', '"+password+"')";
                  c.s.executeUpdate(query);
                  setVisible(false);
                }
       
            }
            catch(Exception e)
            {
               e.printStackTrace();
            }
        }else if (ae.getSource() == cancel){
            setVisible(false);
        }
        }
    public static void main (String args[]){
       new Create();
   }

}
