package learningtest.io.github.bucket4j;

import io.github.bucket4j.Bucket;
import io.github.bucket4j.local.LocalBucket;
import org.junit.jupiter.api.Test;

import java.time.Duration;

/**
 * Tests for {@link Bucket}.
 *
 * @author Johnny Lim
 */
class BucketTests {

    @Test
    void refillGreedy() throws InterruptedException {
        LocalBucket bucket = Bucket.builder().addLimit((limit) -> limit.capacity(10).refillGreedy(2, Duration.ofMillis(100))).build();
        for (int i = 0; i < 100; i++) {
            System.out.println(System.currentTimeMillis() + " " + i + ": " + bucket.tryConsume(1));
            Thread.sleep(10);
        }
    }

}
