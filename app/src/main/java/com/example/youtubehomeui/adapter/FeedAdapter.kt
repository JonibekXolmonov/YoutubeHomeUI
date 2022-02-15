package com.example.youtubehomeui.adapter

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.MediaController
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.youtubehomeui.R
import com.example.youtubehomeui.model.Feed
import com.google.android.material.imageview.ShapeableImageView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

class FeedAdapter(private val context: Context, var videos: ArrayList<Feed>) :
    RecyclerView.Adapter<FeedAdapter.VH>() {

    inner class VH(private val view: View) : RecyclerView.ViewHolder(view) {
        var iv_profile: ShapeableImageView = view.findViewById(R.id.iv_profile)
        var vv_video: YouTubePlayerView = view.findViewById(R.id.vv_video)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH = VH(
        LayoutInflater.from(parent.context).inflate(R.layout.item_feed_video, parent, false)
    )

    override fun onBindViewHolder(holder: VH, position: Int) {
        val video = videos[position]

        Glide.with(context)
            .load(video.profile)
            .into(holder.iv_profile)

        holder.vv_video.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                youTubePlayer.loadVideo(video.videoYoutubeID, 0f)
            }
        })
    }

    override fun getItemCount(): Int = videos.size
}