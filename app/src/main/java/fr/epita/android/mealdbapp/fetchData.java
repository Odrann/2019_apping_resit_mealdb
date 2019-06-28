package fr.epita.android.mealdbapp;

import android.os.AsyncTask;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class fetchData extends AsyncTask<Void, Void, String> {
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }


    @Override
    protected String doInBackground(Void... voids) {
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        // Will contain the raw JSON response as a string.
        String forecastJsonStr = null;

        try {

            URL url = new URL("https://www.themealdb.com/api/json/v1/1/categories.php");
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            int lengthOfFile = urlConnection.getContentLength();
            // Read the input stream into a String
            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();
            if (inputStream == null) {
                return null;
            }
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line + "\n");
            }

            if (buffer.length() == 0) {
                return null;
            }
            forecastJsonStr = buffer.toString();
            Log.e("Json1", forecastJsonStr);

            JSONArray jsonArray = new JSONArray(forecastJsonStr);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Categorie cat = new Categorie();
                cat.setId(jsonObject.getString("idCategory"));
                cat.setCategoryName(jsonObject.getString("strCategory"));
                cat.setCategoryThumb(jsonObject.getString("strCategoryThumb"));
                cat.setCategoryDesc(jsonObject.getString("strCategoryDescription"));
                Categorie.listCat.add(cat);
            }

            return forecastJsonStr;
        } catch (IOException e) {
            Log.e("PlaceholderFragment", "Error ", e);
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (final IOException e) {
                    Log.e("PlaceholderFragment", "Error closing stream", e);
                }
            }
        }
        return forecastJsonStr;
    }

}

