package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val dataName : TextView = findViewById(R.id.tv_item_name)
        val dataDescription : TextView = findViewById(R.id.tv_item_description)
        val dataRating : TextView = findViewById(R.id.tv_item_rating)
        val dataPhoto : ImageView = findViewById(R.id.img_item_photo)
        val dataDirector : TextView = findViewById(R.id.tv_item_director)
        val dataWriter : TextView = findViewById(R.id.tv_item_writer)

        val getName = intent.getStringExtra(EXTRA_NAME)
        val getPhoto = intent.getStringExtra(EXTRA_PHOTO)
        val getRating = intent.getStringExtra(EXTRA_RATING)
        val getDescription = intent.getStringExtra(EXTRA_DESCRIPTION)
        val getDirector = intent.getStringExtra(EXTRA_DIRECTOR)
        val getWriter = intent.getStringExtra(EXTRA_WRITER)

        val buttonShare: Button = findViewById(R.id.action_share)
        buttonShare.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            val shareMessage = "Check out this movie: $getName"
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
            startActivity(Intent.createChooser(shareIntent, "Shared"))
        }

        dataName.text = getName
        Glide.with(this)
            .load(getPhoto)
            .apply(RequestOptions())
            .into(dataPhoto)
            dataRating.text = getRating
        dataDescription.text = getDescription
        dataDirector.text = getDirector
        dataWriter.text = getWriter

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title="Detail"

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_DESCRIPTION = "extra_description"
        const val EXTRA_RATING = "extra_rating"
        const val EXTRA_DIRECTOR = "extra_director"
        const val EXTRA_WRITER = "extra_writer"
    }

}