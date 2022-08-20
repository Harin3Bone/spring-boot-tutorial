package com.tutorial.cucumber.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CalculateServiceImpl implements CalculateService {

    @Override
    public double sum(String a, String b) {
        return Double.parseDouble(a) + Double.parseDouble(b);
    }

    @Override
    public double subtract(String a, String b) {
        return Double.parseDouble(a) - Double.parseDouble(b);
    }

    @Override
    public double multiply(String a, String b) {
        return Double.parseDouble(a) * Double.parseDouble(b);
    }

    @Override
    public double divide(String a, String b) {
        try {
            double bNum = Double.parseDouble(b);
            if (bNum <= 0) {
                throw new ArithmeticException("Cannot divide by 0");
            }
            return Double.parseDouble(a) / bNum;
        } catch (ArithmeticException e) {
            log.error("CalculateServiceImpl.java, a {} / b {}", a, b);
            log.error("CalculateServiceImpl.java, cannot divide by zero");
            throw e;
        }
    }

    @Override
    public double modulo(String a, String b) {
        try {
            double bNum = Double.parseDouble(b);
            if (bNum <= 0) {
                throw new ArithmeticException("Cannot modulo by 0");
            }
            return Double.parseDouble(a) % bNum;
        } catch (ArithmeticException e) {
            log.error("CalculateServiceImpl.java, a {} % b {}", a, b);
            log.error("CalculateServiceImpl.java, cannot modulo by zero");
            throw e;
        }
    }

}
