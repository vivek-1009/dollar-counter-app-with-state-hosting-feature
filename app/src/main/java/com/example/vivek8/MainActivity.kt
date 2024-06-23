package com.example.vivek8

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vivek8.ui.theme.Vivek8Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Vivek8Theme {
                // A surface container using the 'background' color from the theme
               myapp()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Vivek8Theme {
        Greeting("Android")
    }
}
//State Hosting
@Preview(showBackground = true)
@Composable
fun myapp(){
    Surface(modifier=Modifier.fillMaxSize()){
dollarcounter()
    }
}

@Composable
fun dollarcounter(){
    val counter=remember{
        mutableStateOf(1)
    }
    Column(modifier=Modifier.fillMaxSize(),verticalArrangement= Arrangement.Center,horizontalAlignment= Alignment.CenterHorizontally){
        Text(text="$${counter.value*100}",style= TextStyle(color= Color.Black,fontWeight= FontWeight.Bold))
        Spacer(modifier=Modifier.height(190.dp))
        custombutton(){
            counter.value++
        }
    }
}
@Composable
fun custombutton(onClick:()->Unit){
    Card(modifier=Modifier.size(140.dp).clickable{
        onClick.invoke()
    }.background(color=Color.Yellow),shape= CircleShape){
  Box(modifier=Modifier.fillMaxSize(),contentAlignment=Alignment.Center){
    Text(text="Tap",style=TextStyle(color=Color.Green,fontSize=40.sp,fontWeight=FontWeight.Bold))
}
    }
}