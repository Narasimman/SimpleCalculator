package com.example.touchcalc;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        GridView mKeypadGrid;
        KeypadAdapter mKeypadAdapter;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Get reference to the keypad button GridView
        mKeypadGrid = (GridView) findViewById(R.id.grdButtons);


        // Create Keypad Adapter
        mKeypadAdapter = new KeypadAdapter(this);

        // Set adapter of the keypad grid
        mKeypadGrid.setAdapter(mKeypadAdapter);

    mKeypadGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView <?> parent, View v,int position, long id) {
            // This will not help us catch button clicks!
        }
    });

}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
