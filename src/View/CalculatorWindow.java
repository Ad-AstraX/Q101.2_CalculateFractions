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
                if (chooseOperator.getSelectedIndex() == 0) {
                    Fraction resultFrac = new Fraction(
                                            Integer.parseInt(firstNom.getText()),
                                            Integer.parseInt(firstDenom.getText())).addFractions(
                                            new Fraction(
                                                    Integer.parseInt(secondNom.getText()),
                                                    Integer.parseInt(secondDenom.getText())
                                            )
                                        );
                    resultNom.setText(String.valueOf(resultFrac.getNom()));
                    resultDenom.setText(String.valueOf(resultFrac.getDenom()));
                    operator.setText("+");
                } else if (chooseOperator.getSelectedIndex() == 1) {
                    Fraction resultFrac = new Fraction(
                            Integer.parseInt(firstNom.getText()),
                            Integer.parseInt(firstDenom.getText())).addFractions(
                            new Fraction(
                                    Integer.parseInt(secondNom.getText())*-1,
                                    Integer.parseInt(secondDenom.getText())
                            )
                    );
                    resultNom.setText(String.valueOf(resultFrac.getNom()));
                    resultDenom.setText(String.valueOf(resultFrac.getDenom()));
                    operator.setText("-");
                } else if (chooseOperator.getSelectedIndex() == 2) {
                    Fraction resultFrac = new Fraction(
                            Integer.parseInt(firstNom.getText()),
                            Integer.parseInt(firstDenom.getText())).multFractions(
                            new Fraction(
                                    Integer.parseInt(secondNom.getText()),
                                    Integer.parseInt(secondDenom.getText())
                            )
                    );
                    resultNom.setText(String.valueOf(resultFrac.getNom()));
                    resultDenom.setText(String.valueOf(resultFrac.getDenom()));
                    operator.setText("*");
                } else if (chooseOperator.getSelectedIndex() == 3) {
                    Fraction resultFrac = new Fraction(
                            Integer.parseInt(firstDenom.getText()),
                            Integer.parseInt(firstNom.getText())).multFractions(
                            new Fraction(
                                    Integer.parseInt(secondDenom.getText()),
                                    Integer.parseInt(secondNom.getText())
                            )
                    );
                    resultNom.setText(String.valueOf(resultFrac.getNom()));
                    resultDenom.setText(String.valueOf(resultFrac.getDenom()));
                    operator.setText("/");
                }
            }
        });
    }
}
