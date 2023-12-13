package dev.rosa.moviesAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired      //the framework instantiates this class for us
    private MovieRespository movieRepository;

    public List<Movie> AllMovies(){
        return movieRepository.findAll();
    }

    public Optional<Movie> SingleMovie(String id){
        return movieRepository.findMovieByimdbId(id);
    }
}
