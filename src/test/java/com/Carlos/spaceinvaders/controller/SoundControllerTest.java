package com.Carlos.spaceinvaders.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.sound.sampled.Clip;
import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class SoundControllerTest {
    private SoundController soundController;

    @BeforeEach
    public void setUp() {
        soundController = new SoundController();
    }

    @Test
    public void testLoadSound(){
        String name = "Shoot";
        String filePath = "/sound/Shoot.wav";

        soundController.loadSound(name, filePath);

        Map<String, Clip> clips = soundController.getClips();
        assertTrue(clips.containsKey(name));
        assertNotNull(clips.get(name));
    }
    @Test
    public void testPlaySound(){
        String name = "Shoot";
        String filePath = "/sound/Shoot.wav";
        soundController.loadSound(name, filePath);

        soundController.playSound(name);

        Clip clip = soundController.getClips().get(name);
        assertNotNull(clip);
        assertEquals(11025, clip.getFramePosition());
        assertTrue(clip.isRunning());
    }
    @Test
    public void testPlayNonExistentSound() {
        String name = "NonExistentSound";
        assertDoesNotThrow(() -> soundController.playSound(name));
    }

}