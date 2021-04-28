package com.company.gazedimi.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Add extends JFrame {

    private JPanel addPanel;

    private JTextField code;
    private JTextField name;
    private JComboBox animalClass;
    private JSpinner weight;
    private JSpinner maxAge;
    private JTextArea description;

    private JButton addAnimal;


    public Add() {
        //-------------------------form configuration settings----------------------
        setResizable(false);                                                         //no resize
        setTitle("MyZoo - Add Animal");
        setPreferredSize(new Dimension(500, 400));
        setContentPane(addPanel);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);                                                //display form in center
        //code.setText();
        setVisible(true);

        //on button click event for adding a new animal
        addAnimal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
