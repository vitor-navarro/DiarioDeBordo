package com.example.diariodebordo

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val loginButton: Button = findViewById(R.id.loginButton)

        loginButton.setOnClickListener{
            val intent = Intent(this, SummaryActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume();
        val errorCode = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this)
        //Switch case no kotlin
        when(errorCode){
            ConnectionResult.SERVICE_MISSING -> Log.d("SERVICE_MISSING", "SERVICE_MISSING")
            ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED -> Log.d("SERVICE_VERSION_UPDATE_REQUIRED", "SERVICE_VERSION_UPDATE_REQUIRED")
            ConnectionResult.SERVICE_DISABLED -> {
                GoogleApiAvailability.getInstance().getErrorDialog(this, errorCode, 0) {
                    finish()
                }?.show()
            }

            ConnectionResult.SUCCESS -> Log.d("SUCCESS", "SUCCESS")
        }

    }


}