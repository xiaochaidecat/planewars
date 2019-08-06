package com.neuedu.runtime;

import com.neuedu.base.BaseSprite;
import com.neuedu.base.Drawable;
import com.neuedu.base.Moveable;
import com.neuedu.constant.FrameConstant;
import com.neuedu.main.GameFrame;
import com.neuedu.util.DataStore;
import com.neuedu.util.ImageMap;

import java.awt.*;
import java.util.Random;

public class EnemyPlane extends BaseSprite implements Moveable, Drawable {
    private Image image;
    private Image image2;
    private  Integer speed= FrameConstant.SPEED*5;
    private Random random=new Random();
    private int index=0;
    public   int type;
    public   int xueliang;


    static int blood1=FrameConstant.BLOOD*7;
    static int blood2=FrameConstant.BLOOD*13;



    public EnemyPlane(int x, int y, int type) {
        super(x, y);
        this.type = type;
        this.image = ImageMap.get("ep1");
        this.image2 =ImageMap.get("ep2");
        if (type==1){
            xueliang=blood1;
        }else if (type==2){
            xueliang=blood2;
        }
    }

    public EnemyPlane() {
    }

    public void fire(){
        GameFrame gameFrame= DataStore.get("gameFrame");
        if (random.nextInt(1000)>985) {
            gameFrame.enemyBulletList.add(new EnemyBullet(getX()+(image.getWidth(null)/2)-ImageMap.get("ezd1").getWidth(null)/2,
                    getY()+image.getHeight(null), ImageMap.get("ezd1")));
            index++;

        }
    }
    @Override
    public void draw(Graphics g) {
        GameFrame gameFrame= DataStore.get("gameFrame");

        if (type==1) {
            g.drawImage(image, getX(), getY(), image.getWidth(null), image.getHeight(null), null);
        }else if (type==2){
            g.drawImage(image2, getX(), getY(), image.getWidth(null), image.getHeight(null), null);

        }
        if(gameFrame.bsjjishu==1&&getX()>-20&&getY()>-20){
            gameFrame.enemyPlaneList.remove(this);

        }
        move();
        fire();
        borderTesting();

    }

    @Override
    public void move() {
if(type==1){
            setY(getY() + 2);
            if (getX() <= -100) {
                setX(getX() + 860);
            } else {
                setX(getX() - speed);
            }
        }else {  setY(getY() + 2);
    if (getX() >= 830) {
        setX(getX() - 900);
    } else {
        setX(getX() + speed);
    }

}

    }


    @Override
    public Rectangle getRectangle() {
        return new Rectangle(getX(),getY(),image.getWidth(null),image.getHeight(null));

    }

    public  void borderTesting(){
        if (getY()>FrameConstant.FRAME_HEIGHT){
            GameFrame gameFrame= DataStore.get("gameFrame");
            gameFrame.enemyPlaneList.remove(this);
        }
    }


}
