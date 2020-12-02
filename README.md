# EasyExLiveData
a easy case to study live data

### step by step

1. Add dependce in build.gradle

        // liveData and ViewModel
        implementation 'android.arch.lifecycle:viewmodel:1.1.1'
        implementation 'android.arch.lifecycle:extensions:1.1.1'
        annotationProcessor 'android.arch.lifecycle:compiler:1.1.1'
        
2. Create your ViewModel e.g. LiveDataTimerViewModel

3. Edit in your View class(Activity or fragment)

         // a. init ViewModel
         // b. create observer and override onChanged event
         // c. use viewModel.getYourLiveData.observe(this, observer)
         
4. When liveData changed by post value or set value, View will triggered onChanged event to do something about update UI   

### Part of coding

ViewModel :
        
        public class LiveDataTimerViewModel extends ViewModel {
            private MutableLiveData<Long> mElapsedTime;
            ...
            // this function let View can observer liveData in this ViewModel
            public MutableLiveData<Long> getElapsedTime() {
                if (null == mElapsedTime){
                    mElapsedTime = new MutableLiveData<>();
                }
                return mElapsedTime;
            }
View :
        
        public class MainActivity extends AppCompatActivity {
            private LiveDataTimerViewModel liveDataTimerViewModel;
            ...
            protected void onCreate(Bundle savedInstanceState) {
                // 1. init ViewModel
                liveDataTimerViewModel = ViewModelProviders.of(this).get(LiveDataTimerViewModel.class);
                // 2. create observers
                final Observer<Long> elapsedTimeObserver = new Observer<Long>() {
                    @Override
                    public void onChanged(@Nullable final Long aLong) {
                        // 5. update UI
                        ((TextView)findViewById(R.id.text1)).setText(aLong.toString());
                    }
                };               
                // 3. observe LiveData by get it from ViewModel and bind lifeCycle of this View
                liveDataTimerViewModel.getElapsedTime().observe(this, elapsedTimeObserver);
            }
            // 4. ... do someMethod cause liveData change value

### Demo

![Android Demo](https://github.com/u0652804/EasyExLiveData/blob/main/demo.png)
