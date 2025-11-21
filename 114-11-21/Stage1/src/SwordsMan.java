public class SwordsMan extends Role{
    // 建構子：初始化劍士的名稱、生命值和攻擊力
    public SwordsMan(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    // 攻擊對手，父類別參考指到子類別物件
    @Override
    public void attack(Role opponent) {
        opponent.setHealth(opponent.getHealth() - this.getAttackPower());
        System.out.println(this.getName() + " 揮劍攻擊 " + opponent.getName() + " 造成 " +
                this.getAttackPower() + " 點傷害。" + opponent);
    }
    /**
     * 展示角色的特殊技能
     * 為什麼設計成抽象方法？
     * 1. 每個角色都有特殊技能（共同規格）
     * 2. 但每個角色的技能內容都不同（個別實作）
     * 3. 我們無法在 Role 類別中提供一個「適合所有角色」的預設實作
     */
    @Override
    public void showSpecialSkill(){
        System.out.println("╔═════════════════════════════╗");
        System.out.println("║ " + this.getName() + " 的特殊技能：     ║");
        System.out.println("╠═════════════════════════════╣");
        System.out.println("║ 技能名稱：連續斬擊          ║");
        System.out.println("║ 技能描述：快速揮劍三次      ║");
        System.out.println("║ 技能效果：造成 150% 傷害    ║");
        System.out.println("╚═════════════════════════════╝");
    }
}
