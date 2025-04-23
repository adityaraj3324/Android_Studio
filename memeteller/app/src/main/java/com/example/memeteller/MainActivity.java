package com.example.memeteller;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int[] memes = {
            R.drawable.meme1,
            R.drawable.meme2,
            R.drawable.meme3,
            R.drawable.meme4,
            R.drawable.meme5,
            R.drawable.meme6,
            R.drawable.meme7
    };

    Button memeButton;
    ImageView memeImageView;
    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        memeButton = findViewById(R.id.memeButton);
        memeImageView = findViewById(R.id.memeImageView);
        random = new Random();

        memeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int memeIndex = random.nextInt(memes.length);
                memeImageView.setImageResource(memes[memeIndex]);
            }
        });
    }
}
