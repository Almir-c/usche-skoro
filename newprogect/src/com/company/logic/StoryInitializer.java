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
                "Вам не очень хорошо и вы хотите кушать\n" +
                "Что будете делать?");
        start.addChoiceButton(
                new ChoiceButton("Посапать", new ButtonActionListener(
                        imagePanel,
                        storyPanel,
                        choicePanel,
                        GameStatus.WAKING_UP))
        );

        start.addChoiceButton(
                new ChoiceButton("Пойти на кухню", new ButtonActionListener(
                        imagePanel,
                        storyPanel,
                        choicePanel,
                        GameStatus.DRINK_WATER
                ))
        );

        //Попить воды
        GameTurn drinkWater = new GameTurn();
        drinkWater.setImagePath("кухня.jpg");
        drinkWater.setGameStatus(GameStatus.DRINK_WATER);
        drinkWater.setStoryText("На кухне ничего не окозалось кроме прошлогоднего доширака, и ваш мега мозг решил его съесть \n" +
                "Вы отравились   вам очень плохо\n" +
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

        //Попить какавы с таблеткой
        GameTurn takePill = new GameTurn();
        takePill.setImagePath("таблетки.jpg");
        takePill.setGameStatus(GameStatus.TAKE_PILL);
        takePill.setStoryText("Вам надо выбрать таблетку! \n" +
                "Синяя...\n" +
                "Или красная?");
        takePill.addChoiceButton(
                new ChoiceButton("Синяя", new ButtonActionListener(
                        imagePanel,
                        storyPanel,
                        choicePanel,
                        GameStatus.NEPOMOGLO
                ))
        );

        takePill.addChoiceButton(
                new ChoiceButton("Красная", new ButtonActionListener(
                        imagePanel,
                        storyPanel,
                        choicePanel,
                        GameStatus.NEPOMOGLO
                ))
        );
        //Начало пути
        GameTurn nepomoglo = new GameTurn();
        nepomoglo.setImagePath("звонок.jpeg");
        nepomoglo.setGameStatus(GameStatus.NEPOMOGLO);
        nepomoglo.setStoryText("Таблетки были бесполезны. \n" +
                "Позвонить ли в скорую?");
        nepomoglo.addChoiceButton(
                new ChoiceButton("Позвонить в скорую", new ButtonActionListener(
                        imagePanel,
                        storyPanel,
                        choicePanel,
                        GameStatus.GO_TO_HOSPITAL
                ))
        ); nepomoglo.addChoiceButton(
                new ChoiceButton("Не впервой!", new ButtonActionListener(
                        imagePanel,
                        storyPanel,
                        choicePanel,
                        GameStatus.DEAD
                ))
        );
        //Не отвечают
        GameTurn zvonok = new GameTurn();
        zvonok.setImagePath("звонок2.jpg");
        zvonok.setGameStatus(GameStatus.GO_TO_HOSPITAL);
        zvonok.setStoryText("Пока что не отвечают. \n" +
                "Что делать дальше?");
        zvonok.addChoiceButton(
                new ChoiceButton("Ждать", new ButtonActionListener(
                        imagePanel,
                        storyPanel,
                        choicePanel,
                        GameStatus.ALLO
                ))
        ); zvonok.addChoiceButton(
                new ChoiceButton("Забить", new ButtonActionListener(
                        imagePanel,
                        storyPanel,
                        choicePanel,
                        GameStatus.DEAD
                ))
        );
        //Ответили
        GameTurn otvet = new GameTurn();
        otvet.setImagePath("помощь.jpg");
        otvet.setGameStatus(GameStatus.ALLO);
        otvet.setStoryText("Вам ответили и Вы смогли вызвать скорую");
        otvet.addChoiceButton(
                new ChoiceButton("Продолжить", new ButtonActionListener(
                        imagePanel,
                        storyPanel,
                        choicePanel,
                        GameStatus.POLETELI
                ))
        ); otvet.addChoiceButton(
                new ChoiceButton("Продолжить", new ButtonActionListener(
                        imagePanel,
                        storyPanel,
                        choicePanel,
                        GameStatus.POLETELI
                ))
        );
        //Попадание в больницу
        GameTurn go = new GameTurn();
        go.setImagePath("палата.jpg");
        go.setGameStatus(GameStatus.POLETELI);
        go.setStoryText("Вас отвезли и поселили в прекрасную палату");
        go.addChoiceButton(
                new ChoiceButton("Ждать своей участи", new ButtonActionListener(
                        imagePanel,
                        storyPanel,
                        choicePanel,
                        GameStatus.PRIEHALI
                ))
        ); go.addChoiceButton(
                new ChoiceButton("", new ButtonActionListener(
                        imagePanel,
                        storyPanel,
                        choicePanel,
                        GameStatus.NULL
                ))
        );
        //Побег
        GameTurn run = new GameTurn();
        run.setImagePath("прилив сил.jpg");
        run.setGameStatus(GameStatus.PRIEHALI);
        run.setStoryText("Вы почувствовали, как ваша сила и инергия возвращается");
        run.addChoiceButton(
                new ChoiceButton("Бежать от сюда", new ButtonActionListener(
                        imagePanel,
                        storyPanel,
                        choicePanel,
                        GameStatus.POBEG
                ))
        ); run.addChoiceButton(
                new ChoiceButton("От сюда бежать", new ButtonActionListener(
                        imagePanel,
                        storyPanel,
                        choicePanel,
                        GameStatus.POBEG
                ))
        );
        //Вас поймали
        GameTurn no = new GameTurn();
        no.setImagePath("санитар.jpg");
        no.setGameStatus(GameStatus.POBEG);
        no.setStoryText("Увы Вас поймали");
        no.addChoiceButton(
                new ChoiceButton("Пытаться сбежать", new ButtonActionListener(
                        imagePanel,
                        storyPanel,
                        choicePanel,
                        GameStatus.SANITAR
                ))
        ); no.addChoiceButton(
                new ChoiceButton("Ничего не делать", new ButtonActionListener(
                        imagePanel,
                        storyPanel,
                        choicePanel,
                        GameStatus.SANITAR
                ))
        );

















        //Добавление ходов в список
        turns.add(start);
        turns.add(drinkWater);
        turns.add(takePill);
        turns.add(nepomoglo);
        turns.add(zvonok);
        turns.add(otvet);
        turns.add(go);
        turns.add(run);
        turns.add(no);

    }
}
