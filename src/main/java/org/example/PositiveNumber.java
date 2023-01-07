package org.example;

public class PositiveNumber {

    private int value;

    public PositiveNumber(int value) {
        validate(value);
        this.value = value;
    }

    public void validate(int value){
        if(isNegativeNumber(value)){
            throw new IllegalArgumentException("0또는 음수를 전달할 수 없습니다.");
        }
    }

    private boolean isNegativeNumber(int value) {
        return value <= 0;
    }

    public int toInt(){
        return value;
    }
}
