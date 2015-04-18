package com.teeth.app;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import com.teeth.app.model.User;
import com.teeth.app.service.TeethService;
import retrofit.RetrofitError;
import com.teeth.app.restClient.RestClient;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new LongRunningGetIO().execute();
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

    private class LongRunningGetIO extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            RestClient restClient = new RestClient();

            User user = new User();
            try {

                TeethService teethService= restClient.getTeethService();
//                user = teethService.getUser("tester@mailinator.com");
                user = teethService.getUser("francisoliver.malit@gmail.com");

            } catch (RetrofitError e) {
                Log.d("Got error type: {}", e.getKind().toString());
            }

            return user.toString();

        }
        protected void onPostExecute(String results) {
            if (results!=null) {
                EditText editText = (EditText)findViewById(R.id.editText);
                editText.setText(results);
            }
        }

    }
}
