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
import com.teeth.app.model.Login;
import com.teeth.app.model.User;
import com.teeth.app.service.TeethService;
import retrofit.RetrofitError;
import com.teeth.app.restClient.RestClient;
import retrofit.client.Response;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        Button button = (Button)findViewById(R.id.submit);
        button.setOnClickListener(mLoginListener);




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
//        String username;

        @Override
        protected String doInBackground(Void... params) {

            User  user = buildUserFromRegisterPage();
            try {
                Response r = getTeethService().register(user);
                String o;
//                username = r.
            } catch (RetrofitError e) {
                System.out.print(e.getMessage());
            }
            return "ok";
        }
        protected void onPostExecute(String results) {
            setContentView(R.layout.login_layout);
//            username + " successfully registered.";
        }

    }

    private User buildUserFromRegisterPage() {
        /*
        email
        firstName
        lastName
        password
        mobile
         */

        EditText email = (EditText)findViewById(R.id.email);
        String _email =  email.getText().toString();

        EditText firstName = (EditText)findViewById(R.id.firstName);
        String _firstName =  firstName.getText().toString();

        EditText lastName = (EditText)findViewById(R.id.lastName);
        String _lastName =  lastName.getText().toString();

        EditText password = (EditText)findViewById(R.id.password);
        String _password =  password.getText().toString();

        EditText mobile = (EditText)findViewById(R.id.mobile);
        String _mobile =  mobile.getText().toString();

        User user = new User( _email, _mobile, _firstName, _lastName, _password);
        return  user;
    }

    private View.OnClickListener mLoginListener = new View.OnClickListener() {

        public void onClick(View v) {

            new LongRunningGetIO().execute();

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
