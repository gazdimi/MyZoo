package com.company.gazedimi.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class Menu extends JFrame{
    private JPanel menu;
    private JTextField textField1;
    private JComboBox comboBox1;
    private JButton searchButton;
    private JButton addButton;

    public Menu(){
        //-------------------------form configuration settings----------------------
        setTitle("MyZoo - Menu");
        setPreferredSize(new Dimension(800,600));
        setContentPane(menu);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);                                                //display form in center
        setVisible(true);

        //on button click event Add
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Add instance = Add.getInstance();
                instance.setVisible(true);
            }
        });
    }
}
