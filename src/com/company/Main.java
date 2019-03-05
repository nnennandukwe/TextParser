package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Main me = new Main();
        me.doIt();

    }

    public void doIt() throws FileNotFoundException {

        File file = new File("/Users/nnennandukwe/IdeaProjects/TextParser/src/com/company/dorian_gray.txt");

        MyLinkedList list = new MyLinkedList();

        Scanner read = new Scanner(file);

        System.out.println("CURRENTLY: parsing file " + file);
        System.out.println("Please wait until completion...");

        System.out.println("-----------------------");
        System.out.println("-----------------------");
        while (read.hasNextLine()) {

            String word = read.next().replaceAll(
                    "\\p{Punct}", ""
            ).toLowerCase();
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

            // If node exists, print out Node details
            if (node != null) {
                System.out.println("Word: " + node.getWord() + " -- Count:  " + node.getCount());

                // if not does not exist, word count is 0
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
        System.out.println("\n\n-----------------------");
        // Print out the number of words that occur in list more than 20 times
        System.out.println("NUMBER OF WORDS OCCURRING MORE THAN 20 TIMES: " +  list.getNodesWithOver20());
        System.out.println("-----------------------");
        System.out.println("-----------------------");
        System.out.println("MOST FREQUENT WORD: ");
        System.out.println("Word: " + list.mostFrequent().getWord() + " -- Count: " + list.mostFrequent().getCount());
        System.out.println("LONGEST WORD ---------- ");
        System.out.println("Word: " + list.longestWord().getWord());

        System.out.println("WORD BEFORE THE WORD 'IRRITATING': ");
        MyLinkedList.PrevCur previous = list.prevSearch("irritating");
        System.out.println(previous.getPrev().getWord());

    }
}
