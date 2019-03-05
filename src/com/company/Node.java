package com.company;

public class Node {

    private String word;
    private Node next;
    private int count;

    public Node(String newWord){
        word = newWord;
        next = null;
        count = 1; // set default count of word to 1
    }

    /**
     * ACCESSOR METHOD
     * @return word
     */
    public String getWord() {
        return word;
    }

    /**
     * ACCESSOR METHOD
     * @return next
     */
    public Node getNext() {
        return next;
    }

    /**
     * ACCESSOR METHOD
     * @return count
     */
    public int getCount(){
        return count;
    }

    /**
     * MUTATOR METHOD
     * @param newWord
     */
    public void setWord(String newWord){
        word = newWord;
    }

    /**
     * MUTATOR METHOD
     * @param newNext
     */
    public void setNext(Node newNext) {
        next = newNext;
    }

    /**
     * MUTATOR METHOD
     * @param newCount
     */
    public void setCount(int newCount) {
        count = newCount;
    }

}
