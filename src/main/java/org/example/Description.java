package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Description {
    @JsonProperty("participantInn")
    private String participantInn;

    public Description(String participantInn) {
        this.participantInn = participantInn;
    }

    public String getParticipantInn() {
        return participantInn;
    }

    public void setParticipantInn(String participantInn) {
        this.participantInn = participantInn;
    }
}
