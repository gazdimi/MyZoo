package com.company.gazedimi.UI;

import com.company.gazedimi.Animal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static com.company.gazedimi.Zoo.animals;

public final class Menu extends JFrame{
    private JPanel menu;
    private JTextField userInput;
    private JComboBox filters;
    private JButton searchButton;
    private JButton addButton;
    private JScrollPane results;

    public Menu(){
        //-------------------------form configuration settings----------------------
        setTitle("MyZoo - Menu");
        setPreferredSize(new Dimension(800,600));
        search(3);                                                       //at first display all available animals
        setContentPane(menu);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);                                                //display form in center
        setVisible(true);

        //on button click event Add
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Add instance = Add.getInstance();                                   //add form
                instance.setVisible(true);
            }
        });

        //on button click event search using filters
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (filters.getSelectedItem().toString()){                //search animal using filters - combobox
                    case "By name":
                        search(1);
                        break;
                    case  "By code":
                        search(2);
                        break;
                    case "All":
                        search(3);
                        break;
                }
            }
        });
    }

    private void search(int option){
        String input = userInput.getText();                                             //input from searchbar
        if(animals.size()!=0){

            //construct dynamically results
            List<JButton> buttons = new ArrayList<>();
            JPanel content = new JPanel();
            content.setLayout(new GridLayout(animals.size(), 1));                   //rows, 1 column
            int i = 0;
            boolean op1 = false; boolean op2 = false; boolean op3 = false;
            for (Animal animal : animals){
                if(option==1){                                                          //by name
                    op1 = input.equals(animal.getName());
                }else if(option==2){                                                    //by code
                    try {
                        op2 = Integer.valueOf(input)==animal.getCode();
                    }catch (Exception e){
                        JOptionPane.showMessageDialog(Menu.this,"Please enter valid code");
                        return;
                    }
                }else {                                                                 //all available animals
                    op3 = true;
                }
                if(op1 || op2 || op3){
                    buttons.add(new JButton(animal.getName()));
                    buttons.get(i).setFont(new Font("Cambria",Font.BOLD,18));
                    buttons.get(i).setFocusable(false);

                    //on button click event search result
                    buttons.get(i).addActionListener(new ActionListener() {          //create listener for each button
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            new Edit(animal);                                       //pass animal instance
                        }
                    });
                    content.add(buttons.get(i));
                    i++;
                }
            }
            results.setViewportView(content);                                         //add buttons list to JScrollPane
            if(buttons.size()==0){
                JOptionPane.showMessageDialog(Menu.this,"No available animals!");
            }
        }
    }
}
