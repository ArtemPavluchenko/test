/**
 * Created by Gwindblaid on 16.05.2016.
 */
public class Book {
    private String name;
    private String autor;
    private String publishing;
    private int publishingYear;
    private int numOfPages;
    private int price;
    private String typeOfBinding;

    public void setName(String name) {
        this.name = name;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setPublishing(String publishing) {
        this.publishing = publishing;
    }

    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }

    public void setPrise(int price) {
        this.price = price;
    }

    public void setTypeOfBinding(String typeOfBinding) {
        this.typeOfBinding = typeOfBinding;
    }

    public String getName() {
        return name;
    }

    public String getAutor() {
        return autor;
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public int getPrice() {
        return price;
    }

    public String getPublishing() {
        return publishing;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public String getTypeOfBinding() {
        return typeOfBinding;
    }

    @Override
    public String toString() {

        return "Название "+name+"\n"+"Автор "+autor+"\n"+"Издательство: "+publishing+"\n"+"Год издательства: "+
                publishingYear+"\n"+"Количество страниц: "+numOfPages+"\n"+"Тип переплета: "+typeOfBinding+"\n"+
                "Цена: "+price+" грн"+"\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (publishingYear != book.publishingYear) return false;
        if (numOfPages != book.numOfPages) return false;
        if (price != book.price) return false;
        if (name != null ? !name.equals(book.name) : book.name != null) return false;
        if (autor != null ? !autor.equals(book.autor) : book.autor != null) return false;
        if (publishing != null ? !publishing.equals(book.publishing) : book.publishing != null) return false;
        return typeOfBinding != null ? typeOfBinding.equals(book.typeOfBinding) : book.typeOfBinding == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (autor != null ? autor.hashCode() : 0);
        result = 31 * result + (publishing != null ? publishing.hashCode() : 0);
        result = 31 * result + publishingYear;
        result = 31 * result + numOfPages;
        result = 31 * result + price;
        result = 31 * result + (typeOfBinding != null ? typeOfBinding.hashCode() : 0);
        return result;
    }
}
