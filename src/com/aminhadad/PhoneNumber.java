package com.aminhadad;

public class PhoneNumber {
    enum NumberType{home,work,other,phone}
    private String number;
    private NumberType numberType;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public NumberType getNumberType() {
        return numberType;
    }

    public void setNumberType(NumberType numberType) {
        this.numberType = numberType;
    }
}
