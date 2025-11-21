public abstract class RangedRole extends Role {
    private int range;      // 攻擊範圍
    private int energy;     // 能量值
    private int maxEnergy;
    public int getRange(){
        return range;
    }
    public int getEnergy(){
        return energy;
    }
    public int setEnergy(int energy){
        return this.energy=energy;
    }
    public int setRange(int range){
        return this.range=range;
    }
    public RangedRole(String name, int health, int attackPower, int range, int maxEnergy) {
        super(name, health, attackPower);
        this.range = range;
        this.energy = maxEnergy;
        this.maxEnergy = maxEnergy;
}
    // 具體方法：檢查射程
    public boolean isInRange(int distance) {
        int rangeBonus = 0;
        if (energy > maxEnergy / 2) {
            rangeBonus = 2; // 能量超過一半時，增加額外射程
        }
        return distance <= (range + rangeBonus);
    }

    // 具體方法：能量管理
    public boolean consumeEnergy(int amount) {
        if (energy >= amount) {
            energy -= amount;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + ", 射程: " + range + ", 能量: " + energy + "/" + maxEnergy;
    }
    public void onRangedPrepare() {
        System.out.println("🔋  目前能量值：" + energy + "/" + maxEnergy);
    }

    // 抽象方法：取得攻擊類型
    public abstract String getRangedAttackType();
}
