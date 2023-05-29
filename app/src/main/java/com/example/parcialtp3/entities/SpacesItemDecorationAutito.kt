package com.example.parcialtp3.entities

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class SpacesItemDecorationAutito(private val spacingInPixels: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {

        // You can also set spacing for top and bottom if needed
        outRect.top = spacingInPixels
        outRect.bottom = spacingInPixels
    }
}