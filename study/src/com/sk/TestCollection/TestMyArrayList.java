package com.sk.TestCollection;

/**
 * @author sk
 * create on  2019/12/18:20:09
 */

/**
 * 使用泛型
 *  泛型在java中有很重要的地位，在面向对象编程及各种设计模式中有非常广泛的应用。
 *
 *  什么是泛型？为什么要使用泛型？
 *
 *  泛型，即“参数化类型”。
 *  一提到参数，最熟悉的就是定义方法时有形参，然后调用此方法时传递实参。
 *  那么参数化类型怎么理解呢？顾名思义，就是将类型由原来的具体的类型参数化，
 *  类似于方法中的变量参数，此时类型也定义成参数形式（可以称之为类型形参），
 *  然后在使用/调用时传入具体的类型（类型实参）。
 *
 *  泛型的本质是为了参数化类型（在不创建新的类型的情况下，通过泛型指定的不同类型来控制形参具体限制的类型）。
 *  也就是说在泛型使用过程中，操作的数据类型被指定为一个参数，
 *  这种参数类型可以用在类、接口和方法中，分别被称为泛型类、泛型接口、泛型方法。
 */


public class TestMyArrayList<E> {
    private Object[] elementDate;
    private int size = 0;
    private static final int DEFALT_CAPACITY = 10;

    public TestMyArrayList(){
        elementDate = new Object[DEFALT_CAPACITY];
    }

    public TestMyArrayList(int capacity){
        if(capacity<0){
            throw new RuntimeException("不能为负："+capacity);
        }else {
            elementDate = new Object[DEFALT_CAPACITY];
        }
        elementDate = new Object[capacity];
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){

        if (size == 0)
            return true;
        return false;
    }

    public void add(E element){
        //扩容
        if(size == elementDate.length){
            Object[] newArray = new Object[size+(size>>1)];
            System.arraycopy(elementDate,0,newArray,0,size);
            elementDate = newArray;
        }

        elementDate[size++] = element;
    }

    public void remove(int index){
        judgeRange(index);
        int numMoved = elementDate.length-index-1;

        if(numMoved>0) {
            System.arraycopy(elementDate, 0, elementDate, index + 1, numMoved);
        }
        elementDate[--size] = null;
    }

    public void remove(E element){
        for (int i = 0; i < size; i++) {
            if(element.equals(get(i))){//容器中所有比较操作，都使用equals而不是==
                remove(i);
            }
        }
    }

    public E get(int index){
        judgeRange(index);
        return (E)elementDate[index];
    }

    public void set(E element,int index){

        elementDate[index] = element;
        judgeRange(index);
    }

    //判断索引合法性
    public void judgeRange(int index){
        if(index<0||index>size-1){
            throw new RuntimeException("索引不合法："+index+"[0-"+size+"]");
        }
    }

    @Override
    public String toString() {
        //return Arrays.toString(elementDate); //[12, 234, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null]
        StringBuilder sb = new StringBuilder();//可变字符序列
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elementDate[i]+",");
        }
        sb.setCharAt(sb.length()-1,']');

        return sb.toString();//[12,234]
    }

    public static void main(String[] args) {
        TestMyArrayList<String> myList = new TestMyArrayList<>(20);
        for (int i = 0; i <30 ; i++) {
            myList.add("sk"+i);
        }
        System.out.println(myList.toString());
        myList.set("123",7);
        System.out.println(myList.toString());
        System.out.println(myList.get(7));
        myList.remove("sk290");
        System.out.println(myList.toString());
    }
}
