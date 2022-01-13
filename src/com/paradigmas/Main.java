package com.paradigmas;

public class Main {

    public static void main(String[] args) {
        Editor editor = new Editor("GDocs");
        int siz = editor.getRegistrados().size();
        System.out.println(siz);
    }
}
