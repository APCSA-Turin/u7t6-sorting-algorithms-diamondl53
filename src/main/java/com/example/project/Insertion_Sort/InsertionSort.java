package com.example.project.Insertion_Sort;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {

    // PART A. implementing insertion sort
    public static int[] insertionSort(int[] elements) {
        int count = 0;
        int currentValue;
        int compareValue = Integer.MAX_VALUE;
        int j;
        for (int i = 1; i < elements.length; i++) {  // iterate through list starting at index 1
            currentValue = elements[i];
            j = i;
            while (j > 0 && elements[j-1] > currentValue) {  
                count++;    
                compareValue = elements[j-1];
                    elements[j] = compareValue;
            j--;
            }
            elements[j] = currentValue;
        }
        System.out.println("INSERTION SORT: Number of loop iterations: " + count);
    return elements;
}
    public static void main(String[] args) {
        int[] list = {5, 2, 9, 1, 5};
        insertionSort(list);
        for(int i = 0; i < list.length; i++){
            System.out.println(list[i]);
        }

        int[] arrA = {77, 97, 12, 38, 68, 33, 90, 88, 43, 17, 38, 45, 70, 63, 17, 65, 11, 49, 28, 15, 18, 68, 41, 33, 20, 54, 17, 25, 88, 15, 24, 58, 31, 14, 81};



        InsertionSort.selectionSort(arrA);
        System.out.println(Arrays.toString(arrA));
        System.out.println();
        int[] arrB = {77, 97, 12, 38, 68, 33, 90, 88, 43, 17, 38, 45, 70, 63, 17, 65, 11, 49, 28, 15, 18, 68, 41, 33, 20, 54, 17, 25, 88, 15, 24, 58, 31, 14, 81};


        InsertionSort.insertionSort(arrB);
        System.out.println(Arrays.toString(arrB));

    }
    
    public static void selectionSort(int[] elements) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        int temp;
        int count = 0;
        for(int i = 0; i < elements.length-1; i++){
            min = elements[i];
            for(int j = i+1; j < elements.length; j++){
                count++;
                if(elements[j]<min){
                    min = elements[j];
                    index = j;
                }
            }
            if(index != -1 && min<elements[i]){
                temp = elements[i];
                elements[i] = elements[index];
                elements[index] = temp;
            }
        }
       System.out.println("SELECTION SORT: Number of loop iterations: " + count);
    }

    // PART B. sorting a 1000-word list
    public static ArrayList<String> insertionSortWordList(ArrayList<String> words) {
        String currentString;
        int j;
        int count = 0;
        for(int i = 1; i < words.size(); i++){
            currentString = words.get(i);
            j = i;
            while(j > 0 && words.get(j-1).compareTo(currentString)>0){
                count++;
                words.set(j, words.get(j-1));
                j--;
            }
            words.set(j, currentString);
        }
        System.out.println("INSERTION SORT: Number of loop iterations: " + count);
        return words;
    }

    public static void selectionSortWordList(ArrayList<String> words) {
        int index = -1;
        String temp;
        String min;
        int count = 0;
        for(int i = 0; i < words.size()-1; i++){
            min = words.get(i);
            for(int j = i+1; j < words.size(); j++){
                count++;
                if(words.get(j).compareTo(min)<0){
                    min = words.get(j);
                    index = j;
                }
            }
            if(index != -1 && min.compareTo(words.get(i))<0){
                temp = words.get(i);
                words.set(i, words.get(index));
                words.set(index, temp);
            }
        }
        System.out.println("SELECTION SORT: Number of loop iterations: " + count);
    }

    public static ArrayList<String> loadWordsInto(ArrayList<String> wordList) {
        try {
            Scanner input = new Scanner(new File("src/main/java/com/example/project/Selection_Sort/words.txt"));
            while (input.hasNext()) {
                String word = input.next();
                wordList.add(word);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return wordList;
    }

   
}