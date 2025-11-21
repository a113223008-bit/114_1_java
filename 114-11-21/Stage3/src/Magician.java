public class Magician extends RangedRole{
    // 治癒力
    private int healPower;

    // 建構子：初始化魔法師的名稱、生命值和攻擊力
    public Magician(String name, int health, int attackPower, int healPower, int range, int maxEnergy) {
        super(name, health, attackPower, range, maxEnergy);
        this.healPower = healPower;
    }

    // 取得治癒力
    public int getHealPower() {
        return healPower;
    }

    // 攻擊對手
    public void attack(Role opponent) {
        opponent.takeDamage(this.getAttackPower());
        System.out.println("✨"+this.getName()+"施放魔法攻擊"+opponent.getName()+"!");
    }

    // 治療劍客
    public void heal(Role ally) {
        // 檢查能量是否足夠
        if (!consumeEnergy(10)) {
            System.out.println("❌ " + getName() + " 能量不足，無法施放治療！");
            return;
        }
        int oldHealth = ally.getHealth();
        ally.setHealth(ally.getHealth() + this.healPower);
        System.out.println("💚 " + this.getName() + " 治療 " + ally.getName() +
                " 回復 " + healPower + " 點生命值。" +
                "(" + oldHealth + " → " + ally.getHealth() + ")");
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
        System.out.println("║ 射程：" + getRange() + " 米                ║");
        System.out.println("╚═════════════════════════════╝");
    }
    /**
     * 魔法師的戰前準備
     * 吟唱咒語，準備施法
     */
    @Override
    public void onDeath() {
        System.out.println("💀 " + this.getName() + " 的生命之火熄滅了...");
        System.out.println("✨ " + this.getName() + " 的身體化為無數魔法粒子，消散在空氣中。");
        System.out.println("🌟 魔法書掉落在地上，微微發光。");
        System.out.println("---");
    }
    @Override
    public void prepareBattle() {
        System.out.println("📖 " + this.getName() + " 翻開魔法書，開始吟唱古老的咒語...");
        System.out.println("✨ 魔法能量在周圍凝聚，空氣中閃爍著神秘的光芒。");
    }

    /**
     * 魔法師的戰後行為
     * 冥想恢復魔力
     */
    @Override
    public void afterBattle() {
        System.out.println("🧘 " + this.getName() + " 閉目冥想，恢復消耗的魔力。");
    }

    @Override
    public String toString() {
        return super.toString() + ", 治癒力: " + healPower;
    }
    public String getRangedAttackType() {
        return "魔法攻擊";
    }
    @Override
    protected void onRangedPrepare() {
        System.out.println("🔮 " + getName() + " 檢查 魔法書 的狀態...");
        System.out.println("✨ 目前魔力值：" + getEnergy() + "/" + (getEnergy()+10));
    }
    @Override
    protected void onRangedAfterBattle() {
        System.out.println("🔮 " + getName() + " 閉上魔法書，感受魔力的流動...");
    }
    @Override
    public String toSring() {
        return super.toString() + ", 治癒力: " + healPower;
    }
}
