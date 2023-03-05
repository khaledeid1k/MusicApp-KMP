package com.example.musicapp_kmp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.example.musicapp_kmp.player.MediaPlayerController
import com.seiko.imageloader.ImageLoader
import com.seiko.imageloader.LocalImageLoader
import com.seiko.imageloader.cache.memory.maxSizePercent
import com.seiko.imageloader.component.setupDefaultComponents
import com.seiko.imageloader.util.DebugLogger
import com.seiko.imageloader.util.LogPriority


@Composable
fun MainAndroid() {
    Column(Modifier.background(color = Color(0xFF1A1E1F))) {
        val mediaPlayerController = MediaPlayerController()
        val context = LocalContext.current
        CompositionLocalProvider(
            LocalImageLoader provides ImageLoader {
                logger = DebugLogger(LogPriority.VERBOSE)
                components {
                    setupDefaultComponents(context)
                }
                interceptor {
                    memoryCacheConfig {
                        maxSizePercent(context)
                    }
                }
            },
        ) {
            MainCommon(mediaPlayerController)
        }
    }
}

