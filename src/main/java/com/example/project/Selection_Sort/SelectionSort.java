package com.example.project.Selection_Sort;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;

public class SelectionSort {

    // PART A. implementing selection sort
    public static int[] selectionSort(int[] elements) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        int temp;
        for(int i = 0; i < elements.length-1; i++){
            min = elements[i];
            for(int j = i+1; j < elements.length; j++){
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
       return elements;
    }


    // PART B. sorting a 1000-word list
    public static ArrayList<String> selectionSortWordList(ArrayList<String> words) {
        int index = -1;
        String temp;
        String min;
        for(int i = 0; i < words.size()-1; i++){
            min = words.get(i);
            for(int j = i+1; j < words.size(); j++){
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
        return words;
    }

    //call this method to load 1000 words into list. Use it to test Part B
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
