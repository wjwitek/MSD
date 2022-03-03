import static java.util.Objects.isNull;

public enum Rules {
    BASIC,
    CITIES,
    CORAL,
    RAIN;

    private int basicNewState(Point nei){
        int neighbourNum = nei.numberOfNeighbours();
        if (neighbourNum == 3){
            return 1;
        }
        else if (nei.getState() == 1 && neighbourNum == 2){
            return 1;
        }
        else {
            return 0;
        }
    }

    private int citiesNewState(Point nei){
        int neighbourNum = nei.numberOfNeighbours();
        if (nei.getState() == 1 && neighbourNum >= 2 && neighbourNum <= 5) {
            return 1;
        } else if (nei.getState() == 0 && neighbourNum >= 4 && neighbourNum <= 8) {
            return 1;
        } else {
            return 0;
        }
    }

    private int coralNewState(Point nei){
        int neighbourNum = nei.numberOfNeighbours();
        if (nei.getState() == 1 && neighbourNum >= 4 && neighbourNum <= 8) {
            return 1;
        } else if (nei.getState() == 0 && neighbourNum == 3) {
            return 1;
        } else {
            return 0;
        }
    }

    private int rainNewState(Point nei){
        if (nei.getState() > 0){
            return nei.getState() - 1;
        }
        else if (nei.getState() == 0 && !isNull(nei.rain_neighbour) && nei.rain_neighbour.getState() > 0){
            return 6;
        }
        else {
            return 0;
        }
    }

    public int decideRules(Point nei){
        switch (this) {
            case RAIN -> {return rainNewState(nei);}
            case CORAL -> {return coralNewState(nei);}
            case CITIES -> {return citiesNewState(nei);}
            case BASIC -> {return basicNewState(nei);}
            default -> {return -1;}
        }
    }
}
