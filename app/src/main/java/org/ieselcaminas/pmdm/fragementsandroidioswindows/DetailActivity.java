package org.ieselcaminas.pmdm.fragementsandroidioswindows;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }
        setContentView(R.layout.detail_activity);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String name = extras.getString("os_name");
            DetailFragment detailFragment =
                    (DetailFragment) getSupportFragmentManager()
                            .findFragmentById(R.id.detailFragment); // the id in detail_activity.xml
            detailFragment.setText(name);
        }
    }

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
