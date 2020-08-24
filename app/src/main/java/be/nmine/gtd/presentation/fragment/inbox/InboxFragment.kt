package be.nmine.gtd.presentation.fragment.inbox

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
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
        initListViewStuffs()
        initZeroInboxText()
    }

    private fun initListViewStuffs() {
        inboxViewModel.stuffTitlesLiveData.observe(
            viewLifecycleOwner,
            Observer { names: List<String> ->
                recipe_list_view.adapter = InboxListAdapter(activity, names, inboxViewModel)
            })
    }

    private fun initZeroInboxText() {
        inboxViewModel.inboxZero.observe(
            viewLifecycleOwner,
            Observer { inboxZeroDTO: InboxZeroDTO ->
                zeroInbox.text = StringBuilder().append(inboxZeroDTO.duration.toDays())
            })
    }
}