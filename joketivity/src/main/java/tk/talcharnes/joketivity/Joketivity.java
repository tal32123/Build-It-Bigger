package tk.talcharnes.joketivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Joketivity extends AppCompatActivity {
    public final static String INTENT_JOKE_TAG = "joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joketivity);

        Intent jokeIntent = getIntent();
        String joke = jokeIntent.getStringExtra(INTENT_JOKE_TAG);
        TextView jokeTextView = (TextView) findViewById(R.id.joke_textview);
        jokeTextView.setText(joke);
    }
}
