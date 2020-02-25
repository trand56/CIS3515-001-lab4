package temple.edu.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

public class PaletteActivity extends AppCompatActivity {

    private boolean loaded = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ColorAdapter colAdapter = new ColorAdapter(this);
        Spinner colSpin = findViewById(R.id.color_spinner);
        colSpin.setAdapter(colAdapter);

        colSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(loaded) {
                    Intent intentCanvas = new Intent(PaletteActivity.this, CanvasActivity.class);
                    intentCanvas.putExtra("color", ((TextView) view).getText());
                    startActivity(intentCanvas);
                }
                else loaded = true;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
