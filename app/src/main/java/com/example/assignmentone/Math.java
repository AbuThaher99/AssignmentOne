package com.example.assignmentone;


import java.util.ArrayList;

public class Math {
    private double x;
    private double y;
    private String operation;
    private double optionOne;
    private double optionTwo;
    private double optionThree;
    private double optionFour;
    private double answer;



    public Math(double x, double y, String operation, double optionOne, double optionTwo, double optionThree, double optionFour, double answer) {
        this.x = x;
        this.y = y;
        this.operation =operation;
        this.optionOne = optionOne;
        this.optionTwo = optionTwo;
        this.optionThree = optionThree;
        this.optionFour = optionFour;
        this.answer = answer;
    }


    public static final Math[] hardMath = {
            new Math(200 , 5 ,"*",900,700,1000,10000,1000),
            new Math(1554 , 9 ,"-",1541,1548,1544,1545,1545),
            new Math(169 , 500 ,"-",331,336,-336,-331,-331),
            new Math(500 , 10 ,"/",50,10,20,60,50),
            new Math(809 , 312,"+",1112,1111,1141,1121,1121),
            new Math(78 , 2 ,"*",156,180,165,118,156),
            new Math(752 , 5 ,"+",747,748,757,758,757),
            new Math(100 , 100 ,"/",10,5,1,20,1)
    };

    public static final Math[] esayMath = {
            new Math(10, 9 ,"-",-1,1,2,0,1),
            new Math(5, 5 ,"*",15,25,20,24,25),
            new Math(5, 9 ,"-",4,-3,-4,3,-4),
            new Math(7, 7 ,"*",45,47,44,49,49),
            new Math(10, 11 ,"+",19,22,21,20,21),
            new Math(10, 2 ,"/",1,4,6,5,5),
            new Math(7, 8 ,"+",15,14,16,18,15),
            new Math(5, 5 ,"/",-1,1,2,0,1)
    };


    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getOptionOne() {
        return optionOne;
    }

    public void setOptionOne(double optionOne) {
        this.optionOne = optionOne;
    }

    public double getOptionetwo() {
        return optionTwo;
    }

    public void setOptionetwo(double optionetwo) {
        this.optionTwo = optionetwo;
    }

    public double getOptionThree() {
        return optionThree;
    }

    public void setOptionThree(double optionThree) {
        this.optionThree = optionThree;
    }

    public double getOptionFour() {
        return optionFour;
    }

    public void setOptionFour(double optionFour) {
        this.optionFour = optionFour;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double getAnswer() {
        return answer;
    }

    public void setAnswer(double answer) {
        this.answer = answer;
    }
}