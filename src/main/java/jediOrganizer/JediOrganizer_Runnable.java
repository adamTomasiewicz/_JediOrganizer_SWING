package jediOrganizer;

import jediOrganizer.dao.JediOrganizer_repo;
import jediOrganizer.view.JediOrganizer_JFrame1;

import javax.swing.*;
import java.awt.*;

public class JediOrganizer_Runnable {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
               JediOrganizer_JFrame1 jediOrganizer_jFrame1 = new JediOrganizer_JFrame1();
                jediOrganizer_jFrame1.setVisible(true);
                jediOrganizer_jFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JediOrganizer_repo.isTablesInDBCreated();


            }
        });
    }
}
