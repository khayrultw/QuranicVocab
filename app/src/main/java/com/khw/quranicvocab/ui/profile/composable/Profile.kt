package com.khw.quranicvocab.ui.profile.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.khw.quranicvocab.ui.profile.viewModel.ProfileViewModel

@Composable
fun Profile(
    viewModel: ProfileViewModel,
) {
    Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            Icons.Default.Person,
            "Person",
            Modifier.size(64.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedButton(onClick = { /*TODO*/ }) {
            Text(text = "Signup with google")
            Spacer(modifier = Modifier.width(8.dp))
            Icon(Icons.Default.Face, "Google")
        }
    }
}