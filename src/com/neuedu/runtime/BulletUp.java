package com.neuedu.runtime;

import com.neuedu.base.BaseSprite;
import com.neuedu.base.Drawable;
import com.neuedu.base.Moveable;
import com.neuedu.constant.FrameConstant;
import com.neuedu.main.GameFrame;
import com.neuedu.util.DataStore;
import com.neuedu.util.ImageMap;

import java.awt.*;

public class BulletUp extends BaseSprite implements Moveable, Drawable {
    private Image image;
    private Image image2;
    private Image image3;
    private int type;
    private boolean right = true;


    public BulletUp() {

    }

    public BulletUp(int x, int y, int type) {
        super(x, y);
        this.type = type;

        this.image = ImageMap.get("zdup1");
        this.image2 = ImageMap.get("bloodup");
        this.image3 = ImageMap.get("speedup");
    }

    @Override
    public void draw(Graphics g) {
        if (type == 1) {
            g.drawImage(image, getX(), getY(), image.getWidth(null), image.getHeight(null), null);
        } else if (type == 2) {
            g.drawImage(image2, getX(), getY(), image.getWidth(null), image.getHeight(null), null);

        } else if (type == 3) {
            g.drawImage(image3, getX(), getY(), image.getWidth(null) * 2, image.getHeight(null) * 2, null);

        }
        borderTesting();
        move();
    }

    @Override
    public void move() {
        if (type == 1) {
            setY(getY() + 10);
        } else if (type == 2) {
            if (right) {
                setX(getX() + 5);
                setY(getY() + 3);
            } else {
                setX(getX() - 5);
                setY(getY() + 3);
            }
        }
        else  if(type==3){
            setY(getY()+15);
        }
    }

    @Override
    public Rectangle getRectangle() {
        return new Rectangle(getX(), getY(), image.getWidth(null), image.getHeight(null));

    }

    public void borderTesting() {
        if (type == 1) {
            if (getY() > FrameConstant.FRAME_HEIGHT) {
                GameFrame gameFrame = DataStore.get("gameFrame");
                gameFrame.enemyPlaneList.remove(this);
            }
        } else if (type == 2) {
            if (getX() + image2.getWidth(null) >= FrameConstant.FRAME_HEIGHT - 170) {
                right = false;
            } else if (getX() < 0) {
                right = true;
            }
        }
    }

    //增益对我的碰撞检测
    public void collisionTesting(Plane plane) {

        GameFrame gameFrame = DataStore.get("gameFrame");
        if (plane.getRectangle().intersects(this.getRectangle())) {

            gameFrame.bulletUpList.remove(this);
            if (type == 1) {
                gameFrame.level = 1;
            } else if (type == 2) {
                gameFrame.hp++;
            }
            else if (type==3){
                //飞机速度
                gameFrame.plane.setSpeed(plane.getSpeed()+6);
                //子弹速度+7
                gameFrame.zdsp+=7;

            }
        }
    }
}
