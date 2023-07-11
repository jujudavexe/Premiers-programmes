package fr.jujudave.entity;

public enum Race {
    BAR("Bar"), CARPE("Carpe"), MEROU("Merou"), POISSONCLOWN("PoissonClown"), SOLE("Sole"), THON("Thon");

    private final String race;


    Race(String race) {
        this.race = race;

    }

    @Override
    public String toString() {
        return race;
    }

}
