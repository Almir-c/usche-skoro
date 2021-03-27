package com.company.graphic.panel;

import com.company.Main;

import javax.swing.*;
import java.awt.*;

/**
 * Панель с картинкой
 */
public class ImagePanel extends JPanel {
    //ширина картинки
    private final int width = 1000;
    //высота картинки
    private final int height = 500;
    //переменная с картинкой
    private Image image;

    //Создание и первичная настройка панели
    public ImagePanel() {
        this.setSize(1000, 500);
        this.setBackground(Color.BLACK);
        this.setLocation(0, 0);
        //загрузка картинки в программу
        image = new ImageIcon("file.jpg").getImage();
        //изменение размера картинки
        image = image.getScaledInstance(width, height, Image.SCALE_DEFAULT);
    }

    //отрисовка панели. запускается при создании
    //можено перерисовать заного методом reapint
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //отрисовка изображения
        g.drawImage(image, 0, 0, this);
    }

    //Метод устанавливает картинку и перерисовывает панель
    public void setImage(String imagePass) {
        //загрузка картинки в программу
        image = new ImageIcon(imagePass).getImage();
        //изменение размера картинки
        image = image.getScaledInstance(width, height, Image.SCALE_DEFAULT);
        //перерисовываем всю панель
        //(вызывается метод paintComponent())
        this.repaint();
    }


}
