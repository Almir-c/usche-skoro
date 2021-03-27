package com.company.graphic.panel;

import com.company.graphic.button.ButtonActionListener;
import com.company.graphic.button.ChoiceButton;
import com.company.logic.GameStatus;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Панель с кнопками
 * Содержит в себе ссылки на панель с картинкой и текстом,
 * чтобы текст и картинки можно было менять по нажатиям по кнопкам
 */
public class ChoicePanel extends JPanel {

    public ChoicePanel() {
        this.setSize(300, 300);
        this.setLocation(0, 500);
        this.setBackground(Color.RED);
        this.setLayout(new GridLayout(2, 1));
    }

    public void start(JButton startButton) {
        this.add(startButton);
    }

    //обновить кнопки
    public void fillButtons(ArrayList<JButton> buttons) {
        //удаление старых компонентов (кнопок)
        this.removeAll();
        for (JButton b : buttons) {
            this.add(b);
        }
    }
}
