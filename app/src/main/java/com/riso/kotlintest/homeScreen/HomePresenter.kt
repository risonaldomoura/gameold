package com.riso.kotlintest.homeScreen

import android.os.Handler
import com.riso.kotlintest.helpers.ListMatch
import com.riso.kotlintest.homeScreen.`object`.Button

class HomePresenter (private var view: HomeInteractor.View?): HomeInteractor.Presenter {

    override fun generateListButton(): List<Button> {

        var list = ArrayList<Button>()

        for(i in 1..9){
            list.add(Button(i))
        }

        return list
    }

    override fun processClick(itemClicked: Int, list: ArrayList<Int>, gamer: Int, cont: Int) {
        list.add(itemClicked)
        if(list.size >= 3){
            var result = verifyList(list)
            verifyWin(result,gamer, cont)
        }
    }

    private fun verifyList(list: ArrayList<Int>): Boolean {

        var result = false

        for (i in 0..7){
            when(i){
                0 -> result = verifyMatchList(list, ListMatch.listMatch1)
                1 -> result = verifyMatchList(list, ListMatch.listMatch2)
                2 -> result = verifyMatchList(list, ListMatch.listMatch3)

                3 -> result = verifyMatchList(list, ListMatch.listMatch4)
                4 -> result = verifyMatchList(list, ListMatch.listMatch5)
                5 -> result = verifyMatchList(list, ListMatch.listMatch6)

                6-> result = verifyMatchList(list, ListMatch.listMatch7)
                7-> result = verifyMatchList(list, ListMatch.listMatch8)
            }
            if(result)
                break
        }

        return result
    }

    private fun verifyWin(result: Boolean, gamer: Int, cont: Int){
        if(result){
            view?.messageWin("Gamer $gamer is win!")
            Handler().postDelayed({view?.resetActivity()}, 1000)
        }
        else if(!result && cont==9){
            view?.messageWin("Game old")
            Handler().postDelayed({view?.resetActivity()}, 1000)
        }
    }

    private fun verifyMatchList(listClick: ArrayList<Int>, listMatch: ArrayList<Int>): Boolean{
        var result = false
        var contResult = 0

        for(i in 0..listClick.size-1){

            for(ii in 0..listMatch.size-1){
                if(listClick[i] == listMatch[ii]){
                    contResult += 1
                }
            }
        }
        if(contResult == 3)
            result = true

        return result
    }

    fun onDestroy(){
        view = null
    }
}