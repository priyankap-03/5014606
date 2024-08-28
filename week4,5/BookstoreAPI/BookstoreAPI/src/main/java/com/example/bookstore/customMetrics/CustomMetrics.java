package com.example.bookstore.customMetrics;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;
@Component
public class CustomMetrics {
    public CustomMetrics(MeterRegistry meterRegistry) {
        meterRegistry.counter("bookstore.books.viewed").increment();
        meterRegistry.gauge("bookstore.book.count", 100); // Dummy book count
    }
}
