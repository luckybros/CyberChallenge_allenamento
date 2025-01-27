import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {

    public static List<String> sanitize(List<String> bannedWords, List<String> words) {
        List<String> result = new ArrayList<>();

        for(int i = 0; i < words.size(); i++) {
            String safe = "SAFE";

            for(int j = 0; j < bannedWords.size(); j++) 
                if(words.get(i).contains(bannedWords.get(j)))   
                    safe = "BANNED";
            
            result.add(safe);
        }

        return result;
    }

    public static void main(String[] args) throws FileNotFoundException {
        File fileInput = new File("/Users/luketto/Desktop/CyberChallenge/Prova2024/Esercizio1/input/input1.txt");

        File fileOutput = new File("/Users/luketto/Desktop/CyberChallenge/Prova2024/Esercizio1/output/output1.txt");

        Scanner scanner = new Scanner(fileInput);
        Scanner scannerOutput = new Scanner(fileOutput);
        
        int numWords = scanner.nextInt();
        int numBannedWords = scanner.nextInt();
        scanner.nextLine();

        List<String> bannedWords = new ArrayList<>();
        List<String> words = new ArrayList<>();
        List<String> outputExpected = new ArrayList<>();

        for(int i = 0; i < numBannedWords; i++) {
            bannedWords.add(scanner.nextLine());
        }

        for(int i = 0; i < numWords; i++) {
            words.add(scanner.nextLine());
        }

        while (scannerOutput.hasNextLine()) {
            outputExpected.add(scannerOutput.nextLine());
        }

        List<String> result = sanitize(bannedWords, words);

        scanner.close();
        scannerOutput.close();

        boolean match = true;
        for (int i = 0; i < result.size(); i++) {
            if (!result.get(i).equals(outputExpected.get(i))) {
                match = false;
                break;
            }
        }

        if (match) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST NOT PASSED");
        }

    }
}