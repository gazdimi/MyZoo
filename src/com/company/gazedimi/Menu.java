package com.company.gazedimi;

import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame{
    private JPanel menu;
    private JButton display;
    private JButton add;
    private JButton search_name;
    private JButton search_code;
    private JButton edit;
    private JButton delete;
    private JButton exit;

    public Menu(){
        //-------------------------form configuration settings----------------------
        setTitle("MyZoo - Menu");
        setPreferredSize(new Dimension(500,600));
        setContentPane(menu);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);                                                //display form in center
        setVisible(true);
    }
}
