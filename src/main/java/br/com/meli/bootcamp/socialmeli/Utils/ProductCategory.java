package br.com.meli.bootcamp.socialmeli.Utils;

public enum ProductCategory {

    CADEIRAS(0),
    MESAS(1),
    MONITORES(2),
    TECLADOS(3),
    MOUSES(4),
    VASSOURAS(5);

    private int value;

    ProductCategory(int value) {
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
