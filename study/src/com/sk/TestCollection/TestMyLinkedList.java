package com.sk.TestCollection;

/**
 * @author sk
 * create on  2019/12/18:21:56
 */
public class TestMyLinkedList <E>{

    private Node fist;
    private Node last;
    private int size;

    //["aa","bb","cc"]
    public void add(E element){
        Node node = new Node(element);

        if(fist==null){
            fist = node;
            last = node;
        }else {
            node.previous = last;
            node.next = null;

            last.next = node;
            last = node;
        }
    }

    public E get(int index){
        Node temp = fist;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return (E)temp.element;
    }

    public void set(E element, int index){
        Node temp = fist;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node temp = fist;
        while (temp!=null){
            sb.append(temp.element+",");
            temp = temp.next;
        }
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }

    public static void main(String[] args) {
        TestMyLinkedList myList = new TestMyLinkedList();
        for (int i = 0; i <20 ; i++) {
            myList.add("sk"+i);
        }
        System.out.println(myList.toString());
        System.out.println(myList.get(1)); //sk1
    }
}
