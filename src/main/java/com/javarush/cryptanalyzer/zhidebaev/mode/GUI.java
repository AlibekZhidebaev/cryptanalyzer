package com.javarush.cryptanalyzer.zhidebaev.mode;

import com.javarush.cryptanalyzer.zhidebaev.constants.FileConstants;
import com.javarush.cryptanalyzer.zhidebaev.repository.FunctionCode;
import com.javarush.cryptanalyzer.zhidebaev.run.Run;
import com.javarush.cryptanalyzer.zhidebaev.utilities.Validate;
import com.javarush.cryptanalyzer.zhidebaev.view.ConsoleView;
import com.javarush.cryptanalyzer.zhidebaev.view.GUIView;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.List;

public class GUI {
    private final JFrame frame;
    private final JPanel panel_decode, panel_decode_buttons;
    private JTextField txt_in_file, txt_out_file, keyField, decode_key_field;
    private JRadioButton radioButtonEncode, radioButtonDecode, radioButtonOtherDecode;
    private JButton buttonEncode, buttonDecode;
    private List<String> parameters;
    private int selectNumber;


    public GUI() {

//---------------------------------------------Фрейм------------------------------------------------------------

        frame = new JFrame("Шифратор и дешифратор");
        frame.setResizable(false);
        frame.getContentPane().setBackground(SystemColor.inactiveCaption);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));
        //frame.setSize(715, 500);
        frame.setSize(715, 215);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.isMaximumSizeSet();
        // frame.setDefaultCloseOperation(JFrame.);

//---------------------------------------------Панели------------------------------------------------------------
//---------------------------------------------Панель заголовок------------------------------------------------------------
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));
//---------------------------------------------Панель для выбора режима------------------------------------------------------------
        JPanel panel_mode = new JPanel();
        panel_mode.setBorder(new TitledBorder(null, "Режим работы", TitledBorder.CENTER, TitledBorder.TOP, null, null));
//---------------------------------------------Основная панель для шифрования файла------------------------------------------------------------
        JPanel panel_encode = new JPanel();
        panel_encode.setLayout(new BoxLayout(panel_encode, BoxLayout.Y_AXIS));
        panel_encode.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
                "Шифрование методом Цезаря",
                TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));

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

        panel_decode = new JPanel();
        panel_decode.setLayout(new BoxLayout(panel_decode, BoxLayout.X_AXIS));
        panel_decode.setBackground(UIManager.getColor("RadioButtonMenuItem.background"));
        panel_decode.setBorder(new TitledBorder(null, "Расшифровка текста",
                TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel_decode.setVisible(false);
//----------------------------------------Панель инструментов для расшифровки----------------------------------------------------------------------

        panel_decode_buttons = new JPanel();
        panel_decode_buttons.setLayout(new BoxLayout(panel_decode_buttons, BoxLayout.Y_AXIS));
        panel_decode_buttons.setVisible(false);

        JPanel panel_decode_brutforce = new JPanel();
        JPanel other_decode = new JPanel();


//----------------------------------------RadioButtons для режима выбора---------------------------------------------------------------------
        radioButtonEncode = new JRadioButton("Шифрование");
        radioButtonEncode.setSelected(true);
        radioButtonEncode.setActionCommand("modeEncode");

        radioButtonDecode = new JRadioButton("Дешифрование");
        radioButtonDecode.setActionCommand("modeDecode");

        radioButtonOtherDecode = new JRadioButton("Дешифрование Brut force и статистический анализатор");


//----------------------------------------Labels---------------------------------------------------------------------

        JLabel in_file = new JLabel("Исходный файл:    ");
        JLabel out_file = new JLabel("Файл назначения: ");
        JLabel keyText = new JLabel("Ключ: ");

//--------------------------------------Текстовые поля и области---------------------------------------------------------------
        txt_in_file = new JTextField();
        txt_in_file.setColumns(50);
        txt_in_file.setText(FileConstants.INPUT_FILE);

        txt_out_file = new JTextField();
        txt_out_file.setColumns(50);
        txt_out_file.setText(FileConstants.ENCODED_FILE);

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
        buttonEncode = new JButton("Зашифровать");
        buttonDecode = new JButton("Расшифровать");
        buttonDecode.setVisible(false);

//-------------------------------------------Добавление элементов в панель  выбора --------------------------------------------------------
        panel_mode.add(radioButtonEncode);
        panel_mode.add(radioButtonDecode);
        panel_mode.add(radioButtonOtherDecode);
//-------------------------------------------Добавление элементов в панель  входного файла --------------------------------------------------------

        panel_input_file.add(in_file);
        panel_input_file.add(txt_in_file);


//-------------------------------------------Добавление элементов в панель  выходного файла --------------------------------------------------------

        panel_output_file.add(out_file);
        panel_output_file.add(txt_out_file);

//-------------------------------------------Добавление элементов в панель  поля и кнопки шифрования-------------------------------------------------

        panel_key_and__encrypt_button.add(keyText);
        panel_key_and__encrypt_button.add(keyField);
        panel_key_and__encrypt_button.add(buttonEncode);
        panel_key_and__encrypt_button.add(buttonDecode);


//-------------------------------------------Добавление элементов в панель текстовой области для расшифрования---------------------------------------

        panel_decode.add(text_area_for_encode);

//------------------Полосы прокрутки для text area-------------------------------
        JScrollPane scrollPane = new JScrollPane(text_area_for_encode, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        panel_decode.add(scrollPane);

//-------------------------------------------Добавление элементов в панель дешифрования -----------------------------------------------------------

        panel_decode_brutforce.add(decode_key_field);
        panel_decode_brutforce.add(slider_for_decode);

//-------------------------------------------Добавление панелей в панель заголовка ----------------------------------------------------------------
        header.add(panel_mode);
        header.add(panel_encode);

//-------------------------------------------Добавление панелей на  панель шифрования, дешифрования -----------------------------------------------

        panel_encode.add(panel_input_file);
        panel_encode.add(panel_output_file);
        panel_encode.add(panel_key_and__encrypt_button);
        panel_decode_buttons.add(panel_decode_brutforce);
        panel_decode_buttons.add(other_decode);

//----------------------------------------Добавление панелей на Главную панель----------------------------------------------------------------------
        frame.getContentPane().add(header, BorderLayout.NORTH);
        frame.getContentPane().add(panel_decode, BorderLayout.CENTER);
        frame.getContentPane().add(panel_decode_buttons, BorderLayout.SOUTH);

//--------------События----------------------------------------------------------------------------------
        radioButtonEncode.addActionListener(e -> setSelectedEncode());
        radioButtonDecode.addActionListener(e -> setSelectedDecode());
        radioButtonOtherDecode.addActionListener(e -> setSelectedOtherDecode());

        buttonEncode.addActionListener(e -> selectNumber = 1);
        buttonDecode.addActionListener(e -> selectNumber = 2);

//--------------------------------------------------------------------------------------------------------------------------------------------------

        frame.setVisible(true);

        //-- 1111111111111111111111111111111111111111
        while (true) {
            // -- Проверка корректности ввода --
            //  int selectNumber = Validate.inputValidation(scan, 1, 5);

            // -- Поле выбора команд --
            switch (selectNumber) {
                case 1 ->
                        parameters = List.of(FunctionCode.ENCODE.toString(), txt_in_file.getText(), txt_out_file.getText(), keyField.getText());
                case 2 ->
                        parameters = List.of(FunctionCode.DECODE.toString(), txt_in_file.getText(), txt_out_file.getText(), keyField.getText());
                //   case 3 ->
                //        parameters = List.of(FunctionCode.BRUTEFORCE.toString(), txt_in_file.getText(), txt_out_file.getText());
                //  case 4 ->
                //           parameters = List.of(FunctionCode.STAT_ANALYSIS.toString(), txt_in_file.getText(), txt_out_file.getText());
            }
            // -- Передача выбранной команды в виде параметра в экземпляр класса ConsoleView --
            GUIView guiView = new GUIView(parameters);
            // -- Передача экземпляра класса ConsoleView в виде параметра в исполняющий класс Run (Запуск) --
            new Run(guiView);
        }
        // -- 1111111111111111111111111111111111111111
    }

    //-------------------------Методы---------------------------------------------------------------------
    void setSelectedEncode() {
        radioButtonDecode.setSelected(false);
        radioButtonOtherDecode.setSelected(false);
        buttonDecode.setVisible(false);
        buttonEncode.setVisible(true);
        frame.setSize(715, 215);
        frameResize();
    }

    void setSelectedDecode() {
        radioButtonEncode.setSelected(false);
        radioButtonOtherDecode.setSelected(false);
        buttonEncode.setVisible(false);
        buttonDecode.setVisible(true);
        frame.setSize(715, 215);
        frameResize();
    }

    void setSelectedOtherDecode() {
        radioButtonOtherDecode.setSelected(true);
        radioButtonEncode.setSelected(false);
        radioButtonDecode.setSelected(false);
        buttonEncode.setVisible(false);
        buttonDecode.setVisible(true);
        panel_decode.setVisible(true);
        panel_decode_buttons.setVisible(true);
        frame.setSize(715, 500);
        frameResize();
    }

    private void frameResize() {
        frame.setResizable(true);
        frame.setResizable(false);
    }

}
