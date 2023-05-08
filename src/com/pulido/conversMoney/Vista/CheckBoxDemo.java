package com.pulido.conversMoney.Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CheckBoxDemo implements ItemListener {
    JLabel jlabSelected;
    JLabel jlabChanged;
    JCheckBox jcbAlpha;
    JCheckBox jcbBeta;
    JCheckBox jcbGamma;
    CheckBoxDemo() {
        //Creacio del Frame
        JFrame frame = new JFrame(" CONTADOR DE MONEDES");
        //Especificacio del Layout
        frame.setLayout(new FlowLayout());
        //Mida de la finestra
        frame.setSize(350,280);
        //Acabar prograna
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Crear els textos
        jlabSelected = new JLabel("");
        jlabChanged = new JLabel("");
        //Crear checkBoxes
        jcbAlpha = new JCheckBox("Alpha");
        jcbBeta = new JCheckBox("Beta");
        jcbGamma = new JCheckBox("Gamma");

        //Events generats per els checkbosex
        jcbAlpha.addItemListener(this);
        jcbBeta.addItemListener(this);
        jcbGamma.addItemListener(this);

        //Afegir checkboxes i labels
        frame.add(jcbAlpha);
        frame.add(jcbBeta);
        frame.add(jcbGamma);
        frame.add(jlabChanged);
        frame.add(jlabSelected);

        //Display the frame
        frame.setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        String str = "";
        //Obtenir la referencia
    }
}
