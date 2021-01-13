/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Asus
 */
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Model {
    String DBurl = "jdbc:mysql://localhost/responsi";
    String DBusername = "root";
    String DBpassword = "";
    Connection koneksi;
    Statement statement;
    
    public Model(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = (Connection) DriverManager.getConnection(DBurl,DBusername,DBpassword);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            System.out.println("Koneksi gagal");
        }
    }
    
    public void insertData(String id, String judul, String genre, String penulis, String penerbit, String lokasi, String stok){
        int jmlData=0;
        try {
           String query = "Select * from perpustakaan WHERE id=" + id; 
           ResultSet resultSet = statement.executeQuery(query);
           
           while (resultSet.next()){ 
                jmlData++;
            }
           
           
            if (jmlData==0) {
                query = "INSERT INTO perpustakaan(id,judul_Buku,genre_Buku,penulis,penerbit,lokasi,stok) VALUES ('"+id+"','"+judul+"','"+genre+"','"+penulis+"','"+penerbit+"','"+lokasi+"','"+stok+"')";
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); 
                System.out.println("Berhasil ditambahkan");
                JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data sudah ada");
            }
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public void updateData(String id, String judul, String genre, String penulis, String penerbit, String lokasi, String stok){
        int jmlData=0;
         try {
           String query = "Select * from perpustakaan WHERE id =" + id; 
           ResultSet resultSet = statement.executeQuery(query);
           
           while (resultSet.next()){ 
                jmlData++;
            }
           
             if (jmlData==1) {
                query = "UPDATE perpustakaan SET id='" + id + "',judul_Buku='" + judul + "',genre_Buku='" + genre + "', penulis='" + penulis +"',penerbit='" + penerbit + "',lokasi='" + lokasi + "',stok='" + stok + "' WHERE id=" + id;
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); 
                System.out.println("Berhasil diupdate");
                JOptionPane.showMessageDialog(null, "Data Berhasil diupdate");
             }
             else {
                 JOptionPane.showMessageDialog(null, "Data Tidak Ada");
             }
           
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public String[][] readData(){
        try{
            int jmlData = 0;
            
            String data[][] = new String[getBanyakData()][7]; 
            
            String query = "Select * from perpustakaan"; 
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("id"); 
                data[jmlData][1] = resultSet.getString("judul_Buku");     
                data[jmlData][2] = resultSet.getString("genre_Buku");                
                data[jmlData][3] = resultSet.getString("penulis");
                data[jmlData][4] = resultSet.getString("penerbit");
                data[jmlData][5] = resultSet.getString("lokasi"); 
                data[jmlData][6] = resultSet.getString("stok");
                jmlData++;
            }
            return data;
               
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    public String[][] cariData(String cari, String find){
        try{
            int jmlData = 0;
            
            String data[][] = new String[cariBanyakData(cari,find)][7]; 
            
            String query = "Select * FROM perpustakaan WHERE "+cari+" LIKE '"+find+"%'"; 
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("id"); 
                data[jmlData][1] = resultSet.getString("judul_Buku");     
                data[jmlData][2] = resultSet.getString("genre_Buku");                
                data[jmlData][3] = resultSet.getString("penulis");
                data[jmlData][4] = resultSet.getString("penerbit");
                data[jmlData][5] = resultSet.getString("lokasi"); 
                data[jmlData][6] = resultSet.getString("stok");
                jmlData++;
            }
            return data;
               
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public int cariBanyakData(String cari,String find){
            int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "Select * FROM perpustakaan WHERE "+cari+" LIKE '"+find+"%'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ 
                jmlData++;
            }
            return jmlData;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    
    public int getBanyakData(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "Select * from perpustakaan";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ 
                jmlData++;
            }
            return jmlData;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    
    public void deleteData(String id) {
        try{
            String query = "DELETE FROM perpustakaan WHERE id = '"+id+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
            
        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }
    
}
