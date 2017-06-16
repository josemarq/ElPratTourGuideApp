package josemarq.elprattourguideapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        //GET EXTRA FROM INTENT
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }

        //TITULO
        String title = getIntent().getStringExtra("Title");
        TextView titleText = (TextView) findViewById(R.id.titulo);
        titleText.setText(title);
        setTitle(getIntent().getStringExtra("Title"));

        //DESCRIPCION
        String descripcion = getIntent().getStringExtra("Description");
        TextView descripcionText = (TextView) findViewById(R.id.descripcion);
        descripcionText.setText(descripcion);

        //EMOJI (if exist)
        String emoji = getIntent().getStringExtra("Emoji");
        if (emoji!=null) {
        TextView emojiText = (TextView) findViewById(R.id.emoji);
        emojiText.setText(emoji);
        emojiText.setVisibility(View.VISIBLE);
        }

        int imagen = getIntent().getIntExtra("Imagen", 0);
        ImageView featureImage = (ImageView) findViewById(R.id.feature_image);
        featureImage.setImageResource(imagen);


    }

    // Make up button work as back for go to parent activity in the tab of the MainActivity
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
