package com.riso.kotlintest.homeScreen

import com.riso.kotlintest.homeScreen.`object`.Button

interface HomeInteractor {

    interface View{

        fun resetActivity()
        fun messageWin(message: String)
        fun onDestroy()
        fun dialogMessage(message: String)

    }

    interface Presenter{
        fun generateListButton(): List<Button>
        fun processClick(itemClicked: Int, list: ArrayList<Int>, gamer:Int, cont:Int)
    }
}