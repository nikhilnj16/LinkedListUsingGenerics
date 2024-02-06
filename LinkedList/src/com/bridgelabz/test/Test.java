package com.bridgelabz.test;

class MyNode<T>{
    T data;
    MyNode<T> next;

    public MyNode(T data) {
        this.data = data;
        this.next = null;
    }
}

class MyLinkedLists<T>{
    MyNode<T> head;
    public MyLinkedLists() {
        this.head = null;
    }

    public void InsertFirst(T data){
        MyNode<T> AddFirstNode = new MyNode<>(data);
        AddFirstNode.next = head;
        head = AddFirstNode;

    }

    public void addNode(T data){
        MyNode<T> newNode = new MyNode<>(data);
        if(head == null){
            head = newNode;
        }
        else{
            MyNode<T> temp = head;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
    public void displayList(){
        MyNode<T> temp = head;
        while (temp != null){
            System.out.print(temp.data + "-> ");
            temp = temp.next;
        }
        System.out.println();
    }





}
public class Test {
    public static void main(String[] args) {
        MyLinkedLists <Integer> integerList = new MyLinkedLists<>();
        integerList.InsertFirst(70);
        integerList.InsertFirst(30);
        integerList.InsertFirst(56);
        System.out.println("Linked List: ");
        integerList.displayList();
    }
}
