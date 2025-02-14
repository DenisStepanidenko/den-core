package com.den.DenCore.structures.linkedList;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Node<T> {

    private T data;
    private Node<T> next;

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public Node(T data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }

}
