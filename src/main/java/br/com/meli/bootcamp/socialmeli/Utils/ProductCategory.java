package br.com.meli.bootcamp.socialmeli.Utils;

public enum ProductCategory {

    VARINHAS(0),
    CORUJAS(1),
    CALDEIRÕES(2),
    CAPAS(3),
    DOCES(4),
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
