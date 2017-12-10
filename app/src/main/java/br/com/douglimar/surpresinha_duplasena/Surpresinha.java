package br.com.douglimar.surpresinha_duplasena;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Douglimar Moraes on 02/12/17.
 *
 *
 */

class Surpresinha {

    public String generateDuplaSenaGame() {

        /* Regra do Jogo:
	    * O apostador pode escolher 6 numeros entre 50 numeros disponiveis
	    */

        int numsDuplaSena[] = new int[6];

        int indice;
        Random random = new Random();
        StringBuilder Retorno = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            indice = random.nextInt(51);

            for (int k = 0; k < 50; k++) {
                if (consisteJogo(numsDuplaSena, indice) || indice == 0) {
                    indice = random.nextInt(51);
                }
            }
            numsDuplaSena[i] = indice;
        }

        Arrays.sort(numsDuplaSena);

        for (int i = 0; i < 6; i++) {

            if (numsDuplaSena[i] < 10)
                Retorno.append(" 0").append(numsDuplaSena[i]);
            else
                Retorno.append(" ").append(numsDuplaSena[i]);
        }

        return Retorno.toString();

    }


    private boolean consisteJogo(int pArray[], int PNumero) {

        boolean Retorno = false;

        for (int aPArray : pArray) {
            if (aPArray == PNumero) {
                Retorno = true;
                break;
            }
        }

        return Retorno;
    }

}
