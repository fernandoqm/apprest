package com.fquesada.apprestaurante.domain.model

import androidx.annotation.DrawableRes

data class Comandas (
    val id: Int? = -1,
    val id_salon: Int? = 0,
    val id_mesa: Int? = 0,
    val mnonto: Double? = 0.00,
    val notas: String? = null,
    val estado: String? = null,
    val usuario_registra: String? = null,
    val fecha_registro: String? = null,
    val hora_saolicitud: String? = null,
)