package Hotel.ReviewService.Repository;

import Hotel.ReviewService.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepo extends JpaRepository<Review, Integer> {
}
