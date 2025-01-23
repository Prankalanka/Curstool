package com.example.curstool

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.curstool.ui.theme.CurstoolTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CurstoolTheme {
                Scaffold (
                    topBar = TopAppBar()
                )
            }
        }
    }

}

data class ToggleableInfo (
    val isChecked: Boolean,
    val text: String,
)

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun ServiceSwitch() {
    // Variable switch is set using remember so that the jetpack components are recomposed when it changes
    var switch by remember { mutableStateOf(ToggleableInfo(isChecked = false, text = "Service running")) }
    Row (verticalAlignment = Alignment.CenterVertically) {
        Spacer(modifier = Modifier.weight(1f))
        Switch(
            checked = switch.isChecked,
            // Set isChecked to current value
            onCheckedChange = { isChecked: Boolean -> switch = switch.copy(isChecked = isChecked) }
        )
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CurstoolTheme {
        Greeting("Android")
    }
}