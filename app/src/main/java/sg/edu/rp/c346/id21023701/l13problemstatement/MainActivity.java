package sg.edu.rp.c346.id21023701.l13problemstatement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
ListView lvCarpark;
AsyncHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCarpark = findViewById(R.id.lvCarpark);
        client = new AsyncHttpClient();

    }
    @Override
    protected void onResume() {
        super.onResume();

        ArrayList<Carpark> alCarpark = new ArrayList<Carpark>();

        client.get("https://api.data.gov.sg/v1/transport/carpark-availability", new JsonHttpResponseHandler() {


            String CarparkNum;
            String TotalLots;
            String LotType;
            String LotAvail;


            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                try {
                    JSONArray jsonArrItems = response.getJSONArray("items");
                    JSONObject firstObj = jsonArrItems.getJSONObject(0);
                    JSONArray jsonArrInfoData = firstObj.getJSONArray("carpark_data");
                    for(int i = 0; i < jsonArrInfoData.length(); i++) {
                        JSONObject jsonObjinfo = jsonArrInfoData.getJSONObject(i);
                        JSONArray jsonArrayInfo = (JSONArray) jsonObjinfo.get("carpark_info");
                        JSONObject dataobj = jsonArrayInfo.getJSONObject(0);

                        CarparkNum = jsonObjinfo.getString("carpark_number");
                        TotalLots = dataobj.getString("total_lots");
                        LotAvail = dataobj.getString("lots_available");
                        LotType = dataobj.getString("lot_type");

                        Carpark carpark = new Carpark(TotalLots,LotType,LotAvail,CarparkNum);
                        alCarpark.add(carpark);

                    }
                }
                catch(JSONException e){
                    Log.d("exception", e.toString());
                }
                ArrayAdapter<Carpark> aaCarpark= new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,alCarpark);
                lvCarpark.setAdapter(aaCarpark);
            }
        });
    }//end onResume
}