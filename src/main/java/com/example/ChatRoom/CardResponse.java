package com.example.ChatRoom;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CardResponse {
    private String name;

    @JsonProperty("image_uris")
    private ImageUris imageUris;

    public String getName() {
        return name;
    }

    public ImageUris getImageUris() {
        return imageUris;
    }

    public static class ImageUris {
        private String normal;

        public String getNormal() {
            return normal;
        }
    }
}
