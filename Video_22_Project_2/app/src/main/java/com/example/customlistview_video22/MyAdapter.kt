package com.example.customlistview_video22

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

// ':' expression is used for extending the class.
// Here, ArrayAdapter is extended using ':' expression.
class MyAdapter(private val context: Activity, private val arrayList: ArrayList<User>) :
    ArrayAdapter<User>(context, R.layout.activity_each_item, arrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.activity_each_item, null)

        val civProfileImage = view.findViewById<CircleImageView>(R.id.civProfileImage)
        val tvName = view.findViewById<TextView>(R.id.tVName)
        val tvLastMsg = view.findViewById<TextView>(R.id.tVLastMessage)
        val tvLastMsgTime = view.findViewById<TextView>(R.id.tVLastMsgTime)

        civProfileImage.setImageResource(arrayList[position].imageId)
        tvName.text = arrayList[position].name
        tvLastMsg.text = arrayList[position].lastMsg
        tvLastMsgTime.text = arrayList[position].lastMsgTime

        return view
    }
}
