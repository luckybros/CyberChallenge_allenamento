import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution  {
    public static File inputDirectory = new File("/Users/luketto/Desktop/CyberChallenge/Prova2024/Esercizio4/input/");
    public static File outputDirectory = new File("/Users/luketto/Desktop/CyberChallenge/Prova2024/Esercizio4/output/");

    private static Scanner scanner;
    private static Scanner scannerOutput;

    public static int calculate(char[] alphabet, String stringToEvaluate) {
        // Genero la lista dei prefissi
        List<String> prefixes = new ArrayList<>();
        int result = 0;

        // Lineare con lunghezza di stringa
        for(int i = 1; i <= stringToEvaluate.length(); i++) {
            prefixes.add(stringToEvaluate.substring(0, i));
            //System.out.println(prefixes.get(i-1));
        }


        for(int i = 0; i < prefixes.size(); i++) {
            if(check(stringToEvaluate, prefixes.get(i))) {
                System.out.println(stringToEvaluate + " " + prefixes.get(i));
                result++;
            }
        }

        return result;
    }

    public static boolean check(String stringToEvaluate, String candidate) {
        int currIdx = 0;
        int lastIdx = 0;

        // Verifica le sovrapposizioni
        while (lastIdx < stringToEvaluate.length()) {
            int index = stringToEvaluate.indexOf(candidate, currIdx);

            if (index == -1) {
                return false;  // Se non troviamo la sottostringa, restituisci false
            }

            lastIdx = index + candidate.length();
            currIdx = index + 1;  // Per permettere sovrapposizioni
        }

        return lastIdx == stringToEvaluate.length();  // Se la stringa è stata coperta interamente
    }



    public static void main(String[] arg) throws FileNotFoundException {
        
        /*File[] inputFiles = inputDirectory.listFiles();
        File[] outputFiles = outputDirectory.listFiles();

        Arrays.sort(inputFiles);
        Arrays.sort(outputFiles);

        boolean correct = true;
        
        for (int i = 0; i < inputFiles.length; i++) {
            scanner = new Scanner(inputFiles[i]);
            scannerOutput = new Scanner(outputFiles[i]);

            int numTest = scanner.nextInt();
            scanner.nextLine();  // Consuma la nuova linea
        
            for (int j = 0; j < numTest; j++) {
                int alphabetLength = scanner.nextInt();
                int stringLength = scanner.nextInt();
                scanner.nextLine();  // Consuma la nuova linea
            
                String alphabet = scanner.nextLine();

                String stringToEvaluate = scanner.nextLine();

                char[] alphabetArray = alphabet.toCharArray();

                int result;
            }
        
            
        
            

            scanner.close();
            scannerOutput.close();

            break;
        }
            */

            String input = "3\n" +
            "2 11\nSG\nGGGSGGSGSGG\n" +
            "2 4\nPC\nCCCC\n" +
            "2 6\nHK\nHKHKHK\n";

    // Creiamo un oggetto Scanner per leggere l'input
    scanner = new Scanner(input);

    // Numero di test cases
    int numTest = scanner.nextInt();
    scanner.nextLine();  // Consuma la nuova linea

    for (int i = 0; i < numTest; i++) {
        int alphabetLength = scanner.nextInt();  // Lunghezza dell'alfabeto (non usato qui, ma presente nell'input)
        int stringLength = scanner.nextInt();    // Lunghezza della stringa da valutare
        scanner.nextLine();  // Consuma la nuova linea

        String alphabet = scanner.nextLine();    // Alfabeto
        String stringToEvaluate = scanner.nextLine(); // Stringa da valutare

        // Calcoliamo il numero di possibili sottostringhe che possono coprire la stringa
        char[] alphabetArray = alphabet.toCharArray();
        int result = calculate(alphabetArray, stringToEvaluate);

        // Stampiamo il risultato
        System.out.println(result);
    }

    scanner.close();

        

    }
}
