package com.example.msgsys.sharedlib.model;

import java.io.Serializable;

public class IngestMessage implements Serializable {

    private static final long serialVersionUID = 6462645650014741587L;
    private String id;
    private String body;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "IngestMessage{" +
                "id='" + id + '\'' +
                ", body='" + body + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof IngestMessage)) {
            return false;
        }

        IngestMessage that = (IngestMessage) o;

        if (id != null ? !id.equals(that.id) : that.id != null) {
            return false;
        }
        return body != null ? body.equals(that.body) : that.body == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (body != null ? body.hashCode() : 0);
        return result;
    }
}
