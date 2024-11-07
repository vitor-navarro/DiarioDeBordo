package com.example.diariodebordo.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.diariodebordo.R
import com.google.android.gms.location.LocationServices

class RouteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_route)
        val client = LocationServices.getFusedLocationProviderClient(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        /*
        //Serviço de localização
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }

        client.getLastLocation().addOnSuccessListener {
            location ->
            if (location != null){
                val latitude = location.latitude
                val longitude = location.longitude

                val builder = AlertDialog.Builder(this)
                builder.setTitle("Localização")
                builder.setMessage(String.format("Latitude: $latitude, Longitude: $longitude"))
                builder.show()
            }

            }
            .addOnFailureListener() {

            }

        //LocationRequest.
        */

        val plateEditText: EditText = findViewById(R.id.vehiclePlateEditText)
        val startKilometerEditText: EditText = findViewById(R.id.startKilometerEditText)
        val endKilometerEditText: EditText = findViewById(R.id.endKilometerEditText)
        val routeButton: Button = findViewById(R.id.btnRoute)

        routeButton.setOnClickListener {
            if (routeButton.text == "Iniciar novo Trajeto") {
                val plateText = plateEditText.text.toString().trim()
                val startKilometerText = startKilometerEditText.text.toString().trim()

                if (plateText.isNotEmpty() && startKilometerText.isNotEmpty()) {
                    routeButton.text = "Finalizar Trajeto"

                    plateEditText.isEnabled = false
                    startKilometerEditText.isEnabled = false
                    endKilometerEditText.isEnabled = true
                } else {
                    Toast.makeText(this, "Por favor, preencha os campos Placa e Quilometragem Inicial.", Toast.LENGTH_SHORT).show()
                }
            } else {
                val startKilometer = startKilometerEditText.text.toString().toIntOrNull()
                val endKilometer = endKilometerEditText.text.toString().toIntOrNull()

                if (endKilometer != null && startKilometer != null && endKilometer > startKilometer) {
                    // Finaliza o trajeto e retorna à SummaryActivity
                    val intent = Intent(this, SummaryActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "A quilometragem final deve ser maior que a inicial.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}