package dev.diegop88.alignmentlines

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.diegop88.alignmentlines.alignment.CenterAlignmentLine
import dev.diegop88.alignmentlines.ui.theme.AlignmentLinesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlignmentLinesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AlignLayout()
                }
            }
        }
    }
}

@Composable
fun AlignLayout() {
    Row {
        IconToAlign(modifier = Modifier.alignBy(CenterAlignmentLine))
        TextToAlign(modifier = Modifier.alignBy(CenterAlignmentLine))
    }
}

@Preview
@Composable
fun Preview_AlignLayout() {
    AlignLayout()
}
