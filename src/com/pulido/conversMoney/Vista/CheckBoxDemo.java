package com.pulido.conversMoney.Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CheckBoxDemo extends JFrame {
    private final JTextField txtQuantitat;
    private final JComboBox<String> cbMonedas;
    private final JLabel lblDolares;
    private final JLabel lblEuros;
    private final JLabel lblLibras;
    private final JLabel lblPesosMexicanos;


    private final double[] tipoCambio = {1.0, 0.91, 0.79, 17.78}; //Tipo de cambio actual a Mayo 2023

    public static double[] leerTipoCambioDesdeArchivo(String rutaArchivo) throws IOException {
        double[] tipus = new double[4];

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(rutaArchivo));
            String linea;
            int i = 0;
            while ((linea = br.readLine()) != null && i < 4) {
                tipus[i] = Double.parseDouble(linea);
                i++;
            }
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return tipus;
    }

    public CheckBoxDemo() {
        super("Convertidor de Monedes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLayout(new GridLayout(5, 2));

        JLabel lblMonto = new JLabel("Quantitat:");
        txtQuantitat = new JTextField(10);
        JLabel lblMoneda = new JLabel("Moneda:");
        cbMonedas = new JComboBox<>(new String[]{"Dòlars", "Euros", "Lliures", "Pesos Mexicans"});
        JLabel lblConversion = new JLabel("Conversions:");
        lblDolares = new JLabel("");
        lblEuros = new JLabel("");
        lblLibras = new JLabel("");
        lblPesosMexicanos = new JLabel("");
        JButton btnConvertir = new JButton("Convertir");

        btnConvertir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    leerTipoCambioDesdeArchivo("src/com/pulido/conversMoney/files/convertir.txt");
                } catch (IOException ex) {
                    System.out.println("L'arxiu no s'ha trobat");
                }
                double diners = Double.parseDouble(txtQuantitat.getText());
                int monedaSeleccionada = cbMonedas.getSelectedIndex();
                double[] conversiones = new double[4];
                for(int i = 0; i < 4; i++) {
                    try {
                        conversiones[i] = diners / leerTipoCambioDesdeArchivo("src/cm/pulido/conversMoney/files/convertir.txt")[monedaSeleccionada] * leerTipoCambioDesdeArchivo("src/com/pulido/conversMoney/files/convertir.txt")[i];
                    } catch (IOException ex) {
                        System.out.println("L'arxiu no s'ha trobat");
                    }
                }
                lblDolares.setText(String.format("%.2f", conversiones[0]));
                lblEuros.setText(String.format("%.2f", conversiones[1]));
                lblLibras.setText(String.format("%.2f", conversiones[2]));
                lblPesosMexicanos.setText(String.format("%.2f", conversiones[3]));
            }
        });

        add(lblMonto);
        add(txtQuantitat);
        add(lblMoneda);
        add(cbMonedas);
        add(new JLabel(""));
        add(btnConvertir);
        add(lblConversion);
        add(new JLabel(""));
        add(new JLabel("Dòlars:"));
        add(lblDolares);
        add(new JLabel("Euros:"));
        add(lblEuros);
        add(new JLabel("Lliures:"));
        add(lblLibras);
        add(new JLabel("Pesos Mexicans:"));
        add(lblPesosMexicanos);

        setVisible(true);
        setResizable(false);
    }

}
