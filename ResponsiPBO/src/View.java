/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Asus
 */
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class View extends JFrame {
        
    JLabel ljudul = new JLabel ("Perpustakaan Umum Yogyakarta");
    JLabel lidB= new JLabel(" ID Buku ");
        JTextField fidB = new JTextField(10);
    JLabel ljudulB= new JLabel(" Judul Buku ");
        JTextField fjudulB = new JTextField(40);
    JLabel lgenreB = new JLabel(" Genre Buku ");
        JTextField fgenreB = new JTextField(20);
    JLabel lpenulisB = new JLabel(" Penulis ");
        JTextField fpenulisB = new JTextField(20);
    JLabel lpenerbitB = new JLabel(" Penerbit ");
        JTextField fpenerbitB = new JTextField(20);
    JLabel llokasiB = new JLabel(" Lokasi ");
        JTextField flokasiB = new JTextField(10);
    JLabel lstokB = new JLabel(" STOK ");
        JTextField fstokB = new JTextField(10);
    JLabel lcariB = new JLabel(" STOK ");
        String cariB[]=
        {"Id","Judul","Genre","Penulis","Penerbit","Lokasi"};
        JComboBox cmbcariB = new JComboBox(cariB);
        JTextField fcariB = new JTextField(25);
    
    
    JButton btnTambah = new JButton(" Tambah ");
    JButton btnUbah= new JButton(" Ubah ");
    JButton btnHapus = new JButton(" Hapus ");
    JButton btnCari = new JButton(" Cari ");
    JButton btnReset = new JButton(" Reset "); 
       
        
    
    String data[][] = new String[500][7];
    Object namaKolom[] = {"id","Judul Buku","Genre Buku","Penulis","Penerbit","Lokasi","Stok"}; //membuat kolom dgn array
    JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    
    public View(){
        setTitle("124190028_RESPONSI");
        tabel = new JTable(data,namaKolom);
        scrollPane = new JScrollPane(tabel);
        add(scrollPane);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	setDefaultCloseOperation(3);
        setSize(1200,490);
        add(scrollPane);
        scrollPane.setBounds(450, 55, 700, 325);
        setLayout(null);
        setVisible(true);
    
//ADD COMPONENT
        add(ljudul);
        add(lidB);
        add(fidB);
        add(ljudulB);
        add(fjudulB);
	add(lgenreB);
	add(fgenreB);
        add(lpenulisB);
        add(fpenulisB);
	add(lpenerbitB);
	add(fpenerbitB);
        add(llokasiB);
	add(flokasiB);
        add(lstokB);
	add(fstokB);
        add(lcariB);
        add(cmbcariB);
        add(fcariB);
        
//LABEL
        ljudul.setBounds(70,10,320,25);
        ljudul.setFont(new Font("", Font.BOLD, 20));
        lidB.setBounds(40,55,200,20);
	ljudulB.setBounds(40,105,120,20);
        lgenreB.setBounds(40,155,120,20);
        lpenulisB.setBounds(40,205,120,20);
        lpenerbitB.setBounds(40,255,120,20);
        llokasiB.setBounds(40,305,120,20);
        lstokB.setBounds(40,355,120,20);
        

//TEXT FIELD
        fidB.setBounds(225,55,180,20);
	fjudulB.setBounds(225,105,180,20);
        fgenreB.setBounds(225,155,180,20);
        fpenulisB.setBounds(225,205,180,20);
        fpenerbitB.setBounds(225,255,180,20);
        flokasiB.setBounds(225,305,180,20);
        fstokB.setBounds(225,355,180,20);   
        cmbcariB.setBounds(550,390,120,35);
        fcariB.setBounds(675,390,180,35);
        
//BUTTON PANEL  
        add(btnTambah);
        add(btnCari);
        add(btnUbah);
        add(btnHapus);
        add(btnReset);
        
        btnTambah.setBounds(25,390,90,35);
        btnUbah.setBounds(125,390,90,35);
        btnUbah.setEnabled(false);
        btnHapus.setBounds(225,390,90,35);    
        btnHapus.setEnabled(false);
        btnReset.setBounds(325,390,90,35);
        btnCari.setBounds(450,390,90,35);
        
        
        
    }
    
//GETTER - Input DATA
    public String getID(){
        return fidB.getText();
    }
    
    public String getJudul(){
        return fjudulB.getText();
    }
    
    public String getGenre(){
        return fgenreB.getText();
    }
    
    public String getPenulis() {
        return fpenulisB.getText();
    }

    public String getPenerbit() {
        return fpenerbitB.getText();
    }
    
    public String getLokasi() {
        return flokasiB.getText();
    }
    
    public String getStok() {
        return fstokB.getText();
    }
    
    public String getCari() {
        return fcariB.getText();
    }
    
   
}

