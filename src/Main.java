import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
//I have not given or received any unauthorized aid on this piece of work
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("/Users/cyruschan/IdeaProjects/Counting Plugged/Nineteen+eighty-four.txt"));
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNext()) {
            sb.append(scanner.next().toLowerCase()).append(" ");
        }
        System.out.println("String Builder done");
        //StringBuilder is used to change the file type from txt to something that can split
        String[] cleanWords = sb.toString().split("[^[\\w]]+");
        System.out.println("Words split");
        //cleaning words using .split()
        ArrayList<word> words = new ArrayList<>();
        for (int i = 0; i < cleanWords.length; i++){
            boolean isANewWord = true;

            for (int j = 0; j < words.size(); j++) {
                if (words.get(j).getName().equals(cleanWords[i])) {
                    // If the word is already present in the list, update its count
                    words.set(j, new word(words.get(j).getName(), words.get(j).getCount() + 1));
                    isANewWord = false;
                    break; // Exit the loop since the word is found
                }
            }

            if (isANewWord) {
                // If it's a new word, add it to the list with count = 1
                words.add(new word(cleanWords[i], 1));
                System.out.println("New word: "+cleanWords[i]);
            }
        }
        System.out.println("New words added");
        Scanner commonWords = new Scanner(new File ("/Users/cyruschan/IdeaProjects/Counting Plugged/commonWords.txt"));
        int commonWordsCount = 0;
        while (commonWords.hasNextLine()){
            commonWords.nextLine();
            commonWordsCount++;
            //finds length of the file
        }
        System.out.println("Common words counted");
        String[] commonWordsArray = new String[commonWordsCount];

        // Create a new Scanner to read from the file again
        commonWords = new Scanner(new File ("/Users/cyruschan/IdeaProjects/Counting Plugged/commonWords.txt"));
        for (int i = 0; i < commonWordsCount; i++) {
            commonWordsArray[i] = commonWords.nextLine().toLowerCase();
            System.out.println("New common word: " + commonWordsArray[i]);
        }
        for (int i = 0; i < words.size(); i++){
            System.out.println("Current words checking: " + words.get(i).getName());
            //checks the words array list to see if it's a common word
            //have to do scanner here to reset every time!
            for (int j = 0; j < 79; j++){
                if (commonWordsArray[j].equals(words.get(i).getName())||words.get(i).getName().equalsIgnoreCase("s")){
                    System.out.println(commonWordsArray[j] +" is a common word!");
                    //the programme breaks and removes the word if it is common
                    words.remove(i);
                    i--;
                    break;
                    //break to reduce time
                }
            }
        }
        for( int i = 0; i < words.size()-1; i++) {
            for (int j = 0; j < words.size() - i - 1; j++)
                if (words.get(j).getCount() > words.get(j+1).getCount()) {
                    word temp = words.get(j);
                    words.set(j,words.get(j+1));
                    words.set(j+1,temp);
                }
            // bubble sorting the array

        }
        System.out.println("The top 5 words are:");
        for (int i = words.size()-1; i > words.size()-6; i--){
            System.out.println("Word: " + words.get(i).getName() + " - Count: " + words.get(i).getCount());
        }
    }
}