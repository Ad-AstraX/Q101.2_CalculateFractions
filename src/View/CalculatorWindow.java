package View;

import Model.Fraction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorWindow extends JFrame {
    private JComboBox chooseOperator;
    private JButton confirmButton;
    private JLabel operator;
    private JTextArea firstDenom;
    private JTextArea firstNom;
    private JTextArea secondNom;
    private JTextArea secondDenom;
    private JTextArea resultNom;
    private JTextArea resultDenom;
    private JPanel panel1;

    public CalculatorWindow() {
        setContentPane(panel1);
        setTitle("Fraction Calculator");
        setSize(325,200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        handleInput();
    }

    public void handleInput() {
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                resultNom.setText(
                        String.valueOf(
                        new Fraction(
                                Integer.parseInt(firstNom.getText()),
                                Integer.parseInt(firstDenom.getText())).addFractions(
                                        new Fraction(
                                                Integer.parseInt(secondNom.getText()),
                                                Integer.parseInt(secondDenom.getText())
                                        )
                        ).getNom())
                );
                resultDenom.setText(
                        String.valueOf(
                                new Fraction(
                                        Integer.parseInt(firstNom.getText()),
                                        Integer.parseInt(firstDenom.getText())).addFractions(
                                        new Fraction(
                                                Integer.parseInt(secondNom.getText()),
                                                Integer.parseInt(secondDenom.getText())
                                        )
                                ).getDenom())
                );
            }
        });
    }
}
