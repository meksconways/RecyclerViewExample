package com.androidkurs.recyclerviewexample

import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),PostClickistener {


    override fun setSelectedPost(model: PostDataModel) {
        Toast.makeText(this,"Tıklanan item: ${model.username}",
        Toast.LENGTH_SHORT)
        .show()
    }

    lateinit var postAdapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fillPostList()
        postAdapter = PostAdapter(this)
        rv_post.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.HORIZONTAL,false)
        postAdapter.setItems(postList)
        rv_post.adapter = postAdapter
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(rv_post)

    }

    private val postList = ArrayList<PostDataModel>()

    private fun fillPostList(){

        postList.add(
            PostDataModel(
                ContextCompat.getDrawable(this,R.drawable.city)!!,
                "ui8net",
                ContextCompat.getDrawable(this,R.drawable.city)!!
                )
        )
        postList.add(
            PostDataModel(
                ContextCompat.getDrawable(this,R.drawable.city)!!,
                "asdasd",
                ContextCompat.getDrawable(this,R.drawable.city)!!
            )
        )
        postList.add(
            PostDataModel(
                ContextCompat.getDrawable(this,R.drawable.city)!!,
                "ui8123123net",
                ContextCompat.getDrawable(this,R.drawable.city)!!
            )
        )
        postList.add(
            PostDataModel(
                ContextCompat.getDrawable(this,R.drawable.city)!!,
                "ui84423423net",
                ContextCompat.getDrawable(this,R.drawable.city)!!
            )
        )
        postList.add(
            PostDataModel(
                ContextCompat.getDrawable(this,R.drawable.city)!!,
                "ui4358net",
                ContextCompat.getDrawable(this,R.drawable.city)!!
            )
        )
        postList.add(
            PostDataModel(
                ContextCompat.getDrawable(this,R.drawable.city)!!,
                "ui8neyuklukythgt",
                ContextCompat.getDrawable(this,R.drawable.city)!!
            )
        )



    }

}
class MarginItemDecoration(private val spaceHeight: Int)
    : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect, view: View,
        parent: RecyclerView, state: RecyclerView.State
    ) {
        with(outRect) {
            if (parent.getChildAdapterPosition(view) == 0 ||
                parent.getChildAdapterPosition(view) == 1) {
                //top = spaceHeight
            }
            left = spaceHeight
            right = spaceHeight
//            bottom = spaceHeight
        }
    }
}




