package com.tutorial.cucumber.controller;

import com.tutorial.cucumber.service.CalculateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cal")
@Slf4j
public class CalculateController {

    @Autowired
    public CalculateService calculateService;

    @GetMapping(value ="/version")
    public ResponseEntity<String> checkVersion() {
        return ResponseEntity.ok().body("1.0.0");
    }

    @GetMapping(value = "/sum")
    public ResponseEntity<Double> sumApi(@RequestParam String variable, @RequestParam String constant) {
        return ResponseEntity.ok().body(calculateService.sum(variable,constant));
    }

    @GetMapping(value = "/sub")
    public ResponseEntity<Double> subtractApi(@RequestParam String variable, @RequestParam String constant) {
        return ResponseEntity.ok().body(calculateService.subtract(variable,constant));
    }

    @GetMapping(value = "/mul")
    public ResponseEntity<Double> multiplyApi(@RequestParam String variable, @RequestParam String constant) {
        return ResponseEntity.ok().body(calculateService.multiply(variable,constant));
    }

    @GetMapping(value = "/div")
    public ResponseEntity<Double> divideApi(@RequestParam String variable, @RequestParam String constant) {
        return ResponseEntity.ok().body(calculateService.divide(variable,constant));
    }

    @GetMapping(value = "/mod")
    public ResponseEntity<Double> modularApi(@RequestParam String variable, @RequestParam String constant) {
        log.info("Variable: {}", Double.parseDouble(variable));
        log.info("Constant: {}", Double.parseDouble(constant));
        log.info("Res: {}", Double.parseDouble(variable) % Double.parseDouble(constant));
        return ResponseEntity.ok().body(calculateService.modulo(variable,constant));
    }
}
