package com.example.prcatica9.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.ButtonDefaults
import androidx.wear.compose.material.Text
import com.example.prcatica9.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navegacion()
        }
    }
}

@Composable
fun Imagen(id: Int) {
    Image(
        painter = painterResource(id = id),
        contentDescription = "",
        modifier = Modifier
            .size(50.dp)
            .clip(CircleShape)
            .background(Color.Yellow)
            .padding(4.dp)
    )
}

@Composable
fun Pagina1(navController: NavController) {
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "1 run this week",
            color = Color.Yellow,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val ImagenId = listOf(
                R.drawable.baseline_directions_run_24,
                R.drawable.baseline_accessibility_24,
                R.drawable.baseline_directions_bike_24,
            )

            for (id in ImagenId) {
                Imagen(id)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = { /* Acción para "More" */ },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray),
                modifier = Modifier.padding(8.dp)
            ) {
                Text(
                    text = "More",
                    color = Color.Black,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(10.dp)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { navController.navigate("RutaDos") },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray)
            ) {
                Text(
                    text = "Next",
                    color = Color.Black,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(10.dp)
                )
            }
        }
    }
}

@Composable
fun Pagina2(navController: NavController) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
                .background(Color.Black)
        ) {
            Text(
                text = "Power Yoga",
                color = Color.Yellow,
                fontSize = 18.sp,
                modifier = Modifier.padding(top = 20.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = { navController.popBackStack() },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow),
                modifier = Modifier
                    .width(130.dp)
                    .clip(CircleShape)
                    .padding(10.dp)
            ) {
                Text(
                    text = "Go back",
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Last session 45m",
                color = Color.Yellow,
                fontSize = 16.sp,
                modifier = Modifier.padding(bottom = 20.dp)
            )
        }
    }
}

@Composable
fun Navegacion() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "RutaUno") {
        composable("RutaUno") { Pagina1(navController) }
        composable("RutaDos") { Pagina2(navController) }
    }
}

@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true)
@Composable
fun DefaultPreview() {
    Navegacion()
}
