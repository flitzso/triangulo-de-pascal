import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {

    protected List<List<Integer>> generatePascalTriangle(int nbRows){
        // Validação de entrada
        if ( nbRows < 0 )
            throw new IllegalArgumentException( "O número de linhas não pode ser negativo." );

        // O objeto a devolver
        List<List<Integer>> toReturn = new LinkedList<List<Integer>>();

        // Salve a linha anterior.
        List<Integer> previousRow = Collections.emptyList();

        // Processe todas as linhas
        for( int i = 0 ; i <= nbRows ; i++ ){
            // Crie a linha atual
            List<Integer> currentRow = new LinkedList<Integer>();
            toReturn.add( currentRow );

            // Definir o valor anterior
            int previousValue = 0;
            // Loop em todos os valores
            for(int c : previousRow){
                currentRow.add( c + previousValue );

                // Definir o valor atual como o anterior
                previousValue = c;
            }


            // Adicione o último valor
            currentRow.add( 1 );

            // Salve a linha atual.
            previousRow = currentRow;
        }

        return toReturn;
    }

    public static void main(String[] argv) throws Exception {
        Main t = new Main();


        List<List<Integer>> res = t.generatePascalTriangle(7);

        System.out.println( "Resultado:" );
        String tmp = res.get( res.size() -1 ).toString();

        int max = (int) tmp.length();

        for(List<Integer> c : res ){
            String toDisplay = c.toString();
            int padding = ( max - toDisplay.length()) / 2 ;
            StringBuilder sb = new StringBuilder();
            for(int i=0; i < padding; i++){
                sb.append( " " );
            }

            sb.append( toDisplay );

            System.out.println( sb.toString() );
        }

    }



}