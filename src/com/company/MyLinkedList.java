package com.company;

public class MyLinkedList {

    private Node head; // considered first node in linked list
    private int count; // total count of all nodes in linked list


    /**
     * CONSTRUCTOR METHOD
     */
    MyLinkedList() {
        head = null;
        count = 0;
    }

    /**
     * ACCESSOR METHOD
     * @return count
     */
    public int getCount(){
        return count;
    }

    /**
     * ACCESSOR METHOD
     * @return Node tail
     */
    public Node getTail(){
        Node tmp = head;

        while(tmp.getNext() != null){
            tmp = tmp.getNext();
        }

        return tmp;
    }

    /**
     * MUTATOR METHOD
     * @param newCount
     */
    public void setCount(int newCount) {
        this.count = newCount;
    }

    /**
     * MUTATOR METHOD
     * @param headWord
     */
    public void setHead(String headWord){

        // create new node with word data parameter
        Node headNode = new Node(headWord);
        // set class variable Node 'head' to newly initialized node
        head = headNode;
        headNode.setNext(null);
    }

    /**
     * FUNCTIONALITY: adding new Node with data to LinkedList
     * @param newWord
     */
    public void add(String newWord){

        // start iteration at head of LinkedList
        Node tmp = head;
        // if the head does not exist yet, create it
        if (tmp == null){
            setHead(newWord);
            // increase LinkedList node count by 1
            count++;
            System.out.println("Generating head of List: " + head.getWord());
            return;
        }

        // search for word in LinkedList to determine whether to:
        // 1) create a new node and attach to tail of LinkedList
        // 2) or increase count of existing node b/c of matching word

        Node existingNode = search(newWord);

        if(existingNode == null){

           // if searched node doesn't exist in LinkedList, create new node
            Node n = new Node(newWord);

            // retrieve tail of LinkedList
            Node tail = getTail();

            // set the target's next Node to be the newly created node
            tail.setNext(n);

            // classify new node as tail
            n.setNext(null);

            // increase the overall LinkedList Node count
            count++;

            return;

        } else {

            // increase the count of existing Node's word count data
            existingNode.setCount(existingNode.getCount() + 1);

        }
        return;
    }

    /**
     * FUNCTIONALITY: search for node in LinkedList via node word data
     * as input
     * @param word
     * @return Node
     */
    public Node search(String word){
        Node tmp = head;

        while(tmp != null){
            // check each node's word data against parameter
            if(tmp.getWord().equals(word)){
                // if the word exists in linkedlist already, break out of loop
                break;
            }
            // if word does not exist in linkedlist, move on to the next node
            tmp = tmp.getNext();
        }
        return tmp;
    }

    /**
     * FUNCTIONALITY: tally number of words existing in linked list
     * @return int
     */
    public int getTotalWords(){
        Node tmp = head;
        // set initial count to 0
        int totalWords = 0;

        // loop through linked list
        while (tmp != null){
            // retrieve node's word count and add to total count
            totalWords += tmp.getCount();
            // proceed to next node in linkedlist
            tmp = tmp.getNext();
        }
        return totalWords;
    }

    /**
     * FUNCTIONALITY: send back number of nodes in linkedlist with word count of over 20
     * @return int
     */
    public int getNodesWithOver20(){

        Node tmp = head;
        // set initial word count to 0
        int numOfWords = 0;

        // loop through linked list
        while(tmp != null) {
            // if the node has word count data greater than 20
            if(tmp.getCount() > 20){
                // add 1 to word count
                numOfWords += 1;
            }
            // proceed to next node
            tmp = tmp.getNext();
        }
        return numOfWords;
    }

    /**
     * FUNCTIONALITY: method for returning Node with highest word count
     * @return
     */
    public Node mostFrequent(){

        Node tmp = head;
        // initial highest count Node as null
        Node mostFrequent = null;
        // initial word count set to 0
        int maxCount = 0;

        if(tmp.getNext() != null){
            // loop through linkedlist so long as the next node to current node exists
            for (Node node = tmp; node != null; node = node.getNext()){
                // if the node's word count is higher than the resting maximum count,
                // replace resting node with the current node and maxCount with current
                // node's word count
                if(node.getCount() > maxCount){
                    mostFrequent = node;
                    maxCount = mostFrequent.getCount();
                }
            }
        }
        // by the end of the loop, the node with the highest count will remain as the
        // returned Node
        return mostFrequent;
    }

    /**
     * FUNCTIONALITY: method for returning Node that contains word with highest length
     * @return Node
     */
    public Node longestWord() {

        Node tmp = head;
        // set initial winning Node as null
        Node longestWord = null;
        // set initial length of Node's word data to 0
        int maxLength = 0;

        // if current node is NOT the tail
        if (tmp.getNext() != null) {
            // loop through linked list
            for (Node node = tmp; node != null; node = node.getNext()) {
                // compare length of node's word length to resting length
                if (node.getWord().length() > maxLength) {
                    // replace resting Node with current node
                    longestWord = node;
                    // replace resting node word length with current node's word length
                    maxLength = longestWord.getWord().length();
                }
            }
        }
        // by the end of the loop, the node with the highest word length count will
        // remain as the returned Node
        return longestWord;
    }

    /**
     * FUNCTIONALITY: method to print out each word
     * and it's word count of each node in LinkedList
     */
    public void print() {
        // start at the head of the LinkedList
        Node currentNode = head;
        System.out.println("LinkedList: ");
        // loop through LinkedList
        while (currentNode != null) {
            // print out node's word and word count
            System.out.println("Word: " + currentNode.getWord() + " -- Count: " + currentNode.getCount() + " ");
            // proceed to next node in linked list
            currentNode = currentNode.getNext();
        }
    }

    // class for returning the Previous and Current node
    public class PrevCur {

        private Node prev;
        private Node cur;

        /**
         * ACCESSOR METHOD
         * @return prev
         */
        public Node getPrev(){
            return prev;
        }

        /**
         * ACCESSOR METHOD
         * @return cur
         */
        public Node getCur(){
            return cur;
        }

        /**
         * MUTATOR METHOD
         * @param prev
         */
        public void setPrev(Node prev){
            this.prev = prev;
        }

        /**
         * MUTATOR METHOD
         * @param cur
         */
        public void setCur(Node cur){
            this.cur = cur;
        }
    }

    /**
     * FUNCTIONALITY: method for finding Node in linkedlist with capabilities
     * of calling it's previous and current Node and their respective details
     * @param word
     * @return
     */
    public PrevCur prevSearch(String word){
        // set current Node to head
        Node cur = head;
        // previous Node is defaulted to null
        Node prev = null;

        // initialize new PrevCur
        PrevCur node = new PrevCur();
        node.setPrev(null);
        node.setCur(head);

        while(node.getCur() != null){
            if(node.getCur().getWord().equals(word)){
                // return null if the head is the target
                return node;
            }
            // set the previous to the current
            node.setPrev(node.getCur());
            // set the current to the next and proceed to next node in list
            node.setCur(node.getCur().getNext());
        }

        return node;
    }

}
