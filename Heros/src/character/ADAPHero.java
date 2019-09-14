package character;

public class ADAPHero extends Hero implements AD,AP,Mortal  {
    @Override
    public void magicAttack() {
        System.out.println("进行魔法攻击");
    }

    @Override
    public void physicalAttack() {
        System.out.println("进行物理攻击");
    }

    @Override
    public void die() {
        System.out.println("ADAPHero died!");
    }
}
