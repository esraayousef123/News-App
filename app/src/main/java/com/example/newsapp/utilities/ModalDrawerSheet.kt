package com.example.newsapp.utilities

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.R
import com.example.newsapp.ui.theme.Green
// side menu that will be opened in the activity when i click at the icon button at the app bar
@Composable
fun modalDrawerSheet() {
    androidx.compose.material3.ModalDrawerSheet(
        modifier = Modifier.fillMaxWidth(0.7f),
        drawerContainerColor = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.2f)
                .background(Green),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally //this is how the contant will be arrangment
        ) {

            Text(
                text = stringResource(R.string.news_app),
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold

            )

        }
        DrawerSheetItems(R.drawable.catigory_item, R.string.catigory)
        DrawerSheetItems(R.drawable.setting_icon, R.string.settings)


    }

}
// composable fun of the options in the side menue
@Composable
fun DrawerSheetItems(
    iconId: Int,
    textId: Int
) { // couse i will pass value from the res file so i will pass an id
    Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
        Image(
            painter = painterResource(id = iconId),
            contentDescription = "catigory icon"
        )
        Spacer(modifier = Modifier.padding(8.dp))
        Text(text = stringResource(id = textId) , fontSize = 24.sp , fontWeight = FontWeight.Bold)

    }
}
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun drawersheetPreview() {
    modalDrawerSheet()
}