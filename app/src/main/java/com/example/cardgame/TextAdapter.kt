package com.example.cardgame

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

class TextAdapter(data: List<String>) :
    BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_text, data) {

    override fun convert(helper: BaseViewHolder, item: String?) {
        helper.setText(R.id.tv_text, item)
    }
}