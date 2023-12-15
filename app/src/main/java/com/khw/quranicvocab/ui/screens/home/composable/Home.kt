package com.khw.quranicvocab.ui.screens.home.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.khw.quranicvocab.R
import com.khw.quranicvocab.ui.screens.home.viewModel.HomeViewModel
import com.khw.quranicvocab.ui.screens.tabContainer.TabContainerFragmentDirections

@Composable
fun Home(
    navController: NavController,
    viewModel: HomeViewModel,
    onClick: () -> Unit
) {

    val learnCount = viewModel.state.collectAsStateWithLifecycle().value

    fun navigateToPractice() {
        val action = TabContainerFragmentDirections.actionHomeToPractice()
        navController.navigate(action)
    }


    ConstraintLayout {
        val (header, buttons) = createRefs()
        Text(
            modifier = Modifier.constrainAs(header) {
                top.linkTo(parent.top, 16.dp)
                start.linkTo(parent.start, 0.dp)
                end.linkTo(parent.end, 0.dp)
            },
            text = "You learned $learnCount words",
            style = MaterialTheme.typography.titleLarge
        )
        Column(
            modifier = Modifier
                .constrainAs(buttons) {
                    top.linkTo(header.bottom)
                }
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            VocabButton(
                title = "Learn",
                icon = R.drawable.ic_learn,
                onClick = {}
            )
            Spacer(modifier = Modifier.height(16.dp))
            VocabButton(
                title = "Practice",
                icon = R.drawable.ic_practice,
                onClick = { navigateToPractice() }
            )
            Spacer(modifier = Modifier.height(16.dp))
            VocabButton(
                title = "Review",
                icon = R.drawable.ic_review,
                onClick = {onClick()}
            )
        }
    }
}

@Composable
fun VocabButton(title: String, icon: Int, onClick: () -> Unit) {
    OutlinedButton(
        modifier = Modifier.defaultMinSize(minWidth = 160.dp),
        shape = RoundedCornerShape(10.dp),
        onClick = { onClick() }
    ) {
        Icon(
            painter = painterResource(icon),
            contentDescription = null,
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = title.uppercase())
    }
}
