package com.example.randompasswordgenerator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.util.Arrays;
import java.util.Random;

import static java.lang.Math.random;

public class HelloController {
    @FXML
    private Text txt;
    Random random = new Random();


    @FXML

    public void btnAction() {
        boolean useWords = true;
        boolean useNumbers = true;

        String password = passwordGenerator(useWords, useNumbers);
        txt.setText(password);
    }

    // Separate method (outside btnAction)
    public String passwordGenerator(boolean word, boolean num) {
        String digits = "0123456789";
        String letters = "ABCDEFGH";

        String all = "";

        if (num) {
            all += digits;
        }

        if (word) {
            all += letters;
        }

        StringBuilder password = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            int guess = random.nextInt(all.length());
            password.append(all.charAt(guess));
        }

        return password.toString();
    }
}