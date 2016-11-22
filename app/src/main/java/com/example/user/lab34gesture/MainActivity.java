package com.example.user.lab34gesture;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.view.MotionEventCompat;
import android.widget.TextView;

public class MainActivity extends Activity {

    TextView textViewMessage;
    float xy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewMessage = (TextView) findViewById(R.id.textViewMessage);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = MotionEventCompat.getActionMasked(event);
        if (action == MotionEvent.ACTION_DOWN) { //Touching screen
            xy = event.getX();
            return true;
        }
        if (action == MotionEvent.ACTION_UP) { //Release touch
            float diff = xy - event.getX();
            if (diff > 100) {
                textViewMessage.setText("Move to the LEFT.");
            } else if (diff < -100) {
                textViewMessage.setText("Move to the RIGHT.");
            }
        }
        return super.onTouchEvent(event);
    }

}
