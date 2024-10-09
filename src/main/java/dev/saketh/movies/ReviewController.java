package dev.saketh.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/reviews")
@CrossOrigin(origins = "*")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Reviews> createReviews(@RequestBody Map<String,String> payload){
        return new ResponseEntity<Reviews>(reviewService.createReview(payload.get("reviewBody"),payload.get("imdbId")), HttpStatus.CREATED);

    }

    @GetMapping("/movie/{imdbId}")
    public ResponseEntity<List<Reviews>> getReviewsByImdbId(@PathVariable String imdbId) {
        List<Reviews> reviews = reviewService.findReviewsByImdbId(imdbId);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }
}
