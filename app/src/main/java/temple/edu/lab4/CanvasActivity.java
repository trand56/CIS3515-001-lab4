package temple.edu.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        View canvas = findViewById(R.id.canvasbg_id);
        TextView colText = findViewById(R.id.color_text);

        Intent in = getIntent();
        String colname = in.getStringExtra(getResources().getString(R.string.color_name));
        int colval = in.getIntExtra(getResources().getString(R.string.color_value), Color.BLACK);

        colText.setText(colname);
        canvas.setBackgroundColor(colval);

    }
}
