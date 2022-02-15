package com.example.youtubehomeui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubehomeui.adapter.FeedAdapter
import com.example.youtubehomeui.adapter.FilterAdapter
import com.example.youtubehomeui.model.Feed
import com.example.youtubehomeui.model.Filter

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerFeed: RecyclerView
    private lateinit var recyclerFilter: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        recyclerFeed = findViewById(R.id.recyclerFeed)
        recyclerFilter = findViewById(R.id.recyclerFilter)

        refreshStoryAdapter(getAllFilters())
        refreshFeedAdapter(getAppFeeds())
    }

    private fun refreshFeedAdapter(feeds: ArrayList<Feed>) {
        val adapter = FeedAdapter(this,feeds)
        recyclerFeed.adapter = adapter
    }

    private fun refreshStoryAdapter(allFilters: ArrayList<Filter>) {
        val adapter = FilterAdapter(allFilters)
        recyclerFilter.adapter = adapter
    }

    private fun getAllFilters(): ArrayList<Filter> {
        return ArrayList<Filter>().apply {
            this.add(Filter("Computer Programming"))
            this.add(Filter("Android Native"))
            this.add(Filter("Mobile Development"))
            this.add(Filter("Back End"))
            this.add(Filter("Computer Science"))
            this.add(Filter("Computer Fix"))
            this.add(Filter("Telephone"))
        }
    }

    private fun getAppFeeds(): ArrayList<Feed> {
        return ArrayList<Feed>().apply {
            for (i in 0..2) {
                this.add(Feed("https://yt3.ggpht.com/LLoRVw7onB5Bw-rSb5OXerG2Moj4S8Q56_bqs3fDu2dYZxr2EyRymHN6ybyUp9uzb4GlfMlu8A=s88-c-k-c0x00ffffff-no-rj","2aFBf7Qt6L0"))
                this.add(Feed("https://yt3.ggpht.com/E81KY7SAPat3qrUuc1N7cztfr8QABJ0f3CUlOF_gQkH7cKP1K8lxaFyp8w3732goS4-pj5KhJpk=s88-c-k-c0x00ffffff-no-rj","MQIAKvjPwus"))
                this.add(Feed("https://yt3.ggpht.com/pl-pa9hLg5NS2sXUlKsvpDwoinfjlKzYb8cM0zqGVxUUBDeRbGegGZbC8QRcPj62yiFzYN70Lg=s88-c-k-c0x00ffffff-no-rj","I7P3zMCPVLQ"))
                this.add(Feed("https://yt3.ggpht.com/ytc/AKedOLQ01YVhDOp8uanTDAcSLvEmHoRNzj9ONYu488UiRg=s88-c-k-c0x00ffffff-no-rj","yi0OYUMqvAw"))
            }
        }
    }
}