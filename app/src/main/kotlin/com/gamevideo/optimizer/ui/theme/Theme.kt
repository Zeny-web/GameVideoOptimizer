package com.gamevideo.optimizer

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AutoFixHigh
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.ColorLens
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.HighQuality
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.VideoLibrary
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gamevideo.optimizer.ui.theme.GameVideoOptimizerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GameVideoOptimizerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun HomeScreen() {
    val scrollState = rememberScrollState()
    var selectedVideoUri by remember { mutableStateOf<Uri?>(null) }
    var resolution by remember { mutableIntStateOf(1080) }
    var fps by remember { mutableIntStateOf(60) }
    var brightness by remember { mutableFloatStateOf(1.0f) }
    var contrast by remember { mutableFloatStateOf(1.0f) }
    var saturation by remember { mutableFloatStateOf(1.0f) }
    var sharpness by remember { mutableFloatStateOf(1.0f) }

    val accent = Brush.verticalGradient(
        listOf(
            Color(0xFF0B1220),
            Color(0xFF101A2F),
            Color(0xFF0B1220)
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = accent)
            .verticalScroll(scrollState)
            .padding(horizontal = 16.dp, vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "GAME VIDEO OPTIMIZER",
                color = Color(0xFF5BFF8A),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Icon(
                imageVector = Icons.Default.Bolt,
                contentDescription = null,
                tint = Color(0xFF5BFF8A),
                modifier = Modifier.size(28.dp)
            )
        }

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF101A2F)),
            shape = RoundedCornerShape(18.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "Boost your gameplay video",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "Enhance clarity, smoothness and color so your gaming clips look cleaner and more competitive.",
                    color = Color(0xFFA9B7D2),
                    fontSize = 13.sp
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Button(
                        onClick = { /* open picker */ },
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5BFF8A))
                    ) {
                        Icon(imageVector = Icons.Default.VideoLibrary, contentDescription = null)
                        Spacer(modifier = Modifier.size(8.dp))
                        Text(text = "Select Video", color = Color.Black)
                    }
                    OutlinedButton(
                        onClick = { /* export */ },
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(imageVector = Icons.Default.Download, contentDescription = null)
                        Spacer(modifier = Modifier.size(8.dp))
                        Text(text = "Export")
                    }
                }
            }
        }

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF101A2F)),
            shape = RoundedCornerShape(18.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Video Controls",
                    color = Color(0xFF5BFF8A),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                SliderControl(title = "Resolution", value = resolution.toFloat(), min = 720f, max = 2160f, step = 180f) {
                    resolution = it.toInt()
                }
                SliderControl(title = "Target FPS", value = fps.toFloat(), min = 30f, max = 120f, step = 10f) {
                    fps = it.toInt()
                }
                SliderControl(title = "Brightness", value = brightness, min = 0.7f, max = 1.5f, step = 0.05f) {
                    brightness = it
                }
                SliderControl(title = "Contrast", value = contrast, min = 0.8f, max = 1.6f, step = 0.05f) {
                    contrast = it
                }
                SliderControl(title = "Saturation", value = saturation, min = 0.8f, max = 1.8f, step = 0.05f) {
                    saturation = it
                }
                SliderControl(title = "Sharpness", value = sharpness, min = 0.8f, max = 2.0f, step = 0.05f) {
                    sharpness = it
                }
            }
        }

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF101A2F)),
            shape = RoundedCornerShape(18.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Text("Enhancement presets", color = Color(0xFF5BFF8A), fontWeight = FontWeight.Bold, fontSize = 18.sp)
                FeatureRow(icon = Icons.Default.HighQuality, label = "Quality boost")
                FeatureRow(icon = Icons.Default.Bolt, label = "FPS smoothness")
                FeatureRow(icon = Icons.Default.ColorLens, label = "Color correction")
                FeatureRow(icon = Icons.Default.AutoFixHigh, label = "Clarity enhancement")
            }
        }

        Button(
            onClick = { /* run optimization */ },
            modifier = Modifier.fillMaxWidth().height(56.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6AA9FF)),
            shape = RoundedCornerShape(14.dp)
        ) {
            Icon(imageVector = Icons.Default.PlayArrow, contentDescription = null)
            Spacer(modifier = Modifier.size(10.dp))
            Text(text = "Optimize Video", color = Color.White, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun SliderControl(
    title: String,
    value: Float,
    min: Float,
    max: Float,
    step: Float,
    onValueChange: (Float) -> Unit
) {
    Column(modifier = Modifier.padding(vertical = 10.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(title, color = Color.White)
            Text(String.format("%.2f", value), color = Color(0xFF5BFF8A))
        }
        Slider(
            value = value,
            onValueChange = onValueChange,
            valueRange = min..max,
            steps = ((max - min) / step).toInt() - 1,
            colors = SliderDefaults.colors(
                thumbColor = Color(0xFF5BFF8A),
                activeTrackColor = Color(0xFF5BFF8A),
                inactiveTrackColor = Color(0xFF2A3B5F)
            )
        )
    }
}

@Composable
fun FeatureRow(icon: androidx.compose.ui.graphics.vector.ImageVector, label: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(icon, contentDescription = null, tint = Color(0xFF5BFF8A))
        Spacer(modifier = Modifier.size(10.dp))
        Text(label, color = Color.White)
    }
}
