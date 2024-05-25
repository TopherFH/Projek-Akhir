/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author PC PRAKTIKUM
 */
import Model.Dosen.*;
import View.Dosen.EditDataDosen;
import View.Dosen.InputDataDosen;
import View.Dosen.ViewDataDosen;
import java.util.List;
import javax.swing.JOptionPane;

public class ControllerDosen {
    ViewDataDosen halamanTable;
    InputDataDosen halamanInput;
    EditDataDosen halamanEdit;

    InterfaceDAODosen daoDosen;
    
    List<ModelDosen> daftarDosen;
    
    public ControllerDosen(ViewDataDosen halamanTable) {
        this.halamanTable = halamanTable;
        this.daoDosen = new DAODosen();
    }
    
    public ControllerDosen(InputDataDosen halamanInput) {
        this.halamanInput = halamanInput;
        this.daoDosen = new DAODosen();
    }
    
    public ControllerDosen(EditDataDosen halamanEdit) {
        this.halamanEdit = halamanEdit;
        this.daoDosen = new DAODosen();
    }
    
    public void showAllDosen() {
 
        daftarDosen = daoDosen.getAll();

        ModelTableDosen table = new ModelTableDosen(daftarDosen);

        // Mengisi tabel yang berada pada halaman Table Mahasiswa
        halamanTable.getTableDosen().setModel(table);
    }
    
    public void insertDosen() {
        try {
            ModelDosen dosenBaru = new ModelDosen();
            
            String nama = halamanInput.getInputNama();
            String no_hp = halamanInput.getNoHP();
            String email = halamanInput.getEmail();

            /*
              Mengecek apakah input dari nama atau nim kosong/tidak.
              Jika kosong, maka buatlah sebuah exception.
             */
            if ("".equals(nama) || "".equals(no_hp) || "".equals(email)) {
                throw new Exception("Nama atau NIDN tidak boleh kosong!");
            }
      
            dosenBaru.setNama(nama);
            dosenBaru.setNoHP(no_hp);
            

            daoDosen.insert(dosenBaru);
           
            JOptionPane.showMessageDialog(null, "Dosen baru berhasil ditambahkan.");

            halamanInput.dispose();
            new ViewDataDosen();
        } catch (Exception e) {
            // Menampilkan pop-up ketika terjadi error
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    public void editDosen(int id) {
        try {
      
            ModelDosen dosenYangMauDiedit = new ModelDosen();
      
            String nama = halamanEdit.getInputNama();
            String no_hp = halamanEdit.getInputNoHP();
            String email = halamanEdit.getEmail();

            if ("".equals(nama) || "".equals(no_hp) || "".equals(email)) {
                throw new Exception("Nama atau NIDN tidak boleh kosong!");
            }
 
            dosenYangMauDiedit.setId(id);
            dosenYangMauDiedit.setNama(nama);
            dosenYangMauDiedit.setNoHP(no_hp);
            dosenYangMauDiedit.setEmail(email);
            
            daoDosen.update(dosenYangMauDiedit);

            // Menampilkan pop-up ketika berhasil mengedit data
            JOptionPane.showMessageDialog(null, "Data Dosen berhasil diubah.");

            // Terakhir, program akan pindah ke halaman Table Mahasiswa()
            halamanEdit.dispose();
            new ViewDataDosen();
        } catch (Exception e) {
            // Menampilkan pop-up ketika terjadi error
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    public void deleteDosen(Integer baris) {
        // Mengambil id dan nama berdasarkan baris yang dipilih
        Integer id = (int) halamanTable.getTableDosen().getValueAt(baris, 0);
        String nama = halamanTable.getTableDosen().getValueAt(baris, 1).toString();

        // Membuat Pop-Up untuk mengonfirmasi apakah ingin menghapus data
        int input = JOptionPane.showConfirmDialog(
                null,
                "Hapus " + nama + "?",
                "Hapus Dosen",
                JOptionPane.YES_NO_OPTION
        );

        // Jika user memilih opsi "yes", maka hapus data.
        if (input == 0) {
            /* 
              Memanggil method delete() untuk menghaous data dari DB
              berdasarkan id yang dipilih.
            */
            daoDosen.delete(id);
            
            // Menampilkan pop-up jika berhasil menghapus.
            JOptionPane.showMessageDialog(null, "Berhasil menghapus data.");

            // Memanggil method "showAllMahasiswa()" untuk merefresh table.
            showAllDosen();
        }
    }


}
