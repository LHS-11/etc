package com.example.javastudy.java2;

public class MyChar {

    private char c;

    public MyChar(char c) {
        this.c = c;
    }

    public boolean isVowel(){
        if(this.c=='a' || this.c=='e' || this.c=='i'|| this.c=='o'||this.c=='u') return true;
        else return false;
    }

    public boolean isNumber(){
        if(this.c>='0' && this.c<='9') return true;
        else return false;
    }

    public boolean isAlphabet(){
        if((this.c>='a' && this.c<='z') || (this.c>='A' && this.c<='Z')) return true;
        return false;
    }

    public void printLowerCaseAlphabets(){
        if(isAlphabet()) {
            if(this.c>='a' && this.c<='z') System.out.println((char)(this.c-'a'+'A'));
        }
    }

    public void printUpperCaseAlphabets(){
        if(isAlphabet()) {
            if(this.c>='A' && this.c<='Z') System.out.println(this.c);
        }
    }
}
