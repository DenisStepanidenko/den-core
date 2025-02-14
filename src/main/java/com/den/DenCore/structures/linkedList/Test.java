package com.den.DenCore.structures.linkedList;

public class Test {

    public static void main(String[] args) {
        LinkedList<String> test = new LinkedList<>();

        test.add("test1");
        test.add("test2");
        test.add("test3");

        test.remove(2);
        System.out.println("tail : " + test.getTail());
        System.out.println("head : " + test.getHead());
        System.out.println(test);


    }
}
