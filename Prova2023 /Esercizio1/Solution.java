import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    // Lettura dalle directory da file
    public static File inputDirectory = new File("/Users/luketto/Desktop/CyberChallenge/Prova2023 /Esercizio1/input");
    public static File outputDirectory = new File("/Users/luketto/Desktop/CyberChallenge/Prova2023 /Esercizio1/output");

    private static Scanner scanner;
    private static Scanner scannerOutput;

    public static List<Integer> calculate(String correctAnswers, List<String> studentAnswers) {
        
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < studentAnswers.size(); i++) {
            String studentAnswer = studentAnswers.get(i);
            int score = 0;

            for(int j = 0; j < correctAnswers.length(); j++) {
                if(correctAnswers.charAt(j) == studentAnswer.charAt(j)) {
                    score++;
                }
            }

            result.add(score);
        }

        return result;
    }

    public static void main(String[] args) throws FileNotFoundException {
        
        File[] inputFiles = inputDirectory.listFiles();
        File[] outputFiles = outputDirectory.listFiles();

        System.out.println(outputFiles[0].getName());
        Arrays.sort(inputFiles);
        Arrays.sort(outputFiles);

        boolean match = true;
        
        for (int i = 0; i < inputFiles.length; i++) {
            // Lettura per ogni file
            scanner = new Scanner(inputFiles[i]);
            scannerOutput = new Scanner(outputFiles[i]);
    
            int numQuestions = scanner.nextInt();
            int numStudents = scanner.nextInt();

            scanner.nextLine();

            String correctAnswers = scanner.nextLine();

            List<String> studentAnswers = new ArrayList<>();
            List<Integer> expectedResult = new ArrayList<>();

            for(int j = 0; j < numStudents; j++) {
                studentAnswers.add(scanner.nextLine());
            }

            for(int j = 0; j < numStudents; j++) {
                expectedResult.add(scannerOutput.nextInt());
            }

            List<Integer> result = calculate(correctAnswers, studentAnswers);

            // Check sul risultato
            if(!result.equals(expectedResult)) {
                match = false;
                System.out.println("Errore al test " + outputFiles[i].getName());
                System.out.println("EXPECTED " + expectedResult);
                System.out.println("OBTAINED " + result);
            }
            
            scanner.close();
            scannerOutput.close(); 
        }
        
        if(match) System.out.println("ALL TEST PASSED");
        
        /* 
        scanner = new Scanner(System.in);
        */

    }
}
