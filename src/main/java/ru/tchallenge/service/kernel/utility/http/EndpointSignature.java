package ru.tchallenge.service.kernel.utility.http;

import java.io.Serializable;

import com.google.common.base.Objects;

public final class EndpointSignature implements Serializable {

    public static final class Builder {

        private String method;
        private String uri;

        public EndpointSignature build() {
            if (method == null) {
                throw new NullPointerException("endpoint method is required");
            }
            if (uri == null) {
                throw new NullPointerException("endpoint uri is required");
            }
            return new EndpointSignature(this);
        }

        public Builder method(final String method) {
            this.method = method;
            return this;
        }

        public Builder uri(final String uri) {
            this.uri = uri;
            return this;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    private final String method;
    private final String uri;

    private EndpointSignature(final Builder builder) {
        this.method = builder.method;
        this.uri = builder.uri;
    }

    public String getMethod() {
        return method;
    }

    public String getUri() {
        return uri;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        final EndpointSignature another = (EndpointSignature) object;
        return Objects.equal(method, another.method) && Objects.equal(uri, another.uri);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(method, uri);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).toString();
    }
}
