package ru.itis.demo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    public MessageType type;
    public String content;
    public String sender;

    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }

}
