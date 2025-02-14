package com.den.DenCore.structures.stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.add(1);
        stack.add(2);
        stack.add(3);

        System.out.println(stack.peek());
        System.out.println(stack.poll());
        System.out.println(stack);
        System.out.println(stack.peek());
    }
}
