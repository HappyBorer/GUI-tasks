package Registration_form_GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.System.exit;

public class Registration extends JFrame{
    private JLabel name;
    private JTextField textField2;
    private JTextField textField3;
    private JLabel lastNameLabel;
    private JLabel ageLabel;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JLabel sexLabel;
    private JPanel registration;
    private JTextField textField1;
    private JTextField textField4;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JTextArea textArea1;
    private JComboBox comboBox1;
    private JCheckBox consentToPersonalDataCheckBox;
    private JButton button1;
    private JLabel emailAddressLabel;
    private JLabel passwordLabel;
    private JLabel yourWishesLabel;
    private JLabel yourExperienceLabel;


    Registration(){
        this.getContentPane().add(registration);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(consentToPersonalDataCheckBox.isSelected()){
                    String date = name.getText() + ": " + textField1.getText() + "\n";
                    date += lastNameLabel.getText() + ": " + textField2.getText() + "\n";
                    date += ageLabel.getText() + ": " + textField3.getText() + "\n";
                    date += sexLabel.getText() + ": ";
                    if(maleRadioButton.isSelected()) {
                        date += maleRadioButton.getText() + "\n";
                    }else{
                        date += femaleRadioButton.getText() + "\n";
                    }
                    date += emailAddressLabel.getText() + ": " + textField4.getText() + "\n";
                    date += passwordLabel.getText() + ": " + passwordField1.getText() + "\n";
                    date += yourWishesLabel.getText() + ": " + textArea1.getText() + "\n";
                    date += yourExperienceLabel.getText() + ": " + comboBox1.getSelectedItem() + "\n";
                    JOptionPane.showMessageDialog(null, date,"Date", JOptionPane.INFORMATION_MESSAGE);
                    exit(0);
                }
            }
        });
    }
}
