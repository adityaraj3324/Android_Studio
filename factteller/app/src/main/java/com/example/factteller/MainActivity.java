package com.example.factteller;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int[] factImages = {
            R.drawable.fact1,
            R.drawable.fact2,
            R.drawable.fact3,
            R.drawable.fact4,
            R.drawable.fact5,
            R.drawable.fact6,
            R.drawable.fact7
    };

    String[] facts = {
            "Bananas are berries, but strawberries aren't.",
            "Honey never spoils.",
            "Octopuses have three hearts.",
            "A day on Venus is longer than a year.",
            "There’s enough DNA in your body to stretch from the sun to Pluto and back.",
            "Sharks are older than trees.",
            "Hot water freezes faster than cold water.",
            "The Eiffel Tower can grow more than 6 inches in summer.",
            "Sloths can hold their breath longer than dolphins.",
            "Humans share 60% of their DNA with bananas.",
            "A bolt of lightning contains enough energy to toast 100,000 slices of bread.",
            "Wombat poop is cube-shaped.",
            "The unicorn is Scotland’s national animal.",
            "The first oranges weren’t orange.",
            "There's a basketball court on the top floor of the U.S. Supreme Court building.",
            "Some cats are allergic to humans.",
            "Octopuses taste with their arms.",
            "The majority of your brain is fat.",
            "Sea otters hold hands when they sleep.",
            "Water can boil and freeze at the same time.",
            "A jiffy is an actual unit of time.",
            "An apple, potato, and onion taste the same if you eat them with your nose plugged.",
            "Cows have best friends.",
            "You can hear a blue whale's heartbeat from 2 miles away.",
            "Humans glow in the dark (faintly).",
            "The moon has moonquakes.",
            "Tomatoes have more genes than humans.",
            "The smell of fresh-cut grass is actually a distress call.",
            "Butterflies can taste with their feet.",
            "The longest hiccuping spree lasted 68 years.",
            "A snail can sleep for 3 years.",
            "The dot over the “i” is called a tittle.",
            "Your stomach gets a new lining every 3–4 days.",
            "Some turtles can breathe through their butts.",
            "Pineapples take 2 years to grow.",
            "There's a planet made of diamonds.",
            "Mosquitoes are the deadliest animal.",
            "The average cloud weighs over 1 million pounds.",
            "Apples float because they’re 25% air.",
            "Goats have rectangular pupils.",
            "An octopus can squeeze through any hole bigger than its beak.",
            "Humans can survive without a stomach.",
            "The inventor of the microwave appliance only received $2.",
            "Birds don’t urinate.",
            "There are more trees on Earth than stars in the galaxy.",
            "It's impossible to hum while holding your nose.",
            "Dogs can smell your feelings.",
            "Coca-Cola was the first soft drink in space.",
            "A shrimp's heart is in its head."
    };

    Button factButton;
    ImageView factImageView;
    TextView factTextView;
    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        factButton = findViewById(R.id.factButton);
        factImageView = findViewById(R.id.factImageView);
        factTextView = findViewById(R.id.factTextView);
        random = new Random();

        factButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int imageIndex = random.nextInt(factImages.length);
                int factIndex = random.nextInt(facts.length);

                factImageView.setImageResource(factImages[imageIndex]);
                factTextView.setText(facts[factIndex]);
            }
        });
    }
}
