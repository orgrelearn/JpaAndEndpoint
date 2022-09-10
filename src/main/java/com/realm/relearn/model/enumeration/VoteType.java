package com.realm.relearn.model.enumeration;
import com.realm.relearn.exceptions.VoteTypeNotFoundException;

import java.util.Arrays;

public enum VoteType {
    UPVOTE(1), DOWNVOTE(-1);
    private int direction;
    private VoteType(int direction) {
        this.direction =direction;
    }

    // I don't see the use of this method
    public static VoteType lookup(Integer direction) {
        return Arrays.stream(VoteType.values())
                .filter(value -> value.getDirection().equals(direction))
                .findAny()
                .orElseThrow(() -> new VoteTypeNotFoundException("Vote not found"));
    }

    public Integer getDirection() {
        return direction;
    }
}