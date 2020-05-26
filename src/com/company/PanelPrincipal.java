package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;

public class PanelPrincipal extends JPanel {
    private Stack<String> tasksStack = new Stack<>();
    private LinkedList<String> usersArray =new LinkedList<>();
    private JTextField tasksArea =new JTextField(27);
    private JTextField usersArea =new JTextField(5);
    private JButton buttonTask =new JButton("ADD NEW TASK");
    private JButton buttonUser =new JButton("ADD USER");
    private JButton randomButton = new JButton("RANDOMIZE !");
    private Component thisComp=this;
    private JTextArea outputArea=new JTextArea(5,50);
    private JScrollPane scrollOut=new JScrollPane(outputArea);


    public PanelPrincipal (){
        super.setLayout(new BorderLayout());
        add(new InputArea(),BorderLayout.CENTER);
        add(scrollOut,BorderLayout.SOUTH);
        addActionToButtons();
    }

    private class InputArea extends JPanel {
        public InputArea (){
            super.setLayout(new GridLayout(3,2));
            add (new PanelTasks());
            add (new RandomPanel());
        }
    }

    private class RandomPanel extends JPanel {
        public RandomPanel (){
            randomButton.setPreferredSize(new Dimension(250,30));
            randomButton.setForeground(Color.RED);
            randomButton.setBackground(Color.WHITE);
            randomButton.addActionListener(new MainAction());
            add (randomButton);
        }
    }

    private class MainAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            LinkedList <String> aux;
            String text="";
            Random rand=new Random();
            if (tasksStack.isEmpty()||usersArray.isEmpty()){
                JOptionPane.showMessageDialog(thisComp,"ERROR, USERS OR TASKS ARRAY IS EMPTY");
            }else {
                while (!tasksStack.isEmpty()){
                    aux=(LinkedList<String>) usersArray.clone();
                    while (!aux.isEmpty()&&!tasksStack.isEmpty()){
                        int indice = rand.nextInt(aux.size());
                        text+=tasksStack.pop()+" -> "+aux.get(indice)+"  \n";
                        outputArea.setText(text);
                        aux.remove(indice);
                    }
                }
                usersArray=new LinkedList<>();
                tasksStack=new Stack<>();
            }
        }
    }



    private void addActionToButtons(){
        buttonTask.addActionListener(new AccionTask());
        buttonUser.addActionListener(new AccionUser());
        tasksArea.addActionListener(new AccionTask());
        usersArea.addActionListener(new AccionUser());
    }

    private class AccionUser implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            if (usersArea.getText().compareTo("")!=0){
                usersArray.add(usersArea.getText());
                usersArea.setText("");
            }
        }
    }

    private class AccionTask implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            if (tasksArea.getText().compareTo("")!=0){
                tasksStack.push(tasksArea.getText());
                tasksArea.setText("");
            }
        }
    }

    private class PanelTasks extends JPanel{
        public PanelTasks (){
            initialConfig();
        }

        private void initialConfig (){
            setLayout(new GridLayout(2,2,5,5));
            add(tasksArea);
            add(buttonTask);
            add (usersArea);
            add (buttonUser);
            tasksArea.setFont(new Font(tasksArea.getFont().getName(),Font.BOLD,16));
            usersArea.setFont(new Font(tasksArea.getFont().getName(),Font.BOLD,16));
            outputArea.setLineWrap(true);
            outputArea.setFont(tasksArea.getFont());
            outputArea.setEditable(false);
        }
    }
}
