package com.player.jessica;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class OrderActivity extends ActionBarActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        String storeName = getIntent().getStringExtra("storeName");
        textView = (TextView) findViewById(R.id.storeName);
        textView.setText(storeName);
    }

    public void cnt(View view) //參數-被點擊的元件實體    //2015.05.01
    {
        Button button = (Button) view;
        int i = Integer.parseInt(button.getText().toString()); //文字轉整數
        button.setText(String.valueOf(i + 1)); //整數加一轉回字串，return

        getData();
    }

    public void reset(View view) //RESET Button   //2015.05.05
    {

    }

    public void ok(View view) //OK Button   //2015.05.05
    {
        Intent data = new Intent();
        data.putExtra("order", getData().toString()); //丟入額外的值給下個Activity   //參數值為數索引值及JSON字串

        setResult(RESULT_OK, data);
        finish();
    }

    private JSONArray getData()   //2015.05.01
    {
        int[] id = {R.id.black_tea_l, R.id.black_tea_m};


        String blackTeaL = ((Button)findViewById(R.id.black_tea_l)).getText().toString();
        String blackTeaM = ((Button)findViewById(R.id.black_tea_m)).getText().toString();
        String milkTeaL = ((Button)findViewById(R.id.milk_tea_l)).getText().toString();
        String milkTeaM = ((Button)findViewById(R.id.milk_tea_m)).getText().toString();

        try
        {
            JSONObject blackTea = new JSONObject();
            blackTea.put("name", "black-tea");
            blackTea.put("l", Integer.parseInt(blackTeaL));
            blackTea.put("m", Integer.parseInt(blackTeaM));

            JSONObject milkTea = new JSONObject();
            milkTea.put("name", "milk-tea");
            milkTea.put("l", Integer.parseInt(milkTeaL));
            milkTea.put("m", Integer.parseInt(milkTeaM));

            JSONArray order = new JSONArray();
            order.put(blackTea);
            order.put(milkTea);

            Log.d("debug", order.toString());

            return order;


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_order, menu);
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
}
