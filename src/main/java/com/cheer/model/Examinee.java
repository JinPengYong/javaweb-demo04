package com.cheer.model;

public class Examinee {
    private String num;
    private String password;
    private int correct;
    private int wrong;
    private int score;
    private String result;

    public Examinee() {
    }

    public Examinee(String num, int correct, int wrong, int score, String result) {
        this.num = num;
        this.correct = correct;
        this.wrong = wrong;

        this.score = score;
        this.result = result;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public int getWrong() {
        return wrong;
    }

    public void setWrong(int wrong) {
        this.wrong = wrong;
    }


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Examinee{" +
                "num='" + num + '\'' +
                ", password='" + password + '\'' +
                ", correct=" + correct +
                ", wrong=" + wrong +
                ", score=" + score +
                ", result='" + result + '\'' +
                '}';
    }
}
