package com.lafore;

class Node2{

    Node2(int in){
        data = in;
    }
    int data=0;
    Node2 next;
    Node2 prev;

}

public class CircularLinkedList {

    Node2 current;
    int size = -1;


    public void insert(int in){
        Node2 n = new Node2(in);
        if(current == null){
            current = n;
            current.next = current;
            current.prev = current;

        }else{

            current.next.prev = n;
            n.next = current.next;
            current.next = n;

            n.prev = current;
            current = n;
        }
        size++;

    }

    public void removeCurrent(){

        if(current != null){
            if(current.next == current && current.prev == current){
                current = null;
            }else {
                current.prev.next = current.next;
                current.next.prev = current.prev;
                current= current.next;
            }
        }
        size--;
    }

    public void display(){
        int pos = size;
        Node2 temp = current;
        while(pos> -1 ){
            System.out.println(temp.data);
            temp = temp.next;
            pos--;
        }

    }

    public static void main(String[] args){
        CircularLinkedList s = new CircularLinkedList();
        s.insert(1);
        s.insert(2);
        s.insert(3);
        s.insert(4);
        s.insert(5);
        s.display();
        System.out.println("data"+s.current.data);
        s.removeCurrent();
        System.out.println("data"+s.current.data);
        s.removeCurrent();
        s.display();
    }
}
