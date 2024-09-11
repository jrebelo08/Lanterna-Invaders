package com.Carlos.spaceinvaders.model.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreTest {

    private ScoreModel scoreModel;

    @BeforeEach
    public void setUp() {
        PositionModel position = new PositionModel(10, 10);
        scoreModel = new ScoreModel(position);
    }

    @Test
    public void testGetScore() {
        assertEquals(0, scoreModel.getScore());
    }

    @Test
    public void testIncrementScore() {
        scoreModel.incrementScore();
        assertEquals(1, scoreModel.getScore());
    }

    @Test
    public void testGetIncrementValue() {
        assertEquals(1, scoreModel.getIncrementValue());
    }

    @Test
    public void testSetIncrementValue() {
        scoreModel.setIncrementValue(5);
        assertEquals(5, scoreModel.getIncrementValue());
    }

    @Test
    public void testSetScore() {
        scoreModel.setScore(100);
        assertEquals(100, scoreModel.getScore());
    }
}