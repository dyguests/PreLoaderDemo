package com.fanhl.preloaderdemo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.billy.android.preloader.PreLoader
import com.billy.android.preloader.interfaces.DataListener
import com.billy.android.preloader.interfaces.DataLoader
import kotlinx.android.synthetic.main.activity_second.*


class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val preLoaderId = intent.getIntExtra(SecondLoader.preLoaderId, -1)
        PreLoader.listenData(preLoaderId, DataListener<String> {
            textView.text = it
        })
    }

    companion object {
        fun launch(context: Context, bundle: Bundle) {
            val intent = Intent(context, SecondActivity::class.java)
            intent.putExtras(bundle)
            context.startActivity(intent)
        }
    }

    class SecondLoader : DataLoader<String> {
        override fun loadData(): String {
            Thread.sleep(1000)
            return "test data"
        }

        companion object {
            val preLoaderId = "preLoaderId"
        }
    }
}
