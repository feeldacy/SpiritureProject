package Entities;

import Main.Game;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public abstract class Entity {
    protected int health;
    protected int damage;
    protected int defense;
    protected float x, y;
    protected int width, height;
    protected Rectangle2D.Float hitBox;

    public Entity(float x, float y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    protected void drawHitBox(Graphics g){
        // for debugging hitbox
        g.setColor(Color.PINK);
        g.drawRect((int)hitBox.x, (int)hitBox.y, (int)hitBox.width, (int)hitBox.height);
    }

    protected void initHitBox(float x, float y, float width, int height) {
        hitBox = new Rectangle2D.Float(x, y, width, height);
    }

//    protected void updateHitBox(){
//        hitBox.x = (int)x;
//        hitBox.y = (int)y;
//    }

    public boolean isAlive(){
        if (health > 0){
            return true;
        } else {
            return false;
        }
    }

    public Rectangle2D.Float getHitBox(){
        return hitBox;
    }

}
