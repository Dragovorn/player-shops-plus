package com.dragovorn.pcp.entity.trade;

import java.util.UUID;

public class TradeKey {

    private final UUID first;
    private final UUID second;

    public TradeKey(UUID first, UUID second) {
        this.first = first;
        this.second = second;
    }

    public UUID getFirst() {
        return this.first;
    }

    public UUID getSecond() {
        return this.second;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof TradeKey)) {
            return false;
        }

        TradeKey other = (TradeKey) object;

        return (this.first.equals(other.first) || this.first.equals(other.second))
                && (this.second.equals(other.first) || this.second.equals(other.second));
    }

    @Override
    public int hashCode() {
        return this.first.hashCode() + this.second.hashCode();
    }
}
