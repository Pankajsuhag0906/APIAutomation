package org.example.Sample_check;

public class NoDesignPattern {

    public void Step1()
    {
        System.out.println("Step 1");
    }

    public void Step2(){
        System.out.println("Step 2");
    }

    public void Step3(){
        System.out.println("Step 3");
    }

    public static void main(String[] args) {
        NoDesignPattern np=new NoDesignPattern();
        np.Step1();
        np.Step2();
        np.Step3();

       //  np.Step1().Step2().Step3();   Not Possible

        //But this is possible using Builder Design Pattern
    }
}
