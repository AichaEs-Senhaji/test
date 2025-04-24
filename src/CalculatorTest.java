package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    void division_NormalCase_ReturnsCorrectResult() {
        assertEquals(2.0, calculator.division(6, 3));
    }

    @Test
    void division_ByZero_ThrowsArithmeticException() {
        assertThrows(ArithmeticException.class, () -> calculator.division(5, 0));
    }

    @ParameterizedTest
    @CsvSource({
            "5, 3, 1.6666666666666667",
            "10, 2, 5",
            "-10, 2, -5"
    })
    void division_ParameterizedValidInputs_ReturnsExpected(double a, double b, double expected) {
        assertEquals(expected, calculator.division(a, b), 0.0001);
    }

    @Test
    void addition_ValidInputs_ReturnsSum() {
        assertEquals(8, calculator.addition(5, 3));
    }

    @Test
    void multiplication_ValidInputs_ReturnsProduct() {
        assertEquals(12, calculator.multiplication(3, 4));
    }
}