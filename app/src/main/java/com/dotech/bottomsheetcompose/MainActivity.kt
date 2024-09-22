package com.dotech.bottomsheetcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.dotech.bottomsheetcompose.ui.theme.BottomSheetComposeTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            BottomSheetComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Content(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Content(modifier: Modifier = Modifier) {
    val sheetState = rememberModalBottomSheetState()
    var isSheetOpened by rememberSaveable {
        mutableStateOf(false)
    }

    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button({
            isSheetOpened = true
        }) {
            Text("Open Sheet")
        }
    }

    if (isSheetOpened){
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = {isSheetOpened = false}
        ) {
            Image(
                painter = painterResource(R.drawable.save_palestine_2016),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BottomSheetComposeTheme {
        Content()
    }
}