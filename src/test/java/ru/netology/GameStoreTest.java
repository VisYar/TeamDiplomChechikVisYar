package ru.netology;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GameStoreTest {
    GameStore store = new GameStore();

    @Test
    public void shouldAddOneGame() {

        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }
    @Test
    public void shouldAddGameThatAlreadyExists() {

        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game gameCopy = new Game("Нетология Баттл Онлайн", "Аркады", store);

        assertThrows(RuntimeException.class, () -> store.publishGame(gameCopy.getTitle(), gameCopy.getGenre()));
    }

    @Test
    public void shouldContainsLastGames() {

        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("Minecraft", "Симулятор");

        assertTrue(store.containsGame(game1));
    }

    @Test
    public void shouldAddGameNotFound() {

        assertFalse(store.containsGame(null));
    }


    @Test
    public void shouldAddTimeToExistingPlayer() {

        store.addPlayTime("Ivan", 2);

        store.addPlayTime("Ivan", 8);

        int expected = 10;
        int actual = store.getSumPlayedTime();

        assertEquals(expected, actual);
    }


    @Test
    public void shouldGetMostPlayerIfPlayersDoNotRepeat() {

        store.addPlayTime("Ivan", 2);
        store.addPlayTime("Vita", 14);
        store.addPlayTime("Ira", 21);
        store.addPlayTime("Sonia", 22);

        assertEquals("Sonia", store.getMostPlayer());
    }

    @Test
    public void shouldGetMostPlayerIfPlayersDoRepeat() {

        store.addPlayTime("Ivan", 21);
        store.addPlayTime("Vita", 14);
        store.addPlayTime("Ivan", 12);
        store.addPlayTime("Sonia", 22);

        assertEquals("Ivan", store.getMostPlayer());
    }

    @Test
    public void shouldGetMostPlayerIfPlayersAreEqual() {

        store.addPlayTime("Ivan", 2);
        store.addPlayTime("Vita", 2);


       assertEquals("Ivan",  store.getMostPlayer());
    }

    @Test
    public void shouldGetMostPlayerIfPlayedForOneHour() {

        store.addPlayTime("Ivan", 1);
        store.addPlayTime("Vita", 0);

        assertEquals("Ivan", store.getMostPlayer());
    }

    @Test
    public void shouldGetMostNotPlayer() {

        assertEquals(null, store.getMostPlayer());
    }

    @Test
    public void shouldGetSumPlayedTime() {

        store.addPlayTime("Vita", 15);
        store.addPlayTime("Ivan", 5);
        store.addPlayTime("Sonia", 32);

        assertEquals(52, store.getSumPlayedTime());
    }

    @Test
    public void shouldGetSumOnePlayedTime() {

        store.addPlayTime("Vita", 15);

        assertEquals(15, store.getSumPlayedTime());
    }

    @Test
    public void shouldGetSumPlayedTimeIfAreNoPlayers() {

        assertEquals(0, store.getSumPlayedTime());
    }
}