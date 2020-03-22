package temple.edu.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class PaletteActivity extends AppCompatActivity implements PaletteFragment.ColorSelectorInterface {

    private boolean loaded = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PaletteFragment palfrag = PaletteFragment.newInstance(getResources().getStringArray(R.array.color_names_array));
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container1, palfrag)
                .commit();


        /*
        ColorAdapter colAdapter = new ColorAdapter(this);
        Spinner colSpin = findViewById(R.id.color_spinner);
        colSpin.setAdapter(colAdapter);

        colSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(loaded) {
                    Intent intentCanvas = new Intent(PaletteActivity.this, CanvasActivity.class);
                    TextView colorView = (TextView)view;
                    intentCanvas.putExtra(getResources().getString(R.string.color_name), colorView.getText());
                    intentCanvas.putExtra(getResources().getString(R.string.color_value), ((ColorDrawable)colorView.getBackground()).getColor());
                    startActivity(intentCanvas);
                }
                else loaded = true;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        */
    }

    public void onColorSelected(String colorName, int colorValue){
        Toast.makeText(this, colorName + ", " + colorValue, Toast.LENGTH_SHORT).show();
    }

}
