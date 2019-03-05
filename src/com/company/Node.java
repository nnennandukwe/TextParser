package com.company;

public class Node {

    private String word;
    private Node next;
    private int count;

    public Node(){
        word = null;
        next = null;
        count = 0;
    }

    public Node(String newWord){
        word = newWord;
        next = null;
        count = 1;
    }

    public String getWord() {
        return word;
    }

    public Node getNext() {
        return next;
    }

    public int getCount(){
        return count;
    }

    public void setWord(String newWord){
        word = newWord;
    }

    public void setNext(Node newNext) {
        next = newNext;
    }

    public void setCount(int newCount) {
        count = newCount;
    }

}
