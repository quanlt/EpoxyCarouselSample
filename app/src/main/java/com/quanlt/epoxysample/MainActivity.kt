package com.quanlt.epoxysample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.epoxy.CarouselModel_
import com.airbnb.epoxy.EpoxyModel
import kotlinx.android.synthetic.main.activity_main.button
import kotlinx.android.synthetic.main.activity_main.recyclerView

class MainActivity : AppCompatActivity() {

    private var flag = true
    private val list1 =
        listOf(Item(1), Item(2), Item(3), Item(4), Item(5), Item(6), Item(7), Item(8))
    private val list2 = listOf(Item(1), Item(3), Item(4), Item(5), Item(6), Item(7), Item(8))
    private var finalList = list1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            flag = !flag
            finalList = if (flag) {
                list1
            } else {
                list2
            }
            recyclerView.requestModelBuild()
        }
        recyclerView.setItemSpacingRes(R.dimen._8dp)
        recyclerView.buildModelsWith { controller ->
            val models = mutableListOf<EpoxyModel<*>>()
            finalList.forEach {
                models.add(
                    ItemModelViewModel_()
                        .id(it.id)
                        .shouldShow(flag)
                )
            }
            CarouselModel_()
                .id(1)
                .models(models)
                .addTo(controller)
        }
    }

    data class Item(val id: Int)
}
