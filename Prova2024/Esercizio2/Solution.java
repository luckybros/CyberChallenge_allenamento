import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Solution {
    
    public static File inputDirectory = new File("/Users/luketto/Desktop/CyberChallenge/Prova2024/Esercizio2/input/");
    public static File outputDirectory = new File("/Users/luketto/Desktop/CyberChallenge/Prova2024/Esercizio2/output/");

    private static Scanner scanner;
    private static Scanner scannerOutput;

    public static long calculate(List<String> code) {
        HashMap<String, Long> characterStatus = new HashMap<>();
        HashMap<String, Integer> labels = new HashMap<>();
   
        characterStatus.put("a", 0L);
        characterStatus.put("b", 0L);
        characterStatus.put("c", 0L);
        characterStatus.put("d", 0L);
        characterStatus.put("e", 0L);
        characterStatus.put("f", 0L);
   
        int i = 0;
        while (i < code.size()) {
            String instruction = code.get(i);
            String[] instructions = instruction.split(" ");
            
            if(instructions[0].equals("add")) {
                String variable = instructions[1];
                Integer operator = Integer.parseInt(instructions[2]);
   
                characterStatus.put(variable, characterStatus.get(variable) + operator);
   
            } else if(instructions[0].equals("sub")) {
                String variable = instructions[1];
                Integer operator = Integer.parseInt(instructions[2]);
   
                characterStatus.put(variable, characterStatus.get(variable) - operator);
   
            } else if(instructions[0].equals("mul")) {
                String variable = instructions[1];
                Integer operator = Integer.parseInt(instructions[2]);
   
                characterStatus.put(variable, characterStatus.get(variable) * operator);
   
            } else if(instructions[0].equals("lab")) {
                labels.put(instructions[1], i);
   
            } else if(instructions[0].equals("jmp")) {
                Long variableValue = characterStatus.get(instructions[1]);
                Integer number = Integer.parseInt(instructions[2]);
                String labelToJump = instructions[3];
   
                if(variableValue != null && variableValue.equals((long) number)) {
                    // Aggiungi il salto
                    i = labels.get(labelToJump); // Non sommare 1, i è già l'indice giusto
                }
            }
            
            // Continua con la prossima istruzione
            i++;
        }
        
        long result = 0;
        Collection<Long> results = characterStatus.values();
   
        for(Long number : results) 
            result += number;
   
        return result;
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
    
            long expectedResult = scannerOutput.nextLong();
    
            int numOperations = scanner.nextInt();
            scanner.nextLine();
    
            List<String> code = new ArrayList<>();
    
            for(int j = 0; j < numOperations; j++)
                code.add(scanner.nextLine());
    
            scanner.close();
            scannerOutput.close();
    
            long result = calculate(code);

            if (result != expectedResult) {
                System.out.println("Ottenuto: " + result);
                System.out.println("Aspettato: " + expectedResult);
                System.out.println(outputFiles[i].getName());
                System.err.println();
                correct = false;
                
            }
        }

        if(correct) System.out.println("ALL TEST PASSED");
        else System.out.println("NOT ALL TEST PASSED");
        
    
    }
}
