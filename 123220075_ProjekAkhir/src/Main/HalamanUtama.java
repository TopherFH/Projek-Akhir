/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author PC PRAKTIKUM
 */
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author ASUS
 */
public class HalamanUtama extends JFrame implements ActionListener{
    JLabel salam= new JLabel();
    JLabel tulisan = new JLabel("Silahkan pilih untuk melanjutkan");
    JButton mahasiswa = new JButton("Mahasiswa");
    JButton dosen= new JButton("Dosen");
    JButton logout = new JButton("Logout");

    public HalamanUtama(String Username) {
        setVisible(true);
        setSize(480, 520);
        setTitle("Halaman Utama");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLayout(null);  
        
        add(salam);
        salam.setText("Wellcome, "+ Username);
        salam.setBounds(20, 20, 370, 40);
        salam.setFont(new Font("Serif",Font.BOLD, 20));
        
        add(tulisan);
        tulisan.setBounds(20,40,370,40);
        
        add (mahasiswa);
        mahasiswa.setBounds(20,100, 410,40);
        mahasiswa.addActionListener(this);
        
        
        add(dosen);
        dosen.setBounds(20,150, 410,40);
        dosen.addActionListener(this);
        
        add(logout);
        logout.setBounds(20,200, 410,40);
        logout.addActionListener(this);
        
    }

    public HalamanUtama() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource() == mahasiswa){
        new View.Mahasiswa.ViewData();
        this.dispose();
    }else if(e.getSource() == dosen){
        new View.Dosen.ViewDataDosen();
        this.dispose();
    }else if (e.getSource() == logout){
        this.dispose();
        new LoginFrame();
    }
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
