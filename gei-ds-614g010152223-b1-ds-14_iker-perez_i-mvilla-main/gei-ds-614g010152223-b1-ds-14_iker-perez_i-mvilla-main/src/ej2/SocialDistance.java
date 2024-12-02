package ej2;

public class SocialDistance {
    private static int countRound(char [][] layout, int i, int j){
        int count=0;
        if (j == 0) {
            if (layout[i-1][0] == '#')
                count++;
            if (layout[i - 1][1] == '#')
                count++;
            if (layout[i][1] == '#')
                count++;
            if (layout[i + 1][1] == '#')
                count++;
            if (layout[i + 1][0] == '#')
                count++;
        } else if (j==(layout[0].length-1)) {
            if (layout[i-1][j] == '#')
                count++;
            if (layout[i - 1][j-1] == '#')
                count++;
            if (layout[i][j-1] == '#')
                count++;
            if (layout[i + 1][j-1] == '#')
                count++;
            if (layout[i + 1][j] == '#')
                count++;
        } else if (i==0) {
            if (layout[0][j-1] == '#')
                count++;
            if (layout[1][j-1] == '#')
                count++;
            if (layout[1][j] == '#')
                count++;
            if (layout[1][j+1] == '#')
                count++;
            if (layout[0][j+1] == '#')
                count++;
        } else if (i==(layout.length-1)) {
            if (layout[i][j-1] == '#')
                count++;
            if (layout[i-1][j-1] == '#')
                count++;
            if (layout[i-1][j] == '#')
                count++;
            if (layout[i-1][j+1] == '#')
                count++;
            if (layout[i][j+1] == '#')
                count++;
        }else {
            if (layout[i-1][j-1] == '#')
                count++;
            if (layout[i-1][j] == '#')
                count++;
            if (layout[i-1][j+1] == '#')
                count++;
            if (layout[i][j-1] == '#')
                count++;
            if (layout[i][j+1] == '#')
                count++;
            if (layout[i+1][j-1] == '#')
                count++;
            if (layout[i+1][j] == '#')
                count++;
            if (layout[i+1][j+1] == '#')
                count++;
        }


        return count;

    }
    /**
     * Given the layout of a class with available sites marked with an ’A’ and
     * invalid sites marked with a ’. ’, returns the resulting layout with the
     * sites occupied by the students marked with a ’#’ following two rules :
     * - Students occupy an empty seat if there are no other adjacent students .
     * - A student leaves a seat empty if he/ she has 4 or more adjacent students .
     * @param layout The initial layout .
     * @return The resulting layout .
     * @throws IllegalArgumentException if the initial layout is invalid (is null ,
     * is ragged , includes characters other than ’.’ or ’A ’)).
     */
    public static char [][] seatingPeople ( char [][] layout ) {
        //comprueba que la matriz no es nula
        if (layout == null)
            throw new IllegalArgumentException();

        int i, j, row, col, count;
        row = layout.length; //filas
        col = layout[0].length; //columnas
        char[][] matrix= new char[row][col];
        for (i = 0; i <row; i++) {
            for (j = 0; j < col; j++) {
                if ((layout[i][j] != '.') && (layout[i][j] != 'A'))
                    throw new IllegalArgumentException();
            }
        }
        //comprobar que el layout no es irregular
        for (i = 0; i < row; i++){
            if(layout[i].length != col)
                throw new IllegalArgumentException();
        }

        //copiar layout a matrix
        for (i=0;i<row;i++){
            for (j=0;j<col;j++)
                matrix[i][j]=layout[i][j];
        }

        //cambio de esquinas
        if(layout[0][0]=='A')
            matrix[0][0]='#';
        if (layout[0][col-1]=='A')
            matrix[0][col-1]='#';
        if(layout[row-1][0]=='A')
            matrix[row-1][0]='#';
        if(layout[row-1][col-1]=='A')
            matrix[row-1][col-1]='#';


        boolean finish = false;
        while (!finish){
            count = 0;

            for(i=1; i<row-1; i++) {
                //lado izq
                if (layout[i][0] == 'A') {
                    if(col<2)
                        matrix[i][0] = '#';
                    else if (countRound(layout, i, 0) == 0)
                        matrix[i][0] = '#';

                }
                //lado dcho
                if (layout[i][col - 1] == 'A') {
                    if(col<2)
                        matrix[i][col-1] = '#';
                    else if (countRound(layout, i, col - 1) == 0)
                        matrix[i][col - 1] = '#';
                }
            }
            for (j=1; j<col-1; j++){
                //lado superior
                if (layout[0][j] == 'A') {
                    if(row<2)
                        matrix[0][j] = '#';
                    else if (countRound(layout, 0, j) == 0)
                        matrix[0][j] = '#';
                }
                //lado inferior
                if (layout[row - 1][j] == 'A') {
                    if(row<2)
                        matrix[row-1][j] = '#';
                    else if (countRound(layout, row - 1, j) == 0)
                        matrix[row - 1][j] = '#';
                }

            }
            //recorre posiciones internas de la matriz para sentarse
            for (i = 1; i <row-1; i++) {
                for (j = 1; j < col-1; j++) {
                    if (layout[i][j] == 'A') {
                        //recorre alrededor de la posicion si está ocupado

                        if (countRound(layout, i, j)==0)
                            matrix[i][j] = '#';
                    }
                }
            }

            //copia matrix a layout
            for (i=0;i<row;i++){
                for (j=0;j<col;j++)
                    layout[i][j]=matrix[i][j];
            }
            //levantarse
            for(i=1; i<row-1; i++) {
                //lado izq
                if (layout[i][0]=='#') {
                    if(col>=2) {
                        if (countRound(layout, i, 0) >=4) {
                            matrix[i][0] = 'A';
                            count++;
                        }
                    }
                }
                //lado dcho
                if (layout[i][col-1]=='#') {
                    if(col>=2) {
                        if (countRound(layout, i, col - 1) >=4) {
                            matrix[i][col - 1] = 'A';
                            count++;
                        }
                    }
                }
            }
            for (j=1; j<col-1; j++){
                //lado superior
                if (layout[0][j]=='#') {
                    if(row>=2) {
                        if (countRound(layout, 0, j) >=4) {
                            matrix[0][j] = 'A';
                            count++;
                        }
                    }
                }
                //lado inferior
                if (layout[row-1][j]=='#') {
                    if(row>=2) {
                        if (countRound(layout, row - 1, j) >=4) {
                            matrix[row - 1][j] = 'A';
                            count++;
                        }
                    }
                }
            }
            //recorre posiciones internas de la matriz para levantarse
            for (i = 1; i <row-1; i++) {
                for (j = 1; j < col-1; j++) {
                    if (layout[i][j]== '#') {
                        //recorre alrededor de la posicion si está ocupado
                        //libera asiento si imcumple la norma
                        if (countRound(layout, i, j) >=4){
                            matrix[i][j] = 'A';
                            count++;
                        }
                    }
                }
            }

            //copia matrix a layout
            for (i=0;i<row;i++){
                for (j=0;j<col;j++)
                    layout[i][j]=matrix[i][j];
            }

            if (count == 0)
                finish = true;
        }

        return layout;
    }
}