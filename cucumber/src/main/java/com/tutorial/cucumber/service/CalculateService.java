package com.tutorial.cucumber.service;

import org.springframework.stereotype.Service;

@Service
public interface CalculateService {

    public double sum(String a, String b);

    public double subtract(String a, String b);

    public double multiply(String a, String b);

    public double divide(String a, String b);

    public double modulo(String a, String b);

}
