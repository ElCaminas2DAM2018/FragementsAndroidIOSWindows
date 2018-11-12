package org.ieselcaminas.pmdm.fragementsandroidioswindows;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements
        ButtonFragment.Communicator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void displayMessage(String OS_Name) {
        DetailFragment detailfragment = (DetailFragment) getSupportFragmentManager()
                .findFragmentById(R.id.detail_Fragment);
        if (detailfragment != null && detailfragment.isInLayout()) {
            detailfragment.setText(OS_Name);
        } else {
            Intent intent = new Intent(getApplicationContext(),
                    DetailActivity.class);
            intent.putExtra("os_name", OS_Name);
            startActivity(intent);
        }

    }

}