package com.sopian.binardialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    private val btnDialogCancelable by lazy {
        findViewById<Button>(R.id.dialog_cancelable_button)
    }

    private val btnDialogWithAction by lazy {
        findViewById<Button>(R.id.dialog_with_action_button)
    }

    private val btnCustomDialog by lazy {
        findViewById<Button>(R.id.dialog_custom_button)
    }

    private val parentLayout by lazy {
        findViewById<ConstraintLayout>(R.id.parent_layout)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupAlertDialog()
    }

    private fun setupAlertDialog() {
        btnDialogCancelable.setOnClickListener {
            this.showAlertDialog(
                title = "Dialog Cancelable",
                message = "Dialog Cancelable bisa ditutup dengan klik bagian luar dialog"
            )
        }

        btnDialogWithAction.setOnClickListener {
            this.showAlertDialog(
                "Positive Button",
                "Negative button",
                "Neutral button",
                "Dialog - Chapter 4",
                "Dialog with Button untuk berbagaii aksi",
                actionOnPositiveButton = { parentLayout.showShortSnackbar("Positive Button Clicked") },
                actionOnNegativeButton = { parentLayout.showShortSnackbar("Negative Button Clicked") },
                actionOnNeutralButton = { parentLayout.showShortSnackbar("Neutral Button Clicked") }
            )
        }

        btnCustomDialog.setOnClickListener {
            val view = LayoutInflater.from(this).inflate(R.layout.custom_dialog_layout, null, false)
            AlertDialog.Builder(this).apply {
                setView(view)
                setCancelable(true)
                create()
            }.show()
        }
    }
}