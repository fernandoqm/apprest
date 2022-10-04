package com.fquesada.apprestaurante.ui.view

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.FilterQuality.Companion.Medium
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.fquesada.apprestaurante.R
import com.fquesada.apprestaurante.domain.model.Comandas
import com.fquesada.apprestaurante.ui.theme.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun pantallaPrincipal(navController: NavController){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(DeepBlue),
    ) {
        TopBar()
        SalonesActivos(Salones = listOf("Principal","Salón 2", "Salón 3","Patio","Piscina", "Terraza"))
        ListadoComandas()
    }
}

@Composable
fun TopBar() {
    val imagenHeight = AppBarExpendedHeight - AppBarCollapsedHeight
    TopAppBar(
        contentPadding = PaddingValues(),
        backgroundColor = Color.White,
        modifier = Modifier.height(AppBarExpendedHeight)
    ) {
        Column {
            Box(Modifier.height(imagenHeight)) {
                Image(
                    painter = painterResource(id = R.drawable.encabezadomain),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colorStops = arrayOf(
                                Pair(0.4f, Transparent),
                                Pair(1f, White)
                            )
                        )
                    )
                )
            }
            Column(
                Modifier
                    .fillMaxWidth()
                    .height(AppBarCollapsedHeight),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Fecha: " )
                
            }
        }
    }
}

@Composable
fun SalonesActivos(
    Salones: List<String>
) {
    var selectSalonIndex by remember {
        mutableStateOf(0)
    }
    LazyRow {
        items(Salones.size) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {
                        selectSalonIndex = it
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectSalonIndex == it) ButtonBlue
                        else DarkerButtonBlue
                    )
                    .padding(15.dp)
            ) {
                Text(text = Salones[it], color = TextWhite)
            }
        }
    }
}


@Composable
fun ListadoComandas(){
    Card(modifier = Modifier
        .padding(horizontal = 8.dp, vertical = 8.dp)
        .fillMaxWidth(),
         elevation = 4.dp,
        backgroundColor = AquaBlue,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        Row{
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ) {
                Text(text = "Comanda #1", style = MaterialTheme.typography.h6)
                Text(text = "Mesa #3", style = MaterialTheme.typography.h6)
                Text(text = "Monto:¢ 5,435.00", style = MaterialTheme.typography.h6)
            }
        }
        
    }

}




