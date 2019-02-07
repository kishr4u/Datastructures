package com.lafore;

class Node{

    Node(int in){
        data = in;
    }
    int data=0;
    Node next;

}
public class DoublyEndedList {


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
