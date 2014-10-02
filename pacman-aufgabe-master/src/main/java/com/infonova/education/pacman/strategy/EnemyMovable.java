package com.infonova.education.pacman.strategy;

import com.infonova.education.pacman.*;

public class EnemyMovable implements Movable {

    @Override
    public void move(UserAction userAction, Level level, GameObject gameObject) {

        Hero h = level.getHero();

        final int maxX = level.getMaxX();
        final int maxY = level.getMaxY();

        int newX = gameObject.getX();
        int newY = gameObject.getY();

        int mod = h.isSuperMode() ? -1 : 1;

        if (h.getX() < newX) {
            newX -= mod;
        } else if (h.getX() > newX) {
            newX += mod;
        } else if (h.getY() < newY) {
            newY -= mod;
        } else if (h.getY() > newY) {
            newY += mod;
        }

        newX = movePosition(newX, maxX);
        newY = movePosition(newY, maxY);


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
