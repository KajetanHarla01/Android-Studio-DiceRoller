package com.example.diceroller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.diceroller.databinding.ActivityMainExtendedBinding
import com.example.diceroller.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySettingsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val numDice = intent.getIntExtra(getString(R.string.numer_of_dice), 2)
        val isHoldEnabled = intent.getBooleanExtra(getString(R.string.allow_dice_hold), true)

        binding.enableHoldSwitch.isChecked = isHoldEnabled

        if (numDice in 2..5)
        {
            binding.numDiceSpinner.setSelection(numDice - 2)
        }
        binding.confirmButton.setOnClickListener {
            val spinnerSelection = binding.numDiceSpinner.selectedItem.toString().toInt()
            val holdEnable = binding.enableHoldSwitch.isChecked
            var result = Intent().apply {
                putExtra(getString(R.string.numer_of_dice), spinnerSelection)
                putExtra(getString(R.string.allow_dice_hold), holdEnable)
            }
            setResult(RESULT_OK, result)
            finish()
        }
    }
}