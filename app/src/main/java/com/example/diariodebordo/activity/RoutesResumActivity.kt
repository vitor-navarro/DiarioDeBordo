package com.example.diariodebordo.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.diariodebordo.R
import com.example.diariodebordo.data.database.AppDatabase
import com.example.diariodebordo.data.database.DatabaseSingleton
import com.example.diariodebordo.data.database.entity.Route
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RoutesResumActivity : AppCompatActivity() {

    private lateinit var database: AppDatabase
    private lateinit var routeRecyclerView: RecyclerView
    private lateinit var routeAdapter: RouteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_routes_resum)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inicializando a instância do banco de dados
        database = DatabaseSingleton.getDatabase(this)

        // Inicializando o RecyclerView
        routeRecyclerView = findViewById(R.id.routesRecyclerView)
        routeRecyclerView.layoutManager = LinearLayoutManager(this)

        // Carregar as rotas da base de dados
        loadRoutes()
    }

    private fun loadRoutes() {
        GlobalScope.launch(Dispatchers.IO) {
            // Recupera todas as rotas do banco de dados
            val routes = database.routeDao().getAllRoutes()

            // Atualiza o RecyclerView na thread principal
            launch(Dispatchers.Main) {
                routeAdapter = RouteAdapter(routes)
                routeRecyclerView.adapter = routeAdapter
            }
        }
    }
}
