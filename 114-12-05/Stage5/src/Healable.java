public interface Healable {

    // 執行治療行為
    void heal(Role target);

    // 回傳治療強度
    int getHealPower();

    // 預設方法：是否能治療
    default boolean canHeal() {
        return getHealPower() > 0;
    }

    // 顯示治療資訊
    default void showHealInfo() {
        System.out.println("治療力：" + getHealPower());
    }
}