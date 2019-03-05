package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Main me = new Main();
        me.doIt();

    }

    public void doIt() throws FileNotFoundException {

        // Utilize the File class to open the local file containing the book text
        File file = new File("/Users/nnennandukwe/IdeaProjects/TextParser/src/com/company/dorian_gray.txt");

        // Initialize new linked list class
        MyLinkedList list = new MyLinkedList();

        // Initialize new Scanner object with Dorian Gray text file as input
        Scanner read = new Scanner(file);

        System.out.println("-----------------------");
        System.out.println("-----------------------");

        // Iterate through each line in text file
        // with the new Scanner object's intake, the Dorian Gray file
        while (read.hasNextLine()) {

            // Parse each word by replacing any punctuation using regex
            // and translate all letters to lower case letters
            String word = read.next().replaceAll(
                    "\\p{Punct}", ""
            ).toLowerCase();

            // add each word to the Linked List
            list.add(word);

        }

        // Find count of specific words that appear in the text:
        // 1) implement search
        // 2) print out word and word count
        String[] wordBank = {
            "portrait",
            "persian",
            "dorian",
            "experimental",
            "magnetic",
        };

        for(String entry : wordBank){

            // search for Node in LinkedList
            Node node = list.search(entry);

            // if node exists, print out Node word data and word count
            if (node != null) {
                System.out.println("Word: " + node.getWord() + " -- Count:  " + node.getCount());

            // if node DOES NOT exist, word count is 0
            // print out word that was searched and unsuccessfully found
            } else {
                System.out.println("Word: " + entry + " -- Count: " + 0);
            }
        }
        System.out.println("-----------------------");
        // Display count of nodes in LinkedList
        System.out.println("NUMBER OF NODES IN LINKEDLIST: " + list.getCount());
        System.out.println("-----------------------");
        // Calculate the number of words in LinkedList:
        System.out.println("NUMBER OF ALL WORDS IN LINKEDLIST: " + list.getTotalWords());
        System.out.println("-----------------------");
        // Print out the number of nodes that occur in list more than 20 times
        System.out.println("NUMBER OF WORDS OCCURRING MORE THAN 20 TIMES: " +  list.getNodesWithOver20());
        System.out.println("-----------------------");
        // Print out most frequent word showing word and word count
        System.out.println("MOST FREQUENT WORD: ");
        System.out.println("Word: " + list.mostFrequent().getWord() + " -- Count: " + list.mostFrequent().getCount());
        System.out.println("LONGEST WORD ---------- ");
        // Print out longest word in Linked List by calling longestWord method
        System.out.println("Word: " + list.longestWord().getWord());
        System.out.println("-----------------------");
        System.out.println("WORD BEFORE THE WORD 'IRRITATING': ");
        // Call search method from Linked List -> PrevCur class
        MyLinkedList.PrevCur previous = list.prevSearch("irritating");
        // Print out word that represents previous node for searched node
        System.out.println(previous.getPrev().getWord());

        // close Scanner
        read.close();
    }
}
