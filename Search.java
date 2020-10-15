package at2.q3;

import java.util.LinkedList;
import java.util.Scanner;

public class Search {
    // Binary search 
    public static String BinarySearch(LinkedList<Integer> list, int target) {
        int first = 0;
        int last = list.size() - 1;
        int mid = (first + last) / 2;
        
        while (first <= last) {
            if (list.get(mid) < target) {
                first = mid + 1;
            } else if (list.get(mid) == target) {
                return "Target '" + target + "' found at index " + mid + ".";
            } else {
                last = mid - 1;
            }
            mid = (first + last) / 2;
        }
        
        if (first > last) {
            return "Target not found.";
        }
        return "";
    }
    
    // Linear search
    public static String LinearSearch(LinkedList<Integer> list, int target) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == target) {
                return "Target '" + target + "' found at index " + i + ".";
            }
        }
        
        return "Target not found.";
    }
    
    // In-built search
    public static String InBuiltSearch(LinkedList<Integer> list, int target) {
        int index = list.indexOf(target);
        if (index >= 0) {
            return "Target '" + target + "' found at index " + list.indexOf(target) + ".";
        } else {
            return "Target not found.";
        }
    }
    
    public static void PerformBinarySearch(LinkedList<Integer> list) {
        LinkedList<Integer> newList = new LinkedList<>(list);
        int input;
        Scanner sc = new Scanner(System.in);
        
        // SORT LIST BEFORE PERFORMING BINARY SEARCH
        System.out.println("\nSorting list for binary search...");
        Sort.InBuiltSort(newList);
        
        System.out.println("\n--- BINARY SEARCH ---");
        System.out.print("Enter salary to search for: ");
        input = sc.nextInt();
        System.out.println("Performing binary search...");

        long startTime = System.currentTimeMillis();
        System.out.println(BinarySearch(newList, input));
        long stopTime = System.currentTimeMillis();

        System.out.println("\nTime to execute: " + ((stopTime - startTime) / 1000.0) + " seconds\n");
    }
    
    public static void PerformLinearSearch(LinkedList<Integer> list) {
        int input;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\n--- LINEAR SEARCH ---");
        System.out.print("Enter salary to search for: ");
        input = sc.nextInt();
        System.out.println("Performing linear search...");

        long startTime = System.currentTimeMillis();
        System.out.println(LinearSearch(list, input));
        long stopTime = System.currentTimeMillis();

        System.out.println("\nTime to execute: " + ((stopTime - startTime) / 1000.0) + " seconds\n");
    }
    
    public static void PerformInBuiltSearch(LinkedList<Integer> list) {
        int input;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\n--- IN-BUILT SEARCH (.indexOf) ---");
        System.out.print("Enter salary to search for: ");
        input = sc.nextInt();
        System.out.println("Performing in-built search...");

        long startTime = System.currentTimeMillis();
        System.out.println(InBuiltSearch(list, input));
        long stopTime = System.currentTimeMillis();

        System.out.println("\nTime to execute: " + ((stopTime - startTime) / 1000.0) + " seconds\n");
    }   
}
