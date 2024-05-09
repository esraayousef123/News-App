package Screens


import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


import android.provider.CalendarContract.Colors
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember

import androidx.compose.ui.Alignment

import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.newsapp.R
import com.example.newsapp.ui.theme.Green
import com.example.newsapp.utilities.SourceTabRow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun NewsScreenContent(
    scope: CoroutineScope,
    drawerState: DrawerState,
    navController: NavHostController,


) {
    Scaffold(
        topBar = { NewsAppBar(drawerState, scope) }
    ) {paddingValues ->

        Column {    // the content of the News screen
            // source tab row
            SourceTabRow(modifier = Modifier.padding(top = paddingValues.calculateTopPadding()))



            }
        }
    }


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsAppBar(drawerState: DrawerState, scope: CoroutineScope) {
    TopAppBar(
        title = {

            Text(
                text = stringResource(id = R.string.news_app),
                color = Color.White,
                fontSize = 28.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Green,
            titleContentColor = Color.White
        ),
        navigationIcon = {
            Image(
                painter = painterResource(id = R.drawable.menu_ic),
                contentDescription = "menu_icon",
                modifier = Modifier
                    .padding(8.dp)
                    .clickable { scope.launch { drawerState.open() } }

            )
        },
        modifier = Modifier.clip(
            RoundedCornerShape(
                bottomStart = 30.dp,
                bottomEnd = 30.dp
            )
        ),// to edit the shape of the app bar
        actions = {
            Image(painter = painterResource(id =R.drawable.search_icon ),
                contentDescription = "search", modifier = Modifier.padding(8.dp))
        }
        


    )

}












