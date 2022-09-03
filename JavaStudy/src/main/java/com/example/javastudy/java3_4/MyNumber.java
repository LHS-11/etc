package com.example.javastudy.java3_4;

public class MyNumber {
    private int num;

    public MyNumber(int num) {
        this.num = num;
    }

    public boolean isPrime(){
        if(this.num==1) return false;
        else if(this.num==2) return false;

        for(int i=2;i*i<this.num;i++){
            if(this.num%i==0) return false;
        }
        return true;
    }

    public int sumUptoN(){
        int result=0;
        for(int i=1;i<=this.num;i++){
            result+=i;
        }
        return result;
    }

    public int sumOfDivisors(){
        int sum=0;
        for(int i=2;i<this.num;i++){
            if(this.num%i==0) sum+=i;
        }
        return sum;
    }

    public void printANumberTriangle(){
        for(int i=1;i<=this.num;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

}
