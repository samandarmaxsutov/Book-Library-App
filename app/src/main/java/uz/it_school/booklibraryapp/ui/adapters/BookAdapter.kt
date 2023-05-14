package uz.it_school.booklibraryapp.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.it_school.booklibraryapp.R
import uz.it_school.booklibraryapp.model.room.entities.BookEntity

class BookAdapter: RecyclerView.Adapter<BookAdapter.Holder>() {
    private val data: MutableList<BookEntity> = ArrayList()
    private var onClickListener:((BookEntity)->Unit)? = null
    @SuppressLint("NotifyDataSetChanged")
    fun submitItems(newItems: List<BookEntity>) {
        data.clear()
        data.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        )
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun onClick(l:(BookEntity)->Unit) {
        onClickListener=l
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name = itemView.findViewById<TextView>(R.id.country_name)
        private val capital = itemView.findViewById<TextView>(R.id.country_capital)
        private val image = itemView.findViewById<ImageView>(R.id.image_item)
        private val imageBtn = itemView.findViewById<ImageView>(R.id.btn_right)
        fun bind(postion: Int) {
            val item: BookEntity = data[postion]
            name.text = item.title
            capital.text = item.author
            image.setImageResource(item.image)
        }

        init {
            imageBtn.setOnClickListener {
                onClickListener?.invoke(
                    data[adapterPosition]
                )
            }
        }
    }
}
