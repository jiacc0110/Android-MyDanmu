package personal.demo.mydanmu.danmu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.TextClock;
import android.widget.TextView;

import java.net.InterfaceAddress;

/**
 * Created by user on 2015/10/13.
 */
public class DanmuView extends TextView{
    private Context context;
    private String text;
    private FrameLayout fl;

    public static final int DANMU_SPEED_FAST=3000;
    public static final int DANMU_SPEED_MIDDLE=5000;
    public static final int DANMU_SPEED_LOW=7000;
    private TranslateAnimation anim;


    public DanmuView(Context context) {
        super(context);
        this.context=context;
    }

    public void setText(String text){
        this.text=text;
    }


   /* public void startGo(int textColor,int danmuSpeed){

       // setTextColor(textColor);
        setTextSize(100);
        anim=new TranslateAnimation(0,fl.getWidth()+this.getWidth(),0,0);
        anim.setDuration(danmuSpeed);
        setAnimation(anim);
        anim.start();
    }*/

 /*   public void setDanmuAnimationListener(DanmuAnimationListener listener){
        anim.setAnimationListener(listener);
    }

    public static abstract class DanmuAnimationListener implements Animation.AnimationListener{
        @Override
        public void onAnimationStart(Animation animation) {
        }
        @Override
        public void onAnimationRepeat(Animation animation) {
        }
    }*/

    public void setParentLayout(FrameLayout fl){
        this.fl=fl;
    }
}
