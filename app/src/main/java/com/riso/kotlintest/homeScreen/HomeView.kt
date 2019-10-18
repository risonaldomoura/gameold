package com.riso.kotlintest.homeScreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.riso.kotlintest.R
import com.riso.kotlintest.base.CustomApplication
import com.riso.kotlintest.base.Utils
import kotlinx.android.synthetic.main.activity_main_new.*

class HomeView : AppCompatActivity(), HomeInteractor.View{

    lateinit var homePresenter: HomePresenter

    val context = CustomApplication.instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_new)

        homePresenter = HomePresenter(this)

        initControl()
    }

    override fun messageWin(message: String) {
        Utils.showToast(context, message)
    }

    override fun resetActivity() {
        finish()
        Utils.startActivity(context, HomeView::class.java)
    }

    override fun dialogMessage(message: String) {
        Utils.alertDialog(context, message)
    }

    fun initControl(){
        val rvButton = rv_buttons
        rvButton.adapter =
            HomeAdapterButton(homePresenter.generateListButton(), this)

        rvButton.setHasFixedSize(true)

        val layoutManager = StaggeredGridLayoutManager(
            3, StaggeredGridLayoutManager.VERTICAL)
        rvButton.layoutManager = layoutManager
    }

    fun clickButtonList(itemClicked: Int, list: ArrayList<Int>, gamer:Int, cont: Int){
        homePresenter = HomePresenter(this)
        homePresenter.processClick(itemClicked, list, gamer, cont)
    }

    override fun onDestroy() {
        homePresenter.onDestroy()
        super.onDestroy()
    }
}
