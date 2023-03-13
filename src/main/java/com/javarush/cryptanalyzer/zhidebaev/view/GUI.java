package com.javarush.cryptanalyzer.zhidebaev.view;

import javax.swing.*;

import static java.awt.TextArea.SCROLLBARS_VERTICAL_ONLY;

public class GUI extends JFrame {
    private JTextField txtKey;
    private JTextArea txtIn;
    private JTextArea txtOut;
    private JScrollPane scrollPane;
    public GUI(){
        setSize(600,400);
    setTitle("Dr. Payne's Secret Message App");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setLayout(null);

    txtIn = new JTextArea(); //          JTextArea
    txtIn.setBounds(10, 11, 564, 140);
         scrollPane = new JScrollPane(txtIn);
       // scrollPane.setViewportView(txtIn);
       // scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
   getContentPane().add(txtIn);
      getContentPane().add(scrollPane);
    txtOut = new JTextArea(); //          JTextArea
    txtOut.setBounds(10, 210, 564, 140);
    getContentPane().add(txtOut);
        txtKey = new JTextField();
        txtKey.setBounds(258, 173, 44, 20);
        getContentPane().add(txtKey);
        JLabel lblKey = new JLabel("Key:");
        lblKey.setBounds(202, 176, 46, 14);
        getContentPane().add(lblKey);
        JButton btnEncodedecode = new JButton("Encode/Decode");
        btnEncodedecode.setBounds(312, 172, 144, 23);
        getContentPane().add(btnEncodedecode);

        setVisible(true);

    }
}
