package com.example.androidstudio_koala_template

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidstudio_koala_template.ui.theme.AndroidStudioKoalaTemplateTheme

class MainActivity : ComponentActivity() {

    @Composable
    fun MyDropDownMenu(modifier: Modifier = Modifier) {
        var selectedText: String by remember { mutableStateOf("") }
        var expanded: Boolean by remember { mutableStateOf(false) }
        val hobbies = listOf("Add", "Call", "Email", "Reading", "Star")
        Column(
            Modifier
                .padding(20.dp, 80.dp)
        ) {
            OutlinedTextField(
                value = selectedText,
                onValueChange = { selectedText = it },
                enabled = false,
                readOnly = true,
                modifier = Modifier
                    .clickable { expanded = true }
                    .fillMaxWidth()
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier
                    .fillMaxWidth()
// Afegir colors i detalls al desplegable:
                    .border(1.dp, Color.Black, RoundedCornerShape(4.dp))
            ) {
                hobbies.forEach { hobby ->
                    DropdownMenuItem(
                        text = { Text(text = hobby) },
                        onClick = {
                            expanded = false
                            selectedText = hobby
                        })
                }
            }
        }
    }
}