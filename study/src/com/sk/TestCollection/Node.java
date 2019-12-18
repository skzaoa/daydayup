package com.sk.TestCollection;

/**
 * @author sk
 * create on  2019/12/18:22:01
 */
public class Node {
    Node previous; //上一个节点
    Node next;//下一个节点
    Object element;//元素数据

    public Node(Node provious, Node next, Object element) {
        this.previous = provious;
        this.next = next;
        this.element = element;
    }

    public Node(Object element) {
        this.element = element;
    }
}
