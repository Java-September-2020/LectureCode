public interface Attackable {
  // What kind of attributes does an object that is attackable have
  int getHealth();

  void takeDamage(int damageAmount);

  void setHealth(int health);
}