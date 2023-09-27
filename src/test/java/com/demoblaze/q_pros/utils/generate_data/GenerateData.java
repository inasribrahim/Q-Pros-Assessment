package com.demoblaze.q_pros.utils.generate_data;

import com.github.javafaker.Faker;

import java.util.Locale;

public class GenerateData {
    private final Faker faker;

    public GenerateData() {
        this.faker = new Faker();
    }

    public String generateLastName() {
        return faker.name().lastName().toLowerCase();
    }

}
