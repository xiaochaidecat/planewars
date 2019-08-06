package com.neuedu.runtime;

import com.neuedu.base.BaseSprite;
import com.neuedu.base.Drawable;
import com.neuedu.base.Moveable;
import com.neuedu.constant.FrameConstant;
import com.neuedu.main.GameFrame;
import com.neuedu.util.DataStore;
import com.neuedu.util.ImageMap;

import java.awt.*;


public class BossBullet  extends BaseSprite implements Moveable, Drawable {
    private Image image;
    private boolean right=true;
    private boolean down=true;
    private boolean xiaoshi=false;
    public int xunlunblood=8;
    int xunlunjishi=0;
    private  int count =0;

    public BossBullet() {
        this(200,200,ImageMap.get("bosszd"));
    }

    public BossBullet(int x, int y, Image image) {
        super(x, y);
        this.image = image;
    }

    @Override
    public void draw(Graphics g) {

            g.drawImage(image, getX(), getY(), image.getWidth(null), image.getHeight(null), null);

        move();
       borderTesting();
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

    public void borderTesting() {
        if (getY() >= FrameConstant.FRAME_HEIGHT-image.getHeight(null)) {
            down=false;
        }else if(getY()<=40){
            down=true ;
        }else if (getX()<=0){
            right=true;
        }else if (getX()>= FrameConstant.FRAME_WIDTH -image.getWidth(null)){
            right=false;
        }
    }

    @Override
    public Rectangle getRectangle() {
        return new Rectangle(getX(), getY(), image.getWidth(null), image.getHeight(null));

    }
    //血轮子弹对我机的碰撞检测
    public void  collisionTesting(Plane plane){
        GameFrame gameFrame= DataStore.get("gameFrame");
        xunlunjishi++;
        if (plane.getRectangle().intersects(this.getRectangle())){
            if (xunlunjishi>=50)
            {
                xunlunblood-=2;
                gameFrame.hp-=2;
                xunlunjishi=0;
            }
            if (xunlunblood==0){
            gameFrame.bossBulletList.remove(this);}
            if (gameFrame.hp<=0){
                gameFrame.game=true;
            }
        }
    }
}
