package com.testingacademy.ex_25062023;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Lab284 {

    @Parameters("browser")
    @Test
    public void testDemo1(String value)
    {
        System.out.println("Browser value = "+value);
        switch (value)
        {
            case "chrome":
                System.out.println("Chrome");
                break;
            case "firefox":
                System.out.println("Firefox");
                break;
            case "ie":
                System.out.println("IE");
                break;
            default:
                System.out.println("No Browser/headless");
        }
    }

}
