package com.teeth.app;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.teeth.app.model.User;
import com.teeth.app.service.TeethService;
import retrofit.RetrofitError;
import com.teeth.app.restClient.RestClient;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        new LongRunningGetIO().execute();
        setContentView(R.layout.login_layout);


        Button button = (Button)findViewById(R.id.logIn);
        button.setOnClickListener(mLoginListener);

//        loginButton.onclick

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

            User user = new User();
            try {

                TeethService teethService= getTeethService();
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

    private View.OnClickListener mLoginListener = new View.OnClickListener() {

        public void onClick(View v) {

            String username = getUserName();
            String password = getPassword();
            User user = new User(username, password);
            getTeethService().register(user);

        }
    };

    @NonNull
    private String getUserName() {
        EditText username = (EditText)findViewById(R.id.username);
        return username.getText().toString();
    }

    @NonNull
    private String getPassword() {
        EditText password = (EditText)findViewById(R.id.password);
        return password.getText().toString();
    }

    private TeethService getTeethService() {
        return new RestClient().getTeethService();
    }

}
