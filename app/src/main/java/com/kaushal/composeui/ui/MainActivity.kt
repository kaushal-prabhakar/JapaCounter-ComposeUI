package com.kaushal.composeui.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.view.ViewCompat
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.add
import androidx.fragment.app.commit
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidView(factory = ag@{ context ->
                val view = FragmentContainerView(context)
                view.id = ViewCompat.generateViewId()
                val selfId = view.id
                supportFragmentManager.commit {
                    add<WelcomeFragment>(selfId)
                }
                return@ag view
            })
        }
    }
}