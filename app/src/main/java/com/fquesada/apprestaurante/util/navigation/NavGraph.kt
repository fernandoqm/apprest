package com.fquesada.apprestaurante.util.navigation

import android.net.Uri
import android.provider.MediaStore.Video
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.fquesada.apprestaurante.ui.view.Login
import com.fquesada.apprestaurante.ui.view.pantallaPrincipal

@Composable
fun NavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Pantallas.Login.route
    ){
        composable(route = Pantallas.Login.route){
            Login(navController)
        }
        composable(route = Pantallas.Main.route){
            pantallaPrincipal(navController)
        }
    }
}