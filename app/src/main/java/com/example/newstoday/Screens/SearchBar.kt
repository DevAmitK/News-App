package com.example.newstoday.Screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.app.lontara.bignews.Navigation.Routes
import com.app.lontara.bignews.ViewModel.NewsViewModel
import okhttp3.Route

@Composable
fun SearchBar(viewModel: NewsViewModel, navController: NavHostController) {
    val context =LocalContext.current
    // State for query text
    val queryText = remember { mutableStateOf("") }

    OutlinedTextField(
        value = queryText.value,
        onValueChange = { queryText.value = it },
        leadingIcon = {
           Image(imageVector = Icons.Default.Search, contentDescription = "",
               modifier = Modifier
                   .size(32.dp)
                   .padding(start = 8.dp))
        },
        textStyle = TextStyle(
            textAlign = TextAlign.Start, fontSize = 14.sp
        ),
        placeholder = {
            Text(
                text = "Search everything...", fontSize = 14.sp
            )
        },
        singleLine = true,
        shape = RoundedCornerShape(100),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.Transparent,
            focusedContainerColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Black,
            focusedIndicatorColor = Color.Gray,
            cursorColor = Color.Gray,
            focusedLeadingIconColor = Color.Gray,
            focusedTextColor = Color.Gray,
            selectionColors = TextSelectionColors(
                handleColor = Color.Gray, backgroundColor = Color.White,
            )
        ),
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Search // Set the keyboard action to "Search"
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                // Navigate to the Search page when "Search" is pressed
                if (queryText.value.isNotEmpty()) {
                    viewModel.res.value = null
                    viewModel.updateQuery(queryText.value.toString(),navController)
                }
            }
        ),
        modifier = Modifier
            .padding(end = 8.dp, start = 8.dp)
            .fillMaxWidth()
    )
}
