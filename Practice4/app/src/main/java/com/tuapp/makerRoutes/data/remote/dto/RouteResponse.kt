package com.tuapp.MakerRouter.data.remote.dto

import com.tuapp.MakerRouter.domain.model.Route

data class RouteResponse(
    val id: Int,
    val name: String,
    val username: String
) {

    fun toDomainModel(): Route {
        return Route(
            id = id.toString(),
            name = name
        )
    }
}