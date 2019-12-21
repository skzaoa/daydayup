package com.sk.TestCollection;

/**
 * @author sk
 * create on  2019/12/21:13:05
 */
public class MapNode<E, V> {
    int hash;
    E key;
    V value;
    MapNode next;

    public MapNode(int hash, E key, V value, MapNode next) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }
}
