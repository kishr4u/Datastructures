package com.lafore;

class Node{

    Node(int in){
        data = in;
    }
    int data=0;
    Node next;

}
public class DoublyEndedList {

    //Double ended list has both first and last to store the fist and last items of the list
    /**
     * Doubly Linked List as Basis for Deques
     * A doubly linked list can be used as the basis for a deque, mentioned in the preceding
     * chapter. In a deque you can insert and delete at either end, and the doubly linked
     * list provides this capability.
     */
    Node first;
    Node last;

    DoublyEndedList(int i){
        first = null;
        last = null;
    }

    boolean isEmpty(){
        if(first == null && last == null)
           return true;
        return false;
    }
    public void insertFirst(int in){


        Node inList = new Node(in);
        if(isEmpty())
            last = inList;
        inList.next = first;

        first = inList;


    }

    public void deleteFirst(){
         first = first.next;
         if(first == null){
             last= null;
         }
    }

    public void insertLast(int in ){
        Node inList = new Node(in);
        last.next = inList;
        last = inList;
    }

}
