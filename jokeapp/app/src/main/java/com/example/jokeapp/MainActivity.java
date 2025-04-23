package com.example.jokeapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String[] jokes = {
            "Why don’t scientists trust atoms? Because they make up everything!",
            "Why don’t skeletons fight each other? They don’t have the guts.",
            "Why did the scarecrow win an award? Because he was outstanding in his field!",
            "I told my wife she was drawing her eyebrows too high. She looked surprised.",
            "I'm reading a book on anti-gravity. It's impossible to put down!",
            "Did you hear about the claustrophobic astronaut? He just needed a little space.",
            "Why don't programmers like nature? It has too many bugs.",
            "Parallel lines have so much in common… it’s a shame they’ll never meet.",
            "I would tell you a construction joke, but I’m still working on it.",
            "What do you call fake spaghetti? An impasta!",
            "What do you call cheese that isn't yours? Nacho cheese.",
            "How does a penguin build its house? Igloos it together.",
            "I only know 25 letters of the alphabet. I don’t know y.",
            "I told my computer I needed a break, and now it won’t stop sending me KitKats.",
            "Why do bees have sticky hair? Because they use honeycombs.",
            "What do you call a dinosaur that is sleeping? A dino-snore!",
            "Why did the math book look sad? Because it had too many problems.",
            "What do you call a boomerang that won’t come back? A stick.",
            "Why did the golfer bring two pairs of pants? In case he got a hole in one.",
            "Why can’t you give Elsa a balloon? Because she’ll let it go.",
            "Why did the coffee file a police report? It got mugged.",
            "I used to play piano by ear, but now I use my hands.",
            "Why don’t some couples go to the gym? Because some relationships don’t work out.",
            "I asked my dog what's two minus two. He said nothing.",
            "Why did the orange stop? It ran out of juice.",
            "I told a joke about chemistry, but I got no reaction.",
            "What do you call a can opener that doesn’t work? A can’t opener.",
            "What’s orange and sounds like a parrot? A carrot.",
            "Why did the chicken join a band? Because it had the drumsticks.",
            "Why did the scarecrow become a successful neurosurgeon? Because he had outstanding brains!",
            "What kind of music do mummies listen to? Wrap music.",
            "Why are skeletons so calm? Because nothing gets under their skin.",
            "What do you call a pile of cats? A meowtain.",
            "Why don’t eggs tell each other secrets? Because they might crack up.",
            "How do you organize a space party? You planet.",
            "Why can’t your nose be 12 inches long? Because then it would be a foot.",
            "I’m on a seafood diet. I see food and I eat it.",
            "What’s brown and sticky? A stick.",
            "Why was the math teacher suspicious of prime numbers? Because they were odd.",
            "Why did the cow win an award? Because it was outstanding in its field.",
            "How do cows stay up to date? They read the moos-paper.",
            "Why did the bicycle fall over? Because it was two-tired.",
            "Why did the tomato turn red? Because it saw the salad dressing!",
            "What did the janitor say when he jumped out of the closet? Supplies!",
            "Why was the broom late? It over swept!",
            "Why was the stadium so cool? It was filled with fans.",
            "What did one wall say to the other? I’ll meet you at the corner.",
            "Why do vampires always seem sick? They’re always coffin.",
            "I ate a clock yesterday. It was very time consuming.",
            "Why don't oysters donate to charity? Because they are shellfish.",
            "Did you hear about the kidnapping at school? It’s fine, he woke up.",
            "I used to be addicted to soap, but I’m clean now."
    };


    int[] images = {
            R.drawable.laugh1,
            R.drawable.laugh2,
            R.drawable.laugh3,
            R.drawable.laugh4,
    };

    TextView jokeTextView;
    Button jokeButton;
    ImageView jokeImageView;
    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jokeTextView = findViewById(R.id.jokeTextView);
        jokeButton = findViewById(R.id.jokeButton);
        jokeImageView = findViewById(R.id.jokeImageView);
        random = new Random();

        jokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show random joke
                int jokeIndex = random.nextInt(jokes.length);
                jokeTextView.setText(jokes[jokeIndex]);

                // Show random image
                int imageIndex = random.nextInt(images.length);
                jokeImageView.setImageResource(images[imageIndex]);
            }
        });
    }
}
