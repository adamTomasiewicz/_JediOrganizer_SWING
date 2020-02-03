package jediOrganizer.view;

import javax.swing.*;

public class JediOrganizer_JFrame1 extends JFrame {

    public JediOrganizer_JFrame1() {
        setSize(900, 700);
        setLocation(100, 50);
        setTitle("Zarzadca Jedi");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        JediOrganizer_JPanel jediOrganizer_jPanel = new JediOrganizer_JPanel();
        getContentPane().add(jediOrganizer_jPanel);
    }
}

