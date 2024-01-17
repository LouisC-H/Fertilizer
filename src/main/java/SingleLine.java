public class SingleLine implements Comparable<SingleLine>{

    private Long srcRangeStart;
    private Long srcRangeEnd;
    private Long offset;


    public SingleLine(String[] numberSplit) {
        long dstRangeStart = Long.parseLong(numberSplit[0]);
        this.srcRangeStart = Long.parseLong(numberSplit[1]);
        long rangeLength = Long.parseLong(numberSplit[2]);
        this.srcRangeEnd = srcRangeStart + rangeLength;
        this.offset = dstRangeStart - srcRangeStart;
    }

    public Long getSrcRangeStart() {
        return srcRangeStart;
    }

    public Long getSrcRangeEnd() {
        return srcRangeEnd;
    }

    public Long getOffset() {
        return offset;
    }

    @Override
    public int compareTo(SingleLine o) {
        return this.srcRangeStart.compareTo(o.getSrcRangeStart());
    }
}
