package com.example.bmicalculatorapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bmicalculatorapp.ui.theme.BMICalculatorAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val viewModel:MainViewModel by viewModels()
        super.onCreate(savedInstanceState)
        setContent {
            BMICalculatorAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier
                            .padding(vertical = 20.dp, horizontal = 40.dp)
                            .verticalScroll(rememberScrollState())
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

                        //Height TextField
                        DetailTextField(
                            text = "Height (cm)",
                            placeholder = "170",
                            value = viewModel.height,
                            onValueChange = { viewModel.height = it })

                        //Weight TextField
                        DetailTextField(
                            text = "Weight (kg)",
                            placeholder = "65",
                            value = viewModel.weight,
                            onValueChange = { viewModel.weight = it })

                        //Calculate Button
                        Button(
                            onClick = { viewModel.calculateBMI() },
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFEE7676)),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 10.dp)
                        ) {
                            Text(
                                text = "Calculate",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }

                        //BMI Result
                        Text(
                            text = "Your BMI is ${viewModel.bmi}",
                            fontSize = 25.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Gray,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(vertical = 10.dp)
                                .fillMaxWidth()
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun DetailTextField(
    text: String,
    placeholder: String,
    value: String,
    onValueChange: (String) -> Unit,
) {
    Text(
        text = text,
        fontSize = 20.sp,
        fontWeight = FontWeight.Medium,
        color = Color(0xFFE46161),
        modifier = Modifier.padding(top = 10.dp, bottom = 5.dp)
    )
    TextField(
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        placeholder = { Text(text = placeholder) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp)
    )
}