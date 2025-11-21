public class ShieldSwordsMan extends SwordsMan {
    private int defenseCapacity;
    public ShieldSwordsMan(String name, int health, int attackPower, int defenseCapacity) {
        super(name, health, attackPower);
        this.defenseCapacity=defenseCapacity;
    }
    @Override
    public void attack(Role opponent) {
        int reducedDamage = this.getAttackPower() -5;
        opponent.takeDamage(this.getAttackPower());
        System.out.println("⚔"+this.getName()+"揮劍攻擊"+opponent.getName()+"!");
    }
    public int getDefenseCapacity(){
        return defenseCapacity;
    }
    public void defence(){
        this.setHealth(this.getHealth()+defenseCapacity);
        System.out.println(this.getName()+" 使用防禦盾牌，恢復 "+defenseCapacity+" 點生命值。" + this);
    }
    @Override
    public void showSpecialSkill(){
        System.out.println("╔═════════════════════════════╗");
        System.out.println("║ " + this.getName() + " 的特殊技能：     ║");
        System.out.println("╠═════════════════════════════╣");
        System.out.println("║ 技能名稱：盾牌猛擊          ║");
        System.out.println("║ 使用盾牌撞擊敵人      ║");
        System.out.println("║ 技能效果：造成傷害並暈眩    ║");
        System.out.println("║ 防禦加成：+"+defenseCapacity+" 防禦力    ║");
        System.out.println("╚═════════════════════════════╝");
    }
    @Override
    public void onDeath() {
        System.out.println("💀 " + this.getName() + " 力竭倒下...");
        System.out.println("🛡️  厚重的盾牌砸在地上，揚起一陣塵土。");
        System.out.println("⚔️  " + this.getName() + " 的劍也隨之掉落。");
        System.out.println("---");
    }
    /**
     * 持盾劍士的戰前準備
     * 檢查盾牌和劍的狀態
     */
    @Override
    public void prepareBattle() {
        System.out.println("🛡️  " + this.getName() + " 檢查盾牌的牢固程度...");
        System.out.println("⚔️  同時確認劍刃的鋒利度，準備應戰。");
    }

    /**
     * 持盾劍士的戰後行為
     * 修復盾牌上的損傷
     */
    @Override
    public void afterBattle() {
        System.out.println("🛡️  " + this.getName() + " 檢視盾牌上的新傷痕，並進行簡單修補。");
    }

}
