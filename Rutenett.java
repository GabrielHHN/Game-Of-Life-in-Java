
public class Rutenett {
    int antRader;
    int antKolonner;
    Celle[][] rutene;

    public Rutenett(int rader, int kolonner){
        antRader = rader;
        antKolonner = kolonner;

        rutene = new Celle[rader][kolonner];
    }

    public void lagCelle(int rad, int kol){
        Celle celle = new Celle();
        boolean randomEnTreDel = Math.random() <= 0.3333;

        if (randomEnTreDel){
            rutene[rad][kol] = celle;
            celle.settLevende();
        }
        else{
            rutene[rad][kol] = celle;
            celle.settDød();
        }

    }

    public void fyllMedTilfeldigeCeller(){
        for (int rad = 0; rad <= antRader - 1; rad++){
            for (int kol = 0; kol <= antKolonner - 1; kol++){
                lagCelle(rad,kol);
            }
        }
    }

    public Celle hentCelle(int rad, int kol){
        if (rad <= antRader - 1){
            if (rad < 0){
                return null;
            }
            else{
                if (kol <= antKolonner - 1){
                    if (kol < 0){
                        return null;
                    }
                    else{
                        return rutene[rad][kol];
                    }
                }
                else{
                    return null;
                }
            }
        }
        else{
            return null;
        }
    }

    public void tegnRutenett(){
        System.out.println();
        System.out.println();
        System.out.println();
        

        for (int rad = 0; rad <= antRader - 1; rad++){
            System.out.println();
            for (int kol = 0; kol <= antKolonner - 1; kol++){
                    System.out.print(hentCelle(rad, kol).hentStatusTegn());
                
            }
        }
        System.out.println();
    }

    public void settNaboer(int rad, int kolonne){
        hentCelle(rad,kolonne).leggTilNabo(hentCelle(rad-1,kolonne-1));
        hentCelle(rad,kolonne).leggTilNabo(hentCelle(rad,kolonne-1));
        hentCelle(rad,kolonne).leggTilNabo(hentCelle(rad+1,kolonne-1));
        hentCelle(rad,kolonne).leggTilNabo(hentCelle(rad-1,kolonne));
        hentCelle(rad,kolonne).leggTilNabo(hentCelle(rad-1,kolonne+1));
        hentCelle(rad,kolonne).leggTilNabo(hentCelle(rad,kolonne+1));
        hentCelle(rad,kolonne).leggTilNabo(hentCelle(rad+1,kolonne));
        hentCelle(rad,kolonne).leggTilNabo(hentCelle(rad+1,kolonne+1));


        
    }

    public void kobleAlleCeller(){
        for (int i = 0; i < antRader; i++){
            for (int j = 0; j < antKolonner; j++){
                settNaboer(i,j);
            }
        }
    }
    public int antallLevende(){
        int antallLevende = 0;
        for (int i = 0; i < antRader; i++){
            for (int j = 0; j < antKolonner; j++){
                if (hentCelle(i,j).erLevende()){
                    antallLevende += 1;
                }
            }
        }
        return antallLevende;
    }


}
