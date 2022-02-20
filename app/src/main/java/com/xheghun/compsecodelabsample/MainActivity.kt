package com.xheghun.compsecodelabsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.xheghun.compsecodelabsample.ui.theme.CompseCodelabSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompseCodelabSampleTheme {
              MyApp()
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    val expanded = remember { mutableStateOf(false) }
    Surface(color = MaterialTheme.colors.primary, modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(modifier = Modifier.weight(1f)) {
                Text("Hello,")
                Text(name)
                if(expanded.value)
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp))
            }
            OutlinedButton(onClick = { expanded.value = !expanded.value }) {
                Text(if (expanded.value) "Show less" else "Show more")
            }
        }
    }
}

@Composable
fun Greetings(names: List<String> = listOf("World", "Compose")) {
    Column(modifier = Modifier.padding(vertical = 5.dp)) {
        for (name in names) {
            Greeting(name = name)
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    CompseCodelabSampleTheme {
       MyApp()
    }
}


@Composable
fun OnboardingScreen(onContinueClicked: () -> Unit) {
    Surface {
        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Welcome to the Basics Codelab!")
            Button(
                modifier = Modifier.padding(vertical = 24.dp),
                onClick = onContinueClicked
            ) {
                Text("Continue")
            }
        }
    }
}



@Preview(showBackground = true, widthDp = 320,  heightDp = 320)
@Composable
fun OnboardingPreview() {
    CompseCodelabSampleTheme {
        OnboardingScreen(onContinueClicked = {})
    }
}

@Composable
private fun MyApp() {
    var shouldShowOnboarding by remember { mutableStateOf(true)}

    if (shouldShowOnboarding) {
        OnboardingScreen(onContinueClicked = { shouldShowOnboarding = false })
    } else {
        Greetings()
    }

}