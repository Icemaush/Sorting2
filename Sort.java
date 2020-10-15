package at2.q3;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.stream.Stream;

public class Sort {
    // Merge sort
    public static Integer[] MergeSort(Integer[] array) {
        if (array.length <= 1) {
            return array;
        }
        
        Integer[] first = new Integer[array.length / 2];
        Integer[] second = new Integer[array.length - first.length];
        System.arraycopy(array, 0, first, 0, first.length);
        System.arraycopy(array, first.length, second, 0, second.length);
        
        MergeSort(first);
        MergeSort(second);
        
        Merge(first, second, array);
        return array;
    }
    
    private static void Merge(Integer[] first, Integer[] second, Integer[] result) {
        int firstIndex = 0;
        int secondIndex = 0;
        int mergedIndex = 0;
        
        while (firstIndex < first.length && secondIndex < second.length) {
            if (first[firstIndex].compareTo(second[secondIndex]) < 0) {
                result[mergedIndex] = first[firstIndex];
                firstIndex++;
            } else {
                result[mergedIndex] = second[secondIndex];
                secondIndex++;
            }
            mergedIndex++;
        }
        
        System.arraycopy(first, firstIndex, result, mergedIndex, first.length - firstIndex);
        System.arraycopy(second, secondIndex, result, mergedIndex, second.length - secondIndex);
    }
    
    
    // Bubble sort
    public static void BubbleSort(Integer[] intArray) {
        int length = intArray.length;
        int temp;
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < (length - i); j++) {
                if (intArray[j - 1] > intArray[j]) {
                    temp = intArray[j - 1];
                    intArray[j - 1] = intArray[j];
                    intArray[j] = temp;
                }
            }
        }
    }
    
    // In-built sort with comparator
    public static void InBuiltSort(LinkedList<Integer> list) {
        Collections.sort(list, new SalaryComparator());
    }
    
    public static void PerformMergeSort(LinkedList<Integer> list) {
        Object[] objArray = list.toArray();
        int length = objArray.length;
        Integer[] intArray = new Integer[length];
        
        for (int i = 0; i < length; i++) {
            intArray[i] = (int)objArray[i];
        }
        
        System.out.println("\n--- MERGE SORT ---");
        System.out.println("Performing merge sort...");

        long startTime = System.currentTimeMillis();
        MergeSort(intArray);
        long stopTime = System.currentTimeMillis();

        System.out.println("Merge sort complete.");
        System.out.println(Arrays.toString(intArray));
        
        System.out.println("\nTime to execute: " + ((stopTime - startTime) / 1000.0) + " seconds\n");
    }
    
    public static void PerformBubbleSort(LinkedList<Integer> list) {
        Object[] objArray = list.toArray();
        int length = objArray.length;
        Integer[] intArray = new Integer[length];
        
        for (int i = 0; i < length; i++) {
            intArray[i] = (int)objArray[i];
        }
        
        System.out.println("\n--- BUBBLE SORT ---");
        System.out.println("Performing bubble sort...");

        long startTime = System.currentTimeMillis();
        BubbleSort(intArray);
        long stopTime = System.currentTimeMillis();

        System.out.println("Bubble sort complete.");
        System.out.println(Arrays.toString(intArray));
        
        System.out.println("\nTime to execute: " + ((stopTime - startTime) / 1000.0) + " seconds\n");
    }
    
    public static void PerformInBuiltSort(LinkedList<Integer> list) {       
        System.out.println("\n--- IN-BUILT SORT (Collections.sort()) w/ Comparator ---");
        System.out.println("Performing in-built sort...");

        long startTime = System.currentTimeMillis();
        InBuiltSort(list);
        long stopTime = System.currentTimeMillis();

        System.out.println("In-built sort complete.\n");
        int[] array = list.stream().mapToInt(i->i).toArray();
        System.out.println(Arrays.toString(array));
        
        System.out.println("\nTime to execute: " + ((stopTime - startTime) / 1000.0) + " seconds\n");
    }
}
