package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerTest {
    GameStore store = new GameStore();
    Player player = new Player("Petya");
    Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
    Game game2 = store.publishGame("F1", "Гонки");
    Game game3 = store.publishGame("Цивилизация", "Стратегия");
    Game game4 = store.publishGame("Ведьмак", "РПГ");
    Game game5 = store.publishGame("MotoGP", "Гонки");

    @Test
    public void shouldSumGenreIfOneGame() {


        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreIfInstallAndNotPlay() {


        player.installGame(game);


        int expected = 0;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void playedSeveralTime() {


        player.installGame(game);
        player.installGame(game2);
        player.play(game, 3);
        player.play(game2, 2);
        player.play(game, 5);


        int expected = 8;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void outputRuntimeExceptionGameNotInstall() {


        assertThrows(RuntimeException.class, () -> {

            player.play(game, 5);
        });
    }

    @Test
    public void sumGenreSeveralGameNotPlay() {

        player.installGame(game);
        player.installGame(game2);
        player.installGame(game3);
        player.installGame(game4);
        player.installGame(game5);

        player.play(game4, 3);
        player.play(game2, 2);
        player.play(game2, 6);
        player.play(game3, 4);

        int expected = 0;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);


    }

    @Test
    public void mostPlayerByGenreGamePlayed() {


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

    @Test
    public void mostPlayerByNotGenreGamePlayed() {


        player.installGame(game);
        player.installGame(game2);
        player.installGame(game3);
        player.installGame(game4);
        player.installGame(game5);

        player.play(game, 6);
        player.play(game2, 5);
        player.play(game3, 3);
        player.play(game5, 7);


        Game expected = null;
        Game actual = player.mostPlayerByGenre("РПГ");

        assertEquals(expected, actual);
    }
}
