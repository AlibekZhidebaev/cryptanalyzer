package com.javarush.cryptanalyzer.zhidebaev.mode;

import com.javarush.cryptanalyzer.zhidebaev.constants.FileConstants;
import com.javarush.cryptanalyzer.zhidebaev.repository.FunctionCode;
import com.javarush.cryptanalyzer.zhidebaev.run.Run;
import com.javarush.cryptanalyzer.zhidebaev.utilities.ReadingFromFile;
import com.javarush.cryptanalyzer.zhidebaev.view.GUIView;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GUI {
    private final JFrame frame;
    private final JPanel panel_decode_text_area;
    private final JPanel panel_other_decode_mode;
    private final JTextField txt_in_file;
    private final JTextField txt_out_file;
    private final JTextField keyField;
    private final JTextArea text_area_for_encode;
    private final JLabel keyText;
    private final JRadioButton radioButtonEncode, radioButtonDecode, radioButtonOtherDecode;
    private final JButton buttonEncode;
    private final JButton buttonDecode;
    private final JButton buttonBruteForce;
    private final JButton buttonStatAnalysis;
    private final JButton downloadTextInArea;


    public GUI() {

//---------------------------------------------Фрейм------------------------------------------------------------

        frame = new JFrame("Шифратор и дешифратор");
        frame.setResizable(false);
        frame.getContentPane().setBackground(SystemColor.inactiveCaption);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));
        frame.setSize(715, 215);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


//--------------------------------------------------ПАНЕЛИ--------------------------------------------------------------
//---------------------------------------------Панель заголовок---------------------------------------------------------
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));
//---------------------------------------------Панель для выбора режима-------------------------------------------------
        JPanel panel_mode = new JPanel();
        panel_mode.setBorder(new TitledBorder(null, "Режим работы", TitledBorder.CENTER, TitledBorder.TOP, null, null));
//---------------------------------------------Основная панель для шифрования файла-------------------------------------
        JPanel panel_encode = new JPanel();
        panel_encode.setLayout(new BoxLayout(panel_encode, BoxLayout.Y_AXIS));
        panel_encode.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
                "Шифрование методом Цезаря",
                TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));

//---------------------------------------------Панель для входного файла------------------------------------------------
        JPanel panel_input_file = new JPanel();
        FlowLayout fl_panel_input_file = (FlowLayout) panel_input_file.getLayout();
        fl_panel_input_file.setAlignment(FlowLayout.LEFT);

//---------------------------------------------Панель для файла назначения----------------------------------------------

        JPanel panel_output_file = new JPanel();
        FlowLayout fl_panel_output_file = (FlowLayout) panel_output_file.getLayout();
        fl_panel_output_file.setAlignment(FlowLayout.LEFT);

//---------------------------------------------Панель для ключа и кнопки шифрования-------------------------------------

        JPanel panel_key_and_encrypt_button = new JPanel();
        panel_key_and_encrypt_button.setBorder(BorderFactory.createEtchedBorder());
        FlowLayout fl_panel_key_and_encode_button = (FlowLayout) panel_key_and_encrypt_button.getLayout();
        fl_panel_key_and_encode_button.setAlignment(FlowLayout.LEFT);

//---------------------------------------------Панель для  текстового поля----------------------------------------------

        panel_decode_text_area = new JPanel();
        panel_decode_text_area.setLayout(new BoxLayout(panel_decode_text_area, BoxLayout.X_AXIS));
        panel_decode_text_area.setBackground(UIManager.getColor("RadioButtonMenuItem.background"));
        panel_decode_text_area.setBorder(new TitledBorder(null, "Расшифровка текста",
                TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel_decode_text_area.setVisible(false);

//----------------------------------------Панель инструментов для расшифровки-------------------------------------------

        panel_other_decode_mode = new JPanel();
        panel_other_decode_mode.setLayout(new BoxLayout(panel_other_decode_mode, BoxLayout.Y_AXIS));
        panel_other_decode_mode.setVisible(false);

        JPanel panel_decode_brute_force = new JPanel();
        panel_decode_brute_force.setBorder(BorderFactory.createEtchedBorder());
        FlowLayout fl_panel_decode_brute_force = (FlowLayout) panel_decode_brute_force.getLayout();
        fl_panel_decode_brute_force.setAlignment(FlowLayout.LEFT);
        JPanel other_decode = new JPanel();
        other_decode.setBorder(BorderFactory.createEtchedBorder());
        FlowLayout fl_other_decode = (FlowLayout)  other_decode.getLayout();
        fl_other_decode.setAlignment(FlowLayout.LEFT);

//----------------------------------------RadioButtons для режима выбора------------------------------------------------

        radioButtonEncode = new JRadioButton("Шифрование");
        radioButtonEncode.setSelected(true);
        radioButtonEncode.setActionCommand("modeEncode");

        radioButtonDecode = new JRadioButton("Дешифрование");
        radioButtonDecode.setActionCommand("modeDecode");
        radioButtonOtherDecode = new JRadioButton("Дешифрование Brute force и статистический анализатор");

//----------------------------------------Labels------------------------------------------------------------------------

        JLabel in_file = new JLabel("Исходный файл:    ");
        JLabel out_file = new JLabel("Файл назначения: ");
        keyText = new JLabel();

//--------------------------------------Текстовые поля и области--------------------------------------------------------
        txt_in_file = new JTextField();
        txt_in_file.setColumns(50);

        txt_out_file = new JTextField();
        txt_out_file.setColumns(50);

        keyField = new JTextField();
        keyField.setText("1");
        keyField.setColumns(4);

        text_area_for_encode = new JTextArea();
        text_area_for_encode.setWrapStyleWord(true);
        text_area_for_encode.setBorder(new EmptyBorder(3, 3, 3, 3));
        text_area_for_encode.setLineWrap(true);

//-------------------------------------------------Кнопки---------------------------------------------------------------
        buttonEncode = new JButton("Зашифровать");
        buttonDecode = new JButton("Расшифровать");
        buttonBruteForce = new JButton("Brute force");
        buttonStatAnalysis = new JButton("Статистический анализатор");
        downloadTextInArea = new JButton("Загрузить текст с файла в поле");

//-------------------------------------------Добавление элементов в панель  выбора -------------------------------------
        panel_mode.add(radioButtonEncode);
        panel_mode.add(radioButtonDecode);
        panel_mode.add(radioButtonOtherDecode);
//-------------------------------------------Добавление элементов в панель  входного файла -----------------------------
        panel_input_file.add(in_file);
        panel_input_file.add(txt_in_file);
//-------------------------------------------Добавление элементов в панель  выходного файла ----------------------------
        panel_output_file.add(out_file);
        panel_output_file.add(txt_out_file);
//-------------------------------------------Добавление элементов в панель поля и кнопки шифрования--------------------

        panel_key_and_encrypt_button.add(keyText);
        panel_key_and_encrypt_button.add(keyField);
        panel_key_and_encrypt_button.add(buttonEncode);
        panel_key_and_encrypt_button.add(buttonDecode);
        panel_key_and_encrypt_button.add(downloadTextInArea);

//-------------------------------------------Добавление элементов в панель текстовой области для расшифрования----------

        panel_decode_text_area.add(text_area_for_encode);

//------------------Полосы прокрутки для text area-------------------------------

        JScrollPane scrollPane = new JScrollPane(text_area_for_encode, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        panel_decode_text_area.add(scrollPane);

//-------------------------------------------Добавление элементов в панель дешифрования --------------------------------

        panel_decode_brute_force.add(buttonBruteForce);
        other_decode.add(buttonStatAnalysis);

//-------------------------------------------Добавление панелей в панель заголовка -------------------------------------

        header.add(panel_mode);
        header.add(panel_encode);

//-------------------------------------------Добавление панелей на панель шифрования, дешифрования --------------------

        panel_encode.add(panel_input_file);
        panel_encode.add(panel_output_file);
        panel_encode.add(panel_key_and_encrypt_button);
        panel_other_decode_mode.add(panel_decode_brute_force);
        panel_other_decode_mode.add(other_decode);

//----------------------------------------Добавление панелей на Главную панель------------------------------------------
        frame.getContentPane().add(header, BorderLayout.NORTH);
        frame.getContentPane().add(panel_decode_text_area, BorderLayout.CENTER);
        frame.getContentPane().add(panel_other_decode_mode, BorderLayout.SOUTH);

//----------------------------------------------События-----------------------------------------------------------------

        radioButtonEncode.addActionListener(e -> setSelectedEncode());
        radioButtonDecode.addActionListener(e -> setSelectedDecode());
        radioButtonOtherDecode.addActionListener(e -> setSelectedOtherDecode());

        buttonEncode.addActionListener(e -> setParameters(FunctionCode.ENCODE.toString()));
        buttonDecode.addActionListener(e -> setParameters(FunctionCode.DECODE.toString()));
        buttonBruteForce.addActionListener(e -> setParameters(FunctionCode.BRUTEFORCE.toString()));
        buttonStatAnalysis.addActionListener(e -> setParameters(FunctionCode.STAT_ANALYSIS.toString()));
        downloadTextInArea.addActionListener(e -> getDownloadTextInArea(txt_in_file.getText()));
//----------------------------------------------------------------------------------------------------------------------

        setSelectedEncode();
        frame.setVisible(true);
    }

//-------------------------------------------Методы---------------------------------------------------------------------
    void setSelectedEncode() {
        radioButtonDecode.setSelected(false); radioButtonOtherDecode.setSelected(false);
        txt_in_file.setText(FileConstants.INPUT_FILE); txt_out_file.setText(FileConstants.ENCODED_FILE);
        keyText.setText("Ключ: ");keyField.setVisible(true);
        buttonDecode.setVisible(false); buttonEncode.setVisible(true);downloadTextInArea.setVisible(false);
        panel_other_decode_mode.setVisible(false);
        buttonBruteForce.setEnabled(false);buttonStatAnalysis.setEnabled(false);
        frame.setSize(715, 215);
        frameResize();
    }

    void setSelectedDecode() {
        radioButtonEncode.setSelected(false); radioButtonOtherDecode.setSelected(false);
        txt_in_file.setText(FileConstants.ENCODED_FILE); txt_out_file.setText(FileConstants.OUTPUT_FILE);
        keyText.setText("Ключ: "); keyField.setVisible(true);
        buttonEncode.setVisible(false); buttonDecode.setVisible(true);downloadTextInArea.setVisible(false);
        panel_other_decode_mode.setVisible(false);
        buttonBruteForce.setEnabled(false);buttonStatAnalysis.setEnabled(false);
        frame.setSize(715, 215);
        frameResize();
    }

    void setSelectedOtherDecode() {
        radioButtonOtherDecode.setSelected(true); radioButtonEncode.setSelected(false); radioButtonDecode.setSelected(false);
        txt_in_file.setText(FileConstants.ENCODED_FILE); txt_out_file.setText(FileConstants.OUTPUT_FILE);
        text_area_for_encode.selectAll(); text_area_for_encode.replaceSelection("");
        keyText.setText(""); keyField.setVisible(false);
        buttonEncode.setVisible(false); buttonDecode.setVisible(false);downloadTextInArea.setVisible(true);
        panel_decode_text_area.setVisible(true);
        panel_other_decode_mode.setVisible(true);
        buttonBruteForce.setEnabled(false);buttonStatAnalysis.setEnabled(false);
        frame.setSize(715, 500);
        frameResize();
    }

    private void frameResize() {
        frame.setResizable(true);
        frame.setResizable(false);
    }

    private void getDownloadTextInArea(String pathFile){
        text_area_for_encode.selectAll(); text_area_for_encode.replaceSelection("");
        buttonBruteForce.setEnabled(true);buttonStatAnalysis.setEnabled(true);
        text_area_for_encode.append(new ReadingFromFile(pathFile).getFileAsString());
        text_area_for_encode.setCaretPosition(1);

    }
    private void setParameters(String command) {
        List<String> parameters = new ArrayList<>(List.of(command, txt_in_file.getText(), txt_out_file.getText()));
        if (command.equals(FunctionCode.ENCODE.toString()) || command.equals(FunctionCode.DECODE.toString()))
            parameters.add(keyField.getText());
        // -- Передача выбранной команды в виде параметра в экземпляр класса ConsoleView --
        GUIView guiView = new GUIView(parameters);
        // -- Передача экземпляра класса ConsoleView в виде параметра в исполняющий класс Run (Запуск) --
        new Run(guiView);
        if (command.equals(FunctionCode.BRUTEFORCE.toString()) || command.equals(FunctionCode.STAT_ANALYSIS.toString()))
            getDownloadTextInArea(txt_out_file.getText());
    }


}
