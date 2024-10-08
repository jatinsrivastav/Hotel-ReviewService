package Hotel.ReviewService.Service;


import Hotel.ReviewService.Entity.Review;
import Hotel.ReviewService.Repository.ReviewRepo;
import Hotel.ReviewService.dto.ReviewDTO;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepo reviewRepo;

    @Autowired
    private ModelMapper modelMapper;


    public Review postReview(ReviewDTO reviewDTO) {
        Review review = modelMapper.map(reviewDTO, Review.class);
        return reviewRepo.save(review);
    }

    public Review updateReview(ReviewDTO reviewDTO) {
        Review review = modelMapper.map(reviewDTO, Review.class);
        reviewRepo.findById(review.getId()).orElseThrow(() -> new EntityNotFoundException("not found"));
        return reviewRepo.save(review);
    }

    public void deletebyId(Integer reviewId) {
        reviewRepo.findById(reviewId).orElseThrow(() -> new EntityNotFoundException("not found"));
        reviewRepo.deleteById(reviewId);

    }

    public List<Review> getAllReview() {
        return reviewRepo.findAll();
    }
}
