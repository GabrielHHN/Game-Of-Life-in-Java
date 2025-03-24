class Celle {
    boolean levende;
    Celle naboer[];
    int antNaboer;
    int antLevendeNaboer = 0;
    

    public Celle(){
        levende = false;
        naboer = new Celle[8];
        antNaboer = 0;
        antLevendeNaboer = 0; 
    }

    public void settDød(){
        levende = false;
    }

    public void settLevende(){
        levende = true;
    }

    boolean erLevende(){
        if (levende){
            return true;
        }
        else{
            return false;
        }
    }

    char hentStatusTegn(){
        if (levende){
            return 'Θ';
        }
        else{
            return '·';
        }   
    }

    void leggTilNabo(Celle celle){
        if (celle != null){
            int i = 0;
            for (i = 0; i < naboer.length; i++){
                if (naboer[i] == null){
                    naboer[i] = celle;
                    antNaboer += 1;
                    break;
                }
            }
        }
    }

    void tellLevendeNaboer(){
        antLevendeNaboer = 0;
        for (int i = 0; i < antNaboer; i++){
            if (naboer[i] != null){
                if (naboer[i].erLevende()){
                    antLevendeNaboer += 1;
                }
            }
        }
    }

    void oppdaterStatus(){
        if (levende){
            if (antLevendeNaboer < 2){
                settDød();
            }
            else if (antLevendeNaboer > 3){
                settDød();
            }
        }
        else {
            if (antLevendeNaboer == 3){
                settLevende();
            }
        }
    }
}
