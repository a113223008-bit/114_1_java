public interface Defendable {

    // 角色進行防禦行為
    void defend();

    // 回傳角色剩餘的防禦容量
    int getDefenseCapacity();
    // 預設方法：是否還能防禦
    default boolean canDefend() {
        return getDefenseCapacity() > 0;
    }
}