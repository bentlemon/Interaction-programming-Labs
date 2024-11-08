package com.example.lab12kotlincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.Image
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab12kotlincompose.ui.theme.Lab12KotlinComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab12KotlinComposeTheme {
                Scaffold( // Fixes the layout
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopBar()
                    }
                ) { paddingValues ->
                    BasicLayout(modifier = Modifier.padding(paddingValues))
                }
            }
        }
    }
}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(MaterialTheme.colorScheme.primary),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        // Title on top bar
        Text(
            text = "Lab1.2: Kotlin + Compose",
            style = TextStyle(
                color = MaterialTheme.colorScheme.onPrimary,
                fontWeight = FontWeight.Medium,
                fontSize = MaterialTheme.typography.titleLarge.fontSize
            ),
            modifier = Modifier.padding(start = 16.dp) // Space between leftside and title text
        )
    }
}

@Composable
fun BasicLayout(modifier: Modifier = Modifier) {
    var textState by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Bild mellan TopBar och TextField
        Image(
            painter = painterResource(id = R.drawable.avatar_img), // Bildresurs
            contentDescription = "Example Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(bottom = 16.dp) // Padding under bilden
        )

        // Rad för text och inputfält
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically, // Centrerar text och textfield vertikalt
            horizontalArrangement = Arrangement.spacedBy(8.dp) // Mellanrum mellan elementen
        ) {
            // Text som beskriver inputfältet
            Text(
                text = "Email",
                style = MaterialTheme.typography.bodyLarge,
            )

            // TextField som användaren kan interagera med
            TextField(
                value = textState,
                onValueChange = { textState = it },
                modifier = Modifier
                    .weight(1f) // Låter TextField ta upp allt tillgängligt utrymme
                    .padding(top = 16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainActivityPreview() {
    Lab12KotlinComposeTheme {
        Scaffold(
            topBar = { TopBar() }
        ) { paddingValues ->
            BasicLayout(modifier = Modifier.padding(paddingValues))
        }
    }
}
