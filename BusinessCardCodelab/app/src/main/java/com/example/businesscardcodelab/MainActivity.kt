package com.example.businesscardcodelab

import android.graphics.drawable.PaintDrawable
import android.graphics.drawable.shapes.OvalShape
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardcodelab.ui.theme.BusinessCardCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardCodelabTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(
        // background
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF073042))
    ) {
        // profile picture, name, title
        Spacer(
            modifier = Modifier
                //.height(250.dp)
                .weight(1f)
        )
        ProfileInfo()
        Spacer(
            modifier = Modifier
                .weight(1f)
        )
        ContactInfo()
        // contact info
    }
}

@Composable
fun ProfileInfo() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 200.dp)
    ) {
        val profilePicture = painterResource(id = R.drawable.android_logo)
        var profileName = stringResource(id = R.string.profile_name)
        var profileProfession = stringResource(id = R.string.profile_profession)
        Image(
            painter = profilePicture,
            contentDescription = "profile picture",
            modifier = Modifier
                //    .border(20.dp, Color.Black, RoundedCornerShape(300.dp))
                .size(100.dp)
                .wrapContentWidth(Alignment.CenterHorizontally)
                .wrapContentHeight(Alignment.CenterVertically)
        )
        Text(
            text = profileName,
            color = Color.White,
            fontSize = 50.sp
        )
        Text(
            text = profileProfession,
            color = Color(0xFF0BDF16),
            fontSize = 20.sp
        )
    }
}

@Composable
fun ContactInfo() {
    //
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    BusinessCardCodelabTheme {
        BusinessCard()
    }
}