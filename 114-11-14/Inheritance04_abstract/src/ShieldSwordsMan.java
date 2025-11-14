public class ShieldSwordsMan extends SwordsMan {
    private int defenseCapacity;
    public ShieldSwordsMan(String name, int health, int attackPower, int defenseCapacity) {
        super(name, health, attackPower);
        this.defenseCapacity=defenseCapacity;
    }
    @Override
    public void attack(Role opponent) {
        int reducedDamage = this.getAttackPower() -5;
        opponent.setHealth(opponent.getHealth() - reducedDamage);
        System.out.println(this.getName() + " 揮劍攻擊 " + opponent.getName() + " 造成 " +
                reducedDamage + " 點傷害。" + opponent);
    }
    public int getDefenseCapacity(){
        return defenseCapacity;
    }
    public void defence(){
        this.setHealth(this.getHealth()+defenseCapacity);
        System.out.println(this.getName()+" 使用防禦盾牌，恢復 "+defenseCapacity+" 點生命值。" + this);
    }
}
