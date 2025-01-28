import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static File inputDirectory = new File("/Users/luketto/Desktop/CyberChallenge/Prova2024/Esercizio3/input/");
    public static File outputDirectory = new File("/Users/luketto/Desktop/CyberChallenge/Prova2024/Esercizio3/output/");

    private static Scanner scanner;
    private static Scanner scannerOutput;

    public static int calculate(List<Integer> S, Integer D) {
        S.sort(null);

        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();

       
        int i = 0;
        int status = 0;

        while(i < S.size() - 1) {
            if (Math.abs(S.get(i) - S.get(i + 1)) >= 500) {
                if(B.isEmpty() && !A.isEmpty()) {
                    A.add(S.get(i));
                    status = 1;
                }
                else if(!B.isEmpty()) {
                    
                }
                
            }

            else {

            }
        }
        
    }
    
    public static void main(String[] arg) throws FileNotFoundException {
        
        File[] inputFiles = inputDirectory.listFiles();
        File[] outputFiles = outputDirectory.listFiles();

        Arrays.sort(inputFiles);
        Arrays.sort(outputFiles);

        boolean correct = true;
        
        for (int i = 0; i < inputFiles.length; i++) {
            scanner = new Scanner(inputFiles[i]);
            scannerOutput = new Scanner(outputFiles[i]);

            int numTest = scanner.nextInt();
            scanner.nextLine();  // Consuma la nuova linea
        
            int numElements = scanner.nextInt();
            int D = scanner.nextInt();
            scanner.nextLine();  // Consuma la nuova linea
        
            List<Integer> S = new ArrayList<>();
        
            // Correzione: cambia 'i' con 'j' per l'iterazione corretta
            for (int j = 0; j < numElements; j++) {
                S.add(scanner.nextInt());
            }
        
            int result = calculate(S, D);

            scanner.close();
            scannerOutput.close();

            break;
        }

    }
    
}
