package com.bridgelabz.test;
import org.junit.*;

import static org.junit.Assert.*;

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

    public T deleteFirst(){
        T val = head.data;
        head = head.next;
        if (head == null){
            tail = null;
        }
        size--;
        return val;

    }

    public T deleteLast(){
        if (size <= 1){
            return deleteFirst();
        }
        MyNode<T> node = head;
        while (node.next != tail){
            node = node.next;
        }
        T val = tail.data;
        node.next = null;
        tail = node;
        return val;
    }


    public T search(T data){
        MyNode<T> node = head;
        while (node != null) {
            if (node.data == data){
                return node.data;
            }
            node = node.next;
        }
        return null;
    }

    public void insertBetweenValues(T newData, T data){

        temp = head;
        MyNode<T> newNode = new MyNode<>(newData);

        while (temp != null && !temp.data.equals(data)){
            temp = temp.next;
        }
        if(temp == null){
            throw new IllegalStateException("Data not found in the list");
        }
        newNode.next = temp.next;
        temp.next = newNode;
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
        integerList.insertBetweenValues(40, 30);
        System.out.println("Linked List: ");
        integerList.displayList();



        System.out.println(integerList.deleteLast());
        System.out.println("Linked List after deletion: ");
        integerList.displayList();

        System.out.println(integerList.search(30));
//        MyNode foundNode = integerList.search(30);
//        assertNotNull(foundNode);
//        assertEquals(30, foundNode.data);
//
//        MyNode notFoundNode = integerList.search(40);
//        assertNull(notFoundNode);

    }
}
