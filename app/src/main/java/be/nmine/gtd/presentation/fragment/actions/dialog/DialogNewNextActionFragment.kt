package be.nmine.gtd.presentation.fragment.actions.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import be.nmine.gtd.R
import kotlinx.android.synthetic.main.dialog_next_action.*


class DialogNewNextActionFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.dialog_next_action, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val get:String = arguments?.get("title") as String
        dialog_text_action_item.text = get
        dialog_button_create_next_action.setOnClickListener { print("clicked") }
    }

}