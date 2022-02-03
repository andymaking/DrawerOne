package io.king.drawerone

import android.icu.text.CaseMap
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.king.drawerone.ui.theme.DrawerOneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DrawerOneTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    Body()
                }
            }
        }
    }
}

@Composable
fun Body() {
    val scaffoldState = rememberScaffoldState()
    Scaffold (
        topBar = {
                 AppBar()
        },
        drawerContent = {
                        NavDrawer(scaffoldState = scaffoldState)
        },
        content = {
                  Greeting(name = "Android!")
        },
            )
}

@Composable
fun AppBar() {
    TopAppBar(
        title = { Text(text = "Nav Drawer Sample")}
    )
}

@Composable
fun NavDrawer(scaffoldState: ScaffoldState) {
    Column {
        Image(painter = painterResource(id = R.drawable.b), contentDescription = null, contentScale = ContentScale.FillBounds, modifier = Modifier
            .padding(32.dp)
            .height(84.dp))

        Divider()

        NavOption(title = "Home", scaffoldState = scaffoldState)
        NavOption(title = "Cart", scaffoldState = scaffoldState)
        NavOption(title = "Like", scaffoldState = scaffoldState)
        NavOption(title = "Feature", scaffoldState = scaffoldState)
        Text(text = "Reject", style = TextStyle(fontSize = 25.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center), modifier = Modifier
            .fillMaxWidth().padding(32.dp, 20.dp,32.dp)
            .clickable(onClick = {

            }))
    }
}

@Composable
fun NavOption(title: String, scaffoldState: ScaffoldState) {
    Text(text = title, style = TextStyle(fontSize = 25.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center), modifier = Modifier
        .fillMaxWidth().padding(32.dp, 20.dp,32.dp)
        .clickable(onClick = {
            scaffoldState.drawerState.isClosed
        }))
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!",modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DrawerOneTheme {
        Body()
    }
}