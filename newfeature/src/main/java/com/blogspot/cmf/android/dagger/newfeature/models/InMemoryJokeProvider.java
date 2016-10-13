package com.blogspot.cmf.android.dagger.newfeature.models;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Clemente Morales Fernandez
 * @since 10/13/2016.
 */

public class InMemoryJokeProvider implements JokeProvider {

    private static final List<Joke> JOKES = new ArrayList<>();

    static {
        JOKES.add(new Joke("animals", "Can a kangaroo jump higher than a house? Of course, a house doesn\'t jump at all."));
        JOKES.add(new Joke("animals", "What did the elephant say to the naked man? How do you breathe through something so small?"));
        JOKES.add(new Joke("animals", "Where do cows go on Saturday nights? To the MOOO-vies!"));
        JOKES.add(new Joke("animals", "Why is it hard to play cards in the jungle? here are too many cheetahs!"));
        JOKES.add(new Joke("animals", "When is it bad luck to see a black cat? When you’re a mouse!"));

        JOKES.add(new Joke("lawyers", "It is so cold outside I saw a politician with his hands in his own pockets."));
        JOKES.add(new Joke("lawyers", "What\'s the difference between an accountant and a lawyer? Accountants know they\'re boring."));
        JOKES.add(new Joke("lawyers", "How many lawyer jokes are there? Only three. The rest are true stories."));
        JOKES.add(new Joke("lawyers", "What do dinosaurs and decent lawyers have in common? They\'re both extinct."));
        JOKES.add(new Joke("lawyers", "Why does the law society prohibit sex between lawyers and their clients? To prevent clients from being billed twice for essentially the same service."));

        JOKES.add(new Joke("marriage", "After finishing our Chinese food, my husband and I " +
                "cracked open our fortune cookies. Mine read, \"Be quiet for a little while.\" " +
                "His read, \"Talk while you have a chance.\"."));
        JOKES.add(new Joke("marriage", "Marriage is really tough because you have to deal with feelings ... and lawyers."));
        JOKES.add(new Joke("marriage", "If it weren\'t for marriage, women would have to spend most of their adult lives arguing with complete strangers."));
        JOKES.add(new Joke("marriage", "What is the difference between the words Incomplete and Finished?. " +
                "A man without a wife is incomplete. After getting one, he\'s finished."));


        JOKES.add(new Joke("general", "I wanted to grow my own food but I couldn\'t get bacon seeds anywhere."));
        JOKES.add(new Joke("general", "I can\'t believe I forgot to go to the gym today. That\'s 7 years in a row now."));
        JOKES.add(new Joke("general", "What goes up and down but never moves? The stairs"));
        JOKES.add(new Joke("general", "What\'s the difference between snowmen and snowladies? Snowballs"));
        JOKES.add(new Joke("general", "I am a nobody, nobody is perfect, therefore I am perfect."));
        JOKES.add(new Joke("general", "Never argue with a fool, they will lower you to their level, and then beat you with experience."));
        JOKES.add(new Joke("general", "What do you call two fat people having a chat? -- A heavy discussion"));
        JOKES.add(new Joke("general", "Stalking is when two people go for a long romantic walk together but only one of them knows about it."));
    }

    @Override
    public Joke getRandomJoke() {
        return getRandomJoke(JOKES);
    }

    @Override
    public Joke getJoke(String category) {
        if (StringUtils.isBlank(category))
            throw new IllegalArgumentException("Category is required");

        List<Joke> jokesByCategory = getJokesByCategory(category);

        if (jokesByCategory.isEmpty())
            throw new IllegalArgumentException("Category not included in the repository");

        return getRandomJoke(jokesByCategory);
    }

    private Joke getRandomJoke(List<Joke> jokes) {
        Random random = new Random();
        int jokeIndex = random.nextInt(jokes.size());
        return jokes.get(jokeIndex);
    }

    private List<Joke> getJokesByCategory(String category) {
        List<Joke> jokes = new ArrayList<>();
        for (Joke joke : JOKES) {
            if (StringUtils.equalsIgnoreCase(joke.getCategory(), category)) {
                jokes.add(joke);
            }
        }
        return jokes;
    }
}
