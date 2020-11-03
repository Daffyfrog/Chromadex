package fr.nalric.chromadex

import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.expandHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.core.content.res.ResourcesCompat
import androidx.ui.tooling.preview.Preview
import fr.nalric.chromadex.ui.ChromadexTheme

class PokemonList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChromadexTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ChromadexTheme {
        PokemonCard(Pokemon())
    }
}
@Composable
fun PokemonCard(pokemon : Pokemon)
{
    Card(shape = RoundedCornerShape(0.dp), modifier = Modifier.padding(2.dp)) {
        Card(
            shape = MaterialTheme.shapes.medium,
            elevation = 14.dp,
            modifier = Modifier.size(150.dp, 200.dp)
                               .padding(10.dp),
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(10.dp)
            ) {
                val imageModifier = Modifier
                    .clip(shape = RoundedCornerShape(4.dp))

                Card(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    shape = CircleShape,
                    elevation = 6.dp,

                    ) {

                    Image(
                        imageResource(id = R.drawable.charizard),
                        contentScale = ContentScale.Fit,
                        modifier = imageModifier
                    )
                }
                Divider(color = Color.Gray, thickness = 1.dp, modifier = Modifier.padding(7.dp))
                Text(text = pokemon.name, fontSize = TextUnit.Em(2))
                Row(
                    modifier = Modifier.fillMaxWidth(1f).padding(PaddingValues(0.dp, 5.dp, 0.dp, 0.dp)),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = "#" + pokemon.numPokedex.toString(),
                        fontSize = TextUnit.Em(2)
                    )
                    Checkbox(checked = true,
                        onCheckedChange = { checked ->
                            pokemon.shiny = checked
                        }
                    )
                }
            }
        }
    }
}
@Composable
fun PokemonGrid(pokemonList : List<Pokemon>) {
    ChromadexTheme() {
        for (pokemon : Pokemon in pokemonList){
            
        }
    }
}