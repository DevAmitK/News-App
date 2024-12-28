package com.example.newstoday.Screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.app.lontara.bignews.API_Service.Article
import com.app.lontara.bignews.Items.ArticleItems
import com.app.lontara.bignews.ViewModel.NewsViewModel
import kotlinx.coroutines.flow.MutableStateFlow

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SearchPage(viewModel: NewsViewModel, navController: NavHostController) {
    // Get Articles
    val res = viewModel.res.value?.articles ?: emptyList()
    // Get Number Of Articles
    val noOfNews = viewModel.res.value?.totalResults ?: "0"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(start = 8.dp, end = 8.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 12.dp, bottom = 12.dp, start = 8.dp)

        ) {
            Text(
                text = "Available news:", style = TextStyle(
                    fontSize = 12.sp, fontWeight = FontWeight.Normal
                ), color = Color.Gray
            )
            Text(
                text = noOfNews.toString(), style = TextStyle(
                    fontSize = 16.sp, fontWeight = FontWeight.Medium
                ), color = Color.Black, modifier = Modifier.padding(start = 4.dp)
            )
        }

        // LazyColumn For Show All Articles


        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            if (!res.isNullOrEmpty()){
                LazyColumn(
                    modifier = Modifier
                        .background(color = Color.White)
                        .fillMaxSize()
                ) {
                    items(res) {
                        ArticleItems(
                            image = it.urlToImage,
                            title = it.title,
                            date = it.publishedAt,
                            url = it.url,
                            article = it,
                            navController = navController
                        )
                    }
                }
            }
            else{
                CircularProgressIndicator()
            }

        }
    }

    DisposableEffect(Unit) {
        onDispose {
            viewModel.res.value = null
            viewModel.updateQuerySearch()
        }
    }

}

