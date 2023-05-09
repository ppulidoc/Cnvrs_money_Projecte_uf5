package com.pulido.conversMoney;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConversorMonedas extends JFrame {
    private JTextField txtMonto;
    private JComboBox<String> cbMonedas;
    private JLabel lblDolares, lblEuros, lblLibras, lblPesosMexicanos;

    private final double[] tipoCambio = {1.0, 0.82, 0.71, 19.92}; //Tipo de cambio actual a Mayo 2023

    public ConversorMonedas() {
        super("Conversor de Monedas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLayout(new GridLayout(5, 2));

        JLabel lblMonto = new JLabel("Quantitat:");
        txtMonto = new JTextField(10);
        JLabel lblMoneda = new JLabel("Moneda:");
        cbMonedas = new JComboBox<String>(new String[]{"Dólares", "Euros", "Libras", "Pesos Mexicanos"});
        JLabel lblConversion = new JLabel("Conversiones:");
        lblDolares = new JLabel("");
        lblEuros = new JLabel("");
        lblLibras = new JLabel("");
        lblPesosMexicanos = new JLabel("");
        JButton btnConvertir = new JButton("Convertir");

        btnConvertir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double monto = Double.parseDouble(txtMonto.getText());
                int monedaSeleccionada = cbMonedas.getSelectedIndex();
                double[] conversiones = new double[4];
                for(int i = 0; i < 4; i++) {
                    conversiones[i] = monto * tipoCambio[monedaSeleccionada] / tipoCambio[i];
                }
                lblDolares.setText(String.format("%.2f", conversiones[0]));
                lblEuros.setText(String.format("%.2f", conversiones[1]));
                lblLibras.setText(String.format("%.2f", conversiones[2]));
                lblPesosMexicanos.setText(String.format("%.2f", conversiones[3]));
            }
        });

        add(lblMonto);
        add(txtMonto);
        add(lblMoneda);
        add(cbMonedas);
        add(new JLabel(""));
        add(btnConvertir);
        add(lblConversion);
        add(new JLabel(""));
        add(new JLabel("Dólares:"));
        add(lblDolares);
        add(new JLabel("Euros:"));
        add(lblEuros);
        add(new JLabel("Libras:"));
        add(lblLibras);
        add(new JLabel("Pesos Mexicanos:"));
        add(lblPesosMexicanos);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ConversorMonedas();
    }
}
