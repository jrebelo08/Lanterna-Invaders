package com.Carlos.spaceinvaders;
import com.google.common.base.Splitter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

import static com.Carlos.spaceinvaders.model.models.PlayerModel.i;

public class HighScore {
    public static String absolutePath = System.getProperty("user.dir") + "/src/main/resources/HighScore.csv";


    public static void updateHighScore(String playerName, int score) {
        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get(absolutePath));
        } catch (IOException e) {
            System.err.println("Error loading high scores: " + e.getMessage());
            return;
        }

        boolean playerFound = false;
        int lowestScoreIndex = -1;
        int lowestScore = Integer.MAX_VALUE;

        for (String line : lines) {
            List<String> parts = Splitter.on(',').splitToList(line);
            if (parts.size() == 2) {
                String storedPlayerName = parts.get(0);
                int storedScore = Integer.parseInt(parts.get(1));

                if (storedPlayerName.equals(playerName)) {
                    playerFound = true;
                    if (score > storedScore) {
                        lines.set(i, playerName + "," + score);
                    }
                    break;
                }

                if (storedScore < lowestScore) {
                    lowestScore = storedScore;
                    lowestScoreIndex = i;
                }
            }
        }

        if (!playerFound) {
            if (lines.size() < 10) {
                lines.add(playerName + "," + score);
            } else if (score > lowestScore) {
                lines.set(lowestScoreIndex, playerName + "," + score);
            }
        }

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(absolutePath), StandardCharsets.UTF_8)) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving high scores: " + e.getMessage());
        }
    }
}
