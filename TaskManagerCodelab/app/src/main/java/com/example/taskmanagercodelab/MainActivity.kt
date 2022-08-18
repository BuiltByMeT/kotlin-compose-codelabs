package com.example.taskmanagercodelab

import android.graphics.drawable.Drawable
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanagercodelab.ui.theme.TaskManagerCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskManagerCodelabTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TaskManagerStatusCheck(status = "finished")
                }
            }
        }
    }
}

@Composable
fun TaskManagerStatusCheck(status: String) {
    var statusText: String
    var congratsText: String
    var statusImage: Painter
    if (status == "finished") {
        statusText = stringResource(id = R.string.status_finished_text)
        congratsText = stringResource(id = R.string.congrats_text)
        statusImage = painterResource(id = R.drawable.ic_task_completed)
        CompletedScreen(statusText, congratsText, statusImage)
    }
}

@Composable
fun CompletedScreen(statusText: String, congratsText: String, statusImage: Painter) {
    //val completedImage = painterResource(id = R.drawable.ic_task_completed)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .wrapContentHeight(Alignment.CenterVertically)
    ) {
        Image(
            painter = statusImage,
            contentDescription = null,
            modifier = Modifier
                .wrapContentWidth(Alignment.CenterHorizontally)
                .wrapContentHeight(Alignment.CenterVertically)
        )
        Text(
            text = statusText,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(top = 24.dp, bottom = 8.dp)
        )
        Text(
            fontSize = 16.sp,
            text = congratsText,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    TaskManagerCodelabTheme {
        TaskManagerStatusCheck("finished")
    }
}