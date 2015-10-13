package personal.demo.mydanmu.danmu;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;

import java.io.File;


public class MainActivity extends Activity implements View.OnClickListener{

    VideoView vv;
     RelativeLayout fl;
    Handler handler=new Handler();
    private  Button btn_add;
    int lineCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        initView();
        initPlayer();
        registerListeners();
    }

    private void registerListeners() {
        btn_add.setOnClickListener(this);
    }

    private void addDanmu() {
        final TextView danmuView=new TextView(this);
        danmuView.setText("第一行弹幕");
        danmuView.setTextSize(20);
        danmuView.setTextColor(Color.WHITE);
         fl.addView(danmuView);
      //  danmuView.setParentLayout(fl);
        //设置动画介绍监听
   /*     danmuView.setDanmuAnimationListener(new DanmuView.DanmuAnimationListener(){
            @Override
            public void onAnimationEnd(Animation animation) {
                fl.removeView(danmuView);
            }
        });*/
        //设置文字 颜色 速度
        //danmuView.startGo( Color.RED, DanmuView.DANMU_SPEED_MIDDLE);

        TranslateAnimation anim=new TranslateAnimation(-300,fl.getWidth(),200,200);
        Log.i("jcc", "-danmuView.getWidth()=" + danmuView.getWidth());
        anim.setDuration(5000);
        danmuView.setAnimation(anim);
        anim.start();
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                    fl.removeView(danmuView);
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    private void initPlayer() {
        File videoFile = new File("/mnt/sdcard/testvideo.mp4");
        vv.setVideoPath(videoFile.getAbsolutePath());
        vv.start();
    }

    private void initView() {
        vv=(VideoView)findViewById(R.id.vv);
        fl=(RelativeLayout)findViewById(R.id.danmuView);
        btn_add=(Button)findViewById(R.id.btn_add);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        addDanmu();
    }
}
