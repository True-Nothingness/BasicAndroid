package com.light.basicandroid.activities

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.light.basicandroid.R
import com.light.basicandroid.User
import com.light.basicandroid.UserAdapter

class ListViewActivity : AppCompatActivity() {
    private lateinit var userAdapter: UserAdapter
    private val userList = mutableListOf<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_view)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        userAdapter = UserAdapter(userList, this)
        recyclerView.adapter = userAdapter

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener {
            showAddUserDialog()
        }
    }
    private fun showAddUserDialog() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_add_user, null)
        val nameET: EditText = dialogView.findViewById(R.id.nameET)
        val ageET: EditText = dialogView.findViewById(R.id.ageET)
        val genderET: EditText = dialogView.findViewById(R.id.genderET)

        AlertDialog.Builder(this)
            .setTitle("Add User")
            .setView(dialogView)
            .setPositiveButton("Add") { _, _ ->
                val name = nameET.text.toString()
                val age = ageET.text.toString().toIntOrNull() ?: 0
                val gender = genderET.text.toString()
                if (name.isNotBlank() && age > 0 && gender.isNotBlank()) {
                    val user = User(name, age, gender)
                    userAdapter.addUser(user)
                } else {
                    Toast.makeText(this, "Please fill in all fields correctly", Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton("Cancel", null)
            .create()
            .show()
    }
}