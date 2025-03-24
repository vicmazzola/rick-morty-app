package com.example.rickandmorty.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.rickandmorty.R
import com.example.rickandmorty.model.Character
import com.example.rickandmorty.model.Result
import com.example.rickandmorty.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun CharacterListScreen(modifier: Modifier = Modifier) {

    var context = LocalContext.current

    var characterList by remember {
        mutableStateOf(listOf<Character>())
    }

    val callCharacter = RetrofitFactory()
        .getCharacterService()
        .getAllCharacters()

    callCharacter.enqueue(object : Callback<Result> {
        override fun onResponse(p0: Call<Result>, result: Response<Result>) {
            characterList = result.body()!!.results!!
            Toast.makeText(context, "Code: ${result.code()}", Toast.LENGTH_SHORT).show()
        }

        override fun onFailure(p0: Call<Result>, p1: Throwable) {

        }

    })

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = stringResource(R.string.chart_list),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(30.dp)
                )
                LazyColumn {
                    items(characterList) { character ->
                        Card(modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp)) {
                            Row {
                                AsyncImage(
                                    model = character.image,
                                    contentDescription = ""
                                )
                                Column(modifier = Modifier.padding(16.dp)) {
                                    Text(text= "Name: ${character.charName}", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                                    Text(text= "Species: ${character.species}")
                                    Text(text= "Gender: ${character.gender}")
                                }
                            }
                        }

                    }

                }
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
private fun CharacterListScreenPreview() {
    CharacterListScreen()
}