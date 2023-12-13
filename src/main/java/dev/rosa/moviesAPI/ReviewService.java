package dev.rosa.moviesAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String imdbId){
        Review review = reviewRepository.insert(new Review(reviewBody));

        // each movie has an array of reviews
        // add this review to its movie
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId")
                .is(imdbId)).apply(new Update()
                .push("reviewIds").value(review))
                .first();

        return review;
    }

}
