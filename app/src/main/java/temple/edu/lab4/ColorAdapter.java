package temple.edu.lab4;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class ColorAdapter extends BaseAdapter{

    private Context context;
    private String[] colorNames;
    private String[] colorHexes;

    public ColorAdapter(Context context)
    {
        super();
        this.context = context;
        this.colorNames = context.getResources().getStringArray(R.array.color_names_array);
        this.colorHexes = context.getResources().getStringArray(R.array.color_hex_array);
    }

    @Override
    public int getCount(){
        return colorNames.length;
    }

    @Override
    public Object getItem(int position)
    {
        return isBetween(position, 0, this.colorNames.length) ? this.colorNames[position] : null;
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if( !isBetween(position, 0, this.colorNames.length) &&
            !isBetween(position, 0, this.colorHexes.length))
            return null;

        TextView newView = (TextView)convertView;
        if(newView == null)
        {
            newView = new TextView(this.context);
            newView.setTextColor(Color.BLACK);
            newView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24 );
        }

        newView.setText(this.colorNames[position]);
        newView.setBackgroundColor(Color.parseColor(this.colorHexes[position]));

        return newView;
    }

    /// check if value is in between a and b ( not including b )
    private boolean isBetween(int x, int a, int b)
    {
        return x >= 0 && x < b;
    }
}
