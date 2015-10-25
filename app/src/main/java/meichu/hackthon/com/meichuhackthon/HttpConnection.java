package meichu.hackthon.com.meichuhackthon;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by User on 2015/10/24.
 */
public class HttpConnection {

    static public final String TEST_FB_ID = "s1406465726045286";
    static public final String DEFAULT_DB = "http://sqltesttttt.azurewebsites.net/sql_adapter.php";

//    private void testNew()
//    {
//        Map<String, String> params = new HashMap<String, String>();
//        params.put("facebookID", HttpConnection.TEST_FB_ID);
//
//        HttpConnection.sendPostRequest(HttpConnection.DEFAULT_DB, params, "UTF-8", new HttpConnection.Callback() {
//            @Override
//            public void handle(String response) {
//                // do something
//            }
//        });
//    }

    private static String getRequestData(Map<String, String> params, String encode)
    {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            for(Map.Entry<String, String> entry : params.entrySet()) {
                stringBuffer.append(entry.getKey())
                        .append("=")
                        .append(URLEncoder.encode(entry.getValue(), encode))
                        .append("&");
            }
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }

    public static void sendPostRequest(final String targetURL, final Map<String, String> params,
                                       final String encode, final Callback callback)
    {
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... args) {

                URL url;
                HttpURLConnection connection = null;
                try {
                    //Create connection
                    String urlParameters = getRequestData(params, encode);
                    url = new URL(targetURL);

                    connection = (HttpURLConnection)url.openConnection();
                    connection.setRequestMethod("POST");
                    connection.setRequestProperty("Content-Type",
                            "application/x-www-form-urlencoded");
                    connection.setRequestProperty("Content-Length", "" +
                            Integer.toString(urlParameters.getBytes().length));
                    connection.setRequestProperty("Content-Language", "UTF-8");

                    connection.setUseCaches (false);
                    connection.setDoInput(true);
                    connection.setDoOutput(true);

                    //Send request
                    DataOutputStream wr = new DataOutputStream (
                            connection.getOutputStream ());
                    wr.writeBytes(urlParameters);
                    wr.flush();
                    wr.close();

                    //Get Response
                    InputStream is = connection.getInputStream();
                    BufferedReader rd = new BufferedReader(new InputStreamReader(is));
                    String line;
                    StringBuffer response = new StringBuffer();
                    while((line = rd.readLine()) != null) {
                        response.append(line);
                        response.append('\r');
                    }
                    rd.close();
                    callback.handle(response.toString());

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if(connection != null) {
                        connection.disconnect();
                    }
                }
                return null;
            }
        }.execute();
    }

    public interface Callback{
        public void handle(String response);
    }

}
