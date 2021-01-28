package com.syahrulsamudra_18102142.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import com.syahrulsamudra_18102142.mainactivity.databinding.ActivitySettingPreferenceBinding

class SettingPreferenceActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var mSettingPreference: SettingPreference
    private lateinit var settingModel: SettingModel
    private lateinit var binding: ActivitySettingPreferenceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingPreferenceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSet.setOnClickListener(this)
        mSettingPreference = SettingPreference(this)
        settingModel = mSettingPreference.getSetting()
        showPreferenceInForm()

        supportActionBar?.title = getString(R.string.setting_page)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    private fun showPreferenceInForm() {
        if (settingModel.isDarkTheme) {
            binding.rbYes.isChecked = true
        } else {
            binding.rbNo.isChecked = true
        }
    }

    override fun onClick(p0: View?) {
        if (p0?.id == R.id.btn_set) {
            val isLoveMU = binding.rgLoveMu.checkedRadioButtonId == R.id.rb_yes
            saveSetting(isLoveMU)
            val resultIntent = Intent()
            setResult(RESULT_CODE, resultIntent)
            finish()
        }
    }

    companion object {
        const val RESULT_CODE = 101
    }

    private fun saveSetting(isLoveMU: Boolean) {
        val settingPreference = SettingPreference(this)
        settingModel.isDarkTheme = isLoveMU
        settingPreference.setSetting(settingModel)
        Toast.makeText(this, "Data tersimpan", Toast.LENGTH_SHORT).show()
    }
}