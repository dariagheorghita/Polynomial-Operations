package org.example.GraphicalUserInterface;

import lombok.Getter;
import lombok.Setter;
import org.example.BusinessLogical.Operatii;
import org.example.BusinessLogical.Regex;
import org.example.DataModels.Polinom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Setter
@Getter

public class Calculator {

    private JLabel polinom1Label;
    private JLabel polinom2label;
    private JLabel rezultatLabel;
    private JTextField polinom1Field;
    private JTextField polinom2Field;
    private JTextField rezultatField;
    private JButton adunareButton;
    private JButton scadereButton;
    private JButton inmultireButton;
    private JButton derivareButton;
    private JButton integrareButton;
    private JFrame frame;

    public JFrame getFrame() {
        return frame;
    }

    public Calculator() {

        frame = new JFrame("Calculator polinomial");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(400, 200, 600, 600);

        polinom1Label = new JLabel("Polinom1:");
        polinom1Label.setFont(new Font("Times New Roman", Font.BOLD, 30));
        polinom1Label.setBounds(60, 10, 300, 30);
        frame.add(polinom1Label);

        polinom2label = new JLabel("Polinom2:");
        polinom2label.setFont(new Font("Times New Roman", Font.BOLD, 30));
        polinom2label.setBounds(60, 60, 300, 30);
        frame.add(polinom2label);

        rezultatLabel = new JLabel("Rezultat:");
        rezultatLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
        rezultatLabel.setBounds(60, 110, 300, 30);
        frame.add(rezultatLabel);

        polinom1Field = new JTextField();
        polinom1Field.setBounds(200, 10, 300, 30);
        frame.add(polinom1Field);

        polinom2Field = new JTextField();
        polinom2Field.setBounds(200, 60, 300, 30);
        frame.add(polinom2Field);

        rezultatField = new JTextField();
        rezultatField.setBounds(200, 110, 300, 30);
        frame.add(rezultatField);

        adunareButton = new JButton("+");
        adunareButton.setBounds(150, 190, 300, 50);
        frame.add(adunareButton);

        scadereButton = new JButton("-");
        scadereButton.setBounds(150, 250, 300, 50);
        frame.add(scadereButton);

        inmultireButton = new JButton("*");
        inmultireButton.setBounds(150, 310, 300, 50);
        frame.add(inmultireButton);

        derivareButton = new JButton("derivare");
        derivareButton.setBounds(150, 370, 300, 50);
        frame.add(derivareButton);

        integrareButton = new JButton("integrare");
        integrareButton.setBounds(150, 430, 300, 50);
        frame.add(integrareButton);

        frame.setLayout(null);
        frame.setVisible(true);

        adunareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pol1 = polinom1Field.getText();
                String pol2 = polinom2Field.getText();

                Polinom polinom1 = Regex.computeInputString(pol1);
                Polinom polinom2 = Regex.computeInputString(pol2);
                Polinom resAdd = Operatii.additionPolinoms(polinom1, polinom2);
                rezultatField.setText(resAdd.toString());
            }
        });

        scadereButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pol1 = polinom1Field.getText();
                String pol2 = polinom2Field.getText();

                Polinom polinom1 = Regex.computeInputString(pol1);
                Polinom polinom2 = Regex.computeInputString(pol2);
                Polinom resSub = Operatii.substractPolinoms(polinom1, polinom2);
                rezultatField.setText(resSub.toString());
            }
        });

        inmultireButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pol1 = polinom1Field.getText();
                String pol2 = polinom2Field.getText();

                Polinom polinom1 = Regex.computeInputString(pol1);
                Polinom polinom2 = Regex.computeInputString(pol2);
                Polinom resMul = Operatii.multiplyPolinoms(polinom1, polinom2);
                rezultatField.setText(resMul.toString());
            }
        });

        derivareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pol = polinom1Field.getText();

                Polinom polinom = Regex.computeInputString(pol);
                Polinom resDer = Operatii.derivatePolinom(polinom);
                rezultatField.setText(resDer.toString());
            }
        });

        integrareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pol = polinom1Field.getText();

                Polinom polinom = Regex.computeInputString(pol);
                Polinom resInt = Operatii.integratePolinom(polinom);
                rezultatField.setText(resInt.toString());
            }
        });

    }
}
