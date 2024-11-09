package Widgets;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelForCalculator extends JPanel implements ActionListener {
    private final JButton[] buttonNumber;
    private final JButton add;
    private final JButton subtraction;
    private final JButton multiplication;
    private final JButton division;
    private final JButton equality;
    private final JButton clear;
    JTextField placeholder;

    PanelForCalculator() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        buttonNumber = new JButton[10];
        add = new JButton("+");
        subtraction = new JButton("-");
        multiplication = new JButton("*");
        division = new JButton("/");
        equality = new JButton("=");
        clear = new JButton("C");
        placeholder = new JTextField("0", 15);
        placeholder.setEditable(false);
        placeholder.setHorizontalAlignment(SwingConstants.RIGHT);

        add.setMaximumSize(new Dimension(100, 100));
        subtraction.setMaximumSize(new Dimension(100, 100));
        multiplication.setMaximumSize(new Dimension(100, 100));
        division.setMaximumSize(new Dimension(100, 100));
        equality.setMaximumSize(new Dimension(100, 100));
        clear.setMaximumSize(new Dimension(100, 100));

        add.addActionListener(this);
        subtraction.addActionListener(this);
        multiplication.addActionListener(this);
        division.addActionListener(this);
        equality.addActionListener(this);
        clear.addActionListener(this);

        for (int i = 0; i < buttonNumber.length; i++) {
            buttonNumber[i] = new JButton(String.valueOf(i));
            buttonNumber[i].setMaximumSize(new Dimension(100, 100));
            buttonNumber[i].addActionListener(this);
        }
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        add(placeholder, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        for (int i = 1; i < buttonNumber.length; i++) {
            add(buttonNumber[i], gbc);
            gbc.gridx++;
            if (i == 3) {
                add(add, gbc);
                gbc.gridy = 2;
                gbc.gridx = 0;
            } else if (i == 6) {
                add(subtraction, gbc);
                gbc.gridy = 3;
                gbc.gridx = 0;
            } else if (i == 9) {
                add(multiplication, gbc);
            }
        }
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(clear, gbc);
        gbc.gridx = 1;
        add(buttonNumber[0], gbc);
        gbc.gridx = 2;
        add(equality, gbc);
        gbc.gridx = 3;
        add(division, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton tmp = (JButton) e.getSource();
        String result = "0";
        switch (tmp.getText()) {
            case "1":
                insertNUmber("1");
                break;
            case "2":
                insertNUmber("2");
                break;
            case "3":
                insertNUmber("3");
                break;
            case "4":
                insertNUmber("4");
                break;
            case "5":
                insertNUmber("5");
                break;
            case "6":
                insertNUmber("6");
                break;
            case "7":
                insertNUmber("7");
                break;
            case "8":
                insertNUmber("8");
                break;
            case "9":
                insertNUmber("9");
                break;
            case "0":
                insertNUmber("0");
                break;
            case "+":
                setSing(" + ");
                break;
            case "-":
                setSing(" - ");
                break;
            case "*":
                setSing(" * ");
                break;
            case "/":
                setSing(" / ");
                break;
            case "=":
                if(!placeholder.getText().equals("division by zero")) {
                    String[] example = placeholder.getText().split(" ");
                    if (example.length == 2) {
                        result = myCalculate(Double.parseDouble(example[0]), Double.parseDouble(example[0]), example[1]);
                    } else if (example.length > 2) {
                        result = myCalculate(Double.parseDouble(example[0]), Double.parseDouble(example[2]), example[1]);
                    }
                    placeholder.setText(result);
                }
                break;
            case "C":
                placeholder.setText("0");
                break;
        }

    }

    private void insertNUmber(String number) {
        if (placeholder.getText().equals("0")) {
            placeholder.setText(number);
        } else if(!placeholder.getText().equals("division by zero")){
            placeholder.setText(placeholder.getText() + number);
        }
    }

    private String myCalculate(double numberA, double numberB, String sing) {
        switch (sing) {
            case "+":
                return String.valueOf(numberA + numberB);
            case "-":
                return String.valueOf(numberA - numberB);
            case "*":
                return String.valueOf(numberA * numberB);
            case "/":
                if (numberB == 0) {
                    return "division by zero";
                } else {
                    return String.valueOf(numberA / numberB);
                }
        }
        return "0";
    }

    private void setSing(String sing) {
        String textPlaceholder = placeholder.getText();
        String[] example = textPlaceholder.split(" ");
        if (Character.isDigit(textPlaceholder.charAt(textPlaceholder.length() - 1))) {
            if (example.length == 1) {
                placeholder.setText(placeholder.getText() + sing);
            } else {
                String result = myCalculate(Double.parseDouble(example[0]), Double.parseDouble(example[2]), example[1]);
                placeholder.setText(result + sing);
            }
        }
    }
}
