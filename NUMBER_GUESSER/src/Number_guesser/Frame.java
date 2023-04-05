package Number_guesser;

import javax.swing.*;
import java.awt.*;

public class Frame {

    private JLabel result;
    private JTextField textField;
    private Guesser guesser;

    public Frame() {

        result = new JLabel();
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(100, 25));
        guesser = new Guesser(result, textField);

        JButton guessButton = new JButton("Guess");
        guessButton.addActionListener(guesser);

        JLabel label = new JLabel("GUESS THE NUMBER FROM 0 TO 100");

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0,1));
        panel.add(label);
        panel.add(result);
        panel.add(textField);
        panel.add(guessButton);

        JFrame frame = new JFrame();
        frame.setSize(500,200);
        frame.add(panel,BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("NUMBER GUESSER");
        frame.setVisible(true);
    }
}
