//Source: CHATGPT! - Not my work - just a reference piece

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ChatGPTReference {
    public static void main(String[] args) throws IOException {
            // Reading the text file
            BufferedReader reader = new BufferedReader(new FileReader("/Users/cyruschan/IdeaProjects/Counting Plugged/textOne.txt"));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line.toLowerCase()).append(" ");
            }
            reader.close();

            // Tokenizing and cleaning words
            String[] cleanWords = sb.toString().split("[^\\w’']+");

            // Counting words using HashMap
            HashMap<String, Integer> wordCount = new HashMap<>();
            for (String word : cleanWords) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }

            // Reading common words into a HashSet
            HashSet<String> commonWords = new HashSet<>();
            BufferedReader commonReader = new BufferedReader(new FileReader("/Users/cyruschan/IdeaProjects/Counting Plugged/commonWords.txt"));
            String commonWord;
            while ((commonWord = commonReader.readLine()) != null) {
                commonWords.add(commonWord.toLowerCase());
            }
            commonReader.close();

            // Filtering out common words
            wordCount.keySet().removeAll(commonWords);

            // Sorting the words by count
            ArrayList<String> sortedWords = new ArrayList<>(wordCount.keySet());
            sortedWords.sort((a, b) -> wordCount.get(b).compareTo(wordCount.get(a)));

            // Outputting the top 5 words
            System.out.println("The top 5 words are:");
            for (int i = 0; i < 5; i++) {
                String word = sortedWords.get(i);
                System.out.println("Word: " + word + " - Count: " + wordCount.get(word));
            }
        }
    }

