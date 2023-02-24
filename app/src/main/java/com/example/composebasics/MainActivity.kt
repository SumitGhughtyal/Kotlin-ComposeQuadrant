package com.example.composebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composebasics.ui.theme.ComposeBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ComposeQuadrantApp()
                }
            }
        }
    }
}

@Composable
fun ComposeQuadrantApp(){
    Column(Modifier.fillMaxWidth()){
        Row(Modifier.weight(1f)){
            ComposeCard(Title = stringResource(R.string.title1), Info = stringResource(R.string.info1), backgroundColor = Color.Green, modifier = Modifier.weight(1f))
            ComposeCard(Title = stringResource(R.string.title2), Info = stringResource(R.string.info2), backgroundColor = Color.Yellow, modifier = Modifier.weight(1f))
        }
        Row(Modifier.weight(1f)){
            ComposeCard(Title = stringResource(R.string.title3), Info = stringResource(R.string.info3), backgroundColor = Color.Cyan, modifier = Modifier.weight(1f))
            ComposeCard(Title = stringResource(R.string.title4), Info = stringResource(R.string.info4), backgroundColor = Color.LightGray, modifier = Modifier.weight(1f))

        }

    }

}

@Composable
private fun ComposeCard(
    Title : String,
    Info : String,
    backgroundColor : Color,
    modifier : Modifier = Modifier
){
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ){
        Text(
            text = Title,
            fontWeight = FontWeight.Bold,
            modifier = modifier.padding(16.dp)

        )
        Text(
            text = Info,
            textAlign = TextAlign.Justify
        )

    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeBasicsTheme {
        ComposeQuadrantApp()
    }
}