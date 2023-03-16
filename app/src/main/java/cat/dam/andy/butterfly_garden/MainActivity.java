package cat.dam.andy.butterfly_garden;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    //member variables
    AnimationDrawable butterfly0_animation, butterfly1_animation,butterfly2_animation,butterfly3_animation, butterfly4_animation;
    ImageView iv_butterfly0, iv_butterfly1, iv_butterfly2, iv_butterfly3, iv_butterfly4;
    Button btn_play, btn_sound, btn_exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniViews();
        initListeners();
        initAnimation();
        initMusic();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void initMusic() {
    }

    private void iniViews() {
        iv_butterfly0 = findViewById(R.id.iv_butterfly0);
        iv_butterfly1 = findViewById(R.id.iv_butterfly1);
        iv_butterfly2 = findViewById(R.id.iv_butterfly2);
        iv_butterfly3 = findViewById(R.id.iv_butterfly3);
        iv_butterfly4 = findViewById(R.id.iv_butterfly4);
        btn_play = findViewById(R.id.btn_play);
        btn_sound = findViewById(R.id.btn_sound);
        btn_exit = findViewById(R.id.btn_exit);
    }

    private void initListeners() {

    }

    private void initAnimation() {
        butterfly0_animation = new AnimationDrawable();
        iv_butterfly0.setX(200);
        iv_butterfly0.setY(130);
        iv_butterfly0.setBackgroundResource(R.drawable.butterfly0_animation);
        butterfly0_animation = (AnimationDrawable) iv_butterfly0.getBackground();
        butterfly0_animation.start();
        butterfly1_animation = new AnimationDrawable();
        iv_butterfly1.setX(60);
        iv_butterfly1.setY(80);
        iv_butterfly1.setBackgroundResource(R.drawable.butterfly1_animation);
        butterfly1_animation = (AnimationDrawable) iv_butterfly1.getBackground();
        butterfly1_animation.start();
        iv_butterfly2.setX(100);
        iv_butterfly2.setY(260);
        iv_butterfly2.setBackgroundResource(R.drawable.butterfly2_animation);
        butterfly2_animation = (AnimationDrawable) iv_butterfly2.getBackground();
        butterfly2_animation.start();
        iv_butterfly3.setX(600);
        iv_butterfly3.setY(160);
        iv_butterfly3.setBackgroundResource(R.drawable.butterfly3_animation);
        butterfly3_animation = (AnimationDrawable) iv_butterfly3.getBackground();
        butterfly3_animation.start();
        iv_butterfly4.setX(350);
        iv_butterfly4.setY(230);
        iv_butterfly4.setBackgroundResource(R.drawable.butterfly4_animation);
        butterfly4_animation = (AnimationDrawable) iv_butterfly4.getBackground();
        butterfly4_animation.start();
    }
}