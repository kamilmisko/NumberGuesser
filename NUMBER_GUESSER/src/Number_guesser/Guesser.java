package Number_guesser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Guesser implements ActionListener {

    private JLabel result;
    private JTextField textField;
    Random rand = new Random();
    int number = rand.nextInt(101);
    int count = 0;
    int guess = 0;
    CompletableFuture<Void> future;

    public Guesser(JLabel result, JTextField textField) {
        this.result = result;
        this.textField = textField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        guess = Integer.parseInt(textField.getText());
        textField.setText("");
        count++;

        if (guess > number) {
            result.setForeground(Color.red);
            result.setText("Your number is too high!");
        } else if (guess < number) {
            result.setForeground(Color.red);
            result.setText("Your number is too low!");
        } else {
            result.setForeground(Color.green);
            result.setText("Congrats! You guessed the number by " + count + " attempt!");
        }

        CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                result.setText("");
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });
    }
}

