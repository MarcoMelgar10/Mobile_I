
package com.tuapp.MakerRouter

import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.tuapp.MakerRouter.presentation.navigation.AppNavigation
import com.tuapp.MakerRouter.ui.theme.MakerRouterTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            val ai = packageManager.getApplicationInfo(packageName, PackageManager.GET_META_DATA)
            val apiKey = ai.metaData?.getString("com.google.android.geo.API_KEY")
            Log.d("MAPS_KEY", "API_KEY meta-data = $apiKey")
        } catch (e: Exception) {
            Log.e("MAPS_KEY", "Error leyendo meta-data de API_KEY", e)
        }

        enableEdgeToEdge()
        setContent {
            MakerRouterTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
                    AppNavigation()
                }
            }
        }
    }
}
