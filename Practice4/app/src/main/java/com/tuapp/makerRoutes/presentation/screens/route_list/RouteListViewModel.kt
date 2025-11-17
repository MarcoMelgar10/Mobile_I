package com.tuapp.MakerRouter.presentation.screens.route_list

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tuapp.MakerRouter.domain.model.Route
import com.tuapp.MakerRouter.domain.repository.RoutesRepository
import com.tuapp.MakerRouter.presentation.navigation.AppScreen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RouteListViewModel @Inject constructor(
    private val repository: RoutesRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val username: StateFlow<String> = savedStateHandle
        .getStateFlow(AppScreen.RouteList.ARG_USERNAME, "")

    val routes: StateFlow<List<Route>> = username.flatMapLatest { user ->
        repository.getRoutes(user)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    private val _isDialogVisible = MutableStateFlow(false)
    val isDialogVisible = _isDialogVisible.asStateFlow()

    private val _newRouteName = MutableStateFlow("")
    val newRouteName = _newRouteName.asStateFlow()

    private val _isDeleteDialogVisible = MutableStateFlow(false)
    val isDeleteDialogVisible = _isDeleteDialogVisible.asStateFlow()

    private val _routeToDelete = MutableStateFlow<Route?>(null)
    val routeToDelete = _routeToDelete.asStateFlow()

    fun onShowDialog() {
        _newRouteName.value = ""
        _isDialogVisible.value = true
    }

    fun onDismissDialog() {
        _isDialogVisible.value = false
    }

    fun onNewRouteNameChange(name: String) {
        _newRouteName.value = name
    }

    fun createRouteAndNavigate(onNavigate: (String, String) -> Unit) {
        viewModelScope.launch {
            val newRoute = repository.createRoute(
                name = _newRouteName.value,
                username = username.value
            )
            newRoute?.let {
                onDismissDialog()
                onNavigate(it.id, it.name)
            }
        }
    }

    fun onShowDeleteDialog(route: Route) {
        _routeToDelete.value = route
        _isDeleteDialogVisible.value = true
    }

    fun onDismissDeleteDialog() {
        _isDeleteDialogVisible.value = false
        _routeToDelete.value = null
    }

    fun confirmDeleteRoute() {
        viewModelScope.launch {
            _routeToDelete.value?.let { route ->
                repository.deleteRoute(route.id)
                onDismissDeleteDialog()
            }
        }
    }
}
