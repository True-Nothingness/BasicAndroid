package com.light.basicandroid

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(private val userList: MutableList<User>, private val context: Context) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTV: TextView = itemView.findViewById(R.id.nameTV)
        val ageTV: TextView = itemView.findViewById(R.id.ageTV)
        val genderTV: TextView = itemView.findViewById(R.id.genderTV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.nameTV.text = user.name
        holder.ageTV.text = context.getString(R.string.user_age, user.age)
        holder.genderTV.text = context.getString(R.string.user_gender, user.gender)

    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun addUser(user: User) {
        userList.add(user)
        notifyDataSetChanged()
    }
}
