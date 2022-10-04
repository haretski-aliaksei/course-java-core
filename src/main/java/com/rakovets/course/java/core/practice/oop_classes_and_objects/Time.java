package com.rakovets.course.java.core.practice.oop_classes_and_objects;

public class Time {
    private int hours;
    private int minutes;
    private int seconds;
    final static int SECONDS_IN_MINUTE = 60;
    final static int SECONDS_IN_HOUR = 3600;

    public Time(int totalSeconds) {
        this.hours = totalSeconds / SECONDS_IN_HOUR;
        this.minutes = (totalSeconds % SECONDS_IN_HOUR) / SECONDS_IN_MINUTE;
        this.seconds = (totalSeconds % SECONDS_IN_HOUR) % SECONDS_IN_MINUTE;
    }

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getTotalSeconds() {
        int totalSeconds;
        final int SECONDS_IN_MINUTE = 60;
        final int SECONDS_IN_HOUR = 3600;

        int convertedHours = getHours() == 0 ? 0 : getHours() * SECONDS_IN_HOUR;
        int convertedSeconds = getSeconds() == 0 ? 0 : getMinutes() * SECONDS_IN_MINUTE;

        totalSeconds = convertedHours + convertedSeconds + getSeconds();
        return totalSeconds;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }
}
