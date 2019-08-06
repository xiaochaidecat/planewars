package com.neuedu.runtime;

import com.neuedu.base.BaseSprite;
import com.neuedu.base.Drawable;
import com.neuedu.base.Moveable;
import com.neuedu.constant.FrameConstant;
import com.neuedu.main.GameFrame;
import com.neuedu.util.DataStore;

import java.awt.*;

public class BossLose extends BaseSprite implements Moveable, Drawable {

    private Image image;

    private boolean down = true;
    private boolean right = true;
    private boolean xiaoshi =false;


    public BossLose() {
    }

    public BossLose(int x, int y, Image image) {
        super(x, y);
        this.image = image;
    }

    @Override
    public void draw(Graphics g) {
        move();
        borderTesting();
        g.drawImage(image, getX(), getY(), image.getWidth(null), image.getHeight(null), null);

    }

    @Override
    public void move() {
        if (xiaoshi) {
            setX(-1500);
            setY(-1500);
        }else {
            if (right && down) {
            setX(getX() + 5);
            setY(getY() + 5);
        } else if (right == false & down) {
            setX(getX() - 5);
            setY(getY() + 5);
        } else if (right == false && down == false) {
            setX(getX() - 5);
            setY(getY() - 5);
        } else if (right && down == false) {
            setX(getX() + 5);
            setY(getY() - 5);
        }}
    }
    @Override
    public Rectangle getRectangle() {
        return new Rectangle(getX(), getY(), image.getWidth(null), image.getHeight(null));

    }

    public void borderTesting() {
        if (getY() >=FrameConstant.FRAME_HEIGHT-image.getHeight(null)) {
            down=false;
        }else if(getY()<=40){
            down=true ;
        }else if (getX()<=0){
            right=true;
        }else if (getX()>= FrameConstant.FRAME_WIDTH -image.getWidth(null)){
            right=false;
        }
    }
    public void  collisionTesting(Plane plane){
        GameFrame gameFrame= DataStore.get("gameFrame");
        if (plane.getRectangle().intersects(this.getRectangle())){
            gameFrame.bossLoseList.remove(this);
                    gameFrame.hp+=3;
            }
        }
    }

