package lab5;

import java.util.regex.*;

public class WordsStartingWithLetter {
    public static void main(String[] args) {
        String text = "The tiger and the turtle";
        char letter = 'T';
        Pattern pattern = Pattern.compile("\\b" + letter + "[A-Za-z]*\\b");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println("Найдено слово: " + matcher.group());
        }
    }
}