package com.khw.quranicvocab.ui.screens.learn.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Redo
import androidx.compose.material.icons.filled.RestartAlt
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.khw.quranicvocab.R
import com.khw.quranicvocab.ui.screens.learn.viewModel.PracticeViewModel

@Composable
fun Practice(viewModel: PracticeViewModel) {
    val state = viewModel.state.collectAsStateWithLifecycle().value

    fun done() {

    }

    fun needPractice() {

    }

    fun reset() {

    }

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (reset, stat, centerContent, bottomContent) = createRefs()

        if(state.vocab.meanings.isNotEmpty()) {
            IconButton(
                modifier = Modifier
                    .constrainAs(reset) {
                        top.linkTo(parent.top, 8.dp)
                        end.linkTo(parent.end, 8.dp)
                    },
                onClick = { reset() }
            ) {
                Icon(
                    Icons.Default.RestartAlt,
                    "",
                    Modifier.size(36.dp),
                    MaterialTheme.colorScheme.error
                )
            }

            TextButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .constrainAs(stat) {
                        top.linkTo(parent.top, 32.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            ) {
                Text(
                    text = "You learned ${state.doneCount} words",
                    style = MaterialTheme.typography.titleLarge
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(centerContent) {
                        linkTo(top = stat.bottom, bottom = bottomContent.top, bias = 0.3f)
                    }
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = state.vocab.word,
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = state.vocab.meanings,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.W500,
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

            Row(modifier = Modifier
                .fillMaxWidth()
                .constrainAs(bottomContent) {
                    bottom.linkTo(parent.bottom, 20.dp)
                },
                horizontalArrangement = Arrangement.Center
            ) {
                OutlinedButton(onClick = { needPractice() }) {
                    Icon(Icons.Default.Redo, "")
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = stringResource(id = R.string.repeat))
                }
                Spacer(modifier = Modifier.width(20.dp))
                OutlinedButton(onClick = { done() }) {
                    Icon(Icons.Default.Check, "")
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = stringResource(id = R.string.im_done))
                }
            }
        } else {
            Text(text = stringResource(id = R.string.need_practice))
        }
    }
}