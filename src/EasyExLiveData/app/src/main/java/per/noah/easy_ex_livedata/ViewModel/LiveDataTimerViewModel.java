package per.noah.easy_ex_livedata.ViewModel;

import android.os.SystemClock;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Timer;
import java.util.TimerTask;

public class LiveDataTimerViewModel extends ViewModel {

    private static final int ONE_SECOND = 1000;

    private MutableLiveData<Long> mElapsedTime;

    private long mInitialTime;

    /**
     * simulation data change per second
     */
    public LiveDataTimerViewModel() {
        mInitialTime = SystemClock.elapsedRealtime();
        Timer timer = new Timer();
        // Update the elapsed time every second.
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                final long newValue = (SystemClock.elapsedRealtime() - mInitialTime) / 1000;
                // setValue() cannot be called from a background thread so post to main thread.
                getElapsedTime().postValue(newValue);
            }
        }, ONE_SECOND, ONE_SECOND);
    }

    public MutableLiveData<Long> getElapsedTime() {
        if (null == mElapsedTime){
            mElapsedTime = new MutableLiveData<>();
        }
        return mElapsedTime;
    }
}
