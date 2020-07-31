package be.nmine.gtd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import be.nmine.gtd.fragment.ActionsFragment
import be.nmine.gtd.fragment.InboxFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener
import kotlinx.android.synthetic.main.fragment_actions.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navigationBar = findViewById<BottomNavigationView>(R.id.navigation_bar)
        navigationBar.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        val listView = recipe_list_view
        val recipeList = arrayOf("test","test3","test4")
        val listItems = arrayOfNulls<String>(recipeList.size)
        for (i in 0 until recipeList.size) {
            val recipe = recipeList[i]
            listItems[i] = recipe
        }
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
        listView.adapter = adapter
    }

    private val mOnNavigationItemSelectedListener = OnNavigationItemSelectedListener {
        when (it.itemId) {
            R.id.menu_inbox -> {
                val fragment = InboxFragment()
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment, fragment.javaClass.getSimpleName())
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.menu_actions -> {
                val fragment = ActionsFragment()
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment, fragment.javaClass.getSimpleName())
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }
}