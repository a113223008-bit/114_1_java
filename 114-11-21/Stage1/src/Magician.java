public class Magician extends Role{
    // 治癒力
    private int healPower;

    // 建構子：初始化魔法師的名稱、生命值和攻擊力
    public Magician(String name, int health, int attackPower, int healPower) {
        super(name, health, attackPower);
        this.healPower = healPower;
    }

    // 取得治癒力
    public int getHealPower() {
        return healPower;
    }

    // 攻擊對手
    public void attack(Role opponent) {
        opponent.setHealth(opponent.getHealth() - this.getAttackPower());
        System.out.println(this.getName() + " 魔法攻擊 " + opponent.getName() + " 造成 " +
                this.getAttackPower() + " 點傷害。" + opponent);
    }

    // 治療劍客
    public void heal(Role ally) {
        ally.setHealth(ally.getHealth() + this.healPower);
        System.out.println(this.getName() + " 治療 " + ally.getName() + " 回復 " + healPower + " 點生命值。" + ally);
    }
    @Override
    public void showSpecialSkill(){
        System.out.println("╔═════════════════════════════╗");
        System.out.println("║ " + this.getName() + " 的特殊技能：     ║");
        System.out.println("╠═════════════════════════════╣");
        System.out.println("║ 技能名稱：元素爆發          ║");
        System.out.println("║ 召喚強大魔法攻擊      ║");
        System.out.println("║ 範圍魔法傷害    ║");
        System.out.println("║ 恢復自身魔力     ║");
        System.out.println("╚═════════════════════════════╝");
    }
    @Override
    public String toString() {
        return super.toString() + ", 治癒力: " + healPower;
    }
}
