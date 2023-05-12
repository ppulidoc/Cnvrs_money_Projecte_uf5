package com.pulido.conversMoney.init;
import com.pulido.conversMoney.Vista.CheckBoxDemo;

import javax.swing.*;

public class inicial {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CheckBoxDemo();
            }
        });

    }
}
