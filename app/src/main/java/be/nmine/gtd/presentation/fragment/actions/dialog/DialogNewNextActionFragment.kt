package be.nmine.gtd.presentation.fragment.actions.dialog

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import be.nmine.gtd.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class DialogNewNextActionFragment : DialogFragment() {


    override fun onCreateDialog(
        savedInstanceState: Bundle?
    ): Dialog {
        val get:String = arguments?.get("title") as String
        return MaterialAlertDialogBuilder(requireContext())
            .setTitle(get)
            .setView(R.layout.dialog_next_action)
            .create()
    }

}