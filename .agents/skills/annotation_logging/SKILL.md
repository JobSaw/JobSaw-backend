---
description: How to log activity and method execution in JobSaw using the @Loggable annotation
---
# Annotation-Based Logging

In the JobSaw backend, we enforce strict, clean code aligned with the "Spring Way". 
As a rule, **business-level logical logging should be done cleanly via annotations** rather than polluting methods with manual `logger.info()` or `logger.debug()` calls.

When generating or editing a component (like a Controller or a Service), apply the custom `@Loggable` annotation to the method. 

## Requirements
- Target annotation: `com.jobsaw.jobsaw.logging.Loggable`
- It accepts an optional `value` parameter to specify the action taking place (e.g., `@Loggable("Processing User CV")`).

## Example Usage

### Bad Approach (Manual Logging)
```java
@Service
public class DocumentService {
    private static final Logger logger = LoggerFactory.getLogger(DocumentService.class);

    public void processDocument(String docId) {
        logger.info("Processing document: {}", docId);
        // Business logic...
        logger.info("Finished processing document.");
    }
}
```

### Good Approach (AOP Annotation)
```java
import com.jobsaw.jobsaw.logging.Loggable;

@Service
public class DocumentService {

    @Loggable("Process Document")
    public void processDocument(String docId) {
        // Business logic...
        // The LoggingAspect will automatically trace entry, exit, execution time, and arguments!
    }
}
```

## When to Use Manual Logging
Manual `LoggerFactory.getLogger(...)` usages are still allowed **inside** complex methods when you need to log an inner loop iteration, a granular state change deep in logic, or a specific caught exception that isn't being thrown upwards. However, method tracing (entry/exit) MUST use `@Loggable`.
