package org.ieselcaminas.pmdm.fragementsandroidioswindows;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {


    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.detail_fragment, container, false);
    }

    // we call this method when button from buttonFragment is clicked
    public void setText(String item) {
        TextView view = (TextView) getView().findViewById(R.id.display_tv);
        view.setText(item);
    }

}
