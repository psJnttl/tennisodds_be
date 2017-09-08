package tennisodds.controller;

import java.util.Date;

/**
 *
 * @author Pasi
 */
public class DateRangeCmd {
    private long playerId;
    private Date start;
    private Date end;

    public DateRangeCmd() {
    }

    public DateRangeCmd(long playerId, Date start, Date end) {
        this.playerId = playerId;
        this.start = start;
        this.end = end;
    }

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    
}
