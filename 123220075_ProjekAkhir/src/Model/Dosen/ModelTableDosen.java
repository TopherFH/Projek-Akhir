/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Dosen;

/**
 *
 * @author PC PRAKTIKUM
 */
import java.util.*;
import javax.swing.table.AbstractTableModel;

public class ModelTableDosen extends AbstractTableModel{
    
    List<ModelDosen> daftarDosen;
    
    String kolom[] = {"ID", "Nama", "NO HP", "Email"};

    /*
      Karena daftarMahasiswa memiliki tipe data List, kita harus mengubahnya
      terlebih dahulu ke dalam tipe data Array Object supaya dapat 
      dimasukkan ke dalam table.
     */
    public ModelTableDosen(List<ModelDosen> daftarDosen) {
        this.daftarDosen = daftarDosen;
    }
    
    @Override
    public int getRowCount() {
        return daftarDosen.size();
    }

    @Override
    public int getColumnCount() {
        return kolom.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return daftarDosen.get(rowIndex).getId();
            case 1:
                return daftarDosen.get(rowIndex).getNama();
            case 2:
                return daftarDosen.get(rowIndex).getNoHP();
            case 3:
                return daftarDosen.get(rowIndex).getEmail();
            default:
                return null;
        }
    }
    
}
