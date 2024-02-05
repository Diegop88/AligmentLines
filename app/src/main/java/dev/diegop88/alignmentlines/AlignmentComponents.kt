package dev.diegop88.alignmentlines

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextLayoutResult
import dev.diegop88.alignmentlines.alignment.createCenterAlignmentLine

@Composable
fun TextToAlign(
    modifier: Modifier = Modifier,
    lineIndexToCenter: Int = 0
) {
    var topPosition by remember { mutableFloatStateOf(0f) }
    var bottomPosition by remember { mutableFloatStateOf(0f) }
    Text(
        modifier = modifier.createCenterAlignmentLine(topPosition, bottomPosition),
        text = "Very long long long long long text",
        style = MaterialTheme.typography.displayLarge,
        onTextLayout = { textLayout: TextLayoutResult ->
            topPosition = textLayout.getLineTop(lineIndexToCenter)
            bottomPosition = textLayout.getLineBottom(lineIndexToCenter)
        }
    )
}

@Composable
fun IconToAlign(
    modifier: Modifier = Modifier,
) {
    Icon(
        modifier = modifier.createCenterAlignmentLine(),
        painter = painterResource(id = R.drawable.cookie),
        contentDescription = "cookie"
    )
}
