package xyz.bpena;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SlackMessage {
    private String username;
    private String text;
    private String icon_emoji;

    @Override
    public String toString() {
        return "{\"text\": \"" + text + "\"}";
    }
}
