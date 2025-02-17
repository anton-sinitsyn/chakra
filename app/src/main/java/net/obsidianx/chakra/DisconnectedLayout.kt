package net.obsidianx.chakra

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import net.obsidianx.chakra.debug.debugDump
import net.obsidianx.chakra.debug.debugTag
import net.obsidianx.chakra.modifiers.alignItems
import net.obsidianx.chakra.modifiers.fitMinContent
import net.obsidianx.chakra.modifiers.flex
import net.obsidianx.chakra.modifiers.gap
import net.obsidianx.chakra.modifiers.justifyContent
import net.obsidianx.chakra.modifiers.positionType
import net.obsidianx.chakra.types.FlexAlign
import net.obsidianx.chakra.types.FlexJustify
import net.obsidianx.chakra.types.FlexPositionType

@Composable
fun DisconnectedLayout() {
    FlexColumn(modifier = Modifier.flex {
        gap(16.dp)
        debugTag("root")
        debugDump()
    }) {
        FlexRow(modifier = Modifier.flex { /*debugDump()*/ }) {
            Text("One")
            Box {
                net.obsidianx.chakra.FlexRow(
                    modifier = Modifier.flex {
                        fitMinContent()
                        debugDump()
                    }
                ) {
                    Text(
                        "Two",
                        modifier = Modifier.flex { positionType(FlexPositionType.Absolute) })
                    Text(
                        "Three",
                        modifier = Modifier.flex { positionType(FlexPositionType.Absolute) })
                }
            }
        }

        FlexRow(
            modifier = Modifier.flex {
                alignItems(FlexAlign.Center)
                justifyContent(FlexJustify.Center)
                debugTag("zstack")
                debugDump()
                fitMinContent()
            }
        ) {
            Box(
                modifier = Modifier
                    .width(5.dp)
                    .height(100.dp)
                    .flex {
                        positionType(FlexPositionType.Absolute)
                        debugTag("tall")
                    }
                    .background(Color.Red)
            )
            Box(
                modifier = Modifier
                    .width(100.dp)
                    .height(5.dp)
                    .flex {
                        positionType(FlexPositionType.Absolute)
                        debugTag("wide")
                    }
                    .background(Color.Blue)
            )
//            Text("Centered", modifier = Modifier.flexPositionType(FlexPositionType.Absolute))
//            Text("Text", modifier = Modifier.flexPositionType(FlexPositionType.Absolute))
        }
    }
}