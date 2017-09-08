package tennisodds.service;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Pasi
 */
public class StatsNode {
    private Date date;
    private long winner;
    private long loser;
    private double odds1;
    private double odds2;

    public static class Builder {

        private Date date;
        private Long winner;
        private Long loser;
        private double odds1;
        private double odds2;

        private Builder() {
        }

        public Builder date(final Date value) {
            this.date = value;
            return this;
        }

        public Builder winner(final Long value) {
            this.winner = value;
            return this;
        }

        public Builder loser(final Long value) {
            this.loser = value;
            return this;
        }

        public Builder odds1(final double value) {
            this.odds1 = value;
            return this;
        }

        public Builder odds2(final double value) {
            this.odds2 = value;
            return this;
        }

        public StatsNode build() {
            return new tennisodds.service.StatsNode(date, winner, loser, odds1, odds2);
        }
    }

    public static StatsNode.Builder builder() {
        return new StatsNode.Builder();
    }

    private StatsNode(final Date date, final Long winner, final Long loser, final double odds1, final double odds2) {
        this.date = date;
        this.winner = winner;
        this.loser = loser;
        this.odds1 = odds1;
        this.odds2 = odds2;
    }

    public Date getDate() {
        return date;
    }

    public Long getWinner() {
        return winner;
    }

    public Long getLoser() {
        return loser;
    }

    public double getOdds1() {
        return odds1;
    }

    public double getOdds2() {
        return odds2;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.date);
        hash = 71 * hash + Objects.hashCode(this.winner);
        hash = 71 * hash + Objects.hashCode(this.loser);
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.odds1) ^ (Double.doubleToLongBits(this.odds1) >>> 32));
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.odds2) ^ (Double.doubleToLongBits(this.odds2) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final StatsNode other = (StatsNode) obj;
        if (Double.doubleToLongBits(this.odds1) != Double.doubleToLongBits(other.odds1)) {
            return false;
        }
        if (Double.doubleToLongBits(this.odds2) != Double.doubleToLongBits(other.odds2)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.winner, other.winner)) {
            return false;
        }
        if (!Objects.equals(this.loser, other.loser)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StatsNode{" + "date=" + date + ", winner=" + winner + ", loser=" + loser + ", odds1=" + odds1 + ", odds2=" + odds2 + '}';
    }

    
}
