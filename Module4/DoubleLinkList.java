package Module4;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Collection;
import java.util.NoSuchElementException;

public class DoubleLinkList {
  public static void main(String[] args) {
    new DoubleLinkList();
  }
  
  public DoubleLinkList() {
    TwoWayLinkedList<Double> list = new TwoWayLinkedList<>();
    System.out.print("Enter five numbers: ");
    Scanner input = new Scanner(System.in);
    double[] v = new double[5];
    for (int i = 0; i < 5; i++) 
      v[i] = input.nextDouble();

    list.add(v[1]);
    list.add(v[2]);
    list.add(v[3]);
    list.add(v[4]);
    list.add(0, v[0]);
    list.add(2, 10.55);
    list.remove(3);
    input.close();

    java.util.ListIterator<Double> iterator1 = list.listIterator();
    System.out.print("The list in forward order: ");
    while (iterator1.hasNext())
      System.out.print(iterator1.next() + " ");

    java.util.ListIterator<Double> iterator2 = list.listIterator(list.size() - 1);
    System.out.print("\nThe list in backward order: ");
    while (iterator2.hasPrevious())
      System.out.print(iterator2.previous() + " ");
  }
}

interface MyList<E> extends java.util.Collection<E> {
  public void add(int index, E e);
  public E get(int index);
  public int indexOf(Object e);
  public int lastIndexOf(E e);
  public E remove(int index);
  public E set(int index, E e);
  
  @Override
  public default boolean add(E e) { 
    add(size(), e); return true; 
  }

  @Override
  public default boolean isEmpty() { 
    return size() == 0; 
  }

  @Override
  public default boolean remove(Object e) {
    if (indexOf(e) >= 0) { 
      remove(indexOf(e)); 
      return true; 
    }
    return false;
  }

  @Override 
  public default boolean containsAll(Collection<?> c) { 
    return true; 
  }

  @Override 
  public default boolean addAll(Collection<? extends E> c) { 
    return true; 
  }

  @Override 
  public default boolean removeAll(Collection<?> c) { 
    return true; 
  }

  @Override 
  public default boolean retainAll(Collection<?> c) { 
    return true; 
  }

  @Override 
  public default Object[] toArray() { 
    return null; 
  }

  @Override 
  public default <T> T[] toArray(T[] array) { 
    return null; 
  }
}

class TwoWayLinkedList<E> implements MyList<E> {
  private Node<E> head, tail;
  private int size;

  public TwoWayLinkedList() {}
  public TwoWayLinkedList(E[] objects) { for (E e : objects) add(e); }

  public E getFirst() { return (size == 0) ? null : head.element; }
  public E getLast() { return (size == 0) ? null : tail.element; }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder("[");
    Node<E> current = head;
    for (int i = 0; i < size; i++) {
      result.append(current.element);
      current = current.next;
      if (current != null) result.append(", ");
      else result.append("]");
    }
    return result.toString();
  }

  public void clear() { 
    head = tail = null; 
  }

  public boolean contains(Object e) {
    Node<E> current = head;
    for (int i = 0; i < size; i++) {
      if (current.element.equals(e)) return true;
      current = current.next;
    }
    return false;
  }

  public E get(int index) {
    if (index < 0 || index >= size) return null;
    Node<E> current = head;
    for (int i = 0; i < index; i++) current = current.next;
    return current.element;
  }

  public int indexOf(Object e) {
    Node<E> current = head;
    for (int i = 0; i < size; i++) {
      if (current.element.equals(e)) return i;
      current = current.next;
    }
    return -1;
  }

  public int lastIndexOf(E e) {
    Node<E> current = tail;
    for (int i = size - 1; i >= 0; i--) {
      if (current.element.equals(e)) return i;
      current = current.previous;
    }
    return -1;
  }

  public E set(int index, E e) {
    if (index < 0 || index >= size) return null;
    Node<E> current = head;
    for (int i = 0; i < index; i++) current = current.next;
    E old = current.element;
    current.element = e;
    return old;
  }

  public void addFirst(E e) {
    Node<E> newNode = new Node<>(e);
    newNode.next = head;
    if (head != null) head.previous = newNode;
    head = newNode;
    size++;
    if (tail == null) tail = head;
  }

  public void addLast(E e) {
    Node<E> newNode = new Node<>(e);
    if (tail == null) {
      head = tail = newNode;
    } else {
      tail.next = newNode;
      newNode.previous = tail;
      tail = newNode;
    }
    size++;
  }

  public void add(int index, E e) {
    if (index <= 0) addFirst(e);
    else if (index >= size) addLast(e);
    else {
      Node<E> current = head;
      for (int i = 1; i < index; i++) current = current.next;
      Node<E> temp = current.next;
      Node<E> newNode = new Node<>(e);
      current.next = newNode;
      newNode.previous = current;
      newNode.next = temp;
      temp.previous = newNode;
      size++;
    }
  }

  public E removeFirst() {
    if (size == 0) return null;
    Node<E> temp = head;
    head = head.next;
    if (head != null) head.previous = null;
    else tail = null;
    size--;
    return temp.element;
  }

  public E removeLast() {
    if (size == 0) return null;
    Node<E> temp = tail;
    tail = tail.previous;
    if (tail != null) tail.next = null;
    else head = null;
    size--;
    return temp.element;
  }

  public E remove(int index) {
    if (index < 0 || index >= size) return null;
    if (index == 0) return removeFirst();
    if (index == size - 1) return removeLast();
    Node<E> current = head;
    for (int i = 0; i < index; i++) current = current.next;
    current.previous.next = current.next;
    current.next.previous = current.previous;
    size--;
    return current.element;
  }

  @Override 
  public int size() { 
    return size; 
  }

  @Override 
  public Iterator<E> iterator() { 
    return listIterator(); 
  }
  public ListIterator<E> listIterator() { 
    return new LinkedListIterator(); 
  }
  public ListIterator<E> listIterator(int index) { 
    return new LinkedListIterator(index); 
  }

  private class LinkedListIterator implements java.util.ListIterator<E> {
    private Node<E> current;
    private int index = 0;

    public LinkedListIterator() { 
      current = head; 
    }
    public LinkedListIterator(int index) {
      if (index < 0 || index > size) throw new IndexOutOfBoundsException();
      current = head;
      for (this.index = 0; this.index < index; this.index++) current = current.next;
    }

    @Override 
    public boolean hasNext() { 
        return index < size; 
    }

    @Override 
    public E next() {
      if (!hasNext()) throw new NoSuchElementException();
      E e = current.element;
      current = current.next;
      index++;
      return e;
    }

    @Override 
    public boolean hasPrevious() { 
        return current != null; 
    }

    @Override 
    public E previous() {
      if (!hasPrevious()) throw new NoSuchElementException();
      E e = current.element;
      current = current.previous;
      index--;
      return e;
    }

    @Override 
    public int nextIndex() { 
        return index; 
    }

    @Override 
    public int previousIndex() { 
        return index - 1; 
    }

    @Override 
    public void remove() {}

    @Override 
    public void add(E e) {}

    @Override 
    public void set(E e) { 
      if (current != null) current.element = e; 
    }
  }

  private static class Node<E> {
    E element;
    Node<E> next, previous;
    public Node(E o) { element = o; }
  }
}