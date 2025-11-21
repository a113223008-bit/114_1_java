public abstract class MeleeRole extends Role {
    private int armor;  // 護甲值：近戰角色特有

    public int getArmor(){
        return armor;
    }

    public int setArmor(int armor){
        return this.armor=armor;
    }
    // 具體方法：計算防禦
    public int calculateDefense(int incomingDamage) {
        int actualDamage = Math.max(0, incomingDamage - armor);
        if (armor > 0 && incomingDamage > 0) {
            System.out.println("🛡️  護甲減免 " + Math.min(armor, incomingDamage) + " 點傷害！");
        }
        return actualDamage;
    }
    @Override
    public void takeDamage(int damage) {
        int actualDamage = calculateDefense(damage);
        super.takeDamage(actualDamage);
    }
    @Override
    public void prepareBattle() {
        System.out.println("⚔️  " + getName() + " 檢查 " + getWeaponType() + " 的狀態...");
        System.out.println("🛡️  目前護甲值：" + armor);
        onMeleePrepare(); // 呼叫抽象方法，讓子類別加入特殊準備
    }
    public MeleeRole(String name, int health, int attackPower, int armor) {
        super(name, health, attackPower);
        this.armor = armor;
    }
    // 抽象方法：取得武器類型
    public abstract String getWeaponType();
    @Override
    public String toString() {
        return super.toString() + ", 護甲值: " + armor;
    }
    // 抽象方法：近戰特殊準備
    protected abstract void onMeleePrepare();
}