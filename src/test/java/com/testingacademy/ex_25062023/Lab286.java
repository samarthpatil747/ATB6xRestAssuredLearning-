package com.testingacademy.ex_25062023;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class Lab286 {
    @Test
    public void testDemo1() {
        Faker faker = new Faker();
        String username = faker.name().username();
        String password = faker.internet().password();
        String phoNo = faker.phoneNumber().phoneNumber();
        System.out.println(username+"\t"+password+"\t"+phoNo);
    }
}
