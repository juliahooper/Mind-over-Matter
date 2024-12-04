public class inputVerification{
    public void mood(int moodRatings) {
        if (moodRatings < 1 || moodRatings > 10) {
            throw new IllegalArgumentException("Mood rating must be between 1 and 10");
        }

    }
}

