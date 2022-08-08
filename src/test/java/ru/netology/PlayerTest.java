package ru.netology;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void shouldSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }
    @Test
    public void outputRuntimeExceptionGameNotInstall() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");


        Player player = new Player("Vasya");

        assertThrows(RuntimeException.class, () -> {

            player.play(game, 5);
        });
    }
    @Test
    public void mostPlayerByGenreGamePlayed() {
        Player player = new Player("Dan");

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("F1", "Гонки");
        Game game3 = store.publishGame("Цивилизация", "Стратегия");
        Game game4 = store.publishGame("Ведьмак", "РПГ");

        player.installGame(game);
        player.installGame(game2);
        player.installGame(game3);
        player.installGame(game4);

        player.play(game, 6);
        player.play(game2, 5);
        player.play(game3, 3);
        player.play(game4, 7);


        Game expected = game4;
        Game actual = player.mostPlayerByGenre("РПГ");

        assertEquals(expected, actual);
    }

    // другие ваши тесты
}
