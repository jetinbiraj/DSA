package com.app.google;

public record Pair<K, V>(K key, V value) {

    @Override
    public K key() {
        return key;
    }

    @Override
    public V value() {
        return value;
    }
}
