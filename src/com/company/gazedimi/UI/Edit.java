package com.company.gazedimi.UI;

import com.company.gazedimi.Animal;
import com.company.gazedimi.Zoo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static com.company.gazedimi.Zoo.animals;

public final class Edit extends JFrame{
    private Animal animal;
    private JPanel editPanel;
    private JTextField code;
    private JTextField name;
    private JSpinner weight;
    private JSpinner max_age;
    private JComboBox animalClass;
    private JTextArea description;
    private JButton edit;
    private JButton deleteButton;
    private boolean flag = false;                                                   //switcher for edit / save

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

        //on button click event for editing an existing animal
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!flag) {
                    flag = true;                                                   //enable editing
                }else{
                    flag = false;
                }
                edit();
            }
        });
        //on button click event for deleting an existing animal
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                animals.remove(animal);                                             //delete animal
                Zoo.serialize(animals,"res/animals.ser");                   //update registration file
                dispose();
            }
        });
    }

    //overloaded constructor
    public Edit(Animal animal){
        this();                                                                     //call default constructor
        this.animal = animal;
        code.setText(String.valueOf(animal.getCode()));
        name.setText(String.valueOf(animal.getName()));
        weight.setValue(animal.getWeight());
        max_age.setValue(animal.getMax_age());
        animalClass.setSelectedItem(animal.getKind());
        description.setText(animal.getDescription());
        disableInfo();                                                       //disable fields while edit is disabled
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
        if(flag) {                                                                  //edit
            name.setEnabled(true);
            weight.setEnabled(true);
            max_age.setEnabled(true);
            description.setEnabled(true);
            edit.setText("Save");
            deleteButton.setEnabled(false);
        }else{                                                                     //save
            //check for valid name
            if(name.getText().equals("")){
                JOptionPane.showMessageDialog(Edit.this,"Please give a name.");
            }
            if(exists()){
                StringBuffer message = new StringBuffer();
                message.append(name.getText()).append("Invalid name, please modify the animal name!\n");
                JOptionPane.showMessageDialog(Edit.this,message);   //dialog window
            }else{
                modify();
                Zoo.serialize(animals,"res/animals.ser");                 //update registration file
                dispose();
            }
        }
    }

    private boolean exists(){                                                   //check if animal name already exists
        for(Animal animal : animals){
            if(animal.getName().equals(name.getText())){
                return true;
            }
        }
        return false;
    }

    private void modify(){                                                              //store the changes
        animal.setName(name.getText());
        animal.setWeight(Double.valueOf(weight.getValue().toString()));
        animal.setMax_age(Integer.valueOf(max_age.getValue().toString()));
        animal.setDescription(description.getText());
    }
}
