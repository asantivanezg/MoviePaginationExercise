package com.asantivanezg.paginationexercise.ui.screen.home

import androidx.paging.PagingData
import com.asantivanezg.paginationexercise.data.db.entity.MovieEntity

sealed interface HomeUiState {

    data object Loading : HomeUiState

    data class Success(val movieData: PagingData<MovieEntity>) : HomeUiState
}