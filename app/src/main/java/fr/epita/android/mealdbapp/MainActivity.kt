package fr.epita.android.mealdbapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import fr.epita.android.mealdbapp.R.id.list
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    var list: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

/*
        list=findViewById(R.id.list);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                int position, long id) {
                Toast.makeText(MainActivity.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();
            }
        });
    }
    }*/
    }
}
