package com.khw.quranicvocab.ui.screens.vocabs.composable

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.khw.quranicvocab.data.model.Vocab
import com.khw.quranicvocab.ui.screens.vocabs.viewModel.VocabsViewModel

@Composable
fun Review(
    viewModel: VocabsViewModel,
) {
    val state = viewModel.getAllVocabs().collectAsStateWithLifecycle(emptyList()).value

    Log.d("debugging", state.toString())

    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp)) {
        items(items = state) {
            VocabItem(vocab = it)
        }
    }
}

@Composable
fun VocabItem(vocab: Vocab) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = vocab.word, style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = vocab.meanings, style = MaterialTheme.typography.bodyLarge)
        }
    }
}