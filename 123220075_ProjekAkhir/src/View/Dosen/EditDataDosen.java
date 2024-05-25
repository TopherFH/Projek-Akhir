/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.Dosen;

/**
 *
 * @author PC PRAKTIKUM
 */
import View.Dosen.ViewDataDosen;
import Controller.ControllerDosen;
import Model.Dosen.ModelDosen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class EditDataDosen extends JFrame{
    ControllerDosen controller;
    
    JLabel header = new JLabel("Edit Dosen");
    JLabel labelInputNama = new JLabel("Nama");
    JLabel labelInputNoHP = new JLabel("No HP");
    JLabel labelInputEmail = new JLabel("Email");
    JTextField inputNama = new JTextField();
    JTextField inputNoHP = new JTextField();
    JTextField inputEmail = new JTextField();
    JButton tombolEdit = new JButton("Edit Dosen");
    JButton tombolKembali = new JButton("Kembali");
    
    public EditDataDosen(ModelDosen dosen) {
        setTitle("Edit Dosen");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setSize(480, 240);

        add(header);
        add(labelInputNama);
        add(labelInputNoHP);
        add(tombolKembali);
        add(labelInputEmail);
        add(inputNama);
        add(inputNoHP);
        add(inputEmail);
        add(tombolEdit);
        header.setBounds(20, 8, 440, 24);
        labelInputNama.setBounds(20, 32, 440, 24);
        inputNama.setBounds(18, 56, 440, 36);
        labelInputNoHP.setBounds(20, 96, 440, 24);
        inputNoHP.setBounds(18, 120, 440, 36);
        labelInputEmail.setBounds(20, 160, 440, 24);
        inputEmail.setBounds(18, 184, 440, 36);
        tombolKembali.setBounds(20, 160, 215, 40);
        tombolEdit.setBounds(240, 160, 215, 40);
        
        // Masukkin nama dan no hp didapat dari halaman sebelumnya.
        inputNama.setText(dosen.getNama());
        inputNoHP.setText(dosen.getNoHP());
        inputEmail.setText(dosen.getEmail());
        
        controller = new ControllerDosen(this);
        
        tombolKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ViewDataDosen();
            }
        });

        tombolEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.editDosen(dosen.getId());
            }
        });
    }

    public String getInputNama() {
        return inputNama.getText();
    }

    public String getInputNoHP(){
        return inputNoHP.getText();
    }
    

    public String getEmail() {
        return inputEmail.getText();    }
}
