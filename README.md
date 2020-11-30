# EasyExLiveData
a easy case to study live data

### step by step

1. Add dependce in build.gradle

        // liveData and ViewModel
        implementation 'android.arch.lifecycle:viewmodel:1.1.1'
        implementation 'android.arch.lifecycle:extensions:1.1.1'
        annotationProcessor 'android.arch.lifecycle:compiler:1.1.1'
        
2. Create your ViewModel e.g. LiveDataTimerViewModel

3. Edit in your View class

         // a. init ViewModel
         // b. create observer and override onChanged event
         // c. use viewModel.getYourLiveData.observe(this, observer)
         
4. When liveData changed by post value or set value, View will triggered onChanged event to do something about update UI   

### Demo

![Android Demo](https://github.com/u0652804/EasyExLiveData/blob/main/demo.png)
