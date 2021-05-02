package com.company.gazedimi.UI;

import com.company.gazedimi.Animal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static com.company.gazedimi.Zoo.animals;

public final class Add extends JFrame {

    private static Add INSTANCE = null;
    private JPanel addPanel;

    private JTextField code;
    private JTextField name;
    private JComboBox animalClass;
    private JSpinner weight;
    private JSpinner maxAge;
    private JTextArea description;
    private SpinnerNumberModel numberModel = new SpinnerNumberModel(0.0,0.0 ,500000.0,0.1);

    private JButton addAnimal;
    private String availableCode;

    //instance initializer
    {
        availableCode = autocomplete();
    }

    private Add() {
        INSTANCE = this;
        //-------------------------form configuration settings-----------------------
        setResizable(false);                                                         //no resize
        setTitle("MyZoo - Add Animal");
        setPreferredSize(new Dimension(500, 400));
        setContentPane(addPanel);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        weight.setModel(numberModel);
        pack();
        setLocationRelativeTo(null);                                                                                        //display form in center
        code.setText(availableCode);
        setVisible(true);

        //on button click event for adding a new animal
        addAnimal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //check for valid code
                boolean invalidCode = checkCode(Integer.valueOf(code.getText()));
                if(invalidCode || code.getText().equals("")){
                    JOptionPane.showMessageDialog(Add.this,"Please select another code.");          //dialog window
                }else {
                    //check for valid name
                    if(name.getText().equals("")){
                        JOptionPane.showMessageDialog(Add.this,"Please give a name.");
                    }
                    if(Animal.checkExistence(code.getText(), name.getText(), (String) animalClass.getSelectedItem(), Double.valueOf(weight.getValue().toString()), Integer.valueOf(maxAge.getValue().toString()), description.getText())){
                        StringBuffer message = new StringBuffer();
                        message.append(name.getText()).append(" already exists, please add another animal!\n");
                        JOptionPane.showMessageDialog(Add.this,message);                                        //dialog window
                    }
                }

                setVisible(false);
                clear();
            }
        });
    }

    //-----------------------singleton for displaying only one add-form------------
    public static Add getInstance(){
        if (INSTANCE != null){
            return INSTANCE;
        }
        return new Add();
    }

    private String autocomplete(){
        if(animals.size()!=0) {
            int previous_code = animals.get(0).getCode();
            for (int i = 1; i < animals.size(); i++) {
                int current_code = animals.get(i).getCode();
                if (current_code - previous_code != 1) {              //return available code (case of deleting animal)
                    return Integer.toString(i);
                }else if(i+1 == animals.size()){                                    //return next code
                    return Integer.toString(i+1);
                }
                previous_code = current_code;
            }
        }
        return Integer.toString(0);                                             //no available animals in list
    }

    private boolean checkCode(int code){
        for (Animal a : animals){
            if(code==a.getCode()){
                return true;
            }
        }
        return false;
    }

    private void clear(){
        availableCode = autocomplete();
        code.setText(availableCode);
        name.setText("");
        weight.setValue(0);
        maxAge.setValue(0);
        animalClass.setSelectedItem("Mammals");
        description.setText("Enter description...");
    }
}
