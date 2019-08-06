package com.neuedu.runtime;

import com.neuedu.base.BaseSprite;
import com.neuedu.base.Drawable;
import com.neuedu.base.Moveable;
import com.neuedu.constant.FrameConstant;
import com.neuedu.main.GameFrame;
import com.neuedu.util.DataStore;
import com.neuedu.util.ImageMap;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Plane extends BaseSprite implements Moveable, Drawable {
















    private Image image;
    private boolean up, right, down, left;
    private boolean fire;
    private Integer speed = FrameConstant.SPEED * 8;
    private Integer index = 0;
    public boolean bsj;
    public boolean shandiankai=false;

    ///////////////////////////////


    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Plane() {
        this((FrameConstant.FRAME_WIDTH - ImageMap.get("my1").getWidth(null) * 2) / 2,
                FrameConstant.FRAME_HEIGHT - ImageMap.get("my1").getHeight(null) * 2,
                ImageMap.get("my1"));

    }

    public Plane(int x, int y, Image image) {
        super(x, y);
        this.image = image;
    }


    @Override
    public void draw(Graphics g) {
        g.drawImage(image, getX(), getY(), image.getWidth(null) * 2, image.getHeight(null) * 2, null);
        move();
        fire();
        boredrTesting();

        if (fire) {
            index++;
            if (index >= 8) {
                index = 0;
            }
        }
    }

    //开火方法
    public void fire() {
        if (fire && index == 0) {
            GameFrame gameFrame = DataStore.get("gameFrame");
            if (gameFrame.level<1){
            gameFrame.bulletList.add(new Bullet(
                    getX() + image.getWidth(null) - (ImageMap.get("myzd1").getWidth(null) / 2),
                    getY() - ImageMap.get("myzd1").getHeight(null),
                    ImageMap.get("myzd1")

            ));
        }else{
                gameFrame.bulletList.add(new Bullet(
                        getX() + image.getWidth(null) - (ImageMap.get("myzd3").getWidth(null) / 2),
                        getY() - ImageMap.get("myzd3").getHeight(null),
                        ImageMap.get("myzd3")));

            }

    }}

    @Override
    public void move() {
        if (up) {
            setY(getY() - speed);
        }
        if (right) {
            setX(getX() + speed);
        }
        if (down) {
            setY(getY() + speed);
        }
        if (left) {
            setX(getX() - speed);
        }


    }
    GameFrame gameFrame= DataStore.get("gameFrame");
    public void keyPressed(KeyEvent e) {


        if (e.getKeyCode() == KeyEvent.VK_W) {
            up = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            left = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            down = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            right = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_J) {
            fire = true;
        }
        //自动开火
        if (e.getKeyCode() == KeyEvent.VK_Z) {
            fire = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_K) {
            bsj = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_L) {
            shandiankai = true;
        }

    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            up = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            left = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            down = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            right = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_J) {
            fire = false;
        }
//        if (e.getKeyCode() == KeyEvent.VK_K) {
//            bsj = false;
//        }


    }

    public void boredrTesting() {
        if (getX() < 0) {
            setX(0);
        }
        if (getX() > FrameConstant.FRAME_WIDTH - image.getWidth(null) * 2) {
            setX(FrameConstant.FRAME_WIDTH - image.getWidth(null) * 2);
        }
        if (getY() < 50) {
            setY(50);
        }
        if (getY() > FrameConstant.FRAME_HEIGHT - image.getHeight(null) * 2) {
            setY(FrameConstant.FRAME_HEIGHT - image.getHeight(null) * 2);
        }
    }

    @Override
    public Rectangle getRectangle() {
        return new Rectangle(getX(), getY(), image.getWidth(null)*2, image.getHeight(null));
    }

}