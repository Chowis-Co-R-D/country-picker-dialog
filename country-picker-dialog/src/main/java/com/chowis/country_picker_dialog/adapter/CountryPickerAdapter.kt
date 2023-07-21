package com.chowis.country_picker_dialog.adapter

import android.graphics.Color
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chowis.country_picker_dialog.databinding.CountryPickerItemBinding
import com.chowis.country_picker_dialog.model.Country

class CountryPickerAdapter(val callback:CountryPickerCallback):RecyclerView.Adapter<CountryPickerAdapter.CountryPickerViewHolder>() {
    private val countries = mutableListOf<Country>()
    private val fullListOfCountries = mutableListOf<Country>()
    private var showPhoneCode = false
    private var countryTextColor = Color.BLACK
    private var phoneCodeTextColor = Color.BLACK
    private var countryTextSize = 16f
    private var phoneCodeTextSize = 16f


    inner class CountryPickerViewHolder(val binding:CountryPickerItemBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryPickerViewHolder {
        val binding = CountryPickerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CountryPickerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return countries.size
    }

    override fun onBindViewHolder(holder: CountryPickerViewHolder, position: Int) {
        val country = countries[position]
        holder.binding.apply {
            itemTvCountryName.text = country.name

            if (showPhoneCode){
                itemTvPhoneCode.text = "+${country.phoneCode}"
            }

            itemTvCountryName.setTextColor(countryTextColor)
            itemTvPhoneCode.setTextColor(phoneCodeTextColor)

            itemTvCountryName.setTextSize(TypedValue.COMPLEX_UNIT_SP, countryTextSize)
            itemTvPhoneCode.setTextSize(TypedValue.COMPLEX_UNIT_SP, phoneCodeTextSize)



            root.setOnClickListener {
                callback.onClick(country)
            }
        }


    }

    fun showPhoneCode(show:Boolean){
        showPhoneCode = show
    }

    fun setCountryTextColor(color: Int){
        countryTextColor = color
    }
    fun setPhoneCodeTextColor(color: Int){
        phoneCodeTextColor = color
    }
    fun setCountryTextSize(size:Float){
        countryTextSize = size
    }
    fun setPhoneCodeTextSize(size:Float){
        phoneCodeTextSize = size
    }


    fun submitList(list:List<Country>){
        countries.clear()
        fullListOfCountries.clear()
        countries.addAll(list)
        fullListOfCountries.addAll(list)
        notifyDataSetChanged()
    }

    fun filter(query:String){
        println("Item query=$query")
        val filteredList = mutableListOf<Country>()
        if (query.isEmpty()){
            filteredList.clear()
            filteredList.addAll(fullListOfCountries)
        }
        else{
            filteredList.addAll(
                fullListOfCountries.filter { it.name.lowercase().contains(query.lowercase()) }
            )
        }

        countries.clear()
        countries.addAll(filteredList)
        notifyDataSetChanged()
    }


    interface CountryPickerCallback{
        fun onClick(country: Country)
    }

}