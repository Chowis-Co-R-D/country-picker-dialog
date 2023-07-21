# country-picker-dialog


![telegram-cloud-photo-size-2-5321033682095556860-y](https://github.com/Chowis-Co-R-D/country-picker-dialog/assets/99383435/37f8651a-abbd-4d4f-92c2-aeb16aa18346)



How to
To get a Git project into your build:

Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

 	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}


 Step 2. Add the dependency

 	dependencies {
	        implementation 'com.github.Chowis-Co-R-D:country-picker-dialog:1.0.3'
	}



How to implement
```
override fun onCreate(savedInstanceState: Bundle?) {
    val dialog = CountryPickerDialog(this)
}
```

First create the dialog then you can use other modification functions.
```
dialog.create()
```

To show phone code you use this function
```
dialog.showPhoneCode(true)
```

To change dialog height this function is used. Insert number from 0 to 1 such as 0.8f
```
dialog.setDialogHeightProportion(0.9f)
```

To change corner radius of the dialog, this function is used.
```
dialog.setCornerRadius(50f)
```

Text color and size is changed using these functions
```
dialog.setCountryTextColor(Color.RED)
dialog.setPhoneCodeTextColor(Color.BLUE)
dialog.setCountryTextSize(16f)
dialog.setPhoneCodeTextSize(16f)
```

This function is used to get selected country
```
dialog.onItemSelected { country->
	textview.text = country.name
}
```

Use show function to show the dialog
```
dialog.show()
```

