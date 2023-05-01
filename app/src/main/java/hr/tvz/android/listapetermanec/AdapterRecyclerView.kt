package hr.tvz.android.listapetermanec

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterRecyclerView constructor() : RecyclerView.Adapter<AdapterRecyclerView.ViewHolder>() {
    private lateinit var mDataset: MutableList<String>

    constructor(mDataset: Array<String>) : this() {
        this.mDataset = mDataset.toMutableList()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView

        init {
            textView = itemView as TextView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.context).inflate(R.layout.text_view, parent, false)

        return ViewHolder(v as TextView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = mDataset[position]

        val intent = Intent(holder.textView.context, DetailsActivity::class.java)
        intent.putExtra("exercise", Exercise(position))


        holder.textView.setOnClickListener { v ->
            v.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return mDataset.size
    }
}