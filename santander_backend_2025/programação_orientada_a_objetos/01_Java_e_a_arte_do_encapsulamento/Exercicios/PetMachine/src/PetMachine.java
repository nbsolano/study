public class PetMachine {

    private boolean clean = true;
    private int water = 30;
    private int shampoo = 10;
    private Pet pet;

    private static final int MAX_WATER = 30;
    private static final int MAX_SHAMPOO = 10;

    public void takeAShower() {
        if (pet == null) {
            System.out.println("Coloque o Pet na máquina para iniciar o banho");
            return;
        }
        if (water < 10 || shampoo < 2) {
            System.out.println("Não há água ou shampoo suficiente para dar banho");
            return;
        }

        water -= 10;
        shampoo -= 2;
        pet.setClean(true);
        clean = false;
        System.out.printf("O pet %s está limpo%n", pet.getName());
    }

    public void addWater() {
        if (water >= MAX_WATER) {
            System.out.println("A capacidade de água está no máximo");
            return;
        }
        water = Math.min(MAX_WATER, water + 2);
        System.out.println("Água adicionada com sucesso");
    }

    public void addShampoo() {
        if (shampoo >= MAX_SHAMPOO) {
            System.out.println("A capacidade de shampoo está no máximo");
            return;
        }
        shampoo = Math.min(MAX_SHAMPOO, shampoo + 2);
        System.out.println("Shampoo adicionado com sucesso");
    }

    public int getWater() {
        return water;
    }

    public int getShampoo() {
        return shampoo;
    }

    public boolean hasPet() {
        return pet != null;
    }

    public void setPet(Pet pet) {
        if (!clean) {
            System.out.println("A máquina está suja, é necessário limpá-la antes de colocar outro pet");
            return;
        }
        if (hasPet()) {
            System.out.printf("O pet %s já está na máquina%n", this.pet.getName());
            return;
        }
        this.pet = pet;
        System.out.printf("O pet %s foi colocado na máquina%n", pet.getName());
    }

    public void removePet() {
        if (pet == null) {
            System.out.println("Não há pet na máquina para remover");
            return;
        }
        clean = pet.isClean();
        System.out.printf("O pet %s foi retirado da máquina%n", this.pet.getName());
        pet = null;
    }

    public void wash() {
        if (water < 3 || shampoo < 1) {
            System.out.println("Não há água ou shampoo suficiente para limpar a máquina");
            return;
        }
        water -= 3;
        shampoo -= 1;
        clean = true;
        System.out.println("A máquina foi limpa");
    }
}

