package cat.dam.ivan.butterfly_garden;

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //member variables
    AnimationDrawable butterfly0_animation, butterfly1_animation, butterfly2_animation, butterfly3_animation, butterfly4_animation;
    ImageView iv_butterfly0, iv_butterfly1, iv_butterfly2, iv_butterfly3, iv_butterfly4;
    Button btn_play, btn_sound, btn_exit;
    //Objecte per reproduir música
    MediaPlayer mp;
    //Variables per controlar si la animació i la música estan pausades
    boolean isAnimationPaused = false;
    boolean isMusicPaused = false;

    //mètode onCreate que s'executa quan s'obre l'aplicació
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initListeners();
        initAnimation();
        initMusic();
    }

    //mètode que s'executa quan l'aplicació es destrueix
    @Override
    protected void onDestroy() {
        super.onDestroy();
//si l'usuari prem el botó d'exit, es destrueix l'objecte de la música
        mp.release();
    }

    //mètode que s'executa quan volem reproduir o pausar la música
    private void initMusic() {
        mp = MediaPlayer.create(this, R.raw.music);
        mp.start();

        //si l'usuari prem el botó de música, es comprova si la música està pausada o no
        btn_sound.setOnClickListener(v -> {
            if (mp.isPlaying()) {
                btn_sound.setBackgroundResource(R.drawable.ic_sound_off);
                mp.pause();
                isMusicPaused = true;
            } else {
                mp = MediaPlayer.create(this, R.raw.music);
                btn_sound.setBackgroundResource(R.drawable.ic_sound_on);
                mp.start();
                isMusicPaused = false;
            }
        });
    }

    //mètode que inicialitza els listeners dels botons i els objectes de les imatges
    private void initViews() {
        iv_butterfly0 = findViewById(R.id.iv_butterfly0);
        iv_butterfly1 = findViewById(R.id.iv_butterfly1);
        iv_butterfly2 = findViewById(R.id.iv_butterfly2);
        iv_butterfly3 = findViewById(R.id.iv_butterfly3);
        iv_butterfly4 = findViewById(R.id.iv_butterfly4);
        btn_play = findViewById(R.id.btn_play);
        btn_sound = findViewById(R.id.btn_sound);
        btn_exit = findViewById(R.id.btn_exit);
    }

    //mètode que inicialitza els listeners dels botons
    private void initListeners() {
        btn_play.setOnClickListener(v -> {
            if (isAnimationPaused) {
                butterfly0_animation.start();
                butterfly1_animation.start();
                butterfly2_animation.start();
                butterfly3_animation.start();
                butterfly4_animation.start();
                isAnimationPaused = false;
                btn_play.setBackgroundResource(R.drawable.ic_pause);
                btn_sound.setBackgroundResource(R.drawable.ic_sound_on);
                mp.start();
            } else {
                butterfly0_animation.stop();
                butterfly1_animation.stop();
                butterfly2_animation.stop();
                butterfly3_animation.stop();
                butterfly4_animation.stop();
                isAnimationPaused = true;
                btn_play.setBackgroundResource(R.drawable.ic_play);
                btn_sound.setBackgroundResource(R.drawable.ic_sound_off);
                mp.pause();
            }
        });

        //si l'usuari prem el botó d'exit, es mostra un diàleg per confirmar si vol sortir o no
        btn_exit.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(R.string.title_exit);
            builder.setMessage(R.string.exit);
            builder.setPositiveButton(R.string.yes, (dialog, which) -> {
                finish();
            });
            builder.setNegativeButton(R.string.no, (dialog, which) -> {
            });
            builder.show();
        });

    }

    //mètode que inicialitza les animacions i les posa en marxa
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