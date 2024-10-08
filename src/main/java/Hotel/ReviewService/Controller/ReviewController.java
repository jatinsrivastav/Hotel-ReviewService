package Hotel.ReviewService.Controller;


import Hotel.ReviewService.Entity.Review;
import Hotel.ReviewService.Service.ReviewService;
import Hotel.ReviewService.dto.ReviewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;


    @PostMapping("/reviews")
    public ResponseEntity<Review> postReview(@RequestBody ReviewDTO reviewDTO) {
        return new ResponseEntity<>(reviewService.postReview(reviewDTO), HttpStatus.OK);
    }


    // GET /reviews/hotel/{hotelId}   get review from the Hotel

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReview(){
        return new ResponseEntity<>(reviewService.getAllReview(), HttpStatus.OK);
    }

    @PutMapping("/reviews")
    public ResponseEntity<Review> updateReview(@RequestBody ReviewDTO reviewDTO) {
        return new ResponseEntity<>(reviewService.updateReview(reviewDTO), HttpStatus.OK);
    }


    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<Void> deleteReview(@PathVariable Integer reviewId){
        reviewService.deletebyId(reviewId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
