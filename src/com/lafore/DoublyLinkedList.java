package com.lafore;

class Node1{

    Node1(int in){
        data = in;
    }
    int data=0;
    Node1 next;
    Node1 prev;

}

public class DoublyLinkedList {

    Node1 first;
    Node1 last;

    public void insertFirst(int in){
        Node1 n = new Node1(in);
        if(first == null){
            first = n;
            last = n;
        }
        else{
            n.next=first;
            first.prev =n;
            first = n;
        }

    }

    public void insertAfter(int key, int in){
        Node1 n = new Node1(in);
        Node1 pos = first;

        while (pos != null && pos.data != key ){
            pos = pos.next;
        }
        if(pos == null){
            System.out.println("key not found");
        }
        if(pos.next == null){
            last = n;
        }else{
            pos.next.prev = n;
        }
        n.next = pos.next;
        n.prev = pos;

        pos.next=n;

    }
}
