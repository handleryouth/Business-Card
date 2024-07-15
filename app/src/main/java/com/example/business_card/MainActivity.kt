package com.example.business_card

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.business_card.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),     contentWindowInsets = WindowInsets(0.dp, 0.dp, 0.dp, 0.dp)) { innerPadding ->
                    BusinessCard(
                        modifier = Modifier
                            .padding(innerPadding)
                            .background(
                                color = colorResource(id = R.color.light_green)
                            )
                    )
                }
            }
        }
    }
}

@Composable
private fun MainTitle(modifier: Modifier = Modifier) {
    val colorResource = colorResource(id = R.color.dark_cyan)
    val resourceImage = painterResource(id = R.drawable.android_logo)

    Column(modifier = modifier.fillMaxSize(),  horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Image(modifier = modifier
            .width(200.dp)
            .height(200.dp)
            .background(color = colorResource), painter = resourceImage, contentDescription =  "Android")

        Text(text = stringResource(R.string.person_name), fontWeight = FontWeight.Bold, fontSize = 35.sp, modifier = Modifier.padding(20.dp), color = Color.Black)

        Text(text = stringResource(R.string.person_description), color = Color.Black)
    }
}

@Composable
private fun Contact(modifier: Modifier = Modifier) {
    val emailIcon = ImageVector.vectorResource(id = R.drawable.email_icon)
    val shareIcon = ImageVector.vectorResource(id = R.drawable.share)
    val phoneIcon  = ImageVector.vectorResource(id = R.drawable.phone)
    val iconModifierStyle = Modifier
        .width(30.dp)
        .height(30.dp)

    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(15.dp)) {
        IconWithText(modifier = iconModifierStyle, imageVector = phoneIcon, contentDescription = stringResource(
            R.string.person_number
        ) )
        IconWithText(modifier = iconModifierStyle, imageVector = shareIcon, contentDescription = stringResource(
            R.string.person_tag
        ) )
        IconWithText(modifier = iconModifierStyle, imageVector = emailIcon, contentDescription = stringResource(
            R.string.person_email
        )
        )
    }
}

@Composable
private fun IconWithText(modifier: Modifier = Modifier, imageVector: ImageVector, contentDescription: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(modifier = modifier, imageVector = imageVector, contentDescription = "Icon", tint = Color.Black)
        Spacer(modifier = Modifier.width(15.dp))
        Text(text = contentDescription, color = Color.Black)
    }
}




@Composable
private fun BusinessCard(modifier: Modifier = Modifier) {
    Box(modifier = modifier
        .fillMaxSize()
        .navigationBarsPadding()){
        MainTitle(modifier)
        Contact(modifier = modifier.align(Alignment.BottomCenter))

    }
}


