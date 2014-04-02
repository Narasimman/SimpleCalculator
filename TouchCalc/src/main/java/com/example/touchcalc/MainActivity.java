package com.example.touchcalc;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

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

        mKeypadAdapter.setOnButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) v;
                // Get the KeypadButton value which is used to identify the
                // keypad button from the Button's tag
                KeypadButton keypadButton = (KeypadButton) btn.getTag();

                // Process keypad button
                ProcessKeypadInput(keypadButton);
            }
        });

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

    private void ProcessKeypadInput(KeypadButton keypadButton) {
        String text = keypadButton.getText().toString();
        TextView userInputText = (TextView) findViewById(R.id.txtInput);
        String currentInput = userInputText.getText().toString();

        int len = currentInput.length();

        switch (keypadButton) {
            case CE:
                userInputText.setText("0");
                break;
            default:
                if(Character.isDigit(text.charAt(0))){
                    if(currentInput.equals("0"))
                        userInputText.setText(text);
                    else
                        userInputText.append(text);
                }
                break;
        }
    }
}
