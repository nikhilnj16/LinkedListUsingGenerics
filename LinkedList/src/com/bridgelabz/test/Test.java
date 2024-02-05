package com.bridgelabz.test;

class Node<T>{
    T key;
    Node<T> next;

    public Node(T key) {
        this.key = key;
        this.next = null;
    }
}

class MyLinkedLists<T>{
    Node<T> head;

    public MyLinkedLists() {
        this.head = null;
    }

    public void addNode(T data){
        Node<T> newNode = new Node<>(data);
        if(head == null){
            head = newNode;
        }
        else{
            Node<T> temp = head;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
    public void displayList(){
        Node<T> temp = head;
        while (temp != null){
            System.out.print(temp.key + "-> ");
            temp = temp.next;
        }
        System.out.println();
    }





}
public class Test {
    public static void main(String[] args) {
        MyLinkedLists <Integer> integerList = new MyLinkedLists<>();
        integerList.addNode(56);
        integerList.addNode(30);
        integerList.addNode(70);
        System.out.println("Linked List: ");
        integerList.displayList();
    }
}
