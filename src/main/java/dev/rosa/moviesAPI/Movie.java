package dev.rosa.moviesAPI;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "movies")
// lombok
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLInk;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;
    @DocumentReference  // store only the ids of the review and the reviews will be stored on a different location
    private List<Review> reviewIds;

}
