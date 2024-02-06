package com.bridgelabz.test;

class MyNode<T>{
    T data;
    MyNode<T> next;

    public MyNode(T data) {
        this.data = data;
        this.next = null;
    }
    public MyNode(T data, MyNode<T> next) {
        this.data = data;
        this.next = next;
    }
}

class MyLinkedLists<T>{
    MyNode<T> head;
    MyNode<T> tail;
    MyNode<T> temp;
    int size=0;
    public MyLinkedLists() {
        this.head = null;
        this.tail = null;
    }

    public void insertFirst(T data){
        MyNode<T> AddFirstNode = new MyNode<>(data);
        AddFirstNode.next = head;
        head = AddFirstNode;
        if (tail == null){
            tail = head;
        }
        size++;

    }
    public void insertLast(T data){
        if (tail == null){
            insertFirst(data);
            return;
        }
        MyNode<T> node = new MyNode<>(data);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insertBetween(T data, int index){
        if (index == 0){
            insertFirst(data);
            return;
        }
        if (index == size){
            insertLast(data);
            return;
        }
        temp = head;
        for(int i = 1 ; i < index; i++){
            temp = temp.next;
        }
        MyNode<T> node = new MyNode<T>(data, temp.next );
        temp.next = node;
        size++;
    }

//    public void addNode(T data){
//        MyNode<T> newNode = new MyNode<>(data);
//        if(head == null){
//            head = newNode;
//        }
//        else{
//            MyNode<T> temp = head;
//            while (temp.next != null){
//                temp = temp.next;
//            }
//            temp.next = newNode;
//        }
//    }
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
        integerList.insertFirst(56);
        integerList.insertLast(70);
        integerList.insertBetween(30, 1);
        System.out.println("Linked List: ");
        integerList.displayList();

    }
}
