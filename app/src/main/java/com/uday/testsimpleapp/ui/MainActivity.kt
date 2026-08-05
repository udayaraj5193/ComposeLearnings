package com.uday.testsimpleapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.uday.testsimpleapp.ui.components.MyApp
import com.uday.testsimpleapp.ui.theme.TestSimpleAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            TestSimpleAppTheme {
                MyApp()
            }
        }
    }
}
