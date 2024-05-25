/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Dosen;

/**
 *
 * @author PC PRAKTIKUM
 */
import Model.Connector;
import java.sql.*;
import java.util.*;

public class DAODosen implements InterfaceDAODosen {
    
    public void insert(ModelDosen dosen) {
       try {
            String query = "INSERT INTO dosen (nama, no_hp) VALUES (?, ?);";
            
            
            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setString(1, dosen.getNama());
            statement.setString(2, dosen.getNoHP());
            statement.setString(3, dosen.getEmail());
            
            statement.executeUpdate();
            
          
            statement.close();
        } catch (SQLException e) {
            // Menampilkan pesan error ketika gagal input data.
            System.out.println("Input Failed: " + e.getLocalizedMessage());
        } 
    }
    
    public void update(ModelDosen dosen) {
        try {
            // Perintah query disimpan ke dalam variabel "query"
            String query = "UPDATE mahasiswa SET nama=?, nim=? WHERE id=?;";

            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setString(1, dosen.getNama());
            statement.setString(2, dosen.getNoHP());
            statement.setString(3, dosen.getEmail());
            statement.setInt(4, dosen.getId());
            
            
            statement.executeUpdate();
            
            // Menutup koneksi untuk menghemat penggunaan memory.
            statement.close();
        } catch (SQLException e) {
            // Menampilkan pesan error ketika gagal edit data.
            System.out.println("update Failed! (" + e.getMessage() + ")");
        }
    }
    
    public void delete(int id) {
        try {
            // Perintah query disimpan ke dalam variabel "query"
            String query = "DELETE FROM dosen WHERE id=?;";
      
            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setInt(1, id);

            statement.executeUpdate();
            
            // Menutup koneksi untuk menghemat penggunaan memory.
            statement.close();
        } catch (SQLException e) {
            // Menampilkan pesan error ketika gagal hapus data.
            System.out.println("Delete Failed: " + e.getLocalizedMessage());
        }
    }
    
    public List<ModelDosen> getAll() {
         List<ModelDosen> listDosen = null;

        try {      
            listDosen = new ArrayList<>();
            
            // Membuat objek statement yang digunakan untuk melakukan query.
            Statement statement = Connector.Connect().createStatement();
          
            String query = "SELECT * FROM dosen;";
            
             // Mengeksekusi query dan menyimpannya ke dalam variabel "resultSet".
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                ModelDosen dos = new ModelDosen();
                
                dos.setId(resultSet.getInt("id"));
                dos.setNama(resultSet.getString("nama"));
                dos.setEmail(resultSet.getString("no_hp"));

                listDosen.add(dos);
            }
            
            // Menutup koneksi untuk menghemat penggunaan memory.
            statement.close();
        } catch (SQLException e) {
            // Menampilkan pesan error ketika gagal mengambil data.
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        return listDosen;
    }
}

