package at2.q3;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Program {
    
    
    public static void main(String[] args) {
        LinkedList<Integer> salaryList = new LinkedList<>();
        int input;
        long startTime;
        long stopTime;
        
        // Display duration to add 100,000 salaries to list
        AddSalaries(salaryList);
        DisplaySalaries(salaryList);
        System.out.println("");
        
        DisplayMenu(salaryList);

        
    }
    
    // Add randomly generated salaries to salaries list
    private static void AddSalaries(LinkedList<Integer> list) {
        for (int i = 0; i < 1_000_000; i++) {
            list.add(GetNumber());
        }
    }
    
    // Generate random number between 1 - 10,000,000
    private static int GetNumber() {
        Random rand = new Random();
        return rand.nextInt(10_000_000) + 1;
    }
    
    public static void DisplaySalaries(LinkedList<Integer> list) {
        for (int i : list) {
            System.out.println(i);
        }
    }
    
    private static void DisplayMenu(LinkedList<Integer> list) {
        while (true) {
            int input;
            Scanner sc = new Scanner(System.in);

            System.out.println("1. Binary Search");
            System.out.println("2. Linear Search");
            System.out.println("3. In-built Search (.indexOf)");
            System.out.println("4. Merge Sort");
            System.out.println("5. Bubble Sort");
            System.out.println("6. In-built Sort");
            System.out.print("Select an option: ");
            input = sc.nextInt();
            
            switch (input) {
                case 1:
                    Search.PerformBinarySearch(list);
                    break;
                case 2:
                    Search.PerformLinearSearch(list);
                    break;
                case 3:
                    Search.PerformInBuiltSearch(list);
                    break;
                case 4:
                    Sort.PerformMergeSort(list);
                    break;
                case 5:
                    Sort.PerformBubbleSort(list);
                    break;
                case 6:
                    Sort.PerformInBuiltSort(list);
                    break;
                default:
                    break;
            }
        }
    }
}
