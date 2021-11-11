package com.rockset.jdbc;

import static com.google.common.base.Preconditions.checkArgument;
import static java.util.Objects.requireNonNull;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This {@code Iterator} is like Guava's {@code Iterators.limit()} but uses a {@code long} limit
 * instead of {@code int}.
 */
final class LengthLimitedIterator<T> implements Iterator<T> {
  private final Iterator<T> iterator;
  private final long limit;
  private long count;

  public LengthLimitedIterator(Iterator<T> iterator, long limit) {
    checkArgument(limit >= 0, "limit is negative");
    this.iterator = requireNonNull(iterator, "iterator is null");
    this.limit = limit;
  }

  @Override
  public boolean hasNext() {
    return count < limit && iterator.hasNext();
  }

  @Override
  public T next() {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    count++;
    return iterator.next();
  }
}
