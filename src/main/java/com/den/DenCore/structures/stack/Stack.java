package com.den.DenCore.structures.stack;



import com.den.DenCore.structures.linkedList.LinkedList;

import java.util.Optional;

/**
 * @author Denis Stepanidenko
 */
public class Stack<T> {
    
    private LinkedList<T> stack;

    public Stack() {
        stack = new LinkedList<>();
    }

    /**
     * Добавить элемент в начало стека
     */
    public void add(T data) {
        stack.addFirst(data);
    }

    public int size() {
        return stack.size();
    }

    public Optional<T> peek() {
        return stack.find(0);
    }

    public Optional<T> poll() {
        return stack.remove(0);
    }


    @Override
    public String toString() {
        return stack.toString();
    }


}
