package meichu.hackthon.com.meichuhackthon;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.telecom.Call;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.blob.CloudBlob;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.ListBlobItem;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContentCrawler
{
    final private String storageConnectionString =
            "DefaultEndpointsProtocol=http;" +
                    "AccountName=gamekinga;" +
                    "AccountKey=D1My+WXtaaC6lhZe9E8KRV5JCVTz9JmuHNHkr0KynT1prQiSpNCSoZxk5ozx2KfAAqnLrsSJY23MJe6wSCR1fg==";

        /**
         * Define your function in callback, it will be invoked when data arraived.
         * @param facebookID
         * @param startdate
         * @param enddate
         * @param callback
         */
    public static void sendDiaryRequest(String facebookID, String startdate, String enddate, final ContentCrawler.Callback callback)
    {
        Map<String, String> params = new HashMap<String, String>();
        params.put("facebookID", facebookID);
        params.put("startdate", startdate);
        params.put("enddate", enddate);

        HttpConnection.sendPostRequest(HttpConnection.DEFAULT_DB, params, "UTF-8", new HttpConnection.Callback() {
            @Override
            public void handle(String response) {
                JsonParser jparser = new JsonParser();
                JsonArray json_array = jparser.parse(response).getAsJsonArray();
                Gson gson = new Gson();

                List<DiaryItem> diaryItems = new ArrayList<DiaryItem>();
                for(int i = 0; i < json_array.size(); i++){
                    DiaryItem ditem = gson.fromJson(json_array.get(i), DiaryItem.class);
                    diaryItems.add(ditem);
                }
                callback.handle(diaryItems);
            }
        });
    }

    public static void drawableFromUrl(final String url, final DrawableCallback callback) throws IOException {
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... params) {
                try{
                    HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                    connection.connect();
                    InputStream input = connection.getInputStream();
                    Drawable d = Drawable.createFromStream(input, url);
                    callback.handle(d);
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
    }

    public interface Callback
    {
        public void handle(List<DiaryItem> datas);
    }

    public interface DrawableCallback
    {
        public void handle(Drawable d);
    }

}
