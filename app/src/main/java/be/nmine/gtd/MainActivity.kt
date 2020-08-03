package be.nmine.gtd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import be.nmine.gtd.fragment.actions.ActionsFragment
import be.nmine.gtd.fragment.inbox.InboxFragment
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.input.getInputField
import com.afollestad.materialdialogs.input.input
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var inputField: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navigationBar = findViewById<BottomNavigationView>(R.id.navigation_bar)
        navigationBar.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        fab_add_stuff.setOnClickListener {
            val dialog: MaterialDialog = MaterialDialog(this).show {
                input { dialog, text ->
                    inputField = dialog.getInputField().text.toString()
                }
                positiveButton(R.string.app_name)
            }
            inputField = dialog.getInputField().text.toString()
        }
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