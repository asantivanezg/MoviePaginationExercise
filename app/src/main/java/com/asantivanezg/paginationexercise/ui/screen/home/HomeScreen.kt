package com.asantivanezg.paginationexercise.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import coil3.compose.AsyncImage
import com.asantivanezg.paginationexercise.R
import com.asantivanezg.paginationexercise.data.db.entity.MovieEntity
import com.asantivanezg.paginationexercise.util.addBaseImageUrl

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel()
) {

    val movieData = homeViewModel.movieData.collectAsLazyPagingItems()

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when {
                // Carga inicial
                movieData.loadState.refresh is LoadState.Loading && movieData.itemCount == 0 -> {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(64.dp), color = Color.White
                        )
                    }
                }

                // Estado vacio
                movieData.loadState.refresh is LoadState.NotLoading && movieData.itemCount == 0 -> {
                    Text(text = stringResource(R.string.movie_empty))
                }

                movieData.loadState.hasError -> {
                    Box(
                        Modifier
                            .fillMaxSize()
                            .background(Color.Red), contentAlignment = Alignment.Center
                    ) {
                        Text(text = stringResource(R.string.error_message))
                    }
                }

                else -> {
                    HomeScreenList(movieData)

                    if (movieData.loadState.append is LoadState.Loading) {
                        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                            CircularProgressIndicator(
                                modifier = Modifier.size(64.dp), color = Color.White
                            )
                        }
                    }
                }
            }

        }

    }
}

@Composable
fun HomeScreenList(movieList: LazyPagingItems<MovieEntity>) {
    LazyColumn {
        items(
            count = movieList.itemCount,
            key = { movieList[it]?._id ?: 0 }) {
            movieList[it]?.let { movie ->
                ItemList(movie)
            }
        }
    }
}

@Composable
fun ItemList(movie: MovieEntity) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Row(modifier = Modifier.padding(12.dp)) {
            AsyncImage(
                model = addBaseImageUrl(movie.posterPath) ,
                contentDescription = movie.title,
                modifier = Modifier
                    .width(100.dp)
                    .height(150.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(movie.title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(4.dp))
                Text("⭐ ${movie.voteAverage}", fontSize = 14.sp, color = Color(0xFFFFA000))
                Text("📅 ${movie.releaseDate}", fontSize = 13.sp, color = Color.Gray)
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    movie.overview,
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 13.sp
                )
            }
        }
    }
}