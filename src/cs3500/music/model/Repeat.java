package cs3500.music.model;

/**
 * Represents a section of a SongRep that should be repeated.
 */
public final class Repeat {
    private int startBeat;
    private int endBeat;
    private int repeatCount;
    private int initialRepeats;

    /**
     * @throws IllegalAccessException you should never use this constructor
     */
    public Repeat() {
        throw new IllegalArgumentException("Please don't do this");
    }

    /**
     * @param start the beginning of the repeat
     * @param end the end of the repeat / when to repeat
     * @param count the amount of times this section should be repeated
     */
    public Repeat(int start, int end, int count) {
        if (start < 0 || end < 0 || count < 0) {
            throw new IllegalArgumentException("Repeat cannot take negative values");
        }

        if (Math.abs(start - end) < 1) {
            throw new IllegalArgumentException("Repeats must span at least one beat");
        }

        if (start > end) {
            throw new IllegalArgumentException("Start must come before end");
        }

        if (start % 4 != 0 || end % 4 != 0) {
            throw new IllegalArgumentException("Repeats must start at the beginning or " +
                    "end of a measure");
        }

        if (count <= 0) {
            throw new IllegalArgumentException("Repeats must repeat at least once");
        }

        this.startBeat = start;
        this.endBeat = end;
        this.repeatCount = count;
        this.initialRepeats = count;
    }

    /**
     * @return the starting beat of the repeat
     */
    public int getStart() {
        return startBeat;
    }

    /**
     * @return the ending beat of the repeat
     */
    public int getEnd() {
        return endBeat;
    }

    /**
     * @return the remaining repeats left on this repeat
     */
    public int getCount() {
        return repeatCount;
    }

    /**
     * Decreases the amount of repeats left; doesn't go below zero.
     */
    public void decreaseRepeats() {
        this.repeatCount = Math.max(0, repeatCount - 1);
    }

    /**
     * Resets the repeats to their original state (as if they had not been played)
     */
    public void resetCount() {
        this.repeatCount = this.initialRepeats;
    }
}
