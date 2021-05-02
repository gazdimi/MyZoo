package com.company.gazedimi.UI;

import com.company.gazedimi.Animal;

import javax.swing.*;
import java.awt.*;

public final class Edit extends JFrame{
    private JPanel editPanel;
    private JTextField code;
    private JTextField name;
    private JSpinner weight;
    private JSpinner max_age;
    private JComboBox animalClass;
    private JTextArea description;
    private JButton edit;
    private JButton deleteButton;

    //instance initializer
    {
        disableInfo();
    }

    //default constructor
    private Edit(){
        //-------------------------form configuration settings-----------------------
        setResizable(false);                                                         //no resize
        setTitle("MyZoo - Edit/View Animal");
        setPreferredSize(new Dimension(500, 400));
        setContentPane(editPanel);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);                                                //display form in center
        setVisible(true);
    }

    //overloaded constructor
    public Edit(Animal animal){
        this();                                                                     //call default constructor
        code.setText(String.valueOf(animal.getCode()));
        name.setText(String.valueOf(animal.getName()));
        weight.setValue(animal.getWeight());
        max_age.setValue(animal.getMax_age());
        animalClass.setSelectedItem(animal.getKind());
        description.setText(animal.getDescription());
        disableInfo();
    }

    private void disableInfo(){
        code.setEnabled(false);
        name.setEnabled(false);
        weight.setEnabled(false);
        max_age.setEnabled(false);
        animalClass.setEnabled(false);
        description.setEnabled(false);
        deleteButton.setEnabled(true);

        ((JSpinner.DefaultEditor) weight.getEditor()).getTextField().setDisabledTextColor(Color.decode("#636363"));
        ((JSpinner.DefaultEditor) max_age.getEditor()).getTextField().setDisabledTextColor(Color.decode("#636363"));
        UIManager.put( "ComboBox.disabledForeground", Color.decode("#636363") );
    }

    private void edit(){
        name.setEnabled(true);
        weight.setEnabled(true);
        max_age.setEnabled(true);
        description.setEnabled(true);
        edit.setText("Save");
        deleteButton.setEnabled(false);
    }
}
