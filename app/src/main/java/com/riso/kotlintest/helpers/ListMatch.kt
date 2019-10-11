package com.riso.kotlintest.helpers

class ListMatch {
    companion object{
        //Match in horizontal
        var listMatch1 = arrayListOf(1, 2, 3)
        var listMatch2 = arrayListOf(4, 5, 6)
        var listMatch3 = arrayListOf(7, 8, 9)

        //Match in vertical
        var listMatch4 = arrayListOf(1, 4, 7)
        var listMatch5 = arrayListOf(2, 5, 8)
        var listMatch6 = arrayListOf(3, 6, 9)

        //Match in diagonal
        var listMatch7 = arrayListOf(1, 5, 9)
        var listMatch8 = arrayListOf(3, 5, 7)
    }
}