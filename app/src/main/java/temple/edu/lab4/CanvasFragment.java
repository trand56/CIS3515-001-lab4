package temple.edu.lab4;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CanvasFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CanvasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CanvasFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String colorName;
    private int colorValue;

    private Context parentActivity;

    public CanvasFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            colorName    = getArguments().getString("colorName");
            colorValue = getArguments().getInt("colorValue");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_canvas, container, false);
        layout.setBackgroundColor(colorValue);
        TextView colText = layout.findViewById(R.id.color_text);
        colText.setText(colorName);
        return layout;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        parentActivity = context;

    }

    @Override
    public void onDetach() {
        super.onDetach();
        parentActivity = null;
    }


    public static CanvasFragment newInstance(String colorName, int colorValue){
        CanvasFragment fragment = new CanvasFragment();
        Bundle bundle = new Bundle();
        bundle.putString("colorName", colorName);
        bundle.putInt("colorValue", colorValue);
        fragment.setArguments(bundle);
        return fragment;
    }
}
