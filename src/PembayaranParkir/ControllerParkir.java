package PembayaranParkir;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ControllerParkir {
    ViewParkir viewParkir;
    ModelParkir modelParkir;
    public String data;

    public ControllerParkir(ModelParkir modelParkir, ViewParkir viewParkir) {
        this.modelParkir = modelParkir;
        this.viewParkir = viewParkir;

        if (modelParkir.getBanyakData()!=0) {
            String dataTrans[][] = modelParkir.readData();
            viewParkir.tabel.setModel((new JTable(dataTrans, viewParkir.namaKolom)).getModel());
        }else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }

        viewParkir.motorRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewParkir.tfJenisKendaraan.setText("Motor");
                viewParkir.tfBiaya.setText("2000");
                viewParkir.mobilRadioButton.setSelected(false);
                viewParkir.mobilRadioButton.setEnabled(true);
            }
        });
        viewParkir.mobilRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewParkir.tfJenisKendaraan.setText("Mobil");
                viewParkir.tfBiaya.setText("5000");
                viewParkir.motorRadioButton.setSelected(false);
                viewParkir.motorRadioButton.setEnabled(true);
            }
        });

        viewParkir.btnProses.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int c = Integer.parseInt(viewParkir.tfBiaya.getText());
                int d = Integer.parseInt(viewParkir.tfLamaParkir.getText());
                int hasil = c*d;
                viewParkir.tfTotalBiaya.setText("" + hasil);
            }
        });

        viewParkir.btnCetak.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String NoKendaraan = viewParkir.getNoKendaraan();
                String JenisKendaraan = viewParkir.getJenisKendaraan();
                int Biaya = viewParkir.getBiaya();
                int LamaParkir = viewParkir.getLamaParkir();
                int TotalBiaya = (Biaya*LamaParkir);

                if (NoKendaraan.isEmpty() || JenisKendaraan.isEmpty() || Biaya == 0 || LamaParkir == 0 || TotalBiaya == 0) {
                    JOptionPane.showMessageDialog(null, "Tidak Boleh Kosong");
                } else {
                    modelParkir.insertData(NoKendaraan, JenisKendaraan, Biaya, LamaParkir, TotalBiaya);
                }

                String dataTrans[][] = modelParkir.readData();
                viewParkir.tabel.setModel((new JTable(dataTrans, viewParkir.namaKolom)).getModel());
            }
        });

        viewParkir.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String NoKendaraan = viewParkir.getNoKendaraan();
                String JenisKendaraan = viewParkir.getJenisKendaraan();
                int Biaya = viewParkir.getBiaya();
                int LamaParkir = viewParkir.getLamaParkir();
                int TotalBiaya = (Biaya*LamaParkir);

                if(NoKendaraan.isEmpty() || JenisKendaraan.isEmpty() || Biaya == 0 || LamaParkir == 0 || TotalBiaya == 0){
                    JOptionPane.showMessageDialog(null, "Tidak Boleh Kosong");
                }
                else{
                    modelParkir.updateData(NoKendaraan, JenisKendaraan, Biaya, LamaParkir, TotalBiaya);
                }


                String dataTrans[][] = modelParkir.readData();
                viewParkir.tabel.setModel((new JTable(dataTrans, viewParkir.namaKolom)).getModel());
            }
        });

        viewParkir.btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                viewParkir.tfNoKendaraan.setText("");
                viewParkir.tfJenisKendaraan.setText("");
                viewParkir.tfBiaya.setText("");
                viewParkir.tfLamaParkir.setText("");
                viewParkir.tfTotalBiaya.setText("");
                viewParkir.motorRadioButton.setSelected(false);
                viewParkir.mobilRadioButton.setSelected(false);
                viewParkir.motorRadioButton.setEnabled(true);
                viewParkir.mobilRadioButton.setEnabled(true);
            }
        });

        viewParkir.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);

                int baris = viewParkir.tabel.getSelectedRow();
                data = viewParkir.tabel.getValueAt(baris, 0).toString();
                String dataUpdate[] = new String[4];
                dataUpdate[0] = viewParkir.tabel.getValueAt(baris, 0).toString();
                dataUpdate[1] = viewParkir.tabel.getValueAt(baris, 1).toString();

                System.out.println(data);
            }
        });

        viewParkir.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int input = JOptionPane.showConfirmDialog(null,
                        "Apa anda ingin menghapus Judul " + data + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);

                if (input == 0) {
                    modelParkir.deleteData(data);
                    String dataTrans[][] = modelParkir.readData();
                    viewParkir.tabel.setModel((new JTable(dataTrans, viewParkir.namaKolom)).getModel());
                } else {
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
                }
            }
        });
    }
}
