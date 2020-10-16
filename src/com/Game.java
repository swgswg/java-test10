package com;

public class Game implements Comparable<Game> {
    private String name;
    private Integer score;

    public Game(String name, Integer score) {
        this.name = name;
        this.score = score;
    }


    @Override
    public int compareTo(Game o) {
        if(this.score < o.score) {
            return 1;
        } else if (this.score > o.score) {
            return -1;
        } else {
            return 0;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
