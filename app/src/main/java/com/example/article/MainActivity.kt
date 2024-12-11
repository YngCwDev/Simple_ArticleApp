package com.example.article

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.article.ui.theme.ArticleTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArticleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                        MainBody()
                }
            }
        }
    }
}

@Composable
fun ArticleImage(){
    Image(
        painter = painterResource(R.drawable.bg_compose_background),
        contentDescription = null,
        contentScale = ContentScale.Fit
    )
}
@Composable
fun ArticleText(title: String, modifier: Modifier = Modifier) {
    Column (
        modifier = Modifier.padding(20.dp)
    ) {
        Text(
            text = title,
            modifier = modifier
                .padding(
                    top = 8.dp,
                    bottom = 8.dp
                ),
            fontSize = 30.sp

        )
        Text(
            text = stringResource(R.string.paragraph_one_text),
            textAlign = TextAlign.Justify,
            modifier = modifier
                .padding(
                    top = 8.dp,
                    bottom = 8.dp
                ),
            fontSize = 24.sp,
            lineHeight = 26.sp,
        )
        Text(
            text = stringResource(R.string.paragraph_two_text),
            textAlign = TextAlign.Justify,
            fontSize = 24.sp,
            lineHeight = 26.sp,
            letterSpacing = 2.sp
        )
    }
}
@Composable
fun MainBody(){
    Column(
        modifier = Modifier.padding(top = 40.dp),

    ) {
        ArticleImage()
        ArticleText(
            title = stringResource(R.string.article_title_text),
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ArticleTheme {
     MainBody()
    }
}