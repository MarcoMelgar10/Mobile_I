package com.tuapp.MakerRouter.presentation.screens.route_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.tuapp.MakerRouter.presentation.components.CreateRouteDialog
import com.tuapp.MakerRouter.presentation.components.DeleteConfirmationDialog
import com.tuapp.MakerRouter.presentation.components.CustomButton
import com.tuapp.MakerRouter.presentation.components.RouteItem

@Composable
fun RouteListScreen(
    viewModel: RouteListViewModel = hiltViewModel(),
    username: String,
    onRouteClick: (routeId: String, routeName: String) -> Unit
) {
    val routes by viewModel.routes.collectAsState()
    val isDialogVisible by viewModel.isDialogVisible.collectAsState()
    val newRouteName by viewModel.newRouteName.collectAsState()

    val isDeleteDialogVisible by viewModel.isDeleteDialogVisible.collectAsState()
    val routeToDelete by viewModel.routeToDelete.collectAsState()

    if (isDialogVisible) {
        CreateRouteDialog(
            newRouteName = newRouteName,
            onRouteNameChange = viewModel::onNewRouteNameChange,
            onDismiss = viewModel::onDismissDialog,
            onConfirm = {
                viewModel.createRouteAndNavigate(onRouteClick)
            }
        )
    }

    // Delete Confirmation Dialog
    if (isDeleteDialogVisible) {
        DeleteConfirmationDialog(
            routeName = routeToDelete?.name ?: "",
            onDismiss = viewModel::onDismissDeleteDialog,
            onConfirm = viewModel::confirmDeleteRoute
        )
    }

    Scaffold(
        bottomBar = {
            Box(
                modifier = Modifier
                    .padding(horizontal = 32.dp)
                    .padding(bottom = 24.dp)
            ) {
                CustomButton(
                    text = "Create a route",
                    onClick = viewModel::onShowDialog
                )
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp),
        ) {
            items(
                items = routes,
                key = { route -> route.id }
            ) { route ->
                RouteItem(
                    route = route,
                    onEditClick = {
                        onRouteClick(route.id, route.name)
                    },
                    onDeleteClick = {
                        viewModel.onShowDeleteDialog(route)
                    }
                )
            }
        }
    }
}
