package org.ieselcaminas.pmdm.fragementsandroidioswindows;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class ButtonFragment extends Fragment implements View.OnClickListener {

    public interface Communicator {
        public void displayMessage(String OS_Name);
    }
    private Communicator communicator;
    Button android_btn, ios_btn, windows_btn;

    public ButtonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.button_fragment, container, false);

        // Initialize Views
        android_btn = (Button) view.findViewById(R.id.android_btn_id);
        ios_btn = (Button) view.findViewById(R.id.ios_btn_id);
        windows_btn = (Button) view.findViewById(R.id.windows_btn_id);

        // set on click Listeners for buttons
        android_btn.setOnClickListener(this);
        ios_btn.setOnClickListener(this);
        windows_btn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        if (activity instanceof Communicator) {
            communicator = (Communicator) activity;
        } else {
            throw new ClassCastException(activity.toString()
                    + " must implement ButtonFragment.Communicator");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.android_btn_id:
                communicator.displayMessage("Android");
                break;

            case R.id.ios_btn_id:
                communicator.displayMessage("IOS");
                break;

            case R.id.windows_btn_id:
                communicator.displayMessage("Windows");
                break;
        }

    }

}
