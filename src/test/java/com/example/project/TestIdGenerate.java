package com.example.project;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestIdGenerate {
    @Test
    public void testIdGenerate(){
        IdGenerate.reset();
       
        IdGenerate.generateID(); //100
        IdGenerate.generateID(); //101
        IdGenerate.generateID(); //102
        IdGenerate.generateID(); //103
        assertEquals("103", IdGenerate.getCurrentId(), "Expected id 104");
    }
}
