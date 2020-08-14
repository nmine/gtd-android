package be.nmine.gtd.fragment.inbox

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import androidx.lifecycle.map
import be.nmine.gtd.R
import be.nmine.gtd.core.domain.stuff.Stuff
import be.nmine.gtd.fragment.inbox.listView.InboxListAdapter
import be.nmine.gtd.fragment.inbox.viewModel.AllStuffViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.inbox_fragment_list_view.*



@AndroidEntryPoint
class InboxFragment : Fragment() {

    private val getAllStuffViewModel: AllStuffViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.inbox_fragment_list_view, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val stuffsNamesLiveData: LiveData<List<String>> = getAllStuffViewModel
            .flow
            .asLiveData()
            .map {list: List<Stuff?> -> list.map { stuff -> stuff!!.name }  }
        stuffsNamesLiveData.observe(viewLifecycleOwner, Observer { names: List<String> ->
            recipe_list_view.adapter = InboxListAdapter(activity, names)
        })
    }
}