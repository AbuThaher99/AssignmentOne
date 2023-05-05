package com.example.assignmentone;

import java.util.ArrayList;

public class MathEQ {
    ArrayList<Math> Hard = new ArrayList<>();
    ArrayList<Math> Easy = new ArrayList<>();

    public MathEQ(){
        Hard.add(new Math(200 , 5 ,"*",900,700,1000,10000,1000));
        Hard.add(new Math(1554 , 9 ,"-",1541,1548,1544,1545,1545));
        Hard.add(new Math(169 , 500 ,"-",331,336,-336,-331,-331));
        Hard.add(new Math(500 , 10 ,"/",50,10,20,60,50));
        Hard.add(new Math(809 , 312,"+",1112,1111,1141,1121,1121));
        Hard.add(new Math(78 , 2 ,"*",156,180,165,118,156));
        Hard.add(new Math(752 , 5 ,"+",747,748,757,758,757));
        Hard.add(new Math(100 , 100 ,"/",10,5,1,20,1));

        Easy.add(new Math(10, 9 ,"-",-1,1,2,0,1));
        Easy.add(new Math(5, 5 ,"*",15,25,20,24,25));
        Easy.add(new Math(5, 9 ,"-",4,-3,-4,3,-4));
        Easy.add(new Math(7, 7 ,"*",45,47,44,49,49));
        Easy.add(new Math(10, 11 ,"+",19,22,21,20,21));
        Easy.add(new Math(10, 2 ,"/",1,4,6,5,5));
        Easy.add(new Math(7, 8 ,"+",15,14,16,18,15));
        Easy.add(new Math(5, 5 ,"/",-1,1,2,0,1));




    }
    public ArrayList<Math> getHardEQ(){
        return Hard;
    }

    public ArrayList<Math> getEasyEQ(){
        return Easy;
    }


}
