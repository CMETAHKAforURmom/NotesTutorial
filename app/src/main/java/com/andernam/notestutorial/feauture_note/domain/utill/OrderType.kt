package com.andernam.notestutorial.feauture_note.domain.utill

sealed class OrderType{
    object Ascending: OrderType()
    object Descending: OrderType()
}
