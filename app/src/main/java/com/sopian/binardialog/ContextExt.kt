package com.sopian.binardialog

import android.content.Context
import androidx.appcompat.app.AlertDialog

fun Context.showAlertDialog(
    positiveButtonLable: String? = null,
    negativeButtonLable: String? = null,
    neutralButtonLable: String? = null,
    title: String = getString(R.string.app_name),
    message: String? = null,
    actionOnPositiveButton: (() -> Unit)? = null,
    actionOnNegativeButton: (() -> Unit)? = null,
    actionOnNeutralButton: (() -> Unit)? = null
) {
    val builder = AlertDialog.Builder(this).apply {
        setTitle(title)
        setCancelable(false)
        setMessage(message)
        setPositiveButton(positiveButtonLable) { dialog, _ ->
            dialog.cancel()
            if (actionOnPositiveButton != null) {
                actionOnPositiveButton()
            }
        }
        setNegativeButton(negativeButtonLable) { dialog, _ ->
            dialog.cancel()
            if (actionOnNegativeButton != null) {
                actionOnNegativeButton()
            }
        }
        .setNeutralButton(neutralButtonLable) { dialog, _ ->
            dialog.cancel()
            if (actionOnNeutralButton != null) {
                actionOnNeutralButton()
            }
        }
    }.show()
}