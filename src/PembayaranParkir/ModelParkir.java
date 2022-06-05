package PembayaranParkir;

import javax.swing.*;
import java.sql.*;

public class ModelParkir {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/parkiran";
    static final String USER = "root";
    static final String PASS = "hibiki123#";

    Connection con;
    Statement s;

    public ModelParkir() {
        try {
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }

    public String[][] readData() {
        try {
            int jmlData = 0;

            String data[][] = new String[getBanyakData()][5];

            String query = "SELECT * FROM data_parkiran";
            ResultSet resultSet = s.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("NoKendaraan"); //harus sesuai nama kolom di mysql
                data[jmlData][1] = resultSet.getString("JenisKendaraan");
                data[jmlData][2] = String.valueOf(resultSet.getInt("Biaya"));
                data[jmlData][3] = String.valueOf(resultSet.getInt("LamaParkir"));
                data[jmlData][4] = String.valueOf(resultSet.getInt("TotalBiaya"));
                jmlData++;
            }
            return data;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }

    public void insertData(String NoKendaraan, String JenisKendaraan, int Biaya, int LamaParkir, int TotalBiaya){
        int jmlData=0;

        try {
            String query = "SELECT * FROM data_parkiran WHERE NoKendaraan='" + NoKendaraan+"'";
            System.out.println(NoKendaraan + " " + JenisKendaraan + " " + Biaya + " " + LamaParkir + " " + TotalBiaya);
            ResultSet resultSet = s.executeQuery(query);

            while (resultSet.next()){
                jmlData++;
            }

            if (jmlData==0) {
                query = "INSERT INTO data_parkiran(NoKendaraan, JenisKendaraan, Biaya, LamaParkir, TotalBiaya) VALUES('"+NoKendaraan+"','"+JenisKendaraan+"','"+Biaya+"','"+LamaParkir+"','"+TotalBiaya+"')";

                s = con.createStatement();
                s.executeUpdate(query); //execute querynya
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

    public void updateData(String NoKendaraan, String JenisKendaraan, int Biaya, int LamaParkir, int TotalBiaya){
        int jmlData=0;
        try {
            String query = "SELECT * FROM data_parkiran WHERE NoKendaraan='" + NoKendaraan+"'";
            ResultSet resultSet = s.executeQuery(query);

            while (resultSet.next()){
                jmlData++;
            }

            if (jmlData==1) {
                query = "UPDATE data_parkiran SET JenisKendaraan='" + JenisKendaraan + "', Biaya='" + Biaya + "', LamaParkir='"+ LamaParkir+"', TotalBiaya='"+ TotalBiaya+"' WHERE NoKendaraan='" + NoKendaraan+"'";
                s = (Statement) con.createStatement();
                s.executeUpdate(query); //execute querynya
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

    public int getBanyakData(){
        int jmlData = 0;
        try{
            s = con.createStatement();
            String query = "SELECT * FROM data_parkiran";
            ResultSet resultSet = s.executeQuery(query);
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

    public void deleteData (String NoKendaraan) {
        try{
            String query = "DELETE FROM data_parkiran WHERE NoKendaraan = '"+NoKendaraan+"'";
            s = con.createStatement();
            s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");

        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }
}
