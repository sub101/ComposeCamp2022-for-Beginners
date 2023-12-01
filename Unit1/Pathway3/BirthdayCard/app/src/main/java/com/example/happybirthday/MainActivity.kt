/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme() {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    BirthdayGreetingWithImage(
                        message = getString(R.string.happy_birthday_txt),
                        from = getString(
                            R.string.from_sb,
                        ),
                    )
                }
            }
        }
    }
}

// 7. 텍스트 정렬 및 패딩 추가
@Composable
fun BirthdayGreetingWithText(message: String, from: String, modifier: Modifier = Modifier) {
    // Create a column so that texts don't overlap
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier,
    ) {
        Text(
            text = message,
            fontSize = 100.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center,
        )
        Text(
            text = from,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally),
        )
    }
}

// 5. Box 레이아웃 추가
@Composable
fun BirthdayGreetingWithImage(message: String, from: String) {
    val img = painterResource(id = R.drawable.androidparty)

    Box {
        Image(
            painter = img,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F,
        )
        BirthdayGreetingWithText(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
        )
    }
}

// 4. 이미지 컴포저블 추가
@Preview(showBackground = true)
@Composable
private fun BirthdayCardPreview() {
    BirthdayGreetingWithImage(stringResource(R.string.happy_birthday_txt), stringResource(R.string.from_sb))
}
