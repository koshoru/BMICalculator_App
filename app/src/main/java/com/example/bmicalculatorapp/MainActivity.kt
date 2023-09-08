package com.example.bmicalculatorapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bmicalculatorapp.ui.theme.BMICalculatorAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMICalculatorAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BMICalculatorApp()
                }
            }
        }
    }
}

@Composable
fun BMICalculatorApp() {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.padding(30.dp)
    ) {

        //Title
        Text(
            text = "BMI Calculator App",
            textAlign = TextAlign.Center,
            fontSize = 35.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
        )
        Text(
            text = "Height (cm)",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xE9D66565),
            modifier = Modifier.padding(top = 10.dp, bottom = 5.dp)
        )
        TextField(
            value = "",
            onValueChange = {},
            singleLine = true,
            placeholder = { Text(text = "170") },
            colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent),
            modifier = Modifier.fillMaxWidth()
        )
    }
}