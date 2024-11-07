package com.atilsamancioglu.statemanagementcompose

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

        var kullaniciGirdisi = "Yaşınızı Giriniz"

        TextField(value = kullaniciGirdisi, onValueChange = {
            kullaniciGirdisi = it
            println(it)
        })
        Spacer(modifier = Modifier.padding(10.dp))
        Text(text = "Merhaba Android")
        Spacer(modifier = Modifier.padding(10.dp))
        Button(onClick = {
            println("button'a tıklandı")
        }, enabled = true) {
            Text("Örnek Button")
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Image(bitmap = ImageBitmap.imageResource(id = R.drawable.istanbul),
            contentDescription = "Istanbul",
            modifier = Modifier.size(350.dp, 220.dp)
            )
        Spacer(modifier = Modifier.padding(10.dp))
        Image(imageVector = ImageVector.vectorResource(id = R.drawable.ic_launcher_background),
            contentDescription = "test")
        Spacer(modifier = Modifier.padding(10.dp))
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