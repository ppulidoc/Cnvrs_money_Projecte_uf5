package com.pulido.conversMoney.Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CheckBoxDemo implements ItemListener {
    JLabel jlabSelected;
    JLabel jlabChanged;
    JCheckBox jcbalpha;
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


    }
}
