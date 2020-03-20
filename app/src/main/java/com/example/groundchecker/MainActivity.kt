package com.example.groundchecker

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.json.JSONArray
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val url = "https://www.thesportsdb.com/api/v1/json/1/search_all_teams.php?l=English%20Premier%20League"

        AsyncTaskHandleJson().execute(url)
    }
}

class AsyncTaskHandleJson : AsyncTask<String, String, String>(){
    override fun doInBackground(vararg url: String?): String {
        var text:String

        val connection = URL(url[0]).openConnection() as HttpURLConnection
        try{
            connection.connect()
            text = connection.inputStream.use { it.reader().use{reader-> reader.readText()} }
        }finally {
            connection.disconnect()
        }

        return text
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
        handleJson(result)
    }

    private fun handleJson(jsonString: String?) {

        val jsonArray = JSONArray(jsonString)

        val list = ArrayList<Teams>()

        var x = 0

        while(x < jsonArray.length()){
            val jsonObject = jsonArray.getJSONObject(x)

            list.add(Teams(
                jsonObject.getString("strTeam"),
                jsonObject.getString("strStaduiumThumb"),
                jsonObject.getString("intFormedYear"),
                jsonObject.getString("strStadium")))

            x++
        }

        val adapter = ListAdapter(this,list)

        teams_list.adapter = adapter



    }

}




