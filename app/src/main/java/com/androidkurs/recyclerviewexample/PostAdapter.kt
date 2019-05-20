package com.androidkurs.recyclerviewexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostAdapter
    (private val listener: PostClickistener)
    : RecyclerView.Adapter<PostAdapter.PostAdapterViewHolder>() {

    fun setItems(list: ArrayList<PostDataModel>){
        this.dataList.addAll(list)
        notifyDataSetChanged()
    }

    private val dataList = arrayListOf<PostDataModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapterViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.item_post,
                parent,
                false
            )

        return PostAdapterViewHolder(view,listener)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: PostAdapterViewHolder, position: Int) {
        holder.bind(dataList[position])
    }


    class PostAdapterViewHolder(
        itemView: View,
        listener: PostClickistener
    ) : RecyclerView.ViewHolder(itemView) {

        lateinit var model: PostDataModel
        private val userImage = itemView.findViewById<ImageView>(R.id.img_user)
        private val username = itemView.findViewById<TextView>(R.id.txt_user)
        private val postImage = itemView.findViewById<ImageView>(R.id.img_post)

        init {
            itemView.setOnClickListener {
                listener.setSelectedPost(model)
            }
        }

        fun bind(model: PostDataModel) {
            this.model = model

            username.text = model.username
            userImage.setImageDrawable(model.userImage)
            postImage.setImageDrawable(model.postImage)

        }


    }


}