# Antigravity Rules for JobSaw

When operating in this project, adhere rigorously to the following rules:

## 1. Code & Architecture
- **Clean & Modular Code**: Write clean, modular code respecting Inversion of Control (IoC) and established design patterns.
- **Spring Ecosystem**: Follow the "Spring way" of writing code. Favor proper dependency injection over instantiation, use service layers, component definitions, and standard repository structures.
- **Annotation-Heavy**: Use as many appropriate Spring and Java annotations as possible to reduce boilerplate and cleanly define component roles.
- **Scalable & Extensible**: Always design and write code in a way that minimizes technical debt and makes it easy to build upon later.

## 2. Logging & Observability
- **Log Everything**: Extensively log all significant events, data transformations, and system states. This is critical for thorough debugging and later audit purposes.

## 3. Comments, Console & Formatting
- **English Only**: All comments, documentation, and logging must be exclusively in English.
- **Strictly No Emojis**: Do not use any emojis in comments, prints, logs, or string outputs. 
- **No "GPT Commas"**: Write strict, direct, professional communication without excessive conversational filler, formatting quirks, or unnecessary fluff.
- **Constant & Simple Comments**: Provide consistent, simple comments. Give enough context to understand *what* is happening and *why*, but avoid over-explaining obvious code blocks.

## 4. File Structure & Project Maintenance
- **Smart File Structure**: Ensure a highly logical, smart, well-designed file and package structure (e.g., standard Maven/Spring Boot packages: `controllers`, `services`, `repositories`, `models`, `config`, etc.).
- **Git Hygiene**: Actively use and maintain `.gitignore` configurations wherever files should not be tracked by source control.
- **Dynamic README**: Always update `README.md` to reflect any new components, logic changes, or architectural decisions made during development.

## 5. Problem Solving & Learning
- **Search Before Guessing**: If you do not know something or are unsure about an implementation detail, DO NOT guess. Search the internet for the appropriate documentation.
- **Verify Official & Latest Sources**: Before choosing a documentation source or solution, verify that it is the **official documentation** and the **latest version** available. 
- **Learn First, Implement Second**: Act like a thorough programmer who learns and understands the tool, library, or framework first before attempting to implement the code.
