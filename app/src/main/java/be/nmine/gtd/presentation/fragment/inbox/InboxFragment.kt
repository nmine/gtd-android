package be.nmine.gtd.presentation.fragment.inbox

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
import be.nmine.gtd.presentation.fragment.inbox.listView.InboxListAdapter
import be.nmine.gtd.presentation.fragment.inbox.viewModel.InboxViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.inbox_fragment_list_view.*


@AndroidEntryPoint
class InboxFragment : Fragment() {

    private val inboxViewModel: InboxViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.inbox_fragment_list_view, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val stuffsNamesLiveData: LiveData<List<String>> = inboxViewModel
            .flow
            .asLiveData()
            .map { list: List<StuffDTO?> -> list.map { stuffDTO -> stuffDTO!!.name } }
        stuffsNamesLiveData.observe(viewLifecycleOwner, Observer { names: List<String> ->
            recipe_list_view.adapter = InboxListAdapter(activity, names)
        })
    }
}