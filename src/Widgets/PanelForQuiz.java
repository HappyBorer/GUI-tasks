package Widgets;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelForQuiz extends JPanel implements ActionListener {
    private JLabel counter;
    private JLabel question;
    private JButton[] options;
    private int[] reply;
    private int number = 0;
    private int rightAnswer = 0;
    private int numberQuestion = 4;
    private String[][] answer;
    private String[] questions;

    PanelForQuiz() {
        GridBagLayout gbl = new GridBagLayout();
        gbl.columnWidths = new int[]{0, 0, 0, 0};
        gbl.rowHeights = new int[]{0, 0, 0, 0};
        setLayout(gbl);
//        GridBagConstraints gbc = new GridBagConstraints();

        counter = new JLabel("Question:" + number + "/" + numberQuestion);

        questions = new String[]{"Как назывался особый головной убор, который носили фараоны в Древнем Египте?",
                "Какие огурцы сажал на брезентовом поле герой одноименной песни?",
                "У какого животного самые большие глаза относительно тела?",
                "Как называли строителя в старину?"};
        question = new JLabel(questions[number]);
        reply = new int[]{1, 3, 2, 2};

        answer = new String[numberQuestion][numberQuestion];
        answer[0][0] = "Картуз";
        answer[0][1] = "Немес";
        answer[0][2] = "Корона";
        answer[0][3] = "Убрус";
        answer[1][0] = "Железные";
        answer[1][1] = "Оловянные";
        answer[1][2] = "Медные";
        answer[1][3] = "Алюминиевые";
        answer[2][0] = "У лемура";
        answer[2][1] = "У летучей мыши";
        answer[2][2] = "У долгопята";
        answer[2][3] = "У тупайи";
        answer[3][0] = "Бондарь";
        answer[3][1] = "Бортник";
        answer[3][2] = "Зодчий";
        answer[3][3] = "Кормчий";

        options = new JButton[]{new JButton(answer[number][0]),
                new JButton(answer[number][1]),
                new JButton(answer[number][2]),
                new JButton(answer[number][3])};
        for (JButton jButton : options) {
            jButton.addActionListener(this);
        }


        Insets insets = new Insets(5, 5, 5, 5);
        add(counter, new GridBagConstraints(4, 0, 1, 1, 1.0, 1.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insets, 1, 1));

        Border border = BorderFactory.createLineBorder(Color.BLACK);

        question.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(25, 25, 25, 25)));

        add(question, new GridBagConstraints(0, 1, 4, 1, 1.0, 1.0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 1, 1));
        int gry = 2;
        int grw = 2;
        int grx = 0;
        for (int i = 0; i < options.length; i++) {
            options[i].setPreferredSize(new Dimension(100, 100));
            options[i].setContentAreaFilled(false);
            add(options[i], new GridBagConstraints(grx, gry, grw, 1, 1.0, 1.0,
                    GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insets, 1, 1));

            if (i == 1) {
                gry++;
                grx = 0;
            } else {
                grx = 2;
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton but = (JButton) e.getSource();
        if (but.getText().equals(answer[number][reply[number]])) {
            rightAnswer++;
        }
        number++;
        if (number == numberQuestion) {
            removeAll();
            revalidate();
            setLayout(new GridBagLayout());
            JLabel result = new JLabel("The right answer " + rightAnswer + " from " + numberQuestion);
            result.setAlignmentX(JComponent.CENTER_ALIGNMENT);
            Insets insets = new Insets(5, 5, 5, 5);
            Border border = BorderFactory.createLineBorder(Color.BLACK);

            result.setBorder(BorderFactory.createCompoundBorder(border,
                    BorderFactory.createEmptyBorder(300, 200, 300, 200)));

            add(result, new GridBagConstraints(0, 1, 4, 4, 1.0, 1.0,
                    GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 1, 1));
        }else {
            counter.setText("Question:" + number + "/" + numberQuestion);
            question.setText(questions[number]);
            for (int i = 0; i < options.length; i++) {
                options[i].setText(answer[number][i]);
            }
        }

    }
}
