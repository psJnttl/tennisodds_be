package tennisodds.service;

import java.util.Date;

/**
 *
 * @author Pasi
 */
public class PlayerStatisticsDto {
    private String name;
    private long matchesTotal;
    private Date from;
    private Date to;
    private long expectedWins;
    private long unExpectedWins;
    private long expectedLosses;
    private long unExpectedLosses;

    public PlayerStatisticsDto() {
    }

    public static class Builder {

        private String name;
        private long matchesTotal;
        private Date from;
        private Date to;
        private long expectedWins;
        private long unExpectedWins;
        private long expectedLosses;
        private long unExpectedLosses;

        private Builder() {
        }

        public Builder name(final String value) {
            this.name = value;
            return this;
        }

        public Builder matchesTotal(final long value) {
            this.matchesTotal = value;
            return this;
        }

        public Builder from(final Date value) {
            this.from = value;
            return this;
        }

        public Builder to(final Date value) {
            this.to = value;
            return this;
        }

        public Builder expectedWins(final long value) {
            this.expectedWins = value;
            return this;
        }

        public Builder unExpectedWins(final long value) {
            this.unExpectedWins = value;
            return this;
        }

        public Builder expectedLosses(final long value) {
            this.expectedLosses = value;
            return this;
        }

        public Builder unExpectedLosses(final long value) {
            this.unExpectedLosses = value;
            return this;
        }

        public PlayerStatisticsDto build() {
            return new tennisodds.service.PlayerStatisticsDto(name, matchesTotal, from, to, expectedWins, unExpectedWins, expectedLosses, unExpectedLosses);
        }
    }

    public static PlayerStatisticsDto.Builder builder() {
        return new PlayerStatisticsDto.Builder();
    }

    private PlayerStatisticsDto(final String name, final long matchesTotal, final Date from, final Date to, final long expectedWins, final long unExpectedWins, final long expectedLosses, final long unExpectedLosses) {
        this.name = name;
        this.matchesTotal = matchesTotal;
        this.from = from;
        this.to = to;
        this.expectedWins = expectedWins;
        this.unExpectedWins = unExpectedWins;
        this.expectedLosses = expectedLosses;
        this.unExpectedLosses = unExpectedLosses;
    }

    public String getName() {
        return name;
    }

    public long getMatchesTotal() {
        return matchesTotal;
    }

    public Date getFrom() {
        return from;
    }

    public Date getTo() {
        return to;
    }

    public long getExpectedWins() {
        return expectedWins;
    }

    public long getUnExpectedWins() {
        return unExpectedWins;
    }

    public long getExpectedLosses() {
        return expectedLosses;
    }

    public long getUnExpectedLosses() {
        return unExpectedLosses;
    }
    
    
    
}
