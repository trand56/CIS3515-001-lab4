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
    private String[] colors;

    public ColorAdapter(Context context)
    {
        super();
        this.context = context;
        this.colors = new String[]{ "Teal", "Red", "Blue", "Yellow", "Purple",
                "White", "LightGray", "Gray", "DarkGray", "Black",
                "Lime", "Navy", "Aqua", "Fuchsia", "Olive"};
    }

    @Override
    public int getCount(){
        return colors.length;
    }

    @Override
    public Object getItem(int position)
    {
        return isBetween(position, 0, this.colors.length) ? this.colors[position] : null;
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if(!isBetween(position, 0, this.colors.length))
            return null;

        TextView newView = (TextView)convertView;
        if(newView == null)
        {
            newView = new TextView(this.context);
            newView.setTextColor(Color.BLACK);
            newView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24 );
        }

        newView.setText(this.colors[position]);
        newView.setBackgroundColor(Color.parseColor(this.colors[position]));

        return newView;
    }

    /// check if value is in between a and b ( not including b )
    private boolean isBetween(int x, int a, int b)
    {
        return x >= 0 && x < b;
    }
}
