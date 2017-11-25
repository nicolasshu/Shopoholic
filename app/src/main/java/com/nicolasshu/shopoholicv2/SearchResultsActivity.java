package com.nicolasshu.shopoholicv2;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.semantics3.api.Products;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;

import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

/**
 * Created by nickshu on 11/18/17.
 */

public class SearchResultsActivity extends AppCompatActivity {

    String API_KEY = "SEM3A075208FC5BB06CD0CE968141F695FE4";
    String API_SECRET = "ZjU1ZjdkZTI3NzFiMzgxMzdhZDAzYWQ1NmQyYmE4OTM";
    Products products = new Products(API_KEY,API_SECRET);

    /**
     * onCreate(Bundle savedInstanceState)
     * This is the function that is loaded up as soon as this activity starts.
     * It runs the constructor, and then in line 38, it uses the
     *      activity_searchresults.xml
     * as the layout for this activity.
     *
     * And then it runs the updateView() defined below...
     */
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchresults);
        updateView();
    }

    /**
     * goBack(View v)
     * This is just the function to run when you want to go back to the previous screen.
     * It just run .finish() when you press the "BACK" button
     */
    public void goBack(View v) {
        this.finish();
    }

    /**
     * updateView()
     * This should be the juicy part of the operation.
     * The first 4 lines don't do anything interesting. They simply pick up the searchQuery
     * that was entered in the previous screen, and then places them on a TextView.
     *
     * In line 70 is when I try accessing the API.
     * I request it to search for the term "iPhone" (line 70), and then I try
     * to pull out the results from it in the try-block. However I found out that
     * it runs into a NetworkOnMainThreadException and then it crashes
     */
    public void updateView()  {
        ItemNum_class itemnum_msg = MainActivity.itemNum_msg;
        TextView searchQuery = (TextView) findViewById(R.id.results_searchQuery);
        String newQuery = itemnum_msg.getSearchQuery();
        searchQuery.setText(newQuery);

        AccessData goal = new AccessData();
        String query = "iphone";
        System.out.println("Ready to try to execute goal");
        goal.execute(query);

    }

    public class AccessData extends AsyncTask<String,String,String> {

        @Override
        protected String doInBackground(String... strings) {
            products.productsField("search",strings[0]);
            try {
                System.out.println("Try Block =======================");
                JSONObject results = products.getProducts();
                System.out.println("Declared JSONObject");
                System.out.println(results);
                System.out.println("End of Try Block______________________");
            }
            catch (NetworkOnMainThreadException e){
                System.out.println("---------NetworkOnMainThreadException happened---------");
                System.out.println(e);
            }
            catch(Exception e){
                System.out.println("---------Exception happened---------");
                System.out.println(e);
            }
            return "end of doInBackground";
        }
        @Override
        protected void onPostExecute(String result) {
            // execution of result of Long time consuming operation
            //progressDialog.dismiss();
            //finalResult.setText(result);
            System.out.println("onPostExecute Started *****************");
        }
        @Override
        protected void onPreExecute() {
            //progressDialog = ProgressDialog.show(MainActivity.this,
            //        "ProgressDialog",
            //        "Wait for "+time.getText().toString()+ " seconds");
            System.out.println("onPreExecute Started! *************************");
        }
        @Override
        protected void onProgressUpdate(String... text) {
            //finalResult.setText(text[0]);
            System.out.println("onProgressUpdate Started! ********************** ");
        }
    }
}
