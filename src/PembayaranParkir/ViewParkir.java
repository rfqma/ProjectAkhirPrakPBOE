package PembayaranParkir;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ViewParkir extends JFrame {
    JLabel lNoKendaraan = new JLabel("No. Kendaraan (Tanpa Spasi)");
    JLabel lJenisKendaraan = new JLabel("Jenis Kendaraan");
    JLabel lBiaya = new JLabel("Biaya (/Jam)");
    JLabel lLamaParkir = new JLabel("Lama Parkir (Jam)");
    JLabel lTotalBiaya = new JLabel("Total Biaya");
    JLabel lInfo = new JLabel("(Pilih Proses untuk menghitung Biaya per-Jam)");

    public JTextField tfNoKendaraan = new JTextField();
    public JRadioButton motorRadioButton = new JRadioButton("Motor");
    public JRadioButton mobilRadioButton = new JRadioButton("Mobil");
    public JTextField tfJenisKendaraan = new JTextField();
    public JTextField tfBiaya = new JTextField();
    public JTextField tfLamaParkir = new JTextField();
    public JTextField tfTotalBiaya = new JTextField();

    public JButton btnProses = new JButton("Proses");

    public JButton btnUpdate = new JButton("Update");
    public JButton btnDelete = new JButton("Delete");
    public JButton btnClear = new JButton("Clear");
    public JButton btnCetak = new JButton("Cetak");

    public JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"Nomor Kendaraan", "Jenis Kendaraan", "Biaya", "Lama Parkir (Jam)", "Total Biaya"};

    public ViewParkir() {
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);

        setTitle("Data Parkir");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setSize(950,500);
        setLocationRelativeTo(null);

        add(scrollPane);
        scrollPane.setBounds(20, 20, 570, 400);

        add(lNoKendaraan);
        lNoKendaraan.setBounds(600, 20, 200, 20);
        add(tfNoKendaraan);
        tfNoKendaraan.setBounds(600, 40, 120, 20);

        add(lJenisKendaraan);
        lJenisKendaraan.setBounds(600, 60, 200, 20);
        add(motorRadioButton);
        motorRadioButton.setBounds(670, 80, 70, 20);
        add(mobilRadioButton);
        mobilRadioButton.setBounds(600, 80, 70, 20);
        add(tfJenisKendaraan);
        tfJenisKendaraan.setBounds(600, 100, 120, 20);


        add(lBiaya);
        lBiaya.setBounds(600, 120, 90, 20);
        add(tfBiaya);
        tfBiaya.setBounds(600, 140, 120, 20);

        add(lLamaParkir);
        lLamaParkir.setBounds(600, 160, 200, 20);
        add(tfLamaParkir);
        tfLamaParkir.setBounds(600, 180, 120, 20);

        add(lTotalBiaya);
        lTotalBiaya.setBounds(600, 200, 90, 20);
        add(tfTotalBiaya);
        tfTotalBiaya.setBounds(600, 220, 120, 20);
        add(lInfo);
        lInfo.setBounds(600, 240, 400, 20);

        add(btnProses);
        btnProses.setBounds(600, 270, 90, 20);
        btnProses.setBackground(Color.GREEN);

        add(btnUpdate);
        btnUpdate.setBounds(600, 330, 90, 20);
        btnUpdate.setBackground(Color.YELLOW);

        add(btnDelete);
        btnDelete.setBounds(600, 360, 90, 20);
        btnDelete.setBackground(Color.RED);

        add(btnClear);
        btnClear.setBounds(600, 390, 90, 20);
        btnClear.setBackground(Color.WHITE);

        add(btnCetak);
        btnCetak.setBounds(600, 420, 90, 20);
        btnCetak.setBackground(Color.CYAN);
    }

    public String getNoKendaraan() {
        return tfNoKendaraan.getText();
    }

    public String getJenisKendaraan() {
        if (motorRadioButton.isSelected()) {
            tfJenisKendaraan.setText("Motor");
        } else if (mobilRadioButton.isSelected()) {
            tfJenisKendaraan.setText("Mobil");
        }
        return tfJenisKendaraan.getText();
    }

    public int getBiaya() {
        if(tfBiaya.getText().isEmpty()) {
            int biaya = 0;
            return biaya;
        } else {
            return Integer.parseInt(tfBiaya.getText());
        }
    }

    public int getLamaParkir() {
        if(tfLamaParkir.getText().isEmpty()) {
            int lamaParkir = 0;
            return lamaParkir;
        } else {
            return Integer.parseInt(tfLamaParkir.getText());
        }
    }
}
