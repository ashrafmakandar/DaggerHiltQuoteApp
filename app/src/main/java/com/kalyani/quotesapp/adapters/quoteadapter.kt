package com.kalyani.quotesapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kalyani.quotesapp.R
import com.kalyani.quotesapp.model.allquotesmodel.AllQuoteItem

class quoteadapter(var context: Context, var lis: List<AllQuoteItem>) :
    RecyclerView.Adapter<quoteadapter.quoteholder>() {


    class quoteholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var quote_en = itemView.findViewById<TextView>(R.id.quote_en)
        var quote_author = itemView.findViewById<TextView>(R.id.quote_author)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): quoteholder {
        var View = LayoutInflater.from(context).inflate(R.layout.quote_item, parent, false)
        return quoteholder(View)

    }

    override fun onBindViewHolder(holder: quoteholder, position: Int) {
        var allQuoteItem = lis[position]
        holder.quote_en.text = allQuoteItem.en.toString()
        holder.quote_author.text = allQuoteItem.author.toString()

    }

    override fun getItemCount(): Int {
        return lis.size

    }


}