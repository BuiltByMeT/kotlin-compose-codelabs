package com.example.businesscardcodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
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
            .background(Color(0xFF073042))
    ) {
        // profile picture, name, title
        Spacer(
            modifier = Modifier
                .weight(5f)
        )
        ProfileInfo(modifier = Modifier.weight(4f))
        Spacer(Modifier.weight(3f))
        ContactInfo(Modifier.weight(4f))
    }
}

@Composable
fun ProfileInfo(modifier: Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
    ) {
        val profilePicture = painterResource(id = R.drawable.android_logo)
        val profileName = stringResource(id = R.string.profile_name)
        val profileProfession = stringResource(id = R.string.profile_profession)
        Image(
            painter = profilePicture,
            contentDescription = stringResource(id = R.string.profile_picture_description),
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
fun ContactInfo(modifier: Modifier) {
    val contactPhoneNumber = stringResource(id = R.string.contact_phone)
    val contactShareLink = stringResource(id = R.string.contact_github_profile)
    val contactEmail = stringResource(id = R.string.contact_email)
    val icons = Icons.Rounded
    var contactIconDescription = stringResource(id = R.string.contact_phone_icon_description)
    var contactString = contactPhoneNumber
    Column(modifier) {
        ContactRow(icons.Phone, contactIconDescription, contactString)
        contactIconDescription = stringResource(id = R.string.contact_share_icon_description)
        contactString = contactShareLink
        ContactRow(icons.Share, contactIconDescription, contactString)
        contactIconDescription = stringResource(id = R.string.contact_email_icon_description)
        contactString = contactEmail
        ContactRow(icons.Email, contactIconDescription, contactString)
    }
}

@Composable
fun ContactRow(
    contactIcon: ImageVector,
    contactIconDescription: String,
    contactString: String
) {
    Spacer(
        modifier = Modifier
            .padding(start = 0.dp)
            .fillMaxWidth()
            .size(1.dp)
            .background(Color(0xF0456174))
    )
    Row(
        modifier = Modifier
            .padding(start = 50.dp, top = 10.dp, bottom = 10.dp)
    ) {
        Icon(
            contactIcon,
            contentDescription = contactIconDescription,
            tint = Color(0xFF0BDF16)
        )
        Text(
            text = contactString,
            color = Color.White,
            modifier = Modifier
                .padding(start = 50.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    BusinessCardCodelabTheme {
        BusinessCard()
    }
}