package com.testingacademy.ex_25062023.listners;

import org.testng.IExecutionListener;
import org.testng.ISuiteListener;

public class CustomListner implements IExecutionListener, ISuiteListener {

    @Override
    public void onExecutionFinish() {
        System.out.println("OnExecutionFinish");
        long endTime = System.currentTimeMillis();
        System.out.println("End time for execustion = "+endTime);
    }

    @Override
    public void onExecutionStart() {
        System.out.println("onExecutionStart");
        long startTime = System.currentTimeMillis();
        System.out.println("Start time for execustion = "+startTime);
    }

}
