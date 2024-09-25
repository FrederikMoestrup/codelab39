package dat.dtos;

import dat.entities.Poem;

public class PoemDTO {

    private String poem;

    private String author;

    private String title;

    public PoemDTO(Poem poem) {
        this.poem = poem.getPoem();
        this.author = poem.getAuthor();
        this.title = poem.getTitle();
    }

}
