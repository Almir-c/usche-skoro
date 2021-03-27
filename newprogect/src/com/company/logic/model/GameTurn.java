package com.company.logic.model;

import com.company.logic.GameStatus;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Ход игрока
 * Необходимый набор парамтров для изменения приложения по нажатию кнопки
 */
public class GameTurn {
    //статус игры на этом ходу
    private GameStatus gameStatus;
    //какие кнопки будут на этом ходу
    private ArrayList<JButton> choices = new ArrayList<>();
    //какой текст будет на этом ходу
    private String storyText;
    //картинка, которая будет на этом ходу
    private String imagePath;

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public ArrayList<JButton> getChoices() {
        return choices;
    }

    public void addChoiceButton(JButton button) {
        this.choices.add(button);
    }

    public void setChoices(ArrayList<JButton> choices) {
        this.choices = choices;
    }

    public String getStoryText() {
        return storyText;
    }

    public void setStoryText(String storyText) {
        this.storyText = storyText;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
