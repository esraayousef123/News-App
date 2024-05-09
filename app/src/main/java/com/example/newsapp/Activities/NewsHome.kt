package Activities

import Screens.NewsScreenContent
import Screens.catigoryScreenContent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import com.example.newsapp.R
import com.example.newsapp.ui.theme.Green
import com.example.newsapp.ui.theme.NewsAppTheme
import kotlinx.coroutines.CoroutineScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.newsapp.utilities.modalDrawerSheet


class NewsHome : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsAppContent()

        }
    }
}

@Composable
fun NewsAppContent() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val navController = rememberNavController()
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(drawerState = drawerState ,drawerContent = {
        // drawerSheet Composable

        modalDrawerSheet() // composable fun

    }) { //screen Contant , navhost
        ScreensNaveHost(navController = navController , drawerState = drawerState , scope =scope )



    }

}
// side menue

@Composable
fun ScreensNaveHost(scope:CoroutineScope , navController : NavHostController , drawerState: DrawerState){
    //navehost like frame layout to contain the fragment of screen
    NavHost(navController = navController, startDestination = "news screen") {
        composable("categories") {
            // Composable for Categories screen like fragment
            catigoryScreenContent(navController = navController, scope =scope , drawerState= drawerState)
        }
        composable("news screen") {
            // Composable for news screen
            NewsScreenContent(navController = navController, scope =scope , drawerState= drawerState)
        }



}}









