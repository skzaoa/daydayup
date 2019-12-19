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
        size++;
    }

    public void add(E element, int index){

        if (size==0 && index==0) {
            add(element);
        } else if (size==0 && index!=0){
            throw new RuntimeException("空链表，可用add(E,0)或add()");
        } else {
            judgeRange(index);
            Node temp = new Node(element);
            Node cur= getNode(index);
            Node up = cur.previous;

            if (up!=null){
                up.next = temp;
                temp.next = cur;
                cur.previous = temp;
                temp.previous = up;
            } else {
                fist = temp;
                temp.next = cur;
                cur.previous = temp;
            }
        }
        size++;
    }

    public E get(int index){
        judgeRange(index);
        return   getNode(index)!=null?(E)getNode(index).element:null;
    }

    private Node getNode(int index){
        Node temp;
        if (index < size/2){
            //System.out.println("从前往后");
            temp = fist;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        }else {
            //System.out.println("从后往前");
            temp = last;
            for (int i = 0; i < size-index-1; i++) {
                temp = temp.previous;
            }
        }
        return temp;
    }
    public void remove(int index){
        judgeRange(index);
        Node temp = getNode(index);
        if(temp!=null) {
            Node up = temp.previous;
            Node down = temp.next;
            if(up!=null) {
                up.next=down;
            }else {
                fist = down;
            }
            if(down!=null) {
                down.previous=up;
            }else {
                last = up;
            }
            System.out.println(last.element);
        }
        size--;
    }

    public void remove(E element){

    }

    public void set(E element, int index){
        Node temp;
        judgeRange(index);
        temp = getNode(index);
        temp.element = element;
    }

    private void judgeRange(int index){
        if(size == 0){
            throw new RuntimeException("空链表");
        }
        if(index<0||index>size-1){
            throw new RuntimeException("索引不合法："+index+"[0-"+(size-1)+"]");
        }
    }

    public int size(){
        return size;
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
        //System.out.println(myList.get(1));
        //myList.remove(1);
        myList.add("sk-1",0);
        for (int i = 0; i <20 ; i++) {
            myList.add("sk"+i);
        }
        System.out.println(myList.toString());
        System.out.println("myList[0]="+myList.get(0)); //sk1
        System.out.println(myList.size());
        System.out.println("myList[19]="+myList.get(19));
        System.out.println(myList.get(2));
        myList.remove(19);
        System.out.println(myList.toString());
        myList.remove(0);
        System.out.println(myList.toString());
        myList.remove(1);
        System.out.println(myList.toString());
        myList.set("sk0",0);
        System.out.println(myList.toString());
        myList.add("sk-2",0);
        myList.add("sk-1",1);
        System.out.println(myList.toString());
    }
}
