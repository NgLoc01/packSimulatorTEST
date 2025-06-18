package com.example.ChatRoom;

//import java.time.LocalTime;

public class OutputMessage {
    private String from;
    private String content;
    private String time;
    private String cardName;
    private String cardImage;

    public OutputMessage(String from, String content, String time, String cardName, String cardImage) {
        this.from = from;
        this.content = content;
        this.time = time;
        this.cardName = cardName;
        this.cardImage = cardImage;
    }

    // Getters (needed for JSON serialization)
    public String getFrom() { return from; }
    public String getContent() { return content; }
    public String getTime() { return time; }
    public String getCardName() { return cardName; }
    public String getCardImage() { return cardImage; }
}

