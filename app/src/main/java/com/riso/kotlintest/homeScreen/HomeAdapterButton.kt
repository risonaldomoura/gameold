package com.riso.kotlintest.homeScreen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.riso.kotlintest.R
import com.riso.kotlintest.helpers.GlobalValues
import com.riso.kotlintest.homeScreen.`object`.Button
import kotlinx.android.synthetic.main.item_list_button.view.*

class HomeAdapterButton(private val list: List<Button>,
                        val context: Context): RecyclerView.Adapter<HomeAdapterButton.ViewHolder>(){

    lateinit var homeView: HomeView

    var cont = 0

    var listGame1 = ArrayList<Int>()
    var listGame2 = ArrayList<Int>()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]

        homeView = HomeView()

        //Evita NullPointerException
        holder?.let {
            it.btn.setOnClickListener(){
                clickButton(item.id, holder.btn)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_list_button, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val btn = itemView.btn_list
    }

    private fun clickButton(item: Int, v: View){

        cont += 1

        //Par
        if((cont%2 != 0)){
            processClick(item, listGame1, 1, cont)
            changeBackgroundAndDisable(v, GlobalValues.btnGreen)
        }
        //Ímpar
        else if(cont%2 == 0){
            processClick(item, listGame2, 2, cont)
            changeBackgroundAndDisable(v, GlobalValues.btnPurple)
        }
    }

    private fun processClick(itemClicked: Int, list: ArrayList<Int>, gamer:Int, cont: Int){
        homeView.clickButtonList(itemClicked, list, gamer, cont)
    }
    private fun changeBackgroundAndDisable(v: View, style: Int){
        v.setBackgroundResource(style)
        v.isClickable = false
    }

}