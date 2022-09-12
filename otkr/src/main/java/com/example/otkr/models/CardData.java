package com.example.otkr.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CardData {
    public String  tarif;
    public Status status;
    public String cardID;
    public String cardHolderName;
}
