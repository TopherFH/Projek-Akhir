/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author PC PRAKTIKUM
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author ASUS
 */
public class LoginFrame extends JFrame implements ActionListener{
    JLabel tulisan = new JLabel("Selamat Datang!");
    JLabel tulisan2 = new JLabel("Silahkan Masuk untuk melanjutkan.");
    JLabel username = new JLabel("Username");
    JTextField inputNama = new JTextField();
    JLabel password = new JLabel("Password");
    JTextField inputpassword = new JTextField();
    JButton tombolLogin = new JButton("Login");
    LoginFrame() {
        setVisible(true);
        setSize(480, 520);
        setTitle("Login Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLayout(null);
        
        add (tulisan);
        tulisan.setBounds(20, 20, 150, 30);
        tulisan.setFont(new Font("Serif",Font.BOLD, 20));
        
        add (tulisan2);
        tulisan2.setBounds(20,40, 300,30);
        
        add (username);
        username.setBounds(20,70, 150,30);
        
        add (inputNama);
        inputNama.setBounds(20, 100, 410, 30);
        
        add(password);
        password.setBounds(20,140,150,30);
        
        add(inputpassword);
        inputpassword.setBounds(20,170,410,30);
        
        add(tombolLogin);
        tombolLogin.setBounds(20, 280, 410, 35);
        tombolLogin.setBackground(Color.white);
        tombolLogin.addActionListener(this);
}

    @Override
    public void actionPerformed(ActionEvent e) {
         try {
            String Username =inputNama.getText();
            
            String Password = inputpassword.getText();
            if(Username.isEmpty()){
                throw new Exception("Jangan kosong");
            }else if(Password.isEmpty()) {
            throw new Exception ("Password jangan Kosong ya!");
        }
            new HalamanUtama(Username);
            this.dispose();
         } catch (Exception error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
         }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
