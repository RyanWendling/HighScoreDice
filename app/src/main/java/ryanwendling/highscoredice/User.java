package ryanwendling.highscoredice;

/**
 * Created by wendlir on 5/7/17.
 */
public class User {

    private String _id;
    private int _score;

    public User() {

    }

    public User(String id, int score) {
        this._id = id;
        this._score = score;
    }

    public void setID(String id) {
        this._id = id;
    }

    public String getID() {
        return this._id;
    }

    public void setScore(int score) {
        this._score = score;
    }

    public int getScore() {
        return this._score;
    }
}
