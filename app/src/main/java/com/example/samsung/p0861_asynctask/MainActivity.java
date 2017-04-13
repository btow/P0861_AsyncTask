package com.example.samsung.p0861_asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    TextView tvInfo;

    class MyTask extends AsyncTask<Void, Void, Void> {

        protected void onPreExecute() {
            super.onPreExecute();
            tvInfo.setText(R.string.begin);
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            tvInfo.setText(R.string.end);
        }
    }

    MyTask myTask;

    public void onClickButton(View view) {
        myTask = new MyTask();
        myTask.execute();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = (TextView) findViewById(R.id.tvInfo);
    }
}
