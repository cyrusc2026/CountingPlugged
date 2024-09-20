import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class HashMapTrial {
    //I have not given or received any unauthorized aid on this piece of work
        public static void main(String[] args) throws IOException {
            Scanner scanner = new Scanner(new File("/Users/cyruschan/IdeaProjects/Counting Plugged/Animal+farm.txt"));
            StringBuilder sb = new StringBuilder();
            while (scanner.hasNext()) {
                sb.append(scanner.next().toLowerCase()).append(" ");
            }
            System.out.println("String Builder done");
            //StringBuilder is used to change the file type from txt to something that can split
            String[] cleanWords = sb.toString().split("[^'’\\w]+");
            System.out.println("Words split");
            //cleaning words using .split()
            HashMap<String, Integer> wordCount = new HashMap<>();
            for (String word : cleanWords) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
            System.out.println("New words added");
            HashSet<String> commonWords = new HashSet<>();
            BufferedReader commonReader = new BufferedReader(new FileReader("/Users/cyruschan/IdeaProjects/Counting Plugged/commonWords.txt"));
            String commonWord;
            while ((commonWord = commonReader.readLine()) != null) {
                commonWords.add(commonWord.toLowerCase());
            }
            commonReader.close();
            wordCount.keySet().removeAll(commonWords);
            ArrayList<String> sortedWords = new ArrayList<>(wordCount.keySet());
            sortedWords.sort((a, b) -> wordCount.get(b).compareTo(wordCount.get(a)));
            System.out.println("The top 5 words are:");
            for (int i = 0; i < 5; i++) {
                String word = sortedWords.get(i);
                System.out.println("Word: " + word + " - Count: " + wordCount.get(word));
            }
        }

    }

