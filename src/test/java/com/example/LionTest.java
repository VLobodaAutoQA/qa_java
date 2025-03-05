package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline feline;


    @Test
    public void testMaleLionHasMane() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertTrue("У самца должна быть грива", lion.doesHaveMane());
    }

    @Test
    public void testFemaleLionDoesNotHaveMane() throws Exception {
        Lion lion = new Lion("Самка", feline);
        assertFalse("У самки не должно быть гривы", lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void testInvalidLionSexThrowsException() throws Exception {
        new Lion("Используйте допустимые значения пола животного - самец или самка", feline);
    }


    @Test
    public void testGetKittensReturnsCorrectValue() throws Exception {
        when(feline.getKittens()).thenReturn(3);
        Lion lion = new Lion("Самец", feline);
        assertEquals(3, lion.getKittens());
    }

    @Test
    public void testGetFoodReturnsPredatorFood() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(expectedFood);
        Lion lion = new Lion("Самец", feline);
        assertEquals(expectedFood, lion.getFood());
    }
}
