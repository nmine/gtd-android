package be.nmine.gtd.fragment.inbox

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import be.nmine.gtd.R
import be.nmine.gtd.core.application.getAllStuffs.GetAllStuffHandler
import be.nmine.gtd.core.infrastructure.BasketInMemory
import be.nmine.gtd.fragment.inbox.listView.InboxListAdapter
import kotlinx.android.synthetic.main.inbox_fragment_list_view.*

class InboxFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.inbox_fragment_list_view, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val stuffDtos = GetAllStuffHandler(BasketInMemory()).handle()
        val map = stuffDtos.map { stuffDTO -> stuffDTO.name }
        val myListAdapter =
            InboxListAdapter(activity, map)
        recipe_list_view.adapter = myListAdapter
    }
}