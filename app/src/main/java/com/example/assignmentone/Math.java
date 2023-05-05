package com.example.assignmentone;

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
