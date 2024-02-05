package dev.diegop88.alignmentlines.alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.layout.layout

val CenterAlignmentLine = HorizontalAlignmentLine { old, new -> new }

fun Modifier.createCenterAlignmentLine() = this.then(layout { measurable, constraints ->
    val placeable = measurable.measure(constraints)
    val centerPoint = placeable.height / 2
    layout(
        placeable.width,
        placeable.height,
        alignmentLines = mapOf(CenterAlignmentLine to centerPoint)
    ) {
        placeable.placeRelative(0, 0)
    }
})

fun Modifier.createCenterAlignmentLine(
    topPosition: Float,
    bottomPosition: Float,
) = this.then(layout { measurable, constraints ->
    val placeable = measurable.measure(constraints)
    val centerPoint = topPosition + ((bottomPosition - topPosition) / 2)
    layout(
        placeable.width,
        placeable.height,
        alignmentLines = mapOf(CenterAlignmentLine to centerPoint.toInt())
    ) {
        placeable.placeRelative(0, 0)
    }
})
