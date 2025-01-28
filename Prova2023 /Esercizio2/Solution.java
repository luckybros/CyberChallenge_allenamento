import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    // Lettura dalle directory da file
    public static File inputDirectory = new File("/Users/luketto/Desktop/CyberChallenge/Prova2025/Esercizio2/input/");
    public static File outputDirectory = new File("/Users/luketto/Desktop/CyberChallenge/Prova2025/Esercizio2/output/");

    private static Scanner scanner;
    private static Scanner scannerOutput;

    public static boolean canComplete(int[] tasks, int W, int T) {
        int[] workers = new int[W]; // Array per tenere traccia del tempo occupato dai worker
        Arrays.fill(workers, 0);

        for (int task : tasks) {
            // Trova il worker con il tempo rimanente maggiore
            int minIndex = 0;
            for (int i = 1; i < W; i++) {
                if (workers[i] < workers[minIndex]) {
                    minIndex = i;
                }
            }

            // Se il task non può essere assegnato a questo worker, non è valido
            if (workers[minIndex] + task > T) {
                return false;
            }

            // Assegna il task al worker
            workers[minIndex] += task;
        }

        return true;
    }

    public static int minimumWorkers(int[] tasks, int T) {
        Arrays.sort(tasks); // Ordina i task per ottimizzare la distribuzione

        for (int i = 0, j = tasks.length - 1; i < j; i++, j--) {
            int temp = tasks[i];
            tasks[i] = tasks[j];
            tasks[j] = temp;
        }

        int left = 1, right = tasks.length, result = tasks.length;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canComplete(tasks, mid, T)) {
                result = mid; // Prova con meno worker
                right = mid - 1;
            } else {
                left = mid + 1; // Serve più worker
            }
        }

        return result;
    }

    public static void main(String[] args) throws FileNotFoundException {
        
        /* 
        File[] inputFiles = inputDirectory.listFiles();
        File[] outputFiles = outputDirectory.listFiles();

        Arrays.sort(inputFiles);
        Arrays.sort(outputFiles);
        
        for (int i = 0; i < inputFiles.length; i++) {
            // Lettura per ogni file
            scanner = new Scanner(inputFiles[i]);
            scannerOutput = new Scanner(outputFiles[i]);
    
            scanner.close();
            scannerOutput.close(); 
        }
        
        */

        /* 
        scanner = new Scanner(System.in);
        */

        scanner = new Scanner(System.in);

        // Lettura input
        System.out.println("Inserisci il numero di task e il tempo T (es: 6 100):");
        int N = scanner.nextInt(); // Numero di task
        int T = scanner.nextInt(); // Durata del round

        int[] tasks = new int[N];
        System.out.println("Inserisci i tempi dei task separati da spazio (es: 12 49 87 21 11 31):");
        for (int i = 0; i < N; i++) {
            tasks[i] = scanner.nextInt();
        }

        // Calcolo del risultato
        int result = minimumWorkers(tasks, T);
        System.out.println("Numero minimo di worker necessari: " + result);

        scanner.close();
    }
}
