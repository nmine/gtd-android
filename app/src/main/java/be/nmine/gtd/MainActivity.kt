package be.nmine.gtd

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import be.nmine.gtd.core.domain.stuff.Stuff
import be.nmine.gtd.fragment.actions.ActionsFragment
import be.nmine.gtd.fragment.inbox.InboxFragment
import be.nmine.gtd.fragment.inbox.viewModel.InboxViewModel
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.input.getInputField
import com.afollestad.materialdialogs.input.input
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    var inputField: String = ""

    private val viewModel: InboxViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initNavigationBar()
        initFAB()
    }

    private fun initFAB() {
        fab_add_stuff.setOnClickListener {
            val dialog: MaterialDialog = MaterialDialog(this).show {
                input { dialog, text ->
                    inputField = dialog.getInputField().text.toString()
                    viewModel.saveStuff(Stuff(name = inputField))
                }
                positiveButton(R.string.app_name)
            }
            inputField = dialog.getInputField().text.toString()
        }
    }

    private fun initNavigationBar() {
        val navigationBar = findViewById<BottomNavigationView>(R.id.navigation_bar)
        navigationBar.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
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