package dat.entities;

import dat.enums.PoemType;
import jakarta.persistence.*;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Poem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private PoemType type;

    @Column(length = 1000) // Poem can be long, so a bigger column size
    private String poem;

    private String author;

    private String title;

    public Poem(PoemType type, String poem, String author, String title) {
        this.type = type;
        this.poem = poem;
        this.author = author;
        this.title = title;
    }
}