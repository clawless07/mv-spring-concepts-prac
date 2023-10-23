package com.mv.spring.pracspringframework02.game;

public class PacManGame implements GamingConsole{
    @Override
    public void up() {
        System.out.println("PacMan up");
    }

    @Override
    public void down() {
        System.out.println("PacMan down");
    }

    @Override
    public void left() {
        System.out.println("PacMan left");
    }

    @Override
    public void right() {
        System.out.println("PacMan right");
    }
}
