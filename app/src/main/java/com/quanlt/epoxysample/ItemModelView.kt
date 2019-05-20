package com.quanlt.epoxysample

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.cardview.widget.CardView
import androidx.core.view.isVisible
import com.airbnb.epoxy.AfterPropsSet
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import kotlinx.android.synthetic.main.view_card_item.view.tvSubtitle
import kotlinx.android.synthetic.main.view_card_item.view.tvTitle

@ModelView(autoLayout = ModelView.Size.WRAP_WIDTH_WRAP_HEIGHT)
class ItemModelView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : CardView(context, attrs, defStyleAttr) {

    init {
        View.inflate(context, R.layout.view_card_item, this)
    }

    var shouldShow: Boolean = false
        @ModelProp set

    @AfterPropsSet
    fun bindModel() {
        tvTitle.isVisible = shouldShow
        tvSubtitle.isVisible = shouldShow
    }
}