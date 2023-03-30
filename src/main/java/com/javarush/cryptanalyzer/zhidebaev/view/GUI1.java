package com.javarush.cryptanalyzer.zhidebaev.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class GUI1 {

    private JTextField txt_in_file, txt_out_file , keyField, decode_key_field;

    public GUI1(){

//---------------------------------------------Фрейм------------------------------------------------------------

        JFrame frame = new JFrame("Шифратор и дешифратор");
        frame.setResizable(false);
        frame.getContentPane().setBackground(SystemColor.inactiveCaption);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));
        frame.setSize(715, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//---------------------------------------------Панели------------------------------------------------------------

//---------------------------------------------Основная панель для шифрования файла------------------------------------------------------------
        JPanel panel_encode = new JPanel();
        panel_encode.setLayout(new BoxLayout(panel_encode, BoxLayout.Y_AXIS));
        panel_encode.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
                "\u0428\u0438\u0444\u0440\u043E\u0432\u0430\u043D\u0438\u0435 \u043C\u0442\u043E\u0434\u043E\u043C \u0426\u0435\u0437\u0430\u0440\u044F",
                TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));

//---------------------------------------------Панель для выбора режима------------------------------------------------------------
        JPanel program_operation_mode = new JPanel();
        FlowLayout fl_program_operation_mode = (FlowLayout) program_operation_mode.getLayout();
        fl_program_operation_mode.setAlignment(FlowLayout.LEFT);


//---------------------------------------------Панель для входного файла------------------------------------------------------------
        JPanel panel_input_file = new JPanel();
        FlowLayout fl_panel_input_file = (FlowLayout) panel_input_file.getLayout();
        fl_panel_input_file.setAlignment(FlowLayout.LEFT);

//---------------------------------------------Панель для файла назначения------------------------------------------------------------

        JPanel panel_output_file = new JPanel();
        FlowLayout fl_panel_output_file = (FlowLayout) panel_output_file.getLayout();
        fl_panel_output_file.setAlignment(FlowLayout.LEFT);

//---------------------------------------------Панель для ключа и кнопки шифрования---------------------------------------------------------------

        JPanel panel_key_and__encrypt_button = new JPanel();
        FlowLayout fl_panel_key_and_encode_button = (FlowLayout) panel_key_and__encrypt_button.getLayout();
        fl_panel_key_and_encode_button.setAlignment(FlowLayout.LEFT);

//---------------------------------------------Панель для  текстового поля----------------------------------------------------------------------

        JPanel panel_decode = new JPanel();
        panel_decode.setLayout(new BoxLayout(panel_decode, BoxLayout.X_AXIS));
        panel_decode.setBackground(UIManager.getColor("RadioButtonMenuItem.background"));
        panel_decode.setBorder(new TitledBorder(null, "\u0420\u0430\u0441\u0448\u0438\u0444\u0440\u043E\u0432\u043A\u0430 \u0442\u0435\u043A\u0441\u0442\u0430",
                TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));

//----------------------------------------Панель инструментов для расшифровки----------------------------------------------------------------------

        JPanel panel_decode_buttons = new JPanel();
        panel_decode_buttons.setLayout(new BoxLayout(panel_decode_buttons, BoxLayout.Y_AXIS));

        JPanel panel_decode_brutforce = new JPanel();
        JPanel other_decode = new JPanel();


//----------------------------------------Labels---------------------------------------------------------------------

        JLabel in_file = new JLabel("Исходный файл:    ");
        JLabel out_file = new JLabel("Файл назначения: ");
        JLabel keyText = new JLabel("Ключ: ");

//--------------------------------------Текстовые поля и области---------------------------------------------------------------
        txt_in_file = new JTextField();
        txt_in_file.setColumns(50);
        txt_in_file.setText("\\files\\input.txt");

        txt_out_file = new JTextField();
        txt_out_file.setColumns(50);
        txt_out_file.setText("\\files\\output.txt");

        keyField = new JTextField();
        keyField.setText("0");
        keyField.setColumns(4);

        JTextArea text_area_for_encode = new JTextArea();
        text_area_for_encode.setWrapStyleWord(true);
        text_area_for_encode.setBorder(new EmptyBorder(3, 3, 3, 3));
        text_area_for_encode.setLineWrap(true);

        decode_key_field = new JTextField();
        decode_key_field.setFont(new Font("Tahoma", Font.PLAIN, 14));
        decode_key_field.setText("0");
        decode_key_field.setColumns(3);

//-------------------------------------------------Ползунок----------------------------------------------------------------------------

        JSlider slider_for_decode = new JSlider();
        slider_for_decode.setValue(0);
        slider_for_decode.setToolTipText("");
        slider_for_decode.setSnapToTicks(true);
        slider_for_decode.setPaintTicks(true);
        slider_for_decode.setPaintLabels(true);
        slider_for_decode.setMinorTickSpacing(7);
        slider_for_decode.setMaximum(84);
        slider_for_decode.setMajorTickSpacing(21);

//-------------------------------------------------Кнопки----------------------------------------------------------------------------
        JButton encode = new JButton("Зашифровать");

//-------------------------------------------Добавление элементов в панель  входного файла --------------------------------------------------------

        panel_input_file.add(in_file);
        panel_input_file.add(txt_in_file);


//-------------------------------------------Добавление элементов в панель  выходного файла --------------------------------------------------------

        panel_output_file.add(out_file);
        panel_output_file.add(txt_out_file);

//-------------------------------------------Добавление элементов в панель  поля и кнопки шифрования-------------------------------------------------

        panel_key_and__encrypt_button.add(keyText);
        panel_key_and__encrypt_button.add(keyField);
        panel_key_and__encrypt_button.add(encode);

//-------------------------------------------Добавление элементов в панель текстовой области для расшифрования---------------------------------------

        panel_decode.add(text_area_for_encode);
//------------------Полосы прокрутки для text area-------------------------------
        JScrollPane scrollPane = new JScrollPane(text_area_for_encode,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        panel_decode.add(scrollPane);

//-------------------------------------------Добавление элементов в панель дешифрования -----------------------------------------------------------

        panel_decode_brutforce.add(decode_key_field);
        panel_decode_brutforce.add(slider_for_decode);

//-------------------------------------------Добавление панелей на  панель шифрования, дешифрования -----------------------------------------------


        panel_encode.add(panel_input_file);
        panel_encode.add(panel_output_file);
        panel_encode.add(panel_key_and__encrypt_button);

        panel_decode_buttons.add(panel_decode_brutforce);
        panel_decode_buttons.add(other_decode);

//----------------------------------------Добавление панелей на Главную панель----------------------------------------------------------------------
        frame.getContentPane().add(program_operation_mode, BorderLayout.NORTH);
        frame.getContentPane().add(panel_encode, BorderLayout.NORTH);
        frame.getContentPane().add(panel_decode, BorderLayout.CENTER);
        frame.getContentPane().add(panel_decode_buttons, BorderLayout.SOUTH);

//--------------------------------------------------------------------------------------------------------------------------------------------------

        frame.setVisible(true);
    }
}