package io.github.tonnyl.whatsnew.adapter

import android.content.Context
import android.graphics.Color
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import io.github.tonnyl.whatsnew.R
import io.github.tonnyl.whatsnew.item.WhatsNewItem

/**
 * Created by lizhaotailang on 30/11/2017.
 */
class ItemsAdapter(private val mData: Array<WhatsNewItem>, private val mContext: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var titleColor: Int = Color.parseColor("#000000")
    var contentColor: Int = Color.parseColor("#808080")

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (position <= mData.size) {
            with(holder as ItemViewHolder) {
                with(itemView) {
                    val titleView = findViewById<TextView>(R.id.itemTitleTextView)
                    mData[position].imageRes?.let { titleView.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(mContext, it), null, null, null) }
                    titleView.compoundDrawablePadding = 16
                    titleView.text = mData[position].title
                    titleView.setTextColor(titleColor)

                    findViewById<TextView>(R.id.itemContentTextView).text = mData[position].content
                    findViewById<TextView>(R.id.itemContentTextView).setTextColor(contentColor)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item, parent, false))
    }

    override fun getItemCount(): Int = mData.size

    inner class ItemViewHolder(mItemView: View) : RecyclerView.ViewHolder(mItemView)
}
