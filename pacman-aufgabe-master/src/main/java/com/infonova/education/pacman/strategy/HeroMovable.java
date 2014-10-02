package com.infonova.education.pacman.strategy;

import com.infonova.education.pacman.BackgroundType;
import com.infonova.education.pacman.GameObject;
import com.infonova.education.pacman.Level;
import com.infonova.education.pacman.UserAction;

public class HeroMovable implements Movable {

    @Override
    public void move(UserAction userAction, Level level, GameObject gameObject) {

        final int maxX = level.getMaxX();
        final int maxY = level.getMaxY();

        int newX = gameObject.getX();
        int newY = gameObject.getY();

        switch (userAction) {
            case LEFT:
                newX = movePosition(--newX, maxX);
                break;
            case RIGHT:
                newX = movePosition(++newX, maxX);
                break;
            case UP:
                newY = movePosition(--newY, maxY);
                break;
            case DOWN:
                newY = movePosition(++newY, maxY);
                break;
        }

        if(level.getBg(newX, newY).getType() != BackgroundType.WALL) {
            gameObject.setX(newX);
            gameObject.setY(newY);
        }
    }

    private int movePosition(int position, int maxPosition) {
        position = Math.max(0, position);
        position = Math.min(position, maxPosition - 1);
        return position;
    }

}
