package per.noah.easy_ex_livedata;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.TextView;

import per.noah.easy_ex_livedata.ViewModel.LiveDataTimerViewModel;

import static per.noah.easy_ex_livedata.Until.enableTimber;

public class MainActivity extends AppCompatActivity {

    private LiveDataTimerViewModel liveDataTimerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init Timber
        new Until().initTimber(enableTimber);

        // instance viewModel and observe liveData
        initViewModels();
        createAndObserveObservers();
    }

    private void initViewModels() {
//        liveDataTimerViewModel = new ViewModelProvider(this, null).get(LiveDataTimerViewModel.class);
        liveDataTimerViewModel = ViewModelProviders.of(this).get(LiveDataTimerViewModel.class);
    }

    private void createAndObserveObservers() {
        // create observers
        final Observer<Long> elapsedTimeObserver = new Observer<Long>() {
            @Override
            public void onChanged(@Nullable final Long aLong) {
                ((TextView)findViewById(R.id.text1)).setText(aLong.toString());
            }
        };

        // observe LiveData
        liveDataTimerViewModel.getElapsedTime().observe(this, elapsedTimeObserver);
    }
}