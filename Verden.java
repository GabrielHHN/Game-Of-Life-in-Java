public class Verden {
    Rutenett rutenett;
    int genNr = 0;
    int rader;
    int kolonner;

    public Verden(int r, int k){
        rader = r;
        kolonner = k;
        rutenett = new Rutenett(rader,kolonner);
        rutenett.fyllMedTilfeldigeCeller();
        rutenett.kobleAlleCeller();

    }

    public void tegn(){
        rutenett.tegnRutenett();
        System.out.println();
        System.out.println("Generasjon: " + genNr);
        System.out.println("Antall levende celler = " + rutenett.antallLevende());
        System.out.println();
    }

    public void oppdatering(){
        for (int i = 0; i < rader; i++){
            for (int j = 0; j < kolonner; j++){
                rutenett.hentCelle(i,j).tellLevendeNaboer();
            }
        }
        for (int i = 0; i < rader; i++){
            for (int j = 0; j < kolonner; j++){
                rutenett.hentCelle(i,j).oppdaterStatus();
            }
        } 
        genNr += 1;
    }
}
