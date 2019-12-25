package com.sk.decorate;

/**
 * @author sk
 * create on  2019/12/25:22:02
 */
public class TestDecorate01 {
    public static void main(String[] args) {

        Person p = new Person();
        p.say();
        Amplifier am = new Amplifier(p);
        am.say();
    }
}

interface Say{
    void say();
}

class Person implements Say {

    private int voice = 10;
    @Override
    public void say() {
        System.out.println("人的声音："+this.getVoice());

    }

    int getVoice() {
        return voice;
    }

    public void setVoice(int voice) {
        this.voice = voice;
    }
}

class Amplifier implements Say{

    private Person p;

    Amplifier(Person p) {
        this.p = p;
    }

    @Override
    public void say() {
        System.out.println("人的声音："+p.getVoice()*100);
        System.out.println("噪音。。。。。。");
    }
}

