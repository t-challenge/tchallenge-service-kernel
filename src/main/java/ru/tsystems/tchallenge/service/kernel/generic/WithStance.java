package ru.tsystems.tchallenge.service.kernel.generic;

public interface WithStance extends Comparable<WithStance> {

    Integer getStance();

    default int compareTo(WithStance another) {
        return Integer.compare(this.getStance(), another.getStance());
    }
}
