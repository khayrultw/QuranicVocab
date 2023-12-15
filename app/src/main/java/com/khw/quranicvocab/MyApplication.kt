package com.khw.quranicvocab

import android.app.Application
import android.util.Log
import com.khw.quranicvocab.data.model.Vocab
import com.khw.quranicvocab.data.repo.VocabRepo
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import java.io.BufferedReader
import java.io.InputStreamReader
import javax.inject.Inject

@HiltAndroidApp
class MyApplication: Application() {

    @Inject
    lateinit var repo: VocabRepo

    override fun onCreate() {
        super.onCreate()
        val `is` = resources.openRawResource(R.raw.vocabs)
        val reader = BufferedReader(InputStreamReader(`is`))
        val ioScope = CoroutineScope(SupervisorJob())

        ioScope.launch(Dispatchers.IO) {
            repo.clear()
            while (true) {
                try {
                    reader.readLine()?.also {
                        val wp = it.split("->")
                        if(wp.size > 1) {
                            vocabs[wp[0]] = wp[1]
                            val vocab = Vocab(word = wp[0], meanings = wp[1])
                            repo.insert(vocab)
                        }
                    } ?: break
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
            `is`.close()
        }
    }

    companion object {
        init {
            System.loadLibrary("quranicvocab")
        }
        var vocabs = mutableMapOf<String, String>()
    }
}