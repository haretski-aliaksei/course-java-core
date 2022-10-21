package com.rakovets.course.java.core.practice.jcf_list.comparator;

import com.rakovets.course.java.core.practice.jcf_list.project_studio.Actor;

import java.util.Comparator;

public class ActorLastNameAgeComparator implements Comparator<Actor> {
    @Override
    public int compare(Actor actor1, Actor actor2) {
        var result = actor1.getLastName().compareTo(actor2.getLastName());
        if (result == 0) {
            return Integer.compare(actor1.getAge(), actor2.getAge());
        } else {
            return result;
        }
    }
}
