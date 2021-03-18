package compulsory;

public class Book extends Item {
    String author;
    int pageNumber;

    //constructor

    public Book() {
    }

    public Book(String id, String name, String path, String author, int pageNumber) throws InvalidItemData {
        this.setId(id);
        this.setName(name);
        this.setLocation(path);
        this.setAuthor(author);
        this.setPageNumber(pageNumber);
    }

    //setters and getters

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) throws InvalidItemData {
        if (author == null) throw new InvalidItemData(" no author name.");
        this.author = author;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) throws InvalidItemData {
        if (pageNumber < 0) throw new InvalidItemData(" negative number of pages.");
        this.pageNumber = pageNumber;
    }

    @Override
    public String toString() {
        return  "author='" + author + '\'' +
                ", pageNumber=" + pageNumber;
    }
}
