package com.company.logic;

import com.company.graphic.button.ButtonActionListener;
import com.company.graphic.button.ChoiceButton;
import com.company.graphic.panel.ChoicePanel;
import com.company.graphic.panel.ImagePanel;
import com.company.graphic.panel.StoryPanel;
import com.company.logic.model.GameTurn;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Инициализация всех ходов
 * Делается до логики игры
 */
public class StoryInitializer {
    private ImagePanel imagePanel;
    private StoryPanel storyPanel;
    private ChoicePanel choicePanel;
    public static ArrayList<GameTurn> turns = new ArrayList<>();

    public StoryInitializer(ImagePanel imagePanel, StoryPanel storyPanel, ChoicePanel choicePanel) {
        this.choicePanel = choicePanel;
        this.imagePanel = imagePanel;
        this.storyPanel = storyPanel;
        this.initializeStory();
    }

    //Инициализация всех ходов
    public void initializeStory() {
        JButton button = new JButton("Начать игру");
        button.addActionListener(new ButtonActionListener(imagePanel, storyPanel, choicePanel, GameStatus.START));
        choicePanel.start(button);

        //Стартовый ход
        GameTurn start = new GameTurn();
        start.setGameStatus(GameStatus.START);
        start.setImagePath("wake.jpg");
        start.setStoryText("Вы проснулись!\n" +
                "Вам не очень хорошо и вы хотите спать\n" +
                "Что будете делать?");
        start.addChoiceButton(
                new ChoiceButton("Проснуться", new ButtonActionListener(
                        imagePanel,
                        storyPanel,
                        choicePanel,
                        GameStatus.WAKING_UP))
        );

        start.addChoiceButton(
                new ChoiceButton("Попить", new ButtonActionListener(
                        imagePanel,
                        storyPanel,
                        choicePanel,
                        GameStatus.DRINK_WATER
                ))
        );

        //Попить воды
        GameTurn drinkWater = new GameTurn();
        drinkWater.setImagePath("pig.png");
        drinkWater.setGameStatus(GameStatus.DRINK_WATER);
        drinkWater.setStoryText("Вы немного попили воды\n" +
                "Но это был уксус...\n" +
                "Вы отравились и вам очень плохо\n" +
                "Что будем делать?");
        drinkWater.addChoiceButton(
                new ChoiceButton("Выпить таблетку", new ButtonActionListener(
                        imagePanel,
                        storyPanel,
                        choicePanel,
                        GameStatus.TAKE_PILL
                ))
        );
        drinkWater.addChoiceButton(
                new ChoiceButton("Забить", new ButtonActionListener(
                        imagePanel,
                        storyPanel,
                        choicePanel,
                        GameStatus.DEAD
                ))
        );

        //Попить воды
        GameTurn takePill = new GameTurn();
        takePill.setImagePath("creeper.jpeg");
        takePill.setGameStatus(GameStatus.TAKE_PILL);
        takePill.setStoryText("Вам надо выбрать таблетку\n" +
                "Синяя...\n" +
                "Или красная?");
        takePill.addChoiceButton(
                new ChoiceButton("Синяя", new ButtonActionListener(
                        imagePanel,
                        storyPanel,
                        choicePanel,
                        GameStatus.DEAD
                ))
        );

        takePill.addChoiceButton(
                new ChoiceButton("Красная", new ButtonActionListener(
                        imagePanel,
                        storyPanel,
                        choicePanel,
                        GameStatus.DEAD
                ))
        );

        //Добавление ходов в список
        turns.add(start);
        turns.add(drinkWater);
        turns.add(takePill);
    }
}
