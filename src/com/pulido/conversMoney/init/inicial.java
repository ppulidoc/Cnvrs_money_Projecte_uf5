package com.pulido.conversMoney.init;
import com.pulido.conversMoney.Vista.CheckBoxDemo;
import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;

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
