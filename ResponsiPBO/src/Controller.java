/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Asus
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class Controller {
    Model model;
    View view;
    JFrame f;
    String cari,cari2;
    
    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
        
        if (model.getBanyakData() != 0) {
            String dataPerpustakaan[][] = model.readData();
            view.tabel.setModel((new JTable(dataPerpustakaan, view.namaKolom)).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        
        view.cmbcariB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    if (view.cmbcariB.getSelectedItem().equals("Id")){
                        cari = "id";  
                        cari2 = "ID"; 
                    }else if(view.cmbcariB.getSelectedItem().equals("Judul")){
                        cari = "judul_Buku";
                        cari2 = "Judul"; 
                    }else if(view.cmbcariB.getSelectedItem().equals("Genre")){
                        cari = "genre_Buku";
                        cari2 = "Genre";
                    }else if(view.cmbcariB.getSelectedItem().equals("Penulis")){
                        cari = "penulis"; 
                        cari2 = "Penulis";
                    }else if(view.cmbcariB.getSelectedItem().equals("Penerbit")){
                        cari = "penerbit";
                        cari2 = "Penerbit";
                    }else if(view.cmbcariB.getSelectedItem().equals("Lokasi")){
                        cari = "lokasi";
                        cari2 = "Penerbit";
                    }
                
            }
        });
        
        view.btnCari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               String find = view.getCari();
                
               int input = JOptionPane.showConfirmDialog(null,"Mencari Data Berdasarkan '"+cari2+"' : '"+find+"'?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);

               if (input == 0) {
               String dataPerpustakaan[][] = model.cariData(cari,find);
               view.tabel.setModel(new JTable(dataPerpustakaan, view.namaKolom).getModel());
               }else{
               JOptionPane.showMessageDialog(null, "Cari Gagal!");
               }
            }
        });
        
        view.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = view.getID();
                String judul = view.getJudul();
                String genre = view.getGenre();
                String penulis = view.getPenulis();
                String penerbit = view.getPenerbit();
                String lokasi = view.getLokasi();
                String stok = view.getStok();
                model.insertData( id,  judul,  genre,  penulis,  penerbit,  lokasi,  stok);

                String dataPerpustakaan[][] = model.readData();
                view.tabel.setModel(new JTable(dataPerpustakaan, view.namaKolom).getModel());
            }
        });
        
        view.btnUbah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String id = view.getID();
                String judul = view.getJudul();
                String genre = view.getGenre();
                String penulis = view.getPenulis();
                String penerbit = view.getPenerbit();
                String lokasi = view.getLokasi();
                String stok = view.getStok();
                model.updateData( id,  judul,  genre,  penulis,  penerbit,  lokasi,  stok);
                
                String dataPerpustakaan[][] = model.readData();
                view.tabel.setModel(new JTable(dataPerpustakaan, view.namaKolom).getModel());
            }
        });
        
        view.btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               String id = view.getID();
                
               int input = JOptionPane.showConfirmDialog(null,"Menghapus view ini?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);

               if (input == 0) {
               model.deleteData(id);
               String dataPerpustakaan[][] = model.readData();
               view.tabel.setModel(new JTable(dataPerpustakaan, view.namaKolom).getModel());
               }else{
               JOptionPane.showMessageDialog(null, "Hapus Gagal!");
               }
            }
        });
        
        view.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                int baris = view.tabel.getSelectedRow();
                
                String id = view.tabel.getValueAt(baris, 0).toString();
                String judul = view.tabel.getValueAt(baris, 1).toString();
                String genre = view.tabel.getValueAt(baris, 2).toString();
                String penulis = view.tabel.getValueAt(baris, 3).toString();
                String penerbit = view.tabel.getValueAt(baris, 4).toString();
                String lokasi = view.tabel.getValueAt(baris, 5).toString();
                String stok = view.tabel.getValueAt(baris, 6).toString();
                
                view.btnTambah.setEnabled(false);
                view.btnCari.setEnabled(false);
                view.btnUbah.setEnabled(true);
                view.btnHapus.setEnabled(true);
                
                view.fidB.setText(id);
                view.fjudulB.setText(judul);
                view.fgenreB.setText(genre);
                view.fpenulisB.setText(penulis);
                view.fpenerbitB.setText(penerbit);
                view.flokasiB.setText(lokasi);
                view.fstokB.setText(stok);
            }
        });
        
        view.btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                view.fidB.setText("");
                view.fjudulB.setText("");
                view.fgenreB.setText("");
                view.fpenulisB.setText("");
                view.fpenerbitB.setText("");
                view.flokasiB.setText("");
                view.fstokB.setText("");
                view.cmbcariB.setSelectedIndex(0);
                view.fcariB.setText("");
                
                view.btnTambah.setEnabled(true);
                view.btnCari.setEnabled(true);
                view.btnUbah.setEnabled(false);
                view.btnHapus.setEnabled(false);
                
                String dataPerpustakaan[][] = model.readData();
                view.tabel.setModel(new JTable(dataPerpustakaan, view.namaKolom).getModel());
            }   
        });
    }
    
}
