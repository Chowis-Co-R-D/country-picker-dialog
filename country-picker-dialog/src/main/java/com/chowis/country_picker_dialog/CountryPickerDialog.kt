package com.chowis.country_picker_dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.chowis.country_picker_dialog.adapter.CountryPickerAdapter
import com.chowis.country_picker_dialog.databinding.DialogCountryPickerBinding
import com.chowis.country_picker_dialog.model.Country

class CountryPickerDialog(context: Context):Dialog(context, R.style.CountryPickerDialogStyle) {
    private lateinit var binding:DialogCountryPickerBinding
    private lateinit var countryAdapter:CountryPickerAdapter

    private var onItemClicked: ((Country) -> Unit)? = null
    fun onItemSelected(item : (Country) -> Unit){
        onItemClicked = item
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogCountryPickerBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initRecyclerview()
        initSearchview()
    }

    override fun dismiss() {
        super.dismiss()
        binding.dialogSearchview.setQuery("", true)
        binding.dialogSearchview.clearFocus()
    }


    private fun initRecyclerview(){
        countryAdapter = CountryPickerAdapter(object : CountryPickerAdapter.CountryPickerCallback {
            override fun onClick(country: Country) {
                onItemClicked?.let {
                    it(country)
                }
                dismiss()
            }
        })
        countryAdapter.showPhoneCode(true)
        countryAdapter.submitList(CountryPickerUtils.prepareCountryList())




        binding.dialogRecyclerview.apply {
            layoutManager = LinearLayoutManager(context,  LinearLayoutManager.VERTICAL, false)
            adapter = countryAdapter
        }

    }

    private fun initSearchview(){
        binding.dialogSearchview.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    countryAdapter.filter(it.trim())
                }
            return true
            }

        })
    }


    fun showPhoneCode(show:Boolean){
        countryAdapter.showPhoneCode(show)
    }
    fun setCountryTextColor(color:Int){
        countryAdapter.setCountryTextColor(color)
    }
    fun setPhoneCodeTextColor(color:Int){
        countryAdapter.setPhoneCodeTextColor(color)
    }
    fun setCountryTextSize(size:Float){
        countryAdapter.setCountryTextSize(size)
    }
    fun setPhoneCodeTextSize(size:Float){
        countryAdapter.setPhoneCodeTextSize(size)
    }
    fun setCornerRadius(radius:Float){
        binding.dialogCardview.radius = radius
    }
    fun setDialogHeightProportion(proportion:Float){
        if (proportion<0 || proportion>1){
            return
        }
        try {
            val height = context.resources.displayMetrics.heightPixels * proportion
            val width = context.resources.displayMetrics.widthPixels * 0.9
            window?.setLayout(width.toInt(), height.toInt())
        }catch (e:Exception){
            e.printStackTrace()
        }

    }



}