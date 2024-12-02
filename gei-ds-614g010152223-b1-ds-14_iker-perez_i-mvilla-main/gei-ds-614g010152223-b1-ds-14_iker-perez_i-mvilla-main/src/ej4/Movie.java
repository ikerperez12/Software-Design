package ej4;

public class Movie {
    public enum MovieRating{
        NOT_RATED(null), AWFUL(0), BAD(2), MEDIOCRE(4), GOOD(6), EXCELLENT(8), MASTERPIECE(10);
        MovieRating(Integer i) {
        }

    }
    String title;
    private MovieRating movieRating;
    /**
     * Creates a new movie with the list of ratings empty .
     * @param title Movie title .
     */
    public Movie ( String title ) {
        this.title = title;
    }
    /**
     * Returns the movie title
     * @return the movie title .
     */
    public String getTitle () {
        return title;
    }
    /**
     * Inserts a new movieRating .
     * It is allowed to insert NOT_RATED .
     * @param movieRating MovieRating to be inserted .
     */
    public void insertRating ( MovieRating movieRating ) {
        this.movieRating = movieRating;
    }
    /**
     * Check if this movie has any rating .
     * @return true if and only if there is a valuation other than NOT_RATED .
     */
    private boolean isRated () {
        return this.movieRating == null;
    }
    /**
     * Gets the highest rating for this movie .
     * @return maximum rating ; or NOT_RATED if there are no ratings .
     */

    /**
     * Calculate the numerical average rating of this movie .
     * NOT_RATED values are not considered .
     * @return Numerical average rating of this movie .
     * @throws java . util . NoSuchElementException if there are no valid ratings .
     */
    public double averageRating () { return 0;
}
}