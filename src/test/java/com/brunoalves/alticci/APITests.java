package com.brunoalves.alticci;

import com.brunoalves.alticci.condiguration.TestsConfiguration;
import com.brunoalves.alticci.controller.AlticciController;
import com.brunoalves.alticci.error.SequenceIndexNotValidException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.*;

public class APITests extends TestsConfiguration {

    @Autowired
    private AlticciController alticciController;

    @Test
    void calculateResultFor0ShouldReturn0() {
        Long result = alticciController.calculateResult(0L);
        assertEquals(0, result);
    }

    @Test
    void calculateResultFor1ShouldReturn1() {

        Long result = alticciController.calculateResult(1L);
        assertEquals(1, result);
    }

    @Test
    void calculateResultFor2ShouldReturn1() {

        Long result = alticciController.calculateResult(2L);
        assertEquals(1, result);
    }

    @Test
    void calculateResultFor10ShouldReturn9() {

        Long result = alticciController.calculateResult(10L);
        assertEquals(9, result);
    }

    @Test
    void calculateResultForNegativeNumberShouldThrowException() {

        Exception exception = assertThrows(SequenceIndexNotValidException.class, () -> {
            alticciController.calculateResult(-1L);
        });

        String expectedMessage = "-1 is not a valid Index.";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);

    }

    @Test
    void VerifyIfCacheIsWorking() {

        // Get current time
        long startBeforeCache = System.currentTimeMillis();
        alticciController.calculateResult(80L);
        // Get elapsed time in seconds
        float elapsedTimeSecBeforeCache = (System.currentTimeMillis()-startBeforeCache)/1000F;

        long startAfterCache = System.currentTimeMillis();
        alticciController.calculateResult(80L);
        float elapsedTimeSecAfterCache = (System.currentTimeMillis()-startAfterCache)/1000F;

        assertTrue(elapsedTimeSecAfterCache < elapsedTimeSecBeforeCache, "Function Execution is faster with cache");
        assertTrue(elapsedTimeSecAfterCache < 1, "Function Execution with cache is faster than 1s");
    }
}
