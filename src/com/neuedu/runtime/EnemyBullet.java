package com.neuedu.runtime;

import com.neuedu.base.BaseSprite;
import com.neuedu.base.Drawable;
import com.neuedu.base.Moveable;
import com.neuedu.constant.FrameConstant;
import com.neuedu.main.GameFrame;
import com.neuedu.util.DataStore;

import java.awt.*;
import java.util.List;

public class EnemyBullet extends BaseSprite implements Moveable, Drawable {
    private Image image;

    public EnemyBullet() {
    }

    public EnemyBullet(int x, int y, Image image) {
        super(x, y);
        this.image = image;
    }

    @Override
    public void draw(Graphics g) {
        GameFrame gameFrame= DataStore.get("gameFrame");
        if(gameFrame.bsjjishu==1&&getX()>0&&getY()>0){
            gameFrame.enemyBulletList.remove(this);

        }
        g.drawImage(image, getX(), getY(), image.getWidth(null), image.getHeight(null), null);


        move();
        borderTesting();

    }

    @Override
    public void move() {
        setY(getY() + 8);
    }



    public  void borderTesting(){
        if (getY()> FrameConstant.FRAME_HEIGHT||getY()<0){
            GameFrame gameFrame= DataStore.get("gameFrame");
            gameFrame.enemyBulletList.remove(this);
        }

    }

    @Override
    public Rectangle getRectangle() {
        return new Rectangle(getX(),getY(),image.getWidth(null),image.getHeight(null));
    }
    //敌人子弹对我机的碰撞检测
    public void  collisionTesting(Plane plane){
        GameFrame gameFrame= DataStore.get("gameFrame");
            if (plane.getRectangle().intersects(this.getRectangle())){
                gameFrame.enemyBulletList.remove(this);
                gameFrame.hp--;
                if (gameFrame.hp<=0){
                    gameFrame.game=true;
                }
        }
    }
}
