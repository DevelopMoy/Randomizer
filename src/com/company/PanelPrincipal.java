package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Stack;


public class PanelPrincipal extends JPanel {
    private Stack<String> tasksStack = new Stack<>();
    private ArrayList <String> usersArray =new ArrayList<>();
    private JTextArea tasksArea =new JTextArea(1,27);
    private JTextArea usersArea =new JTextArea(1,5);
    private JButton buttonTask =new JButton("ADD NEW TASK");
    private JButton buttonUser =new JButton("ADD USER");
    private JButton randomButton = new JButton("RANDOMIZE !");
    private Component thisComp=this;


    public PanelPrincipal (){
        super.setLayout(new GridLayout(2,2));
        add (new PanelTasks());
        addActionToButtons();
        add (new RandomPanel());

    }

    private class RandomPanel extends JPanel {
        public RandomPanel (){
            randomButton.setPreferredSize(new Dimension(250,60));
            randomButton.setForeground(Color.RED);
            randomButton.setBackground(Color.WHITE);
            randomButton.addActionListener(new MainAction());
            add (randomButton);
        }
    }

    private class MainAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (tasksStack.isEmpty()||usersArray.isEmpty()){
                JOptionPane.showMessageDialog(thisComp,"ERROR, USERS OR TASKS ARRAY IS EMPTY");
            }else {
                //MAIN ACTION
            }
        }
    }



    private void addActionToButtons(){
        buttonTask.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (tasksArea.getText().compareTo("")!=0){
                    tasksStack.push(tasksArea.getText());
                    tasksArea.setText("");
                }
            }
        });

        buttonUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (usersArea.getText().compareTo("")!=0){
                    usersArray.add(usersArea.getText());
                    usersArea.setText("");
                }
            }
        });
    }

    private class PanelTasks extends JPanel{
        public PanelTasks (){
            initialConfig();
        }

        private void initialConfig (){
            setLayout(new GridLayout(2,2,20,20));
            add(tasksArea);
            add(buttonTask);
            add (usersArea);
            add (buttonUser);
            tasksArea.setFont(new Font(tasksArea.getFont().getName(),Font.BOLD,19));
            tasksArea.setLineWrap(true);
            usersArea.setFont(new Font(tasksArea.getFont().getName(),Font.BOLD,19));
            usersArea.setLineWrap(true);
        }
    }


}
