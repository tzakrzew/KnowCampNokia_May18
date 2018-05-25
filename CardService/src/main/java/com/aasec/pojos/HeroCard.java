package com.aasec.pojos;

public class HeroCard {
    String name;
    String heroType;
    int attack;
    int defence;

    private HeroCard (HeroBuilder heroBuilder) {
        this.name = heroBuilder.name;
        this.heroType = heroBuilder.heroType;
        this.attack = heroBuilder.attack;
        this.defence = heroBuilder.defence;
    }

    public String getName() {
        return name;
    }

    public String getHeroType() {
        return heroType;
    }

    public Integer getAttack() {
        return attack;
    }

    public Integer getDefence() {
        return defence;
    }

    @Override
    public String toString() {
        return "HeroCard{" +
                "name='" + name + '\'' +
                ", heroType='" + heroType + '\'' +
                ", attack=" + attack +
                ", defence=" + defence +
                '}';
    }

    public static class HeroBuilder {
        private final String name;
        private final String heroType;
        private int attack;
        private int defence;

        public HeroBuilder(String name, String heroType) {
            this.name = name;
            this.heroType = heroType;
        }

        public HeroBuilder attack(int attack) {
            this.attack = attack;
            return this;
        }

        public HeroBuilder defence(int defence) {
            this.defence = defence;
            return this;
        }

        public HeroCard build() {
            return new HeroCard(this);
        }

    }
}
