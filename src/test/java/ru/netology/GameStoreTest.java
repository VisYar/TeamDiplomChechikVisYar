package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GameStoreTest {
    GameStore store = new GameStore();

    Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
    Game game1 = store.publishGame("Minecraft", "Симулятор");
    Game game2 = store.publishGame("F1", "Гонки");
    Game game3 = store.publishGame("Цивилизация", "Стратегия");
    Game game4 = store.publishGame("Ведьмак", "РПГ");

    @Test
    public void shouldAddGames() {

        assertTrue(store.containsGame(game));
        assertTrue(store.containsGame(game1));
        assertTrue(store.containsGame(game2));
        assertTrue(store.containsGame(game3));
        assertTrue(store.containsGame(game4));
        assertFalse(store.containsGame(null));
    }

}
