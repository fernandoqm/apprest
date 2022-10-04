package com.fquesada.apprestaurante.util.navigation

sealed class Pantallas(val route: String){
    object Login: Pantallas("Login")
    object Main: Pantallas("PantallaPrincipal")
}