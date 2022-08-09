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

    @Test
    void shouldAddGameThatAlreadyExists() {
        GameStore store = new GameStore();

        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game gameCopy = new Game("Нетология Баттл Онлайн", "Аркады", store);

        assertThrows(RuntimeException.class, () -> store.publishGame(gameCopy.getTitle(), gameCopy.getGenre()));
    }

    @Test
    public void shouldAddTimeToExistingPlayer() {
        GameStore store = new GameStore();

        store.addPlayTime("Ivan", 2);
        store.addPlayTime("Vita", 14);
        store.addPlayTime("Ivan", 8);
        store.addPlayTime("Ira", 14);
        store.addPlayTime("Sonia", 22);

        //     assertEquals(10, store.getPlayedTime().get("Ivan"));
    }

    @Test
    public void shouldAddNegativeTimeToExistingPlayer() {
        GameStore store = new GameStore();

        store.addPlayTime("Ivan", -2);
        store.addPlayTime("Vita", 14);
        store.addPlayTime("Ivan", 8);
        store.addPlayTime("Ira", 14);
        store.addPlayTime("Sonia", 22);

        //     assertEquals(6, store.getPlayedTime().get("Ivan"));
    }

    @Test
    public void shouldAddTimeNotIntegerToExistingPlayer1() {
        GameStore store = new GameStore();

//        store.addPlayTime("Ivan", 1.5);
        store.addPlayTime("Vita", 14);
        store.addPlayTime("Ivan", 8);
        store.addPlayTime("Ira", 14);
        store.addPlayTime("Sonia", 22);

        //     assertEquals(9.5, store.getPlayedTime().get("Ivan"));
    }

    @Test
    public void shouldGetMostPlayerIfPlayersDoNotRepeat() {
        GameStore store = new GameStore();
        store.addPlayTime("Ivan", 2);
        store.addPlayTime("Vita", 14);
        store.addPlayTime("Ira", 21);
        store.addPlayTime("Sonia", 22);
        assertEquals("Sonia", store.getMostPlayer());
    }

    @Test
    public void shouldGetMostPlayerIfPlayersDoRepeat() {
        GameStore store = new GameStore();
        store.addPlayTime("Ivan", 21);
        store.addPlayTime("Vita", 14);
        store.addPlayTime("Ivan", 12);
        store.addPlayTime("Sonia", 22);
        assertEquals("Ivan", store.getMostPlayer());
    }

    @Test
    public void shouldGetMostPlayerIfPlayersAreEqual () {
        GameStore store = new GameStore();
        store.addPlayTime("Ivan", 2);
        store.addPlayTime("Vita", 2);

        assertEquals(null, store.getMostPlayer());
    }

    @Test
    public void shouldGetMostPlayerIfPlayedForOneHour() {
        GameStore store = new GameStore();
        store.addPlayTime("Ivan", 1);

        assertEquals("Ivan", store.getMostPlayer());
    }

    @Test
    public void shouldGetMostNotPlayer() {
        GameStore store = new GameStore();

        assertEquals(null, store.getMostPlayer());
    }

}