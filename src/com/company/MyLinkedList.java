package com.company;

public class MyLinkedList {

    private Node head;
    private int count;

    MyLinkedList() {
        head = null;
        count = 0;
    }

    public int getCount(){
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void add(String newWord){

        Node tmp = head;

        // if the head does not exist yet, create it
        if (tmp == null){
            setHead(newWord);

            // increase LinkedList count
            count++;
            System.out.println("Generating head of List: " + head.getWord());
            return;
        }

        Node existingNode = search(newWord);

        // search for word in LinkedList to determine whether to:
        // 1) create a new node and attach to tail of LinkedList
        // 2) or increase count of existing node b/c of matching word

        if(existingNode == null){

           // if it doesn't exist in LinkedList, create new node
            Node n = new Node(newWord);

            // retrieve tail of LinkedList
            Node tail = getTail();

            // set the target's next to be the new node
            tail.setNext(n);

            // classify new node as tail
            n.setNext(null);

            // increase the LinkedList count
            count++;

            return;

        } else {

            // increase the count of existing Node
            existingNode.setCount(existingNode.getCount() + 1);

        }
        return;
    }

    public Node getTail(){
        Node tmp = head;

        while(tmp.getNext() != null){
            tmp = tmp.getNext();
        }

        return tmp;
    }

    public void setHead(String headWord){

        Node headNode = new Node(headWord);
        head = headNode;
        headNode.setNext(null);
    }

    public Node search(String word){
        Node tmp = head;
        while(tmp != null){
            if(tmp.getWord().equals(word)){
                // if found, break out of it
                break;
            }
            // if not found, move on to the next one
            tmp = tmp.getNext();
        }
        return tmp;
    }

    public int getTotalWords(){
        Node tmp = head;
        int totalWords = 0;

        while (tmp != null){
            totalWords += tmp.getCount();

            tmp = tmp.getNext();
        }
        return totalWords;
    }

    public int getNodesWithOver20(){

        Node tmp = head;
        int numOfWords = 0;
        while(tmp != null) {
            if(tmp.getCount() > 20){
                numOfWords += 1;
            }
            tmp = tmp.getNext();
        }
        return numOfWords;
    }

    public Node mostFrequent(){

        Node tmp = head;
        Node mostFrequent = null;
        int maxCount = 0;

        if(tmp.getNext() != null){
            for (Node node = tmp; node != null; node = node.getNext()){
                if(node.getCount() > maxCount){
                    mostFrequent = node;
                    maxCount = mostFrequent.getCount();
                }
            }
        }

        return mostFrequent;
    }

    public Node longestWord() {

        Node tmp = head;
        Node longestWord = null;
        int maxLength = 0;

        if (tmp.getNext() != null) {
            for (Node node = tmp; node != null; node = node.getNext()) {
                if (node.getWord().length() > maxLength) {
                    longestWord = node;
                    maxLength = longestWord.getWord().length();
                }
            }
        }
        return longestWord;
    }

    public void print() {
        Node currentNode = head;
        System.out.println("LinkedList: ");

        while (currentNode != null) {
            System.out.println("Word: " + currentNode.getWord() + " -- Count: " + currentNode.getCount() + " ");
            currentNode = currentNode.getNext();
        }
    }

    public class PrevCur {
        private Node prev;
        private Node cur;

        public Node getPrev(){
            return prev;
        }

        public Node getCur(){
            return cur;
        }

        public void setPrev(Node prev){
            this.prev = prev;
        }

        public void setCur(Node cur){
            this.cur = cur;
        }
    }

    public PrevCur prevSearch(String word){
        Node cur = head; // set cursor to head
        Node prev = null; //previous is null

        PrevCur d = new PrevCur();
        d.setPrev(null);
        d.setCur(head);

        while(d.getCur() != null){
            if(d.getCur().getWord().equals(word)){
                return d; // return null if the head is the target
            }
            d.setPrev(d.getCur()); //set the previous to the current ...
            d.setCur(d.getCur().getNext()); //set the current to the next and go again
        }

        return d;
    }

}
