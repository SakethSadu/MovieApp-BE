package dev.saketh.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepo;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Reviews createReview(String reviewBody, String imdbId){
        /*Reviews review = reviewRepo.insert(new Reviews(reviewBody, imdbId));

        mongoTemplate.update(Movie.class).matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review)).first();

        return review;*/

        Reviews review = new Reviews(reviewBody, imdbId);
        reviewRepo.save(review);
        return review;
    }

    public List<Reviews> findReviewsByImdbId(String imdbId) {
        return reviewRepo.findByImdbId(imdbId);
    }
}
