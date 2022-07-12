package Practic.Final;

public enum Ships {

    SHIP("\uD83D\uDFE9"), EMPTY("\uD83D\uDFE6"), AREAL("\uD83D\uDFEA"), BROKEN("\uD83D\uDD25");

    private String picture;

    Ships(String picture) {
        this.picture = picture;
    }

    public String getPicture(){
        return picture;
    }

    @Override
    public String toString() {
        return picture;
    }
}
