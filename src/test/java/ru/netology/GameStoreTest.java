package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GameStoreTest {

    @Test
    public void shouldAddOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldContainsLastGames() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("Minecraft", "Симулятор");
        Game game2 = store.publishGame("F1", "Гонки");

        assertTrue(store.containsGame(game2));
    }

    @Test
    public void shouldAddGameNotFound() {
        GameStore store = new GameStore();
        assertFalse(store.containsGame(null));
    }
}
