package jediOrganizer.view;

import jediOrganizer.model.Jedi;
import jediOrganizer.model.ZakonJedi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JediOrganizer_JPanel extends JPanel {

   public JLabel jLabel_ZakonJedi_title, jLabel_Jedi_title, jLabel_ZakonJedi_rejestracja, jLabel_Jedi_rejestracja,
            jLabel_ZakonJedi_nazwa, jLabel_Jedi_name, jLabel_Jedi_kolorMiecza, jLabel_Jedi_moc, jLabel_Jedi_side;

    public static JList<String> jListOfZakon, jListOfJedi;
   public static DefaultListModel<String> defaultListModelForZakon, defaultListModelForJedi;

    public JTextField jTextField_ZakonJedi_nazwa, jTextField_Jedi_nazwa;

    protected static JList<String> jListOfNonRegisteredJedi;
    protected static DefaultListModel<String> defaultListModelForNonRegisteredJedi;


    protected JComboBox<String> jComboBoxSwordColor;
    protected JSlider jSliderPower;
    protected JRadioButton jRadioButtonLight, jRadioButtonDark;

    protected JTextField jTextField_ZakonJedi_File,jTextField_Jedi_File;
    protected JButton jButton_ZakonJedi_add, jButton_ZakonJedi_import, jButton_ZakonJedi_export;
    protected JButton jButton_Jedi_import, jButton_Jedi_export;
    protected JButton jButton_ZakonJedi_register, jButton_ZakonJedi_wipe, jButton_Jedi_register, jButton_Jedi_wipe;

    protected static JList<String> fillDefaultListModelForZakon() {
        defaultListModelForZakon.clear();
        int counter=1;
        for (ZakonJedi zakonJedi : ZakonJedi.getListOfZakony()) {
            defaultListModelForZakon.addElement(""+counter++ +zakonJedi.toString());
        }
        jListOfZakon.setModel(defaultListModelForZakon);
        return jListOfZakon;
    }
    protected static JList<String> fillDefaultListModelForJedi() {
        defaultListModelForJedi.clear();
        int counter=1;
        for (Jedi jedi : Jedi.getListOfJedi()) {
            defaultListModelForJedi.addElement(""+counter++ +jedi.toString());
        }
        jListOfJedi.setModel(defaultListModelForJedi);
        return jListOfJedi;
    }
    protected static JList<String> fillDefaultListModelForNonRegisteredJedi() {
        defaultListModelForNonRegisteredJedi.clear();
        int counter=1;
        for (Jedi jedi : Jedi.getListOfJedi()) {
            if(jedi.getZakonID()==0) {
                defaultListModelForNonRegisteredJedi.addElement("" + counter++ + jedi.toString());
            }
        }
        jListOfNonRegisteredJedi.setModel(defaultListModelForNonRegisteredJedi);
        return jListOfNonRegisteredJedi;
    }

    public JediOrganizer_JPanel() {
        setLayout(null); // wylacza domyslny zarzadca rozkladu

        JSeparator jSeparator = new JSeparator(SwingConstants.VERTICAL);
        jSeparator.setBounds(449, 10, 50, 640);
        jSeparator.setBackground(Color.black);
        add(jSeparator);

//todo titles i lists

        jLabel_ZakonJedi_title = new JLabel("Zakon Jedi");
        jLabel_ZakonJedi_title.setBounds(200, 10, 150, 30);
        jLabel_ZakonJedi_title.setFont(new Font("TimesRoman", Font.PLAIN, 22));
        add(jLabel_ZakonJedi_title);
        jLabel_Jedi_title = new JLabel("Jedi");
        jLabel_Jedi_title.setBounds(650, 10, 150, 30);
        jLabel_Jedi_title.setFont(new Font("TimesRoman", Font.PLAIN, 22));
        add(jLabel_Jedi_title);
        //jLabel0.setForeground(Color.red);

        defaultListModelForZakon = new DefaultListModel<>();
        jListOfZakon = new JList<>(defaultListModelForZakon);
        jListOfZakon.setBounds(10, 50, 430, 300);
        add(fillDefaultListModelForZakon());

        defaultListModelForJedi = new DefaultListModel<>();
        jListOfJedi = new JList<>(defaultListModelForJedi);
        jListOfJedi.setBounds(460, 50, 415, 300);
        add(fillDefaultListModelForJedi());

//todo ZakonJedi:
//todo jButton_ZakonJedi_add , jListOfNonRegisteredJedi , defaultListModelNonRegisteredJedi ,
//todo jButton_ZakonJedi_import, jButton_ZakonJedi_export

        jLabel_ZakonJedi_rejestracja = new JLabel("Rejestracja Zakonu Jedi");
        jLabel_ZakonJedi_rejestracja.setBounds(150, 360, 200, 20);
        jLabel_ZakonJedi_rejestracja.setFont(new Font("TimesRoman", Font.PLAIN, 16));
        add(jLabel_ZakonJedi_rejestracja);

        //nazwa obiektu i text
        jLabel_ZakonJedi_nazwa = new JLabel("nazwa:");
        jLabel_ZakonJedi_nazwa.setBounds(10, 390, 100, 20);
        jLabel_ZakonJedi_nazwa.setFont(new Font("TimesRoman", Font.PLAIN, 12));
        add(jLabel_ZakonJedi_nazwa);

        jTextField_ZakonJedi_nazwa = new JTextField("nazwa");
        jTextField_ZakonJedi_nazwa.setBounds(100, 390, 300, 20);
        add(jTextField_ZakonJedi_nazwa);

        jButton_ZakonJedi_add = new JButton("add");
        jButton_ZakonJedi_add.setBounds(10, 420, 80, 20);
        jButton_ZakonJedi_add.addActionListener(new Action_ZakonJedi_add());
        add(jButton_ZakonJedi_add);

        defaultListModelForNonRegisteredJedi = new DefaultListModel<>();
        jListOfNonRegisteredJedi = new JList<>(defaultListModelForNonRegisteredJedi);
        jListOfNonRegisteredJedi.setBounds(100, 420, 300, 130);
        add(fillDefaultListModelForNonRegisteredJedi());

        jButton_ZakonJedi_import = new JButton("import");
        jButton_ZakonJedi_import.setBounds(10, 550, 80, 20);
        jButton_ZakonJedi_import.addActionListener(new Action_ZakonJedi_import());
        add(jButton_ZakonJedi_import);

        jTextField_ZakonJedi_File = new JTextField("zakony file");
        jTextField_ZakonJedi_File.setEditable(false);
        jTextField_ZakonJedi_File.setBounds(100, 565, 300, 20);
        add(jTextField_ZakonJedi_File);

        jButton_ZakonJedi_export = new JButton("export");
        jButton_ZakonJedi_export.setBounds(10, 580, 80, 20);
        jButton_ZakonJedi_export.addActionListener(new Action_ZakonJedi_export());
        add(jButton_ZakonJedi_export);

//todo  Jedi reszta :
//todo jLabel_Jedi_kolorMiecza, jLabel_Jedi_moc, jLabel_Jedi_stronaMocy;
//todo jButton_Jedi_import , jButton_Jedi_export;

        jLabel_Jedi_rejestracja = new JLabel("Rejestracja Jedi");
        jLabel_Jedi_rejestracja.setBounds(600, 360, 200, 20);
        jLabel_Jedi_rejestracja.setFont(new Font("TimesRoman", Font.PLAIN, 16));
        add(jLabel_Jedi_rejestracja);

        jLabel_Jedi_name = new JLabel("nazwa:");
        jLabel_Jedi_name.setBounds(460, 390, 100, 20);
        jLabel_Jedi_name.setFont(new Font("TimesRoman", Font.PLAIN, 12));
        add(jLabel_Jedi_name);

        jTextField_Jedi_nazwa = new JTextField("nazwa");
        jTextField_Jedi_nazwa.setBounds(550, 390, 290, 20);
        add(jTextField_Jedi_nazwa);

        jLabel_Jedi_kolorMiecza = new JLabel("kolor miecza: ");
        jLabel_Jedi_kolorMiecza.setBounds(460, 420, 100, 20);
        jLabel_Jedi_kolorMiecza.setFont(new Font("TimesRoman", Font.PLAIN, 12));
        add(jLabel_Jedi_kolorMiecza);

        jComboBoxSwordColor = new JComboBox<>();
        jComboBoxSwordColor.addItem("Red");
        jComboBoxSwordColor.addItem("Green");
        jComboBoxSwordColor.addItem("Blue");
        jComboBoxSwordColor.addItem("Yellow");
        jComboBoxSwordColor.addItem("Purple");
        jComboBoxSwordColor.setBounds(550, 420, 290, 20);
        add(jComboBoxSwordColor);

        jLabel_Jedi_moc = new JLabel("moc: ");
        jLabel_Jedi_moc.setBounds(460, 460, 100, 20);
        jLabel_Jedi_moc.setFont(new Font("TimesRoman", Font.PLAIN, 12));
        add(jLabel_Jedi_moc);

        jSliderPower = new JSlider(0,1000);
        jSliderPower.createStandardLabels(100,0);
        jSliderPower.setMajorTickSpacing(200);
        jSliderPower.setMinorTickSpacing(100);
        jSliderPower.setPaintTicks(true);
        jSliderPower.setPaintLabels(true);
        jSliderPower.setBounds(550, 460, 290, 40);
        add(jSliderPower);

        jLabel_Jedi_side = new JLabel("strona mocy: ");
        jLabel_Jedi_side.setBounds(460, 510, 100, 20);
        jLabel_Jedi_side.setFont(new Font("TimesRoman", Font.PLAIN, 12));
        add(jLabel_Jedi_side);

        ButtonGroup buttonGroup= new ButtonGroup();
        jRadioButtonDark = new JRadioButton("ciemna");
        jRadioButtonDark.setBounds(600, 510, 100, 20);
        add(jRadioButtonDark);
        jRadioButtonLight = new JRadioButton("jasna");
        jRadioButtonLight.setBounds(720, 510, 100, 20);
        add(jRadioButtonLight);
        buttonGroup.add(jRadioButtonDark);
        buttonGroup.add(jRadioButtonLight);


        jButton_Jedi_import = new JButton("import");
        jButton_Jedi_import.setBounds(460, 550, 80, 20);
        jButton_Jedi_import.addActionListener(new Action_Jedi_import());
        add(jButton_Jedi_import);

        jButton_Jedi_export = new JButton("export");
        jButton_Jedi_export.setBounds(460, 580, 80, 20);
        jButton_Jedi_export.addActionListener(new Action_Jedi_export());
        add(jButton_Jedi_export);

        jTextField_Jedi_File = new JTextField("jedi file");
        jTextField_Jedi_File.setEditable(false);
        jTextField_Jedi_File.setBounds(550, 565, 290, 20);
        add(jTextField_Jedi_File);

        //todo register and wipe
        jButton_ZakonJedi_register = new JButton("register");
        jButton_ZakonJedi_register.setBounds(100,610 , 80, 30);
        jButton_ZakonJedi_register.addActionListener(new Action_ZakonJedi_register());
        add(jButton_ZakonJedi_register);
        jButton_ZakonJedi_wipe = new JButton("wipe");
        jButton_ZakonJedi_wipe.setBounds(320, 610, 80, 30);
        jButton_ZakonJedi_wipe.addActionListener(new Action_ZakonJedi_wipe());
        add(jButton_ZakonJedi_wipe);
        jButton_Jedi_register = new JButton("register");
        jButton_Jedi_register.setBounds(550, 610, 80, 30);
        jButton_Jedi_register.addActionListener(new Action_Jedi_register());
        add(jButton_Jedi_register);
        jButton_Jedi_wipe = new JButton("wipe");
        jButton_Jedi_wipe.setBounds(760, 610, 80, 30);
        jButton_Jedi_wipe.addActionListener(new Action_Jedi_wipe());
        add(jButton_Jedi_wipe);
    }
//todo Actions for ZakonJedi
    class Action_ZakonJedi_add  implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
    class Action_ZakonJedi_import  implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }
  class Action_ZakonJedi_export implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }

 class Action_ZakonJedi_register implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = jTextField_ZakonJedi_nazwa.getText();
            ZakonJedi zakonJedi = new ZakonJedi();
            zakonJedi.setName(name);
            new Action_ZakonJedi_wipe();
        }
    }
    class Action_ZakonJedi_wipe implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            jTextField_ZakonJedi_nazwa.setText("name");
        }
    }
//todo Actions for Jedi

    class Action_Jedi_import implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }
     class Action_Jedi_export implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }

    class Action_Jedi_register implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = jTextField_Jedi_nazwa.getText();
            String color = jComboBoxSwordColor.toString();
            int power = jSliderPower.getValue();
            String side = jRadioButtonDark.isSelected()?"dark":"light";
            Jedi jedi = new Jedi();
            jedi.setName(name); jedi.setColor(color);jedi.setPower(power);jedi.setSide(side);
            new Action_Jedi_wipe();
        }
    }
   class Action_Jedi_wipe implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            jTextField_Jedi_nazwa.setText("nazwa");
            jSliderPower.setValue(500);
        }
    }


        // buttons
        //clean
/*        JButton jButton1 = new JButton("submit");
        jButton1.setBounds(150, 440, 150, 50);
        jButton1.addActionListener(new SwingApp_1_JPanel_a1_SignIn.ActionSubmitSignIn());
        // jButton1.addActionListener(new SwingApp_1_JPanel_b1_SignUp.ActionButtonWipeForm()); clean form
        add(jButton1);
        //register
        JButton jButton2 = new JButton("submit");
        jButton2.setBounds(350, 440, 150, 50);
        jButton2.addActionListener(new SwingApp_1_JPanel_a1_SignIn.ActionSwitchToSignUp());
        add(jButton2);

    }*/

/*    class ActionSubmitSignIn implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String login = jTextField1_login.getText();
            String password = String.valueOf(jPasswordField1_password.getPassword());
            System.out.println("login: " + login + " " + "password: " + password);
            if (!login.isEmpty() | !password.isEmpty()) {
                for (Users user : Users.listUsers) {
                    if (user.getLogin().equals(login) & user.getPassword().equals(password)) {
                        jLabel3_result.setText(String.valueOf(Alerts.SUCCESSFULLY_LOGGED_IN));
                        jLabel3_result.setForeground(Color.GREEN);
                    } else {
                        System.out.println("login: " + login + " " + "password: " + password);
                        System.out.println("getlogin: " + user.getLogin() + " " + "getpassword: " + user.getPassword());
                        jLabel3_result.setText(String.valueOf(Alerts.WRONG_LOGIN_OR_PASSWORD));
                        jLabel3_result.setForeground(Color.RED);
                    }
                }
            } else {
                System.out.println(Alerts.EMPTY_LOGIN_OR_PASSWORD);
            }
        }

        ;
    }

    class ActionSwitchToSignUp implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //  ProjectMain_2_JFrame1.

        }



    }*/

}

