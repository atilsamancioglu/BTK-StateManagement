package com.atilsamancioglu.statemanagementcompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.atilsamancioglu.statemanagementcompose.ui.theme.StateManagementComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StateManagementComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        MainScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun MainScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var kullaniciGirdisi = remember { mutableStateOf("") }
        var textDegeri = remember { mutableStateOf("Merhaba Android")}
        var paddingDegeri = remember {mutableStateOf(10.dp)}

        TextField(value = kullaniciGirdisi.value, onValueChange = {
            kullaniciGirdisi.value = it
        }, placeholder = {
            Text("Yaşınızı giriniz!")
        })

        Spacer(modifier = Modifier.padding(paddingDegeri.value))
        Text(text = textDegeri.value)
        Spacer(modifier = Modifier.padding(paddingDegeri.value))
        Button(onClick = {
            textDegeri.value = "Merhaba Atil"
            paddingDegeri.value = 20.dp
        }, enabled = true) {
            Text("Örnek Button")
        }
        Spacer(modifier = Modifier.padding(paddingDegeri.value))
        Image(bitmap = ImageBitmap.imageResource(id = R.drawable.istanbul),
            contentDescription = "Istanbul",
            modifier = Modifier.size(350.dp, 220.dp)
            )
        Spacer(modifier = Modifier.padding(paddingDegeri.value))
        Image(imageVector = ImageVector.vectorResource(id = R.drawable.ic_launcher_background),
            contentDescription = "test")
        Spacer(modifier = Modifier.padding(paddingDegeri.value))
        Image(painter = ColorPainter(Color.Black),
            contentDescription = "black",
            modifier = Modifier.size(100.dp,100.dp)
            )

    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StateManagementComposeTheme {
        MainScreen()
    }
}