package com.den.DenCore.structures.linkedList;

import java.util.Objects;
import java.util.Optional;

/**
 * @author Denis Stepanidenko
 */
public class LinkedList<T> {

    /**
     * Размер списка
     */
    private int size;

    /**
     * Первый элемент в списке
     */
    private Node<T> head;

    /**
     * Последний элемент в списке
     */
    private Node<T> tail;

    public LinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Добавить элемент в конец
     *
     * @param data
     */
    public void add(T data) {
        Node<T> newNode = new Node<>(data);

        if (Objects.isNull(head)) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }

        tail.setNext(newNode);
        tail = newNode;
        size++;
    }

    /**
     * Добавить элемент в начала списка
     *
     * @param data
     */
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);

        if (Objects.isNull(head)) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }

        newNode.setNext(head);
        head = newNode;
        size++;
    }

    /**
     * Удаляет элемент по указанному индексу.
     *
     * @param index индекс элемента, который необходимо удалить
     * @return 1 в случае успешного удаления элемента,
     * -1 если указанный индекс некорректен или выходит за пределы списка
     */
    public Optional<T> remove(int index) {

        if (index < 0 || (index > (size - 1))) {
            return Optional.empty();
        }

        Node<T> dummy = new Node<>(null);
        dummy.setNext(head);

        int currentIndex = 0;
        Node<T> prev = dummy;
        Node<T> current = head;

        while (Objects.nonNull(current)) {
            if (index == currentIndex) {
                prev.setNext(current.getNext());
                head = dummy.getNext();

                if (currentIndex == (size - 1)) {
                    tail = prev;
                }
                return Optional.of(current.getData());
            } else {
                prev = current;
                current = current.getNext();
            }
            currentIndex++;
        }

        return Optional.empty();
    }

    /**
     * Удаляет все элементы по значению data
     */
    public void remove(T data) {
        Node<T> dummy = new Node<>(null);
        dummy.setNext(head);

        Node<T> prev = dummy;
        Node<T> current = head;
        int index = 0; // нужен для того, чтобы знать - обновлять ли указатель tail

        while (Objects.nonNull(current)) {
            if (Objects.equals(current.getData(), data)) {
                prev.setNext(current.getNext());

                if (index == (size - 1)) {
                    tail = prev;
                }
            } else {
                prev = current;
            }

            index++;
            current = current.getNext();

        }

        head = dummy.getNext();

    }

    /**
     * Поиск самого первого элемента по data
     *
     * @param data данные
     * @return true, если элемент был найден, false в противном случае
     */
    public boolean contains(T data) {

        if (size == 0) {
            return false;
        }

        Node<T> current = head;

        while (Objects.nonNull(current)) {

            if (Objects.equals(current.getData(), data)) {
                return true;
            }

            current = current.getNext();
        }


        return false;
    }

    public Optional<T> find(int index) {

        if (index < 0 || (index > (size - 1))) {
            return Optional.empty();
        }

        Node<T> current = head;
        int currentIndex = 0;


        while (Objects.nonNull(current)) {
            if (index == currentIndex) {
                return Optional.of(current.getData());
            } else {
                current = current.getNext();
            }

            currentIndex++;

        }


        return Optional.empty();

    }


    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder linkedList = new StringBuilder();

        if (Objects.isNull(head)) {
            return linkedList.toString();
        }

        Node<T> current = head;

        while (Objects.nonNull(current)) {
            linkedList.append(current.getData()).append(",");

            current = current.getNext();
        }

        return linkedList.deleteCharAt(linkedList.length() - 1).toString();
    }

    public Optional<T> getTail() {
        return Objects.isNull(tail) ? Optional.empty() : Optional.of(tail.getData());
    }

    public Optional<T> getHead() {
        return Objects.isNull(head) ? Optional.empty() : Optional.of(head.getData());
    }
}
