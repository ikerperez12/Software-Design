package ej4;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public enum MovieRating{
    NOT_RATED(-1), AWFUL(0), BAD(2), MEDIOCRE(4), GOOD(6), EXCELLENT(8), MASTERPIECE(10);
    public int nota;
    MovieRating(int nota){
        this.nota = nota;
    }


    public int getNumericRating(){
        return nota;
    }


/**
    public boolean isBetterThan(MovieRating a){
        if(int NumericRating >a.getNumericRating()){
            return true;
        }else{
            return false;
        }
    } */
}