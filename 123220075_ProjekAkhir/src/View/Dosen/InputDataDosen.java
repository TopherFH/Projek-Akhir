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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class InputDataDosen extends JFrame {
 
    ControllerDosen controller;
    
    JLabel header = new JLabel("Input Dosen");
    JLabel labelInputNama = new JLabel("Nama");
    JLabel labelInputNoHP = new JLabel("No HP");
    JLabel labelInputEmail = new JLabel("Email");
    JTextField inputNama = new JTextField();
    JTextField inputNoHP = new JTextField();
    JTextField inputEmail = new JTextField();
    JButton tombolTambah = new JButton("Tambah Dosen");
    JButton tombolKembali = new JButton("Kembali");
    
    public InputDataDosen() {
        setTitle("Input Dosen");
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
        add(tombolTambah);
        header.setBounds(20, 8, 440, 24);
        labelInputNama.setBounds(20, 32, 440, 24);
        inputNama.setBounds(18, 56, 440, 36);
        labelInputNoHP.setBounds(20, 96, 440, 24);
        inputNoHP.setBounds(18, 120, 440, 36);
        labelInputEmail.setBounds(20, 160, 440, 24);
        inputEmail.setBounds(18, 184, 440, 36);
        tombolKembali.setBounds(20, 160, 215, 40);
        tombolTambah.setBounds(240, 160, 215, 40);
        
        controller = new ControllerDosen(this);
        
        tombolKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ViewDataDosen();
            }
        });

        tombolTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.insertDosen();
            }
        });
    }
    
    public String getInputNama() {
        return inputNama.getText();
    }

    public String getNoHP() {
        return inputNoHP.getText();
    }
    
    public String getEmail(){
        return inputEmail.getText();
    }

}
