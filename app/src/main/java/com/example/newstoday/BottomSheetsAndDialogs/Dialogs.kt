package com.app.lontara.bignews.BottomSheetsAndDialogs

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.newstoday.R


@Composable
fun openFullImageDialog1(onDismissRequest: () -> Unit, image: String?) {


    AlertDialog(onDismissRequest = {
        onDismissRequest()
    }, containerColor = Color.White, title = {

        Column(
            horizontalAlignment = Alignment.End
        ) {

            Image(painter = painterResource(id = R.drawable.cancel_icon),
                contentDescription = "Cancel icon",

                modifier = Modifier
                    .size(32.dp)
                    .shadow(
                        elevation = 10.dp, spotColor = Color.Black, shape = CircleShape
                    )
                    .clickable {
                        onDismissRequest()
                    }

            )

            Spacer(modifier = Modifier.height(10.dp))

            AsyncImage(
                model = image,
                contentDescription = "News Image",
                modifier = Modifier
                    .width(300.dp)
                    .height(300.dp)
                    .clip(
                        shape = RoundedCornerShape(20.dp)
                    ),
                contentScale = ContentScale.FillBounds

            )

        }


    }, confirmButton = {

    })

}