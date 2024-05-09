package Activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.newsapp.R

class SplashActiviyt : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this , NewsHome::class.java )
                startActivity(intent)
                finish()
            },2000)
            splashContect()
        }

    }
}
@Composable
fun splashContect(){
    Column(modifier= Modifier
        .fillMaxSize()
        .paint(painterResource(id = R.drawable.pattern), contentScale = ContentScale.FillBounds) ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        )
    
    {
            Spacer(modifier = Modifier.weight(1f))
            Image(painter = painterResource(id = R.drawable.splash_logo)
                , contentScale = ContentScale.Crop
                , contentDescription = "Logo"
                , modifier = Modifier.fillMaxWidth(.6f))
            
            Spacer(modifier = Modifier.weight(1f))

            Image(painter = painterResource(id = R.drawable.splah_supervisor)
                , contentDescription = "supervisor"
                , contentScale = ContentScale.Crop
                , modifier = Modifier.fillMaxWidth(.6f)


            )


    }
}


