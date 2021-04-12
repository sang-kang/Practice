package dev.sangyoon.exercise.ex4;

public class Person {
    private static Person person = new Person();

    private int stamina = 1;
    private int assets = 1;
    private int fatigue = 1;

    private Person(){   //default constructor를 private으로 만들지않았었음. 그러면 new로 객체 생성가능하다는 오류 발생

    }

    public static Person getInstance() {
        return person;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getStamina() {
        return stamina;
    }

    public void setAssets(int assets) {
        this.assets = assets;
    }

    public int getAssets() {
        return assets;
    }

    public void setFatigue(int fatigue) {
        this.fatigue = fatigue;
    }

    public int getFatigue() {
        return fatigue;
    }

    @Override
    public String toString() {
        return "Person{" +
            "stamina=" + stamina +
            ", asset=" + assets +
            ", fatigue=" + fatigue +
            '}';
    }

    //메소드

    private int getRandomInt(int min, int max) {     //최소값은 포함 최대값은 제외.
//        min = (int) Math.ceil(min);               //어짜피 int인데 이거 왜했나? 왜했었지..
//        max = (int) Math.floor(max);
        return (int) (Math.floor(Math.random() * (max - min)) + min);
    }

    public void work() {
        //스태미너 5~6까고 돈을 2~3를 번다. 피로도 3~4증가
        int usedStamina = getRandomInt(5, 7);
        int earnedIncome = getRandomInt(2, 4);
        int fatigueFiledUp = getRandomInt(3, 5);
        stamina = stamina - usedStamina;
        assets = assets + earnedIncome;
        fatigue = fatigue + fatigueFiledUp;
    }

    public void eat() {
        //2~10사이의 돈을까고, 스태미너 10~20 회복
        int spentMoney = getRandomInt(2, 11);
        int recoveredStamina = getRandomInt(10, 21);
        assets = assets - spentMoney;
        stamina = stamina + recoveredStamina;
    }

    public void rest() {
        //피로도 5~8감소.
        int relievedFatigue = getRandomInt(5, 9);
        fatigue = fatigue - relievedFatigue;
    }
}
