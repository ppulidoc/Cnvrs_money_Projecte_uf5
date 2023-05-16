package com.pulido.conversMoney.init;
import com.pulido.conversMoney.Vista.CheckBoxDemo;

import javax.swing.*;

public class inicial {
    public static void main(String[] args) {

        try{
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new CheckBoxDemo();
                }
            });
        } catch (NumberFormatException ex){
            System.out.println("Ha de ser un número.");
        }


    }
}
