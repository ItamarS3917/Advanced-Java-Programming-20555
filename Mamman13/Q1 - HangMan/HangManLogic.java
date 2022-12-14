package com.example.hangman;

import javafx.scene.control.Alert;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;
import static java.lang.String.valueOf;
import static java.lang.System.exit;

public class HangManLogic {
    private static String guessedWord;
    private static LinkedList <Character> oldLettersGuessed;
    private static char [] updateWordInArray;
    private static String updateWord;
    private static boolean flag;
    private static int live;

    public HangManLogic(){
        guessedWord = getWordFromFile();
        updateWordInArray = new char[guessedWord.length()];
        updateWord = printWord();
        oldLettersGuessed = new LinkedList<Character>();
        live = 0;
    }
    public void reset(){
        this.guessedWord = getWordFromFile();
        updateWordInArray = new char[guessedWord.length()];
        updateWordInArray = printWord().toCharArray();
        oldLettersGuessed = new LinkedList<Character>();
        live = 0;
    }

    public LinkedList<Character> getOldLettersGuessed() {
        return oldLettersGuessed;
    }
    public String getGuessedWord() {
        return guessedWord;
    }
    public int getLive() {
        return live;
    }
    public boolean getFlag() {
        return flag;
    }
    public String getUpdateWord() {
        return updateWord;
    }
    public char [] getUpdateWordInArray() {
        return updateWordInArray;
    }

    public static boolean checkValidInput(String letter_guessed) {
        letter_guessed = letter_guessed.toLowerCase();
        if (letter_guessed.length() != 1 || (letter_guessed.charAt(0) < 'a' || letter_guessed.charAt(0) > 'z'))
            return false;
        else return true;
    }

    public static String printWord() {
        Arrays.fill(updateWordInArray , '*');
        return valueOf(updateWordInArray);
    }

    public static String showHiddenWord(String secret_word, char letter) {
        boolean tempFlag = true;
        if (checkValidInput(letter + "")) {
            if(oldLettersGuessed.contains(letter)){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Error");
                alert.setHeaderText("You have already tried to enter this character");
                alert.showAndWait();
                live--;
            }
            else
                oldLettersGuessed.add(letter);
        }

        for (int index = 0; index < secret_word.length(); index++) {
            if (secret_word.charAt(index) == letter) {
                updateWordInArray[index] = letter;
                tempFlag = false;
                flag = false;
            }
        }
        if (tempFlag) {
            flag = true;
            live++;
        }

        updateWord = Arrays.toString(updateWordInArray);
        return updateWord;
    }

    public String getWordFromFile() {
        try {
            List <String> wordList = Files.readAllLines(new File("wordFile.txt").toPath(), Charset.defaultCharset());
            Collections.shuffle(wordList);
            return wordList.get(0);
        }
        catch (IOException e){
            System.out.println("File error");
            exit(0);
        }
        return "";
    }
}