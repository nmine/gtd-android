package be.nmine.gtd.fragment.actions

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.PopupMenu
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import be.nmine.gtd.R
import be.nmine.gtd.fragment.listview.MyListAdapter
import kotlinx.android.synthetic.main.custom_list.*
import kotlinx.android.synthetic.main.fragment_actions.*


class ActionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_actions, container, false)

    data class Word(val name :String, val lastname:String)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recipeList = arrayOf("test", "test3", "test4")
        val listItems = arrayOfNulls<String>(recipeList.size)
        for (i in recipeList.indices) {
            val recipe = recipeList[i]
            listItems[i] = recipe
        }
        val language = arrayOf<String>("C","C++","Java",".Net","Kotlin","Ruby","Rails","Python","Java Script","Php","Ajax","Perl","Hadoop")
        val description = arrayOf<String>(
            "C programming is considered as the base for other programming languages",
            "C++ is an object-oriented programming language.",
            "Java is a programming language and a platform.",
            ".NET is a framework which is used to develop software applications.",
            "Kotlin is a open-source programming language, used to develop Android apps and much more.",
            "Ruby is an open-source and fully object-oriented programming language.",
            "Ruby on Rails is a server-side web application development framework written in Ruby language.",
            "Python is interpreted scripting  and object-oriented programming language.",
            "JavaScript is an object-based scripting language.",
            "PHP is an interpreted language, i.e., there is no need for compilation.",
            "AJAX allows you to send and receive data asynchronously without reloading the web page.",
            "Perl is a cross-platform environment used to create network and server-side applications.",
            "Hadoop is an open source framework from Apache written in Java."
        )

       // val adapter =
         //activity?.let { ArrayAdapter(it, android.R.layout.simple_list_item_2, listItems) }
        val myListAdapter = MyListAdapter(activity,language,description)
        recipe_list_view.adapter = myListAdapter
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

}