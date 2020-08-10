package be.nmine.gtd.fragment.inbox

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import be.nmine.gtd.R
import be.nmine.gtd.core.domain.basket.Basket
import be.nmine.gtd.core.domain.stuff.Stuff
import be.nmine.gtd.fragment.inbox.listView.InboxListAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.inbox_fragment_list_view.*
import javax.inject.Inject

@AndroidEntryPoint
class InboxFragment : Fragment() {

    @Inject
    lateinit var basket: Basket

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.inbox_fragment_list_view, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        basket.getAll{stuffs: List<Stuff> ->
            var map:MutableList<String>  = mutableListOf()
            stuffs.map { stuff -> map.add(stuff.name) }
            recipe_list_view.adapter = InboxListAdapter(activity, map as List<String>)
        }

//        three_dots.setOnClickListener{
//
//        }
    }
}