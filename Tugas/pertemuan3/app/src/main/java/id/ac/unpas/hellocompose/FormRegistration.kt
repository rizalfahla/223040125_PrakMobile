package id.ac.unpas.hellocompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.ac.unpas.hellocompose.ui.theme.HelloComposeTheme

class FormRegistration : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RegistrationForm(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(16.dp)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationForm(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    // State for form fields
    var nama by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var telepon by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }

    // State for error message
    var showError by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Form Registrasi",
            style = MaterialTheme.typography.headlineMedium
        )

        OutlinedTextField(
            value = nama,
            onValueChange = { nama = it },
            label = { Text("Nama") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words,
                imeAction = ImeAction.Next
            ),
            isError = showError && nama.isEmpty(),
            supportingText = {
                if (showError && nama.isEmpty()) {
                    Text("Nama tidak boleh kosong")
                }
            }
        )

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            isError = showError && username.isEmpty(),
            supportingText = {
                if (showError && username.isEmpty()) {
                    Text("Username tidak boleh kosong")
                }
            }
        )

        OutlinedTextField(
            value = telepon,
            onValueChange = { telepon = it },
            label = { Text("Nomor Telepon") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Phone,
                imeAction = ImeAction.Next
            ),
            isError = showError && telepon.isEmpty(),
            supportingText = {
                if (showError && telepon.isEmpty()) {
                    Text("Nomor telepon tidak boleh kosong")
                }
            }
        )

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            isError = showError && email.isEmpty(),
            supportingText = {
                if (showError && email.isEmpty()) {
                    Text("Email tidak boleh kosong")
                }
            }
        )

        OutlinedTextField(
            value = alamat,
            onValueChange = { alamat = it },
            label = { Text("Alamat Rumah") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Sentences,
                imeAction = ImeAction.Done
            ),
            minLines = 3,
            isError = showError && alamat.isEmpty(),
            supportingText = {
                if (showError && alamat.isEmpty()) {
                    Text("Alamat tidak boleh kosong")
                }
            }
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                onClick = {
                    if (nama.isNotEmpty() &&
                        username.isNotEmpty() &&
                        telepon.isNotEmpty() &&
                        email.isNotEmpty() &&
                        alamat.isNotEmpty()
                    ) {
                        // Show success message
                        Toast.makeText(context, "Halo, $nama", Toast.LENGTH_SHORT).show()
                        showError = false
                    } else {
                        // Show error state
                        showError = true
                        Toast.makeText(context, "Semua inputan harus diisi", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Simpan")
            }

            OutlinedButton(
                onClick = {
                    // Reset all form fields
                    nama = ""
                    username = ""
                    telepon = ""
                    email = ""
                    alamat = ""
                    showError = false
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Reset")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegistrationFormPreview() {
    HelloComposeTheme {
        RegistrationForm(
            modifier = Modifier.padding(16.dp)
        )
    }
}