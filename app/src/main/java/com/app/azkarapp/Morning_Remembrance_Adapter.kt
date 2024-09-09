package com.app.azkarapp

import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Morning_Remembrance_Adapter(private val mList: List<Morning_Remembrance_Model>) : RecyclerView.Adapter<Morning_Remembrance_Adapter.ViewHolder>() {
    lateinit var textView: TextView
    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_morning_remembrance, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val Morning_Remembrance_Model = mList[position]

        holder.textView.text = Html.fromHtml( Morning_Remembrance_Model.text.toString())
        holder.TextView2.text =Html.fromHtml(  Morning_Remembrance_Model.title)
        holder.count.text = Html.fromHtml( Morning_Remembrance_Model.count.toString())

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textView: TextView = itemView.findViewById(R.id.textView)
        val TextView2: TextView  = itemView.findViewById(R.id.textView2)
        val count: TextView = itemView.findViewById(R.id.count)

    }
}
