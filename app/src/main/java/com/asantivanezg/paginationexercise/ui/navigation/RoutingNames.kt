package com.asantivanezg.paginationexercise.ui.navigation

import kotlinx.serialization.Serializable

sealed class RoutingNames {
    @Serializable
    data object LoginScreen : RoutingNames()

    @Serializable
    data object HomeScreen : RoutingNames()

}