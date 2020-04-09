package co.asterv.popularmoviesstage1;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.annotation.NonNull;

import co.asterv.popularmoviesstage1.database.AppDatabase;
import co.asterv.popularmoviesstage1.model.Movie;

public class MainViewModel extends AndroidViewModel {

    private LiveData<Movie[]> movies;

    public MainViewModel(@NonNull Application application) {
        super (application);
        AppDatabase database = AppDatabase.getInstance (this.getApplication ());
        movies = database.movieDao ().loadAllMovies ();
    }

    public LiveData<Movie[]> getMovies() {
        return movies;
    }
}
