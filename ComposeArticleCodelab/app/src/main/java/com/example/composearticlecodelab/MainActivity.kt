package com.example.composearticlecodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticlecodelab.ui.theme.ComposeArticleCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleCodelabTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HeaderImage()
                }
            }
        }
    }
}

@Composable
fun HeaderImage() {
    Column() {
        Box {
            // practice adding an image
            // had to look back b/c got to R.drawable
            // but forgot how to do it
            val headerImage = painterResource(id = R.drawable.bg_compose_background)
            Image(
                painter = headerImage,
                contentDescription = null,
                modifier = Modifier
                    .wrapContentWidth(Alignment.CenterHorizontally)
            )
        }
        Box {
            ArticleText()
        }
    }
}

@Composable
fun ArticleText() {
    val titleText = stringResource(id = R.string.title_text)
    val introText = stringResource(id = R.string.intro_text)
    val bodyText = stringResource(id = R.string.body_text)
    Column() {
        Text(
            text = titleText,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp)
                .wrapContentWidth(Alignment.CenterHorizontally)
        )
        Text(
            text = introText,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
        )
        Text(
            text = bodyText,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    ComposeArticleCodelabTheme {
        HeaderImage()
    }
}