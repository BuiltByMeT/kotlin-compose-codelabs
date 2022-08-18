package com.example.composequadrants

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrants.ui.theme.ComposeQuadrantsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BuildQuadrants()
                }
            }
        }
    }
}

// have to include Modifier.weight in BuildSquare() b/c
// it needs to be nested inside of a Column{Row{}}
// but having a tough time getting it to work
@Composable
fun BuildQuadrants() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.weight(1f)) {
            BuildSquare(
                fillColor = Color.Green,
                headerText = stringResource(id = R.string.header_text_green),
                bodyText = stringResource(id = R.string.body_text_green),
                modifier = Modifier.weight(1f)
            )
            BuildSquare(
                fillColor = Color.Yellow,
                headerText = stringResource(id = R.string.header_text_yellow),
                bodyText = stringResource(id = R.string.body_text_yellow),
                modifier = Modifier.weight(1f)
            )
        }
        Row(modifier = Modifier.weight(1f)) {
            BuildSquare(
                fillColor = Color.Cyan,
                headerText = stringResource(id = R.string.header_text_cyan),
                bodyText = stringResource(id = R.string.body_text_cyan),
                modifier = Modifier.weight(1f)
            )
            BuildSquare(
                fillColor = Color.LightGray,
                headerText = stringResource(id = R.string.header_text_light_gray),
                bodyText = stringResource(id = R.string.body_text_light_gray),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

// says modifier (parameter) is unused
// but how would I reference it if I'm using another modifier
// it won't let me change b/c Modifier parameter has to be
// named modifier
@Composable
fun BuildSquare(fillColor: Color, headerText: String, bodyText: String, modifier: Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(fillColor)
    ) {
        Text(
            text = headerText,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(all = 16.dp)
        )
        Text(
            text = bodyText,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(all = 16.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    ComposeQuadrantsTheme {
        BuildQuadrants()
    }
}