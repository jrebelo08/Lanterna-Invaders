package com.Carlos.spaceinvaders.controller;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class SoundController {
    private Map<String, Clip> clips = new HashMap<>();

    public SoundController() {
        loadSound("Shoot", "/sound/Shoot.wav");
        loadSound("GameOver","/sound/GameOver.wav");
    }

    public void loadSound(String name, String filePath) {
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(is));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clips.put(name, clip);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void playSound(String name) {
        Clip clip = clips.get(name);
        if (clip != null) {
            clip.setFramePosition(0);
            clip.start();
        }
    }
    public Map<String, Clip> getClips() {
        return clips;
    }
}