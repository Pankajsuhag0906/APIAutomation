package org.example.Sample_check;

public class Builder_design_pattern {
    // Change return type of each method as class type
    // "this" always points to current/calling object. Returning the same to
    // have same references


    public Builder_design_pattern Step1()
    {
        System.out.println("Step 1 Start");
        System.out.println("Step 1 Stop");
        return this;
    }

    public Builder_design_pattern Step2()
    {
        System.out.println("Step 2 start");
        System.out.println("Step 2 stop");
        return this;
    }

    public Builder_design_pattern Step3()
    {
        System.out.println("Step 3 start");
        System.out.println("Step 3 stop");
        return this;
    }


    public static void main(String[] args) {
        Builder_design_pattern bp=new Builder_design_pattern();
        bp.Step1().Step2().Step3();
    }
}
